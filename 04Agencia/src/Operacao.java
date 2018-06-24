
public class Operacao {
	
		//declarando variaveis
		private String descricao;
		private float valor;
		private float saldoparcial = 0;
		
		//construtor
		public Operacao(String descricao, float valor) {
			this.descricao = descricao;
			this.valor = valor;
			this.saldoparcial += valor;
		}
	
			//getters e setters das variaveis da classe
			public String getDescricao() {
				return descricao;
			}
			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}
			public float getValor() {
				return valor;
			}
			public void setValor(float valor) {
				this.valor = valor;
			}
			public float getSaldoparcial() {
				return saldoparcial;
			}
			public void setSaldoparcial(float saldoparcial) {
				this.saldoparcial = saldoparcial;
			}
			
			public String toString() {
				return "" + descricao + " " + valor + " " + saldoparcial;
			}
			
		}
