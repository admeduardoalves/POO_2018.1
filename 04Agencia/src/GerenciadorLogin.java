public class GerenciadorLogin {
		//declarando variaveis
		private Repositorio<Cliente> usuarios;
		private Cliente user;
		
		//construtor
		public GerenciadorLogin(Repositorio<Cliente> usuarios) {
			this.usuarios = usuarios;
			user = null;
		}
	
			public void Login(String usuario, String password) {
				//se usuario for diferente de nulo
				if(user != null)
					throw new RuntimeException("fail: Ja existe alguem logado");
				//se senha e nome do usario nã exitirem na lista de usuarios 
				if(!usuarios.get(usuario).matchPassword(password)) 
				   throw new RuntimeException("fail: senha invalida ou pessoa nao encontrada");
				//loga usuario
				this.user = usuarios.get(usuario);
			}
		
			public void Logout() {
				//se usuario for nulo
				if(user == null)
				    throw new RuntimeException("fail: não está ninguem logado");
				System.out.println("ok");
				//desloga
				this.user = null;
			}
			
			public Cliente getUser() {
				if(user == null)
					throw new RuntimeException("fail: não está ninguem logado");
				return user;
			}
			
		}
