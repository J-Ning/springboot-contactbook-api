package org.example.controller;

public class MatrixRequest {
    private int[][] inputMatrixA;
    private int[][] inputMatrixB;

    public int[][] getInputMatrixA() {
        return inputMatrixA;
    }

    public int[][] getInputMatrixB() {
        return inputMatrixB;
    }

    public void setInputMatrixA(int[][] inputMatrixA) {
        this.inputMatrixA = inputMatrixA;
    }

    public void setInputMatrixB(int[][] inputMatrixB) {
        this.inputMatrixB = inputMatrixB;
    }
}
