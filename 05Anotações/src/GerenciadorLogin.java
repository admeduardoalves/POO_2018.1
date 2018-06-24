

public class GerenciadorLogin {
	
		//declarando lista de usuarios
		private Repositorio<User> usuarios;
		private User user;
		
		//construtor
		public GerenciadorLogin(Repositorio<User> usuarios) {
			this.usuarios = usuarios;
			user = null;
		}
	
			public void Login(String usuario, String password) {
				//se usuario estiver logado
				if(user != null)
					throw new RuntimeException("fail: Ja existe alguem logado");
				// se n achar nome do usuario e senha 
				if(!usuarios.get(usuario).matchPassword(password)) 
				   throw new RuntimeException("fail: senha invalida ou pessoa nao encontrada");
				//logar usuario
				this.user = usuarios.get(usuario);
			}
		
			public void Logout() {
				//se usuario estiver deslogado
				if(user == null)
				    throw new RuntimeException("fail: não está ninguem logado");
				System.out.println("ok");
				//deslogar
				this.user = null;
			}
			
			public User getUser() {
				if(user == null)
					throw new RuntimeException("fail: não está ninguem logado");
				return user;
			}
			
}
