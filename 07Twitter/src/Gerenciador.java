
public class Gerenciador {
		//criando variavel repositorio do tp tweet com nome tweets
		private Repositorio<Tweet> tweets;
		
		// criando construtor
		public Gerenciador() {
			//criando gerador de tweets para armazenar tweets  
			tweets = new Repositorio<Tweet>("tweets");
		}
		//pegando tweets armazenados 
		public Repositorio<Tweet> getTweets() {
			return tweets;
		}
		// definindo tweet armazenados
		public void setTweets(Repositorio<Tweet> tweets) {
			this.tweets = tweets;
		}
		//gerar tweet
		public void gerarTweet(Tweet t) {
			//adiciona um tweet recebendo id do tweet 
			this.tweets.add(""+t.getIdTweet(), t);
		}
		//mostar tweets
		public String showTweets() {
			String saida = "";
			//para cada tweet dentro do repositorio de tweets
			for(Tweet t : tweets.getAll())
				//saida recebe tweet
				saida += t.toString() + "\n";
			//retorna saida
			return saida;
		}
	}
