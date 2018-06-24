public class Servico {

	//declarando variaveis
	private String idSer;
	private float preco;
	
	//construtor
	public Servico(String idservico, float preco) {
		this.idSer = idservico;
		this.preco = preco;
	}

	//getters e setters da classe
	public String getIdservico() {
		return idSer;
	}

	public void setIdservico(String idservico) {
		this.idSer = idservico;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return " " + idSer + " : " + preco;
	}
}
