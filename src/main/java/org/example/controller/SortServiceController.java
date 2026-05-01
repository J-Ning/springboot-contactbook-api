package org.example.controller;

import org.example.service.MatrixMultiplicationCalc;
import org.example.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SortServiceController {

//    @Autowired
    private final SortService sortService;

//    @Autowired
    private final MatrixMultiplicationCalc matrixMultiplicationCalc;

    @Autowired
    public SortServiceController(SortService sortService, MatrixMultiplicationCalc matrixMultiplicationCalc) {
        this.sortService = sortService;
        this.matrixMultiplicationCalc = matrixMultiplicationCalc;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello " + name + "! From Server.";
    }

    @PostMapping("/sort") public List<Integer> sort(@RequestBody List<Integer> body) {
        return sortService.SortService(body);
    }

//    @PostMapping("/matrixMultiply")
//    public int[][] matrixMultiply(@RequestBody MatrixRequest matrixRequest) {
//        int[][] inputMatrixA = matrixRequest.getInputMatrixA();
//        int[][] inputMatrixB = matrixRequest.getInputMatrixB();
//        return matrixMultiplicationCalc.matrixMultiplicationCalc(inputMatrixA, inputMatrixB);
//    }
//
//    @GetMapping("/hi")
//    public String hi() {
////        sortService.SortService();
//        return ("hi!");
//    }
//
}
