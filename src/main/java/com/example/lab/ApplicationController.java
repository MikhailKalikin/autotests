package com.example.lab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/result")
public class ApplicationController {

    @PostMapping("/plus")
    public String plus(String number1, String number2, int base) {
        Calculate calculate = new Calculate();
        saveCalculationResult(number1, number2, calculate.plus(number1, number2, base), "plus" );
        return calculate.plus(number1, number2, base);


    }




    @PostMapping("/minus")
    public String minus(String number1, String number2, int base) {
        Calculate calculate = new Calculate();
        return calculate.minus(number1, number2, base);
    }


    @PostMapping("/multiply")
    public String multiply(String number1, String number2, int base) {
        Calculate calculate = new Calculate();
        return calculate.multiply(number1, number2, base);
    }


    @PostMapping("/divide")
    public String divide(String number1, String number2, int base) {
        Calculate calculate = new Calculate();
        return calculate.divide(number1, number2, base);
    }

    private final CalculationResultRepository resultRepository;

    @Autowired
    public ApplicationController(CalculationResultRepository resultRepository) {
        this .resultRepository = resultRepository;
    }

    private void saveCalculationResult(String number1, String number2, String result, String operation) {
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setOperand1(number1);
        calculationResult.setOperand2(number2);
        calculationResult.setResult(result);
        calculationResult.setOperation(operation);
        calculationResult.setExecutionTime(LocalDateTime.now());
        resultRepository.save(calculationResult);
    }

}