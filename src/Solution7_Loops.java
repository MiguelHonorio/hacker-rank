import java.util.Scanner;

public class Solution7_Loops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        //lê um inteiro t da entrada,
        // que representa o número de casos de teste a serem executados.
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int base = 2;
            int result = 1;
            int series;
            series = a + result * b;
            System.out.printf("%d ", series);
            for (int j = 1; j < n; j++) {
                result *= base;
                series += result * b;
                System.out.printf("%d ", series);
            }
            System.out.printf("%n");
        }
        in.close();

    }
}
