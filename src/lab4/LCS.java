package lab4;

import java.util.Scanner;

public class LCS {

    public static void getLCS(String seq1, String seq2) {
        int n = seq1.length();
        int m = seq2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println("Length : " + dp[n][m]);
        System.out.println("Sequence : " + getLCSSequence(dp, seq1, seq2, n, m));

    }

    private static String getLCSSequence(int[][] dp, String seq1, String seq2, int i, int j) {
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                lcs.append(seq1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Since we've built the LCS from end to start, reverse it before returning
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter string one : ");
        String seq1 = input.next();

        System.out.print("Enter string two : ");
        String seq2 = input.next();

        getLCS(seq1, seq2); 
        
        input.close();
    }
}
