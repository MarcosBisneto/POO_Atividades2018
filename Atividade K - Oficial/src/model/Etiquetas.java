package model;

public class Etiquetas {
    private String titulo;
    private String cor;
    
    public Etiquetas(String titulo, String cor){
        this.titulo = titulo;
        this.cor = cor;
    }

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public String getCor() {
        return cor;
    }

    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
}