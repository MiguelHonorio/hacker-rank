import java.io.*;
import java.util.Calendar;

class Solution12DayOfWeek {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    static String findDay(int month, int day, int year) {

        Calendar cal = Calendar.getInstance();
        // No Calendar, mês começa do zero (janeiro = 0)
        cal.set(year, month - 1, day);

        // Obtém o nome do dia em maiúsculas
        String[] dias = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
                "THURSDAY", "FRIDAY", "SATURDAY" };
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK); // 1 = Sunday, 7 = Saturday

        return dias[diaSemana - 1];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Solution12DayOfWeek.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
