package com.example.demo.repositories;

import com.example.demo.models.StudentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//@Repository extender o JpaRepository não é necessário colocar o esteriotipo
@Repository
public interface StudentsRepository extends JpaRepository<StudentsModel, UUID> {
}
