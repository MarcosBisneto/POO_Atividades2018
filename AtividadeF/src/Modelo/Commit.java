package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Commit {
	
	public String comentatio;
	public Date hora = new Date();
	public int contadorArquivos;
	public ArrayList<Arquivos> commits = new ArrayList();
	
	public Commit(String comentario, Date hora, int contadorArquivos, ArrayList<Arquivos>commits) {
		this.comentatio = comentario;
		this.hora = hora;
		this.contadorArquivos = contadorArquivos;
		this.commits = commits;
	}
	
	public void commitArquivo(Arquivos arquivo) {
		arquivo.status = "Commited";
	}
	
	

}
