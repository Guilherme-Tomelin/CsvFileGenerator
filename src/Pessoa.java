import java.util.Random;

public class Pessoa {
    private String nome;
    private String apelido;
    private String cpf;
    private int idade;
    private String rg;
    private String telefone;
    private BancoPessoas conn;


    public Pessoa(BancoPessoas db) {
        this.conn = db;
        this.nome = geraNome();
        this.apelido = geraApelido(nome);
        this.cpf = geraCpf();
        this.idade = geraIdade();
        this.rg = geraRG();
        this.telefone = geraTelefone();
    }

    //-------------------------------------------------
    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }


    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }


    public String getRg() {
        return rg;
    }


    public String getTelefone() {
        return telefone;
    }

    //-------------------------------------------------

    /**
     * Gerador de nome completo aleatorio
     */
    public String geraNome() {
        Random rand = new Random();

        String[] nomes = { "Guilherme", "Bruno", "Gabriel", "João", "Pedro", "Amanda", "Letícia", "Rafaela", "Rafael",
                "John", "Márcio", "Bruna", "Gabriela", "Maria", "Juliana", "Juliano", "Henrique", "Miguel", "Laura",
                "Mariana", "Clarissa" };
        String[] sobrenomes = { "Silva", "Bueno", "Magni", "Araujo", "Luigi", "Telis", "Machado", "Oliveira", "Costa",
                "Lima", "Tomelin", "Ferreira", "Souza", "Carvalho", "Rodrigues", "Gomes", " Souza", "Martins",
                "Gonzalez", "Rocha", "Barbosa", "Ribeiro", "Alvez" };

        int valor = rand.nextInt(nomes.length);
        int valor2 = rand.nextInt(sobrenomes.length);
        int valor3 = rand.nextInt(sobrenomes.length);

        String nome;

        if (valor > 10) {
            nome = nomes[valor] + " " + sobrenomes[valor2] + " " + sobrenomes[valor3];
        } else {
            nome = nomes[valor] + " " + sobrenomes[valor2];
        }

        return nome;
    }

    

    /**
     * Gerador de apelido aleatorio
     */

    public String geraApelido(String nome) {

        String apelido = nome.substring(0, 3);
        
        
            int cont = 0;

            if(this.conn.existeApelido(apelido)){
                String tempNick = apelido + Integer.toString(cont);
                while(this.conn.existeApelido(tempNick)){
                    tempNick = apelido;
                    cont++;
                    tempNick = apelido + Integer.toString(cont);
                }
                apelido = tempNick;
            }

            return apelido;
    }

    /**
     * Gera Cpf valido aleatorio
     */

    public String geraCpf() {

        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = randomiza(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (mod(d2, 11));

        String cpf = null;

        if (d2 >= 10)
            d2 = 0;
        cpf = "";

        cpf = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
        return cpf;
    }

    private int randomiza(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    /**
     * Gera Idade aleatória
     */

    public int geraIdade() {
        Random rand = new Random();
        int x = rand.nextInt(100);
        return x;
    }

    /**
     * Gera RG
     */

    public String geraRG() {
        Random rand = new Random();
        
        int n1 = rand.nextInt(10);
        int n2 = rand.nextInt(10);
        int n3 = rand.nextInt(10);
        int n4 = rand.nextInt(10);
        int n5 = rand.nextInt(10);
        int n6 = rand.nextInt(10);
        int n7 = rand.nextInt(10);
        int n8 = rand.nextInt(10);

        int soma = (n1 * 2) + (n2 * 3) + (n3 * 4) + (n4 * 5) + (n5 * 6) + (n6 * 7) + (n7 * 8) + (n8 * 9);
        int resto = soma % 11;
        String dv;


        if(resto == 0){
            dv = "0";
        }else if (resto == 1){
            dv = "X";
        }else{
            dv = Integer.toString(11 - resto);
        }

        return Integer.toString(n1) + n2 + n3 + n4 + n5 + n6 + n7 + n8 + dv;
    }

    /**
     * Gera Telefone aleatório
     */

     public String geraTelefone(){
        Random rand = new Random();
        String ddd[] = {"11","12","13","14","15","16","17","18","19","21","22","24","27","28","31","32","33","34","35","37","38","41","42","43","44","45","46","47","48","49","51","53","54","55","61","62","63" ,"64","65","66","67","68","69","71","73","74","75","77","79","81","82","83","84","85","86" ,"87","88","89","91","92","93","94","95","96","97","98","99"};

        int n1 = rand.nextInt(10);
        int n2 = rand.nextInt(10);
        int n3 = rand.nextInt(10);
        int n4 = rand.nextInt(10);
        int n5 = rand.nextInt(10);
        int n6 = rand.nextInt(10);
        int n7 = rand.nextInt(10);
        int n8 = rand.nextInt(10);



        return "("+ddd[rand.nextInt(ddd.length)]+")"+" "+9+n1+n2+n3+n4+"-"+n5+n6+n7+n8;
     }


     @Override
     public String toString() {
         return "-------------------------"+"\n"+
                "Nome: "+ this.nome + "\n"+
                "Apelido: "+ this.apelido + "\n"+
                "Cpf: "+ this.cpf + "\n"+
                "Idade: "+ this.idade + "\n"+
                "Rg: "+ this.rg+ "\n"+
                "Telefone: "+ this.telefone;
     }
}