import java.util.Scanner;

public class Solution10StaticInitializerBlock {

    static int B;
    static int H;
    private static boolean flag;

    static {
        B = -1;
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        sc.close();

        try {
            if (B <= 0 || H <= 0) {

                throw new Exception("Breadth and height must be positive");
            }
            flag = true;
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }

}
