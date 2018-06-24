
import java.util.ArrayList;
import java.util.List;

public class Contato {
		//criando variavel nome
		private String nome;
		//criando lista de telefones do tp telefone
		private List<Telefone> telefones;
		
		//contrutor
		public Contato(String nome) {
			//recebendo valores
			this.nome = nome;
			this.telefones = new ArrayList<>();
		}
		//criando getters e settters das variaveis
		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public List<Telefone> getTelefones() {
			return telefones;
		}
	
			//adcionar telefone
			public boolean addTelefone(Telefone telefone) throws Exception {
				//para cada telefone dentro da lista de telefones
				for (Telefone fone : telefones) {
					//se telefone eu achar o telefone
					if(fone.foneId.equals(telefone.getFoneId())) {
						throw new Exception("Telefone já existe");
					}
				}
				// adiciona telefone na lista de telefones
				return this.telefones.add(telefone);
			}
			//remover telefone
			public boolean rmTelefone(String foneId) throws Exception{
				// para cada telefone dentro da lista de telefones
				for (Telefone fone : telefones) {
					// se achar telefone
					if (fone.foneId.equals(foneId)) {
						// remove telefone da lista de telefones
						return this.telefones.remove(fone);
					}
				}
				throw new Exception("Identificador não encontrado");
			}
			
			@Override
			public String toString() {
				return "Nome: " + this.nome + " FoneId: " + this.telefones;
			}
		}
