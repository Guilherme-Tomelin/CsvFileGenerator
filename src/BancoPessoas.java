import java.util.ArrayList;

public class BancoPessoas {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();


    public BancoPessoas() {
       
    }

    public BancoPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void mostraPessoas() {
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i));
        }
    }

    public ArrayList<String> addLinha(ArrayList<String> linhas){
        linhas = new ArrayList<String>();

        for (int i = 0; i < pessoas.size(); i++) {
            linhas.add(pessoas.toString());
        }

        return linhas;
    }

    public boolean existeApelido(String apelido) {
        ArrayList<Pessoa> copyPessoas = getPessoas();
        for (int i = 0; i < pessoas.size() ; i++ ) {
            if (copyPessoas.get(i).getApelido().equals(apelido)) {
                return true;
            }
        }
        return false;
    }

    public void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }


}
