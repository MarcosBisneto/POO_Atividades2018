package model;

import java.util.ArrayList;

public class Lista {
    private String titulo;
    private ArrayList<Card> cartoes = new ArrayList<>();
    private int cartaoSelecionado;
    
    public Lista(String titulo){
        this.titulo = titulo;
    }
    
    public void cadastrarCartao(Card cartao){
        this.cartoes.add(cartao);
    }

    public ArrayList<Card> getCartoes() {
        return cartoes;
    }
    
    
    public Card getCartaoSelecionado(){
        return cartoes.get(cartaoSelecionado);
    }
    
    
    public Card getCartaoPorIndiceEDeletar(int indice){
        Card cartao = cartoes.get(indice);
        cartoes.remove(indice);
        return cartao;
    }
    
    
    public boolean alternarCartao(int indice){
        if (indice < 0 || indice >= cartoes.size()){
            return false;
        }
        this.cartaoSelecionado = indice;
        return true;
    }
    
    
    public String getTitulo() {
        return titulo;
    }
    
}