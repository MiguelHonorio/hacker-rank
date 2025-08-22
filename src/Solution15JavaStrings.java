import java.util.Scanner;

public class Solution15JavaStrings {
    /***
     * retorna +1 se e somente se obj1 vier depois de obj2.
     * retorna —1 se e somente se obj1 vier antes de obj2.
     * retorna 0 se e somente se obj1 e obj2 forem iguais.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String A = input.next();
        String B = input.next();

        System.out.println(A.length() + B.length());
        input.close();
        if (A.compareTo(B) <= 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");

        }
        String capitalizeString = A.substring(0, 1).toUpperCase().concat(A.substring(1));
        String capitalizeString2 = B.substring(0, 1).toUpperCase().concat(B.substring(1));

        System.out.println(capitalizeString + " " + capitalizeString2);


    }
}
