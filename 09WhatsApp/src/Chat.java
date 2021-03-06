
public class Chat {

	private String chat;
	Repositorio<Usuario> userchats;
    Repositorio<Mensagem> sms;
    int qtdsms = 0;
    
    public Chat(String chat) {
    	this.chat= chat;
    	userchats = new Repositorio<Usuario>("usuarios");
    	sms = new Repositorio<Mensagem>("mensagens");
    }

	public Repositorio<Mensagem> getSms() {
		return sms;
	}

	public void setSms(Repositorio<Mensagem> sms) {
		this.sms = sms;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public Repositorio<Usuario> getUserchats() {
		return userchats;
	}

	public void setUserchats(Repositorio<Usuario> userchats) {
		this.userchats = userchats;
	}

	public String mostrarUsers() {
		String saida ="[ ";
		for(Usuario us : userchats.getAll())
			saida+=us.toString() + " ";
		return saida + "]";
	}
	
    public void adicionarAoGrupo(Usuario user) {
		this.userchats.add(user.getIduser(), user);
		user.getGrups().add(this.getChat(), new Chat(this.getChat()));
	}
    
    public void escrever(Mensagem m) {
    	for(Usuario us : this.userchats.getAll()) {
    		us.getGrups().get(this.getChat()).getSms().add(m.getIndice(), m);
    	}
    	this.sms.add(m.getIndice(), m);
    }
    public String mostrarSms(String us) {
    	String saida="";
    	for(Mensagem m : this.sms.getAll()) {
    		if(!us.equals(m.getUser())) {
    			saida += m +" ";
    		}
    	}
    	return saida;
    }
    
    public int contarMensagens(String us) {
    	qtdsms = 0;
    	for(Mensagem m : this.sms.getAll()) {
    		if(!us.equals(m.getUser())) {
    			if(!m.isLido()) {
    			    qtdsms++;
    			    m.setLido(true);
    			}
    		}
    	}
    	return qtdsms;
    }
    
	public String toString() {
		return chat;
	}
}

