
public class Vendas {

	private String idCli;
	private String idAni;
	private String idSer;
	
	public Vendas(String idcliente, String idanimal, String idservico) {
		this.idCli = idcliente;
		this.idAni = idanimal;
		this.idSer = idservico;
	}

	public String getIdcliente() {
		return idCli;
	}

	public void setIdcliente(String idcliente) {
		this.idCli = idcliente;
	}

	public String getIdanimal() {
		return idAni;
	}

	public void setIdanimal(String idanimal) {
		this.idAni = idanimal;
	}

	public String getIdservico() {
		return idSer;
	}

	public void setIdservico(String idservico) {
		this.idSer = idservico;
	}
	
	public String toString() {
		return " " + "[" + idCli + " : " + idAni + " : " + idSer + "]" ;
	}
}