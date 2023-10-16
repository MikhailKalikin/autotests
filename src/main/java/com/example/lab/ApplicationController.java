package com.example.lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/calculator")
public class ApplicationController {

    private CalculationResultRepository resultRepository;

    @Autowired
    public void CalculatorController(CalculationResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public ApplicationController(CalculationResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @PostMapping("/plus")
    public String add(@RequestParam String number1, @RequestParam String number2, @RequestParam int base) {
        String result = performAddition(number1, number2, base);
        saveCalculationResult(number1, number2, result, "plus");
        return result;
    }

    @PostMapping("/minus")
    public String subtract(@RequestParam String number1, @RequestParam String number2, @RequestParam int base) {
        String result = performSubtraction(number1, number2, base);
        saveCalculationResult(number1, number2, result, "minus");
        return result;
    }

    @PostMapping("/multiply")
    public String multiply(@RequestParam String number1, @RequestParam String number2, @RequestParam int base) {
        String result = performMultiplication(number1, number2, base);
        saveCalculationResult(number1, number2, result, "multiply");
        return result;
    }

    @PostMapping("/divide")
    public String divide(@RequestParam String number1, @RequestParam String number2, @RequestParam int base) {
        String result = performDivision(number1, number2, base);
        saveCalculationResult(number1, number2, result, "divide");
        return result;
    }

    private String performAddition(String number1, String number2, int base) {
        try {
            int n1 = Integer.parseInt(number1, base);
            int n2 = Integer.parseInt(number2, base);
            int sum = n1 + n2;
            return Integer.toString(sum, base);
        } catch (NumberFormatException e) {
            return "Ошибка преобразования чисел";
        }
    }

    private String performSubtraction(String number1, String number2, int base) {
        try {
            int n1 = Integer.parseInt(number1, base);
            int n2 = Integer.parseInt(number2, base);
            int diff = n1 - n2;
            return Integer.toString(diff, base);
        } catch (NumberFormatException e) {
            return "Ошибка преобразования чисел";
        }
    }

    private String performMultiplication(String number1, String number2, int base) {
        try {
            int n1 = Integer.parseInt(number1, base);
            int n2 = Integer.parseInt(number2, base);
            int product = n1 * n2;
            return Integer.toString(product, base);
        } catch (NumberFormatException e) {
            return "Ошибка преобразования чисел";
        }
    }

    private String performDivision(String number1, String number2, int base) {
        try {
            int n1 = Integer.parseInt(number1, base);
            int n2 = Integer.parseInt(number2, base);
            if (n2 == 0) {
                return "Деление на ноль";
            }
            int quotient = n1 / n2;
            return Integer.toString(quotient, base);
        } catch (NumberFormatException e) {
            return "Ошибка преобразования чисел";
        } catch (ArithmeticException e) {
            return "Ошибка деления";
        }
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