import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5LoopCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int contador = 1;
        while (contador <= 10) {
            int result = n * contador;
            System.out.println(n + " x " + contador + " = " +result);
            contador++;
        }
        bufferedReader.close();
    }
}
