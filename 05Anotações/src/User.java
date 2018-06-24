public class User implements Comparable<User>{
	
		//declarando variaveis
		private String username;
		private String password;
		public Repositorio<Nota> notas;
		//pegando e retornando notas
		public Repositorio<Nota> getNotas() {
			return notas;
		}
		//definido notas
		public void setNotas(Repositorio<Nota> notas) {
			this.notas = notas;
		}
		//construtor
		public User(String username, String password) {
			this.username = username;
			this.password = password;
			notas = new Repositorio<Nota>(username);
		}
			//getters e setters das variaveis da classe
			public String getUsername() {
				return username;
			}
		
			public void setUsername(String username) {
				this.username = username;
			}
		
			public void setPassword(String password) {
				this.password = password;
			}
			
			public boolean matchPassword(String password) {
				return this.password.equals(password);
			}
			
			public String toString() {
				return username + ":" + password;
			}
		
			//saber se tem outro usuario como msm nome
			public int compareTo(User other) {
				return this.username.compareTo(other.username);
			}
		
		
		
		}
