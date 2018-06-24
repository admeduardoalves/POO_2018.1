import java.util.ArrayList;

public class Controller {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		while (true) {
			String line = input.input("Digite um comando: ");
			System.out.println(line);
			ArrayList<String> userInput = input.split(line, " ");
			
			try {
				if(userInput.get(0).equals("addContato")) {
					//adicionar novo contato a agenda
					agenda.addContato(new Contato(userInput.get(1)));
				}else if (userInput.get(0).equals("rmContato")) {
					//remover contato da agenda
					agenda.rmContato(userInput.get(1));
				}else if (userInput.get(0).equals("seach")) {
					//procurar contato dentro da agenda
					agenda.seach(userInput.get(1));
				}else if (userInput.get(0).equals("addFone")) {
					//adicionar novo telefone dentro da agenda
					agenda.addTelefone(userInput.get(1), new Telefone(userInput.get(2), 
														input.toInt(userInput.get(3))));
				}else if (userInput.get(0).equals("rmFone")) {
					//remover telefone da agenda
					agenda.rmTelefone(userInput.get(1), userInput.get(2));
				}else if (userInput.get(0).equals("fim")) {
					//sair 
					break;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
