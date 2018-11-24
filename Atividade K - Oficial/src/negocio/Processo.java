package negocio;

import java.util.ArrayList;
import model.User;
import model.Quadro;
import model.Lista;
import model.Card;
import model.Comentario;
import model.Etiquetas;
import model.Log;

public class Processo {
	private int usuarioNumber = 0; 
	
	private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();
    
    
    //METODOS DE NEGOCIO PARA GERENCIAR O USER.
    public boolean cadastrarUser(String nome, String login, String senha){
        if (nome.trim().length() == 0 || login.trim().length() == 0 || senha.trim().length() == 0) {
            return false;
        }
        User usuario = new User(nome, login, senha);
        this.users.add(usuario);
        return true;
    }
    
    
    public boolean selecionarUser(int indice){
        if (indice < 0 || indice >= users.size()){
            return false;
        }
        this.usuarioNumber = indice;
        return true;
    }
    
    
    public boolean loginUser(String idLogin, String senha){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).login(idLogin, senha)){
                selecionarUser(i);
                return true;
            }
        }
        return false;
    }

    //lista 
    public ArrayList<User> getUsersLista() {
        return users;
    }
    
    // selecionado usuario
    public User getUsersSelecionado(){
        return this.users.get(usuarioNumber);
    }
    
    
    public boolean addQuadro(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Quadro quadro = new Quadro(titulo);
        users.get(usuarioNumber).cadastrarNovoQuadro(quadro);
        String log = " >> O quadro " + titulo + " foi adicionado";
        registrarLogs(log);
        return true;
    }
    
    
    private int getUserLogin(String login){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getLogin().equals(login)){
                return i;
            }
        }
        return -1;
    }
    
    
    public ArrayList<Quadro> getQuadroCadastrados(){
        return users.get(usuarioNumber).getQuadros();
    }
    
    
    public boolean selecionarQuadro(int indiceCard){
        return users.get(usuarioNumber).alternarQuadro(indiceCard);        
    }
    
    
    public boolean addTarefa(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Lista lista = new Lista(titulo);
        users.get(usuarioNumber).getQuadroSelecionado().cadastrarTarefa(lista);
        String log = ">> A tarefa " + titulo+ " foi adicionada";
        registrarLogs(log);
        return true;
    }
    

    public boolean selecionarTarefa(int indice){
        return users.get(usuarioNumber).getQuadroSelecionado().alternarTarefa(indice);        
    }
    
    public ArrayList<Lista> getTarefasCadastrada(){
        return users.get(usuarioNumber).getQuadroSelecionado().getTarefas();
    }
    
    public boolean addCartao(String tituloCartao){
        if (tituloCartao.trim().length() == 0){
            return false;
        }
        Card card = new Card(tituloCartao);
        users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().cadastrarCartao(card);
        String log = ">> O cartão " + tituloCartao + "foi adicionado";
        registrarLogs(log);
        return true;
    }
    
    
    public ArrayList<Card> getCartoesCadastrados(){
        return users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartoes();
    }
    
    
    public boolean selecionarCartao(int indice){
        return users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().alternarCartao(indice);        
    }
    
    
    public void moverCartao(int tarefa, int cartao){
        users.get(usuarioNumber).getQuadroSelecionado().moverCartao(tarefa, cartao);
        String log = ">> O Card " + users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo() + "foi movido";
        registrarLogs(log);
    }
    
    // adicionar descrição nos cards
    public boolean addDescricao(String descricao){
        if (descricao.trim().length() == 0){
            return false;
        }
        users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarDescricao(descricao);
        String log = ">> A descricao <\n" + descricao + 
                ">foi adicioana no card: " + users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
        registrarLogs(log);
        return true;
    }
 // adicionar comentarios nos cards
    public boolean addComentario(String comentario){
        if (comentario.trim().length() == 0){
            return false;
        }
        Comentario comentario1 = new Comentario(users.get(usuarioNumber), comentario);
        users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarComentario(comentario1);
        String log = " >> O Comentario adicionado: \n" + comentario + 
                "adicioana ao cartao: " + users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
        registrarLogs(log);
        return true;
    }
    
    
 // adicionar etiquetas nos cards
    public boolean addEtiqueta(String titulo, String cor){
    	if (cor.trim().length() == 0 || titulo.trim().length() == 0){
    		return false;
    	}
    	Etiquetas etiqueta = new Etiquetas(titulo, cor);
    	users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarEtiqueta(etiqueta);
    	String log = "Nova etiqueta adicionada: \n" + titulo + 
    			"adicioana ao cartao: " + users.get(usuarioNumber).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
    	registrarLogs(log);
    	return true;
    }
    
    public ArrayList<Log> getLog(){
        return logs;
    }
    
    private void registrarLogs(String descricao){
        Log log = new Log(descricao);
        this.logs.add(log);
    }
    
    
}
