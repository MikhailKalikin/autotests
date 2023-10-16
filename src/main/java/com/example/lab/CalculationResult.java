package com.example.lab;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CalculationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operand1;
    private String operand2;
    private String result;
    private String operation;
    private LocalDateTime executionTime;

    // Геттеры и сеттеры для полей
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }
}