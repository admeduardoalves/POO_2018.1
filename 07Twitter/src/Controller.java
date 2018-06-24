import java.util.Scanner;

public class Controller {
		//criando repositorio de usuarios de tp usuario
		Repositorio<User> usuarios;
		Scanner sca;
		//criando numero de tweets
		int numertweet= 1;
		//criando variavel do tp TweetGerenciador 
		Gerenciador ger;
		//criando contador de tweets
		int contadortweets = 0;
		
	public Controller() {
		sca = new Scanner(System.in);
		//criando novo repositorio de usuarios
		usuarios = new Repositorio<User>("username");
		//craindo novo gerenciador de tweet
		ger = new Gerenciador();
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		//se digitar addUser
		if (ui[0].equals("addUser"))
			//adiciona novo usuario ao repositorio de usuarios 
			 usuarios.add(ui[1], new User(ui[1]));
		// se digitar showUser
		else if(ui[0].equals("showUser")) {
			String saida= "";
			//para cada usuario dentro de usuarios
			for(User user : usuarios.getAll())
				//saida recebe usuario + seguidores do usuario + seguidos do usuario
				saida += user.toString() + " seguidores: ["+ user.showSeguidores() +"] seguidos: [" + user.showSeguidos() +"] \n";
		    return saida;
		}	
		//se digitar seguir
		else if(ui[0].equals("seguir")) 
			//me adiciona na lista de seguidores e adiciona o outro usuario na lista de seguidos
			usuarios.get(ui[2]).seguir(usuarios.get(ui[1]));
		// se digitar criarTweet
		else if(ui[0].equals("criartweet")) {
	       String texto = "";
		
	       for(int i = 3 ; i<ui.length; i++)
	    	   texto += ui[i] + " ";
	       
	       for(User s : usuarios.get(ui[1]).getSeguidores().getAll()) 
        	   s.addTime(new Tweet(numertweet, usuarios.get(ui[1]), ui[2], texto));
           
           usuarios.get(ui[1]).criarTweet(new Tweet(numertweet, usuarios.get(ui[1]), ui[2], texto));      
           ger.gerarTweet(new Tweet(numertweet, usuarios.get(ui[1]), ui[2],texto));  
           numertweet++;
		}
		else if(ui[0].equals("mostrarMytweets"))
			System.out.println(usuarios.get(ui[1]).mostrarMytweets());
		else if(ui[0].equals("mostrartweets"))
			System.out.println(ger.showTweets());
		
		else if(ui[0].equals("mostrarTime")) 
			System.out.println(usuarios.get(ui[1]).mostrarTime());
		// se digitar dar liketweet	
		else if(ui[0].equals("liketweet")) {
			//
			usuarios.get(ui[1]).darLike(Integer.parseInt(ui[2]));
			//dar like
			ger.getTweets().get(ui[2]).darLike(usuarios.get(ui[1]).getIduser());
		}
		
		else if(ui[0].equals("showlikes")) {
			System.out.println(" " + ger.getTweets().get(ui[1]).mostrarLikes());
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
