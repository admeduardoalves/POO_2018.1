
public class Cliente implements Comparable<Cliente> {
		//declarando variaveis
		private String idcliente;
		private String password;
		//lista de contas do tp Conta
		Repositorio<Conta> contas;
		static int numero = 1;
		//Construtor
			public Cliente(String idcliente, String password) {
				this.idcliente = idcliente;
				this.password = password;
				this.contas = new Repositorio<Conta>("contas");
			}
	
			//getters e setters das variaveis passowor e idcliente
			public void setPassword(String password) {
				this.password = password;
			}
			
			public boolean matchPassword(String password) {
				return this.password.equals(password);
			}
			
			public String getIdcliente() {
				return idcliente;
			}
		
			public void setIdcliente(String idcliente) {
				this.idcliente = idcliente;
			}
			//pegando lista de contas e retornando
			public Repositorio<Conta> getContas() {
				return contas;
			}
		
			public String toString() {
				return " Cliente:" + idcliente;
			}
			//adicionando uma nova na lista de contas
			public void addConta() {
				this.contas.add("numero" ,new Conta(numero));
			}
			
			public int compareTo(Cliente other) {
				//comparando o id do cliente com o de outro cliente
				return this.idcliente.compareTo(other.idcliente);
			}
			
		}
