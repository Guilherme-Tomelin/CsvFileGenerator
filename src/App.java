import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class App {

    private static final String CSV_PATH = "C:\\Users\\guilh\\OneDrive\\Área de Trabalho\\Projeto\\pessoasGeradas.txt";
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

            //----------------------Gera arquivo CSV----------------------

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_PATH))){
           
            //List<ArrayList> data = new ArrayList<ArrayList>();
            
            ArrayList<String> linhas = new ArrayList<String>();
            linhas.add("nome;apelido;cpf;idade;rg;telefone");
            linhas = dbPessoas.addLinha(linhas);

            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }


        }catch(IOException e){
            e.printStackTrace();
        }
        //----------------------Gera arquivo CSV----------------------

        } catch (InputMismatchException e) {
            System.out.println("\nDigite Somente Números"+"\n"+"Erro: "+e + "\n");
        }
        
        dbPessoas.mostraPessoas();
        

        

        sc.close();
    }
}
