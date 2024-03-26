public class TesteTecnico {

    public static void main(String[] args) {

        boolean comp = Boolean.parseBoolean(compara(10, "10"));

        System.out.println(comp);


    }

    public static String compara(int num, String stg) {

        if (stg.equals(Integer.toString(num))){
            System.out.println("São iguais");
        }else {
            System.out.println("Não são iguais.");
        }
        return stg;

    }

}
