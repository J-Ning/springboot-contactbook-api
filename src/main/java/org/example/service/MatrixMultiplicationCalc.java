package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class MatrixMultiplicationCalc {
    public int[][] matrixMultiplicationCalc(int[][] matrixA, int[][] matrixB) {
        int finalRow = matrixA.length;
        int matrixACol = matrixA[0].length;
        int matrixBRow = matrixB.length;
        int finalCol = matrixB[0].length;

        if (matrixACol != matrixBRow) {
            System.out.println("impossible");
            return null;
        }

        int[][] output = new int[finalRow][finalCol];

        //(0,0) row 1 *col1
        //(0,1) row 1 * col2

        for (int i = 0; i < finalRow; i++) {
            int tempresult = 0;
            for (int j = 0; j < finalCol; j++) {
                for (int k = 0; k < matrixACol; k++) {
                    tempresult += matrixA[i][k] * matrixB[k][j];
                }
                output[i][j] = tempresult;
                tempresult = 0;
            }
        }

        return output;
    }
}
