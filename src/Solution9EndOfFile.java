import java.util.Scanner;

public class Solution9EndOfFile {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        for(int i=1; in.hasNext();i++){
//            String input=in.nextLine();
//            System.out.println(i+" "+input);
//        }
//        in.close();
//    }

    /***
     * Esse loop só para quando não houver mais entrada:
     * Se for no teclado, normalmente é quando o usuário envia EOF (Ctrl+D no Linux/Mac ou Ctrl+Z no Windows e Enter).
     * Se for lendo de um arquivo, para quando o arquivo acaba.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = 0;
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            line++;
            System.out.println(line + " " + input);
        }
        scanner.close();
    }
}
