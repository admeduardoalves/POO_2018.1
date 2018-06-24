

public class Telefone {
		//criando cariavel id
		public String foneId;
		//criando variavel numero
		public int numero;
		
		//construtor
		public Telefone(String foneId, int numero) {
			this.foneId = foneId;
			this.numero = numero;
		}
		
		//criando getters e setters das variasveis declarasdas na classe
		public String getFoneId() {
			return this.foneId;
		}
		
		public void setFoneId(String foneId) {
			this.foneId = foneId;
		}
		
		public int getNumero() {
			return numero;
		}
		
		public void setNumero(int numero) {
			this.numero = numero;
		}
		
		@Override
		public String toString() {
			return "FoneId: " + this.foneId + " Numero: " + this.numero;
		}
	}
