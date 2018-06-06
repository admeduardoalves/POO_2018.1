public class Servico {

	private String idSer;
	private float preco;
	
	public Servico(String idservico, float preco) {
		this.idSer = idservico;
		this.preco = preco;
	}

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