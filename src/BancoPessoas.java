import java.util.ArrayList;

public class BancoPessoas {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public BancoPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
        
    public static void mostraPessoas(ArrayList<Pessoa> pessoas){
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i));
        }
    }
}
