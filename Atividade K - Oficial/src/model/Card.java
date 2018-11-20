package model;

import java.util.ArrayList;

	public class Card {
	    private String titulo;
	    private String descricao;
	    private String dataParaEntrega;
	    private ArrayList<Comentario> comentarios = new ArrayList<>();
	    private ArrayList<Etiquetas> etiquetas = new ArrayList<>();
	    
	    public Card(String titulo){
	        this.titulo = titulo;
	    }
	    
	    // metodos do Card 
	    public void adicionarDescricao(String descricao){
	        this.descricao = descricao;
	    }
	    
	    
	    public void adicionarDataParaEntrega(String dataParaEntrega){
	        this.dataParaEntrega = dataParaEntrega;
	    }
	    
	    
	    public void adicionarComentario(Comentario comentario){
	        this.comentarios.add(comentario);
	    }
	    
	    
	    public void adicionarComentario(User usuario, String titulo){
	        Comentario comentario = new Comentario(usuario, titulo);
	        this.comentarios.add(comentario);
	    }
	    
	    
	    public void adicionarEtiqueta(Etiquetas etiqueta){
	        this.etiquetas.add(etiqueta);
	    }
	    
	    
	    public void adicionarEtiqueta(String titulo, String cor){
	        Etiquetas etiqueta = new Etiquetas(titulo, cor);
	        this.etiquetas.add(etiqueta);
	    }
	    
	    
	    public String getTitulo() {
	        return titulo;
	    }

	    
	    public String getDescricao() {
	        return descricao;
	    }

	    
	    public String getDataParaEntrega() {
	        return dataParaEntrega;
	    }

	    
	    public ArrayList<Comentario> getComentarios() {
	        return comentarios;
	    }

	    
	    public ArrayList<Etiquetas> getEtiquetas() {
	        return etiquetas;
	    }
	    
	}
