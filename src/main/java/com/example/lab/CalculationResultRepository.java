package com.example.lab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
}