
public class Cliente {

	//declarando variaveis
	private String idcliente;
	private String nome;
	Repositorio<Animal> animais;
	
	//construtor
	public Cliente(String idcliente, String nome) {
		this.idcliente = idcliente;
		this.nome = nome;
		animais = new Repositorio<Animal>("animais");
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}
	//pegando lista de animais e retornando animais
	public Repositorio<Animal> getAnimais() {
		return animais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String mostrarAnimais() {
		String saida = " ";
		//para cada aniaml dentro da lista de animais 
		for(Animal a : animais.getAll())
			//saida recebe animais
			saida += a.toString() + "\n";
		return saida;
	}
	
	public String toString() {
		return "" + idcliente + " : " + nome;
	}
}
