public class ValidaCampos {
    public static boolean possuiNumerosRepetidos(String campo) {
        for (int i = 0; i < campo.length() - 1; i++) {
            char atual = campo.charAt(i);
            for (int j = i + 1; j < campo.length(); j++) {
                if (atual == campo.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String campo1 = "123456";
        String campo2 = "111111";

        if (possuiNumerosRepetidos(campo1)) {
            System.out.println("O campo 1 contém números repetidos.");
        } else {
            System.out.println("O campo 1 não contém números repetidos.");
        }

        if (possuiNumerosRepetidos(campo2)) {
            System.out.println("O campo 2 contém números repetidos.");
        } else {
            System.out.println("O campo 2 não contém números repetidos.");
        }
    }
}