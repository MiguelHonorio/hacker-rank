import java.util.ArrayList;
import java.util.List;

public class Solution14JavaList {

    public static void main(String[] args) {


//        L = [12 0 1 78 12];
//        Q = Inserir 23 no índice.;
//        L1 = [12, 0, 1, 78, 12, 23];
//        Q1 = Excluir elemente no indice();
//        L2  = [0,1,78,12,23];

        List<Integer> listagem = new ArrayList<>();
        listagem.add(12);
        listagem.add(0);
        listagem.add(1);
        listagem.add(78);
        listagem.add(12);
        System.out.println((long) listagem.size());
        System.out.println(listagem);

    }
}
