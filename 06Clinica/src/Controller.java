import java.util.Scanner;

public class Controller {
	Repositorio<Cliente> usuarios;
	Repositorio<Servico> servicos; 
	Repositorio<Vendas> vendas;
	float saldo = 0f; 
	int numani = 1;
	int numerodevendas = 0;
	
		
	Scanner scan;
		
	public Controller() {
		scan = new Scanner(System.in);
		usuarios = new Repositorio<Cliente>("username");
		servicos = new 	Repositorio<Servico>("servicos");
		vendas = new Repositorio<Vendas>("vendas");
	}

	public String query(String line) {
		String[] ui = line.split(" ");


		if(ui[0].equals("help")) {
			System.out.println("addCliente__idCli _nome_completo");
			System.out.println("addAnimal _idAni _especie");
			System.out.println("addServico _idSer _preco");
			System.out.println("Vender _idDono _idAnimal _idServiço");
			System.out.println("showClientes");
			System.out.println("showAnimal");
			System.out.println("showAnimaleCliente");
			System.out.println("showServicos");
			System.out.println("showVendas");
			System.out.println("Saldo");
			System.out.println("Help");
						
		}
				
		else if (ui[0].equals("addCliente")) {
			 String texto = " ";
	         for(int i = 2 ; i<ui.length; i++)
	    	     texto += ui[i] + " ";
			usuarios.add(ui[1], new Cliente(ui[1], texto));
		}
		
		
		else if(ui[0].equals("addAnimal")) {
			usuarios.get(ui[1]).animais.add(ui[2] , new Animal(numani,ui[2],ui[3], ui[1]));
		    numani+=1;
		}
		
		else if(ui[0].equals("addServico")) {
			servicos.add(ui[1], new Servico(ui[1],Float.parseFloat(ui[2])));
		}
		

		else if(ui[0].equals("vender")) {
		    usuarios.get(ui[1]); 
		    usuarios.get(ui[1]).animais.get(ui[2]);
		    servicos.get(ui[3]);
		    vendas.add(""+numerodevendas, new Vendas(ui[1],ui[2],ui[3]));
		    saldo += servicos.get(ui[3]).getPreco();
		    numerodevendas+=1;
		}

		else if (ui[0].equals("showClientes")) {
			String saida = " ";
			for(Cliente us : usuarios.getAll())
				saida += us.toString() + "\n";
			return saida;
		}
		
		else if(ui[0].equals("showAnimal")) {
		   String saida = " ";
		   for(Cliente us : usuarios.getAll())
			   saida += us.mostrarAnimais() + "\n";
		   return saida;
		}
		
		else if(ui[0].equals("showAnimaleCliente")) {
		   System.out.println(usuarios.get(ui[1]).animais.getAll().toString());
		}
		
		
		else if(ui[0].equals("showServicos")) {
			String saida = " ";
			for(Servico ser : servicos.getAll())
				saida += ser.toString() + " \n";
			return saida;
		}
		
		else if(ui[0].equals("showVendas")){
		    String saida = " ";
		    for(Vendas v : vendas.getAll())
			    saida += v.toString() + "\n";
		    return saida;
		}
		
		else if(ui[0].equals("Saldo")) {
			System.out.println("Saldo: " + saldo);
		}
		
		else
			return " Comando invalido! \n Digite Help para ver as opções";
		return "done";
	}
	
		public void shell() {
			while (true) {
				String line = scan.nextLine();
				try {
					System.out.println(query(line));
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}
			}
		}
		
		public static void main(String[] args) {
	        Controller c = new Controller();
	        c.shell();
	    }  
	}