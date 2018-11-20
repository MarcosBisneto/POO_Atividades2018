package model;

import java.util.ArrayList;

public class User {
    /* Variaveis */
    private String nome;
    private String login;
    private String senha;
    private ArrayList<Quadro> quadros = new ArrayList<>();
    private int quadroSelecionado = 0;
    
    /* Contrutor */
    public User(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    
    public void cadastrarNovoQuadro(Quadro quadro){
        this.quadros.add(quadro);
    }
    
    
    public void cadastrarNovoQuadro(String titulo){
        Quadro quadro = new Quadro(titulo);
        this.quadros.add(quadro);
    }
    
    
    public ArrayList<Quadro> getQuadros(){
        return this.quadros;
    }
    
    
    public Quadro getQuadroSelecionado(){
        return quadros.get(quadroSelecionado);
    }
    
    
    public boolean alternarQuadro(int indice){
        if (indice < 0 || indice >= quadros.size()){
            return false;
        }
        this.quadroSelecionado = indice;
        return true;
    }
    
    
    public boolean login(String login, String senha){
        return this.login.equals(login) && this.senha.equals(senha);
    }

    
    public String getNome() {
        return nome;
    }

    
    public String getLogin() {
        return login;
    }
    
}