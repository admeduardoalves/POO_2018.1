import java.util.ArrayList;
import java.util.List;

public class Agenda {
		//criando lista de contatos do tp contato
		private List<Contato> contatos;
		//construtor
		public Agenda() {
			//recenbendo os valores da lista de contatos
			this.contatos = new ArrayList<Contato>();
		}
		//pegando valores da lista de contatos
		public List<Contato> getContatos() {
			//retornando contatos
			return contatos;
		}
			//adicionar contato
			public boolean addContato(Contato contato) throws Exception{
				//para cada contato dentro de contatos
				for (Contato cont : contatos) {
					//se nome do contato ja estiver na lista de contatos
					if(cont.getNome().equals(contato.getNome())) {
						throw new Exception("Contato já existente");
					}
				}
				//adicionar contato na lista de contatos
				return this.contatos.add(contato);
					}
			//remover contato
			public boolean rmContato(String nome) throws Exception {
				//para cada contato dentro da lista de contatos
				for (Contato cont : contatos) {
					// se contato existe
					if(cont.getNome().equals(nome)) {
						//retorna remoção do contato da lista de contatos
						return this.contatos.remove(cont);
					}
				}
				throw new Exception("Contato não existe");
			}
			//procura contato
			public Contato seach(String nome) throws Exception {
				//para cada contato na lista de contatos
				for (Contato contato : contatos) {
					//se achar contato na lista
					if(contato.getNome().equals(nome)) {
						//retorna contato
						return contato;
					}
				}
				throw new Exception("Contato não encontrado");
			}
			
			//adicionar telefone
			public boolean addTelefone(String nome, Telefone telefone) throws Exception {
				//para cada contato dentro da lista de contatos
				for (Contato contato : contatos) {
					// se achar contato
					if(contato.getNome().equals(nome)) {
						//adiciona telefone 
						return contato.addTelefone(telefone);
					}
				}
				throw new Exception("Contato não encontrado");
			}
			//remover contato
			public boolean rmTelefone(String nome, String foneId) throws Exception {
				//para cada contato dentro da lista de contatos
				for (Contato contato : contatos) {
					// se achar contato
					if(contato.getNome().equals(nome)) {
						//remover telefone 
						return contato.rmTelefone(foneId);
					}
				}
				throw new Exception("Contato não encontrado");
			}
			
			
		}
