package com.example.demo.controllers;

import com.example.demo.dtos.StudentsRecord;
import com.example.demo.models.StudentsModel;
import com.example.demo.repositories.StudentsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    StudentsRepository studentsRepository;

    // corretos usos da URi
    // dto com records é algo temporário que é usado apenas para transferir informações
    @PostMapping
    public ResponseEntity<StudentsModel> saveStudent(@RequestBody @Valid StudentsRecord studentsRecord) {
        var studentsModel = new StudentsModel();
        BeanUtils.copyProperties(studentsRecord, studentsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentsRepository.save(studentsModel));
    }

    @GetMapping
    public ResponseEntity<List<StudentsModel>> getAllStudents() {
        List<StudentsModel> studentsModelList = studentsRepository.findAll();
        if(!studentsModelList.isEmpty()) {
            for(StudentsModel student : studentsModelList) {
                UUID id = student.getId();
                student.add(linkTo(methodOn(StudentsController.class).getOneStudent(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value="id") UUID id) {

        Optional<StudentsModel> s = studentsRepository.findById(id);
        if(s.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found.");
        }
        s.get().add(linkTo(methodOn(StudentsController.class).getAllStudents()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(s.get());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid StudentsRecord studentsRecord) {
        var s = studentsRepository.findById(id);
        if(s.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var studentModel = s.get();
        BeanUtils.copyProperties(studentsRecord, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentsRepository.save(studentModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value="id") UUID id) {
        Optional<StudentsModel> student = studentsRepository.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        studentsRepository.delete(student.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

}

