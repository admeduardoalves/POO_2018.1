
public class Conta {
		//declarando variaveis
		private float saldo;
		private int numero;
		//declarando uma variavel do tp operação 
		private Repositorio<Operacao> extrato;
		private boolean ativa;
		int auxcontadorextrato;
		
		//construtor
		public Conta(int numero) {
			this.numero = numero;
			this.saldo += saldo;
			this.extrato = new Repositorio<Operacao>(null);
			this.ativa =  true;
		}
	
		public float getSaldo() {
			return saldo;
		}
	
		public float setSaldo(float saldo) {
			return this.saldo = saldo;
		}
	
		public int getNumero() {
			return numero;
		}
		//pegando extrato e mostrando extrato
		public Repositorio<Operacao> getExtrato() {
			return extrato;
		}
	
		public boolean isAtiva() {
			return ativa;
		}
	
		public void setAtiva(boolean ativa) {
			this.ativa = ativa;
		}
	
			public void sacar(float value) {
				// se conta estiver ativa
				if(ativa) {
					//se valor for menor que zero ou maior que o saldo
				     if(value < 0 && value > saldo)
					     throw new RuntimeException("fail: valor " + value + " menor que 0" );
				     //saldo - saque
				     this.setSaldo(saldo -= value);
				     //adiciona nova operação no extrato da conta
				     this.extrato.add( "" + auxcontadorextrato , new Operacao("sacar", value) );
				     auxcontadorextrato++;
				     return;
				}
				throw new RuntimeException("fail: Conta não ativa");
			}
			
			public void depositar(float value) {
				//se conta estiver ativa 
				if (ativa) {
					//se valor for menor que 0
					if (value < 0)
						throw new RuntimeException("fail: valor " + value + "menor que  0");
					//adiciona nova operação no extrato da conta
					this.extrato.add("" + auxcontadorextrato, new Operacao("depositar", value));
					//saldo + deposito
					this.saldo += value;
					auxcontadorextrato++;
				    return;
				}
				throw new RuntimeException("fail: Conta não ativa");
			}
			
			public void transferir(float value, Conta other) {
				//se conta estiver ativa 
				if (this.ativa) {
					//se valor da conta for 0
					if (value < 0)
						throw new RuntimeException("fail: valor" + value + "menor que 0");
					//adiciona nova operação no extrato da conta
					this.extrato.add("" + auxcontadorextrato, new Operacao("transferencia", value));
					//saldo - valor
					this.saldo -= value;
					//saldo do outro + valor
					other.saldo += value;
					auxcontadorextrato++;
					return;
				}
				throw new RuntimeException("fail: Conta não ativa");
			}
			
			public void encerrar() {
				this.ativa = false;
			}
			
		}
