import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();


        try {
            System.out.print("Quantidade de Pessoas que serão geradas: ");
            int qdtPessoas = sc.nextInt();

            for (int i = 0; i < qdtPessoas; i++) {
                Pessoa pessoa = new Pessoa();
                pessoas.add(pessoa);
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: "+e);
        }
        
        BancoPessoas.mostraPessoas(pessoas);

        sc.close();
    }
}
