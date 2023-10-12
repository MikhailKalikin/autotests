package com.example.lab;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/result")
public class ApplicationController {


    @PostMapping("/plus")
    public String plus(String number1, String number2, int base) {
        Calculate calculate = new Calculate();
        return calculate.plus(number1, number2, base);
    }

    /*@PostMapping("minus")
    public String minus() {
        return description;
    }

    @PostMapping("multiply")
    public String multiply() {
        return description;
    }

    @PostMapping("divide")
    public String divide() {
        return description;
    }*/
}