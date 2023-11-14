package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "tb_students")
@Entity
public class StudentsModel extends RepresentationModel<StudentsModel> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // muito usado em arquitetura de micro serve com base de dados distribuidos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Integer age;
    private Integer firstGrade;
    private Integer secondGrade;
    private String teacherName;
    private Integer roomNumber;

    public Integer getFirstGrade() {
        return firstGrade;
    }

    public void setFirstGrade(Integer firstGrade) {
        this.firstGrade = firstGrade;
    }

    public Integer getSecondGrade() {
        return secondGrade;
    }

    public void setSecondGrade(Integer secondGrade) {
        this.secondGrade = secondGrade;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStars() {
        return firstGrade;
    }

    public void setStars(Integer stars) {
        this.firstGrade = stars;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdade() {
        return age;
    }

    public void setIdade(Integer idade) {
        this.age = idade;
    }
}
