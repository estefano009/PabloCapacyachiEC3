package com.example.exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exame.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
