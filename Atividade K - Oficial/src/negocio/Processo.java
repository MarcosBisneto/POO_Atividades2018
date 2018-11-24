package negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.User;
import model.Quadro;
import model.Lista;
import model.Card;
import model.Comentario;
import model.Etiquetas;
import model.Log;

public class Processo {
	public  boolean logadoStatus= false;
	private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();
    private  ArrayList<Quadro> quadros = new ArrayList<>();
    public ArrayList<Card> cards = new ArrayList<>();
    public int idUserSelecionado = 0;
    public int posicao=0;
    
    //menus
    public String menu1() {
    	return     "SEJA BEM VINDO - TRELLAR \n"
           	 + "1 - Login\n" //se clicar nessa opçao vem o formaulario de LOGIN.
             + "2 - Cadastrar Usuario\n" //se clicar nessa opçao vem o formaulario de cadastro.
             + "0 - Sair";
    }
    public String menu2() {
    	return  "  1 -  Criar Novo Quadro\n" //se clicar nessa opçao vem o formaulario NOVO QUADRO.
                + "2 -  Meus Quadros - Listar Quadros\n" //tela com a lista.
                + "3 -  Selecionar Quadro\n"
                + "4 -  Voltar";
    }
    public String menu3() {
    	return "   1 - Cadastrar tarefa\n" //se clicar nessa opçao vem o formaulario NOVO cadastrar tarefa.
    			+ "2 -  Listar tarefas\n" // listas tarefas. 
        		+ "3 -  Selecionar tarefa\n"
        		+ "4 -  Voltar";
    }
    public String menu4() {
    	return "   1 -  Adicionar Card\n"
                + "2 -  Listar Cards\n"      
                + "3 -  Selecionar Cards\n"
                + "0 -  Voltar";
    }
    public String menu5() {
    	  return  "1 - Adicionar descrição ao card\n"
                + "2 - Adicionar comentario ao cartao\n"
                + "3 - Adicionar etiqueta ao cartao\n"
                + "4 - Alternar cartao para outra tarefa\n"
                + "0 - Voltar";
    }

    //METODOS DE NEGOCIO PARA GERENCIAR.
    public boolean cadastrarUser(String nome, String login, String senha){
        if (nome.trim().length() == 0 || login.trim().length() == 0 || senha.trim().length() == 0) {
            return false;
        }
        User usuario = new User(nome, login, senha);
        this.users.add(usuario);
        return true;
    }
    public boolean login(String idLogin, String senha){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).login(idLogin, senha)){
                selecionarUser(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean selecionarUser(int indiceUser){
        if (indiceUser < 0 || indiceUser >= users.size()){
            return false;
        }
        this.idUserSelecionado = indiceUser;
        return true;
    }
    
    public ArrayList<User> getUsuariosCadastrados() {
        return users;
    }
    
    
    public User getUserSelecionado(){
        return this.users.get(idUserSelecionado);
    }
    
    
    public void cadastrarQuadro(String titulo){
        users.get(idUserSelecionado).quadros.add((new Quadro(titulo)));
        
       String log = " >> O quadro " + titulo + " foi adicionado";
        addLog(log);
        
    }
    
    
    private int getUserLogin(String login){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getLogin().equals(login)){
                return i;
            }
        }
        return -1;
    }
    
    
    public ArrayList<Quadro> getQuadrosCadastrados(){
        return users.get(idUserSelecionado).getQuadros();
    }
    
    public ArrayList<Lista> getTarefasCadastradas(){
        return users.get(idUserSelecionado).getQuadroSelecionado().getTarefas();
    }
    
    
    public Quadro selecionarQuadro(String titulo){
    	for(int i = 0; i < this.quadros.size();i++) {
			if(this.quadros.get(i).titulo.equals(titulo)) 
				return this.quadros.get(i);
		}
		
    	return null;
    	
    }
    
    
    public boolean cadastrarTarefa(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Lista lista = new Lista(titulo);
        users.get(idUserSelecionado).getQuadroSelecionado().cadastrarTarefa(lista);
        String log = ">> A tarefa " + titulo+ " foi adicionada";
        addLog(log);
        return true;
    }
   
     
    public boolean selecionarTarefa(int indice){
        return users.get(idUserSelecionado).getQuadroSelecionado().alternarTarefa(indice);        
    }
    
    
    public boolean cadastrarCartao(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Card card = new Card(titulo);
        users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().cadastrarCartao(card);
        String log = ">> O cartão " + titulo + "foi adicionado";
        addLog(log);
        return true;
    }
    
    
    public ArrayList<Card> getCartoes(){
        return users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartoes();
    }
    
    
    public boolean selecionarCartao(int indice){
        return users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().alternarCartao(indice);        
    }
    
    
    public void moverCartao(int tarefa, int cartao){
        users.get(idUserSelecionado).getQuadroSelecionado().moverCartao(tarefa, cartao);
        String log = ">> O Card " + users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo() + "foi movido";
        addLog(log);
    }
    
    public boolean adicionarDescricao(String descricao){
        if (descricao.trim().length() == 0){
            return false;
        }
        users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarDescricao(descricao);
        String log = ">> A descricao <\n" + descricao + 
                ">foi adicioana no card: " + users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
        addLog(log);
        return true;
    }
    
    public boolean adicionarComentario(String comentario){
        if (comentario.trim().length() == 0){
            return false;
        }
        Comentario comentario1 = new Comentario(users.get(idUserSelecionado), comentario);
        users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarComentario(comentario1);
        String log = " >> O Comentario adicionado: \n" + comentario + 
                "adicioana ao cartao: " + users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
        addLog(log);
        return true;
    }
    
    
    
    public boolean adicionarEtiqueta(String titulo, String cor){
    	if (cor.trim().length() == 0 || titulo.trim().length() == 0){
    		return false;
    	}
    	Etiquetas etiqueta = new Etiquetas(titulo, cor);
    	users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarEtiqueta(etiqueta);
    	String log = "Nova etiqueta adicionada: \n" + titulo + 
    			"adicioana ao cartao: " + users.get(idUserSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
    	addLog(log);
    	return true;
    }
    
    private void addLog(String descricao){
        Log log = new Log(descricao);
        this.logs.add(log);
    }
    
	public String listarQuadros(){
		ArrayList<Quadro> quadros = getQuadrosCadastrados();
		//String quadros = "";
		if (quadros.isEmpty()) {
			return "Não há quadros cadastrados!";
		}
		for (int i = 0; i < this.quadros.size();i++){
				return +i+1+"º Quadro: "+  this.quadros.get(i).titulo;
			}
			return null; 
	}
    public String listarTarefas(){
        ArrayList<Lista> tarefas = getTarefasCadastradas();
        if (tarefas.isEmpty()){
             return "Nenhum registro localizado!";
        }
        for (int i = 0; i < tarefas.size(); i++){
            return i+1 + "º Tarefa "+ tarefas.get(i).getTitulo();
        }
		return null;
}
    public ArrayList<Log> getLog(){
        return logs;
    }
    
	public boolean isLogadoStatus() {
		return logadoStatus;
	}


	public boolean setLogadoStatus(boolean logadoStatus) {
		return this.logadoStatus = logadoStatus;
	}
	
    public void logoff(){
        setLogadoStatus(false);
        selecionarUser(0);
    }

	public void listagemListaCartoes(){
		if (cards.isEmpty()){
			   JOptionPane.showMessageDialog(null,"Não há Cards!");
			        }
			        for (int i = 0; i < cards.size(); i++){ 
			        	JOptionPane.showMessageDialog(null," Card"+ i+1);
			        	JOptionPane.showMessageDialog(null,">> Titulo - \n"+ cards.get(i).getTitulo());
			        	JOptionPane.showMessageDialog(null,">> Descricao - \n"+cards.get(i).getDescricao());
			            
			        	JOptionPane.showMessageDialog(null,"  > Comentario(s) Feito(s): ");
			            for (int j = 0; j < cards.get(i).getComentarios().size(); j++){
			                System.out.printf("\t -"+ cards.get(i).getComentarios().get(j).getComentario()+" - \n"+cards.get(i).getComentarios().get(j).getDataHora());
			            }
			            
			            JOptionPane.showMessageDialog(null,"  > Etiqueta(s) Aplicada(s): ");
			            for (int j = 0; j < cards.get(i).getEtiquetas().size(); j++){
			                JOptionPane.showMessageDialog(null,"\t - "+cards.get(i).getEtiquetas().get(j).getTitulo()+" - \n"+cards.get(i).getEtiquetas().get(j).getCor());
			            }
			}
	
	}

	

 	
}	