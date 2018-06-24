import java.util.ArrayList;

public class Tweet {
		//criando variavel id do tweet
		private int idTweet;
		//crainado variavel do tp usuario us
		User us;
		//criando variavel titulo
		private String titulo;
		//criando variavel texto 
		private String texto;
		//criando variavel like
		private boolean isLike;
		//criando variavel lido
		private boolean isLido;
		//criando lista do tp strind da qtd de likes
		private ArrayList<String> quantidadedelikes ;
		
		//criando construtor
		public Tweet(int idTweet,User us,String titulo, String texto) {
			//recebendo id tweet
			this.idTweet = idTweet;
			//recebendo o usuario
			this.us = us;
			//recebendo titulo
			this.titulo = titulo;
			//recebendo texto
			this.texto = texto;
			//recebendo valor do like lido(falso)
			this.isLido = false;
			//recebendo valor do like(falso)
			this.isLike = false;
			//criando nova lista de qtd de likes
			quantidadedelikes = new ArrayList<String>();
		}
		
			//criando setters e getters pegando valores do usuario(id do tweet, usuario, titulo, texto, like e lido)
			public int getIdTweet() {
				return idTweet;
			}
		
			public void setIdTweet(int idTweet) {
				this.idTweet = idTweet;
			}
		
			public User getUs() {
				return us;
			}
		
			public void setUs(User us) {
				this.us = us;
			}
		
			public String getTitulo() {
				return titulo;
			}
		
			public void setTitulo(String titulo) {
				this.titulo = titulo;
			}
		
			public String getTexto() {
				return texto;
			}
		
			public void setTexto(String texto) {
				this.texto = texto;
			}
			
			public boolean isLike() {
				return isLike;
			}
		
		
			public void setLike(boolean isLike) {
				this.isLike = isLike;
			}
		
		
			public boolean isLido() {
				return isLido;
			}
		
		
			public void setLido(boolean isLido) {
				this.isLido = isLido;
			}
			
			public ArrayList<String> getQuantidadedelikes() {
				return quantidadedelikes;
			}
			//dar like
			public void darLike(String username) {
			//adiciona o nome de quem deu o like a qtd de likes
		       this.quantidadedelikes.add(username);
			}
			
			//mostar likes	
			public String mostrarLikes() {
				String saida = "";
				//enquanto i for menor que qtd de likes
				for(int i = 0; i < quantidadedelikes.size(); i++) {
					//saida recebe qtd de likes	
					saida += ":" + quantidadedelikes.get(i) + "\n";
				}
				//retorna saida
				return saida;
			}
			
			public String toString() {
				return ""+ idTweet + ": "+ us + ": " + titulo + ": " + texto ;
			}
		}
