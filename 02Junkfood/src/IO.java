import java.util.ArrayList;
import java.util.Scanner;

class Espiral {
	String nome;
	int qtd;
	float preco;
	
//toString
//Conferido
	public String toString (){
		if (this.nome == null) {
			return "[- : 0 U : 0 RS]";
		} else 	
		return "["+ this.nome + " : " + this.qtd + " U :" + this.preco + " RS]";
	}

//Construtor
//Conferido
	public Espiral(String nome, int qtd, float preco) {
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;
	}
}


//----------------------------------------------------------------------------------------

class Maquina {
	float lucro;
	public float saldoCliente;
	int qtdmax;
	ArrayList<Espiral> espirais;

//Construtor (iniciar _espirais _max_produtos)
//Conferido
	public Maquina (int qtdespirais, int maxprodutos) {
		this.lucro = 0.f;
		this.saldoCliente = 0.f;
		this.espirais = new ArrayList<Espiral>();
		for ( int i = 0 ; i < qtdespirais ; i++) {
			this.espirais.add(new Espiral(null, i, i));
		}
	}

//dinheiro _valor
//Conferido
		public void addDinheiro(float dinheiro) {
			saldoCliente += dinheiro;
			}	
		
//Algo para comer (set _ind _nome _qtd _valor)
	public void setEspiral(int ind, String nome, int qtd, float preco) {
		if (this.espirais.get(ind) != null) {
			espirais.add(new Espiral (nome, qtd, preco));
		}
	}
	
//add
	public void add(int i, String nome, int qtd, float preco) {
		if (i < 0 || i > espirais.size()) {
			throw new RuntimeException("fail: indice" + " "+ i + " " + "nao existe");
		}
		
		else if ( qtd < 0 || qtd > espirais.size()) {
			throw new RuntimeException("fail: limite de produtos eh " + qtdmax + " por espeiral  ");
			
		} else {
		
		this.espirais.get(i).nome = nome;
		this.espirais.get(i).qtd = qtd;
		this.espirais.get(i).preco = preco;
		
		}
	}	
	
// limpar _ind
	void limpar(int ind) {
		this.espirais.get(ind).nome = null;
		this.espirais.get(ind).preco = 0;
		this.espirais.get(ind).qtd = 0;
		}

//Troco
	public void troco() {
		float saldo = saldoCliente;
		saldoCliente -= saldoCliente;
		throw new RuntimeException("voce recebeu " +saldo); 
		
	}
	
	public void comprar(int pos){
			if((pos < 0) || (pos >= espirais.size())){
				throw new RuntimeException("Fail: indice nao existe"); 
			} //funcionando
			
			
			else if (this.espirais.get(pos).qtd <= 0) {
				throw new RuntimeException("Fail: espiral sem produtos");	
			} //não esta entrando
			
			
			else if (this.espirais.get(pos).preco > this.saldoCliente) {
				throw new RuntimeException(this.espirais.get(pos).nome + " Valor " + this.espirais.get(pos).preco +", Saldo insificiente");
			
				
			} else {
				this.espirais.get(pos).qtd -= 1;
				this.saldoCliente -= this.espirais.get(pos).preco;
				throw new RuntimeException("comprou um " + this.espirais.get(pos).nome+"." +" Saldo: "+ saldoCliente);
				
			}
	}
	
//toString
	public String toString() {
		String saida = "";
		for (int i = 0; i < espirais.size(); i++)
			saida += i + " " + espirais.get(i) + " \n";
		return  "saldo: " + saldoCliente + "\n" + saida;
	}
	

	
	public void max(int i) {
		this.qtdmax = i;
		System.out.println(qtdmax);
	}
}


//------------------------------------------------------------------------------------------

class Controller{
    public Maquina maq;
    public static final int DEFAULT_ESPIRAIS = 3;
    public static final int DEFAULT_MAX = 5;
    
    public Controller() {
        maq = new Maquina(DEFAULT_ESPIRAIS, DEFAULT_MAX);
    }
    
	
    
    
    //recebe uma string e tenta converter em float
    private float toFloat(String s) {
        return Float.parseFloat(s);
    }
    
    //nossa funcao oraculo que recebe uma pergunta e retorna uma resposta
    public String oracle(String line){
        String ui[] = line.split(" ");

        if(ui[0].equals("help"))
            return " show \n iniciar _espirais _maximo \n set _posi _desc _qtd _valor"
            		+ "\n limpar _ind \n dinheiro _valor \n saldo \n troco \n comprar _ind";
        else if(ui[0].equals("iniciar")) {
            maq = new Maquina(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
        	maq.max(Integer.parseInt(ui[2]));
        }
        
        else if(ui[0].equals("set"))
            maq.add(Integer.parseInt(ui[1]), ui[2], Integer.parseInt(ui[3]), toFloat(ui[4]));
        
        else if (ui[0].equals("limpar"))
        	maq.limpar(Integer.parseInt(ui[1]));
        
        else if (ui[0].equals("troco"))
        	maq.troco();
        
        else if (ui[0].equals("dinheiro"))
        	maq.addDinheiro(toFloat(ui[1]));
        
        else if (ui[0].equals("saldo"))
        	return "" + "Saldo: " + maq.saldoCliente;
        
        else if (ui[0].equals("comprar"))
        	maq.comprar(Integer.parseInt(ui[1]));
        
        
        else if(ui[0].equals("show"))
            return "" + maq;
        else
            return "comando invalido";
        return "done";
    }
}

public class IO {
    //cria um objeto scan para ler strings do teclado
    static Scanner scan = new Scanner(System.in);
    
    //aplica um tab e retorna o texto tabulado com dois espaços
    static private String tab(String text){
        return "  " + String.join("\n  ", text.split("\n"));
    }
    
    public static void main(String[] args) {
        Controller cont = new Controller();
        System.out.println("Digite um comando ou help:");
        while(true){
            String line = scan.nextLine();

            try {
                //se não der problema, faz a pergunta e mostra a resposta
                System.out.println(tab(cont.oracle(line)));
            }catch(Exception e) {
                //se der problema, mostre o erro que deu
                System.out.println(tab(e.getMessage()));
            }
        }
    }
}

