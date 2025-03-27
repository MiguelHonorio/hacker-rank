import java.util.Locale;
import java.util.Scanner;

public class AreaCirculo {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        double R = scan.nextDouble();

        double A = 3.14159 * Math.pow(R, 2);
        System.out.printf("A=%.4f%n", A);

    }
}