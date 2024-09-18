package lab5;

import java.util.Scanner;

public class MatrixChainOrderMultiplication {

    private static void matrixChainOrderMultiplication(int[] dimensions) {
        int n = dimensions.length;

        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int q = m[i][k] + m[k + 1][j] + (dimensions[i - 1] * dimensions[j] * dimensions[k]);

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("No. of scalar multiplications : " + m[1][n-1]);
        System.out.print("parenthesis matrix : ");
        printMatrixOrder(s, 1, n-1);

    }

    private static void printMatrixOrder(int[][] s, int i, int j){
        if (i==j) {
            System.out.print("A" + i);
        }
        else{
            System.out.print("(");
            printMatrixOrder(s, i, s[i][j]);
            System.out.print("*");
            printMatrixOrder(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of dimensions : ");
        int n = sc.nextInt();
        int[] dimensions = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the dimension(%d/%d) : ", (i + 1), n);
            dimensions[i] = sc.nextInt();
        }
        
        sc.close();
        matrixChainOrderMultiplication(dimensions);
    }
}
