
public class User {
	 	//declarando variaveis da classe user
		private String iduser;
		//lista no repositorio de seguidores
		private Repositorio<User> seguidores;
		//lista no repositorio de seguidos
		private Repositorio<User> seguidos;
		//lista do tweets do usuario no repositorio
		private Repositorio<Tweet> mytweets;
		//lista de timelines do usuario
		private Repositorio<Tweet> timeline;
		Tweet mensagem;
		int contadortwittes = 0;
		
		// declarando construtor da classe user
		public User(String iduser) {
			//recebendo nome do usuario
			this.iduser = iduser;
			//criando um novo repositorio do tipo usuarios  de seguidores
			seguidores = new Repositorio<User>("seguidores");
			//criando um novo repositorio do tipo usuarios  de seguidos
			seguidos = new Repositorio<User>("seguidos");
			//criando um novo repositorio do tipo usuarios  de myTweets
			mytweets = new Repositorio<Tweet>("mytweets");
			//criando um novo repositorio do tipo usuarios  de timeline
		    timeline = new Repositorio<Tweet>("timeline");
		}
				//pegando e retonando timeline(Feed do usuario)
			public Repositorio<Tweet> getTimeline() {
				return timeline;
			}
			
			//pegando id do susario
			public String getIduser() {
				return iduser;
			}
			//definindo o id do usuario
			public void setIduser(String iduser) {
				this.iduser = iduser;
			}
			//pegando e retornando lista seguidores
			public Repositorio<User> getSeguidores() {
				return seguidores;
			}
			//pegando e retornando listaseguidos 
			public Repositorio<User> getSeguidos() {
				return seguidos;
			}
			
			public String toString() {
				return "" + iduser ;
			}
			//mostrar seguidores
			public String showSeguidores() {
				String saida = "";
				//para seguidores do tp Usuario dentro da lista de seguidores ou todos seguidores
				for(User seg : seguidores.getAll())
					//saida recebe seguidores
					saida += seg + " ";
				//retorna seguidores
				return saida ;
			}
			//mostrar seguidos
			public String showSeguidos() {
				String saida = "";
				//para seguidos do tp usuario dentro de lista de seguidos ou todos os seguidos
				for(User seg : seguidos.getAll())
					//sainda recebe seguidos
					saida += seg + " ";
		 		//retorna seguidos
				return saida ;
			}
			//seguir usuario
			public void seguir(User us) {
				//adiciono outro usuario na minha lista de seguidos
				us.seguidos.add(this.getIduser(), new User(this.getIduser()));
				//o usuario se adiciona na lista de seguidores do outro usuario
				this.seguidores.add(us.getIduser(), us);
			} 
			//criar tweet
		    public void criarTweet(Tweet t) {
				//adiciona um novo tweet do usuario aos tweets do usuario
				this.mytweets.add(""+t.getIdTweet(), t);
		    }		
		    
		    public void addTime(Tweet t) {
				//adiciona uma novo tweet a timeline do usuario
		    		this.timeline.add(""+t.getIdTweet(), t);
		    	
		    }
		        // mostrando tweets do usuario 
			public String mostrarMytweets() {
		    	String saida = "";  
			//para cada Tweet s dentro dos tweets do usuario
		    	for(Tweet s : mytweets.getAll()) {
				//saida recebe tweet + usuario +titulo do tweet + texto
		    		saida += " " + s.getIdTweet() + s.getUs() + ":"+s.getTitulo() + " " + s.getTexto() + "\n"; 
		    	}
			//retorna saida
		    	return saida;
		    }
			//mostrar timeline 
			public String mostrarTime() {
		    	String saida = "";
			//para cada tweet s dentro da timeline do usuario ou Feed
		    	for(Tweet s : timeline.getAll()) {
				//se o tweet  não for lido então
		    		if(!s.isLido()) {
				//saida recebe tweet + usuario + titulo + texto
		    		   saida += " " + s.getIdTweet() + " " +s.getUs() + ":"+s.getTitulo() + " " + s.getTexto() + "\n"; 
				//tweet fica lido
		    		   s.setLido(true);
				//conto os tweets lidos
		    	       contadortwittes++;
		    	    }
		    	}
			//mostra a qtd de tweets 
		    	System.out.println(" Voce tem :" + contadortwittes + " tweets");
			//zera o tweets do feed do usuario
		    	contadortwittes = 0;
		    	return saida;
		    }
			// dar like
			public void darLike(int idtweet) {
				//para cada tweet dentro da timeline
				for(Tweet s : timeline.getAll()) {
					// se o tweet que estou pegando estiver na timeline
					if(s.getIdTweet() == idtweet){
						//se n tiver like
						if(!s.isLike()) {
						// dar like
						   s.setLike(true);
						//retona
						   return;
						}
					}
				}
				//tweet n exite na timeline do usuario que eu quero dar like
				throw new RuntimeException("fail: você não possui esse tweet");
			}
			
			
		}
