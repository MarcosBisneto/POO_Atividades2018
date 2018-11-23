package negocio;

import java.util.ArrayList;
import model.User;
import model.Quadro;
import model.Lista;
import model.Card;
import model.Comentario;
import model.Etiquetas;
import model.Log;

public class Processos {
    private ArrayList<User> usuarios = new ArrayList<>();
    private ArrayList<Log> logs = new ArrayList<>();
    private int usuarioSelecionado = 0;
    
    //METODOS DE NEGOCIO PARA GERENCIAR O USER.
    public boolean cadastrarUsuario(String nome, String login, String senha){
        if (nome.trim().length() == 0 || login.trim().length() == 0 || senha.trim().length() == 0) {
            return false;
        }
        User usuario = new User(nome, login, senha);
        this.usuarios.add(usuario);
        return true;
    }
    
    
    public boolean selecionarUsuario(int indice){
        if (indice < 0 || indice >= usuarios.size()){
            return false;
        }
        this.usuarioSelecionado = indice;
        return true;
    }
    
    
    public boolean login(String idLogin, String senha){
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).login(idLogin, senha)){
                selecionarUsuario(i);
                return true;
            }
        }
        return false;
    }

    
    public ArrayList<User> getUsuariosCadastrados() {
        return usuarios;
    }
    
    
    public User getUsuarioSelecionado(){
        return this.usuarios.get(usuarioSelecionado);
    }
    
    
    public boolean cadastrarQuadro(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Quadro quadro = new Quadro(titulo);
        usuarios.get(usuarioSelecionado).cadastrarNovoQuadro(quadro);
        String log = " >> O quadro" + titulo + "foi adicionado";
        gerarLog(log);
        return true;
    }
    
    
    private int getIndiceDeUsuarioPorLogin(String login){
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getLogin().equals(login)){
                return i;
            }
        }
        return -1;
    }
    
    
    public ArrayList<Quadro> getQuadrosCadastrados(){
        return usuarios.get(usuarioSelecionado).getQuadros();
    }
    
    
    public boolean selecionarQuadro(int indice){
        return usuarios.get(usuarioSelecionado).alternarQuadro(indice);        
    }
    
    
    public boolean cadastrarTarefa(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Lista lista = new Lista(titulo);
        usuarios.get(usuarioSelecionado).getQuadroSelecionado().cadastrarTarefa(lista);
        String log = ">> A tarefa " + titulo+ " foi adicionada";
        gerarLog(log);
        return true;
    }
    
    
    public ArrayList<Lista> getTarefasCadastradas(){
        return usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefas();
    }
    
    
    public boolean selecionarTarefa(int indice){
        return usuarios.get(usuarioSelecionado).getQuadroSelecionado().alternarTarefa(indice);        
    }
    
    
    public boolean cadastrarCartao(String titulo){
        if (titulo.trim().length() == 0){
            return false;
        }
        Card card = new Card(titulo);
        usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().cadastrarCartao(card);
        String log = ">> O cartão " + titulo + "foi adicionado";
        gerarLog(log);
        return true;
    }
    
    
    public ArrayList<Card> getCartoesCadastrados(){
        return usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartoes();
    }
    
    
    public boolean selecionarCartao(int indice){
        return usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().alternarCartao(indice);        
    }
    
    
    public void moverCartao(int tarefa, int cartao){
        usuarios.get(usuarioSelecionado).getQuadroSelecionado().moverCartao(tarefa, cartao);
        String log = ">> O Card " + usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo() + "foi movido";
        gerarLog(log);
    }
    
    public boolean adicionarDescricaoAoCartao(String descricao){
        if (descricao.trim().length() == 0){
            return false;
        }
        usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarDescricao(descricao);
        String log = ">> A descricao <\n" + descricao + 
                ">foi adicioana no card: " + usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
        gerarLog(log);
        return true;
    }
    
    public boolean adicionarComentarioAoCartao(String comentario){
        if (comentario.trim().length() == 0){
            return false;
        }
        Comentario c = new Comentario(usuarios.get(usuarioSelecionado), comentario);
        usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarComentario(c);
        String log = " >> O Comentario adicionado: \n" + comentario + 
                "adicioana ao cartao: " + usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
        gerarLog(log);
        return true;
    }
    
    
    
    public boolean adicionarEtiquetaAoCartao(String titulo, String cor){
    	if (cor.trim().length() == 0 || titulo.trim().length() == 0){
    		return false;
    	}
    	Etiquetas etiqueta = new Etiquetas(titulo, cor);
    	usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().adicionarEtiqueta(etiqueta);
    	String log = "Nova etiqueta adicionada: \n" + titulo + 
    			"adicioana ao cartao: " + usuarios.get(usuarioSelecionado).getQuadroSelecionado().getTarefaSelecionada().getCartaoSelecionado().getTitulo();
    	gerarLog(log);
    	return true;
    }
    
    private void gerarLog(String descricao){
        Log log = new Log(descricao);
        this.logs.add(log);
    }
    
    public ArrayList<Log> getLog(){
        return logs;
    }
    
}
