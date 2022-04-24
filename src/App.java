import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        BancoPessoas dbPessoas = new BancoPessoas();

        try {
            System.out.print("Quantidade de Pessoas que serão geradas: ");
            int qdtPessoas = sc.nextInt();

            for (int i = 0; i < qdtPessoas; i++) {
                Pessoa pessoa = new Pessoa(dbPessoas);
                dbPessoas.addPessoa(pessoa);
            }

        } catch (InputMismatchException e) {
            System.out.println("\nDigite Somente Números"+"\n"+"Erro: "+e + "\n");
        }
        


        dbPessoas.mostraPessoas();

        sc.close();
    }
}
