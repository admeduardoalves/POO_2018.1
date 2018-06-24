import java.util.Scanner;

public class Controller {
		Repositorio<User> usuarios;
		Repositorio<Nota> notas;
		Scanner sca;
		GerenciadorLogin ger;
		    
		    
	public Controller() {
		sca = new Scanner(System.in);
		usuarios = new Repositorio<User>("username");
		ger = new GerenciadorLogin(usuarios);
		notas = new Repositorio<Nota>("notas");
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		if (ui[0].equals("addUser"))
			//adiciona novo usuario a lista de usuarios 
			usuarios.add(ui[1], new User(ui[1], ui[2]));
		else if (ui[0].equals("showUsers")) {
			String saida = "";
			//para cada usuario dentro de usuarios
			for(User us : usuarios.getAll())
				//saida recebe usuarios
				saida += us.getUsername() + "\n";
			return saida;
		}
		else if(ui[0].equals("loginUser"))
			//pega nome e senha
			ger.Login(ui[1], ui[2]);
		else if(ui[0].equals("logoutUser"))
			//desloga
			ger.Logout();
		else if(ui[0].equals("attPassword")){
			//pega senhado usuario 
			if(ger.getUser().matchPassword(ui[1]))
				//altera a senha do usuario
				ger.getUser().setPassword(ui[2]);
		}
		else if(ui[0].equals("addAnotacao")) {
		    String texto = "";
		    //enquanto texto for menor que i
		    for(int i = 2 ; i<ui.length; i++)
		    	// texto recebe texto
		    	texto += ui[i] + "";
		    //pega o texto e adiciona uma nova nota do usuario
		    ger.getUser().notas.add(ui[1], new Nota(ui[1],texto)); 	
		}
		else if(ui[0].equals("rmAnotacao"))
			//pega nota do usuario e remove
			ger.getUser().notas.remove(ui[1]);
		else if(ui[0].equals("showAnotacoes")) {
			String saida ="";
		//para cada usuario dentro de usuarios
		for(User u : usuarios.getAll())
			//saida recebe notas do usuario
			saida += u.getNotas() + "\n";
		return saida;
		}
		else
			return " Comando invalido";
		return "done";
	}




		public void shell() {
			while (true) {
				String line = sca.nextLine();
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
