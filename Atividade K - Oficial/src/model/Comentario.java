package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comentario {
    private User usuario;
    private String comentario;
    private String dataHora;
    
    public Comentario(User usuario, String comentario){
        this.usuario = usuario;
        this.comentario = comentario;
        this.dataHora = dataHoraAtual();
    }
    

    private String dataHoraAtual(){
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(dataAtual);
    }
    
    
    public void alterarComentario(String comentario){
        this.comentario = comentario;
    }

    
    public String getComentario() {
        return comentario;
    }

    public String getDataHora() {
        return dataHora;
    }
    
}