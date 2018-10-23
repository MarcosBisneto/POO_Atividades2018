package Modelo;

import java.util.ArrayList;

public class Repositorio {
	String nome;
	String descricao;
	int contador;
	
	public ArrayList<Arquivos> untracked = new ArrayList();
	public ArrayList<Arquivos> tracked = new ArrayList();
	public ArrayList<Commit> commits = new ArrayList();
	
	public Repositorio(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao; 
	}
	
	//GET INIT //UNTRACKED
	public String addArquivo(Arquivos arquivo) {
		untracked.add(arquivo);
		contador = contador +1;
		return "Arquivo adicionado no Repositorio %s" + nome;
	}
	public String removerArquivo(Arquivos arquivo) {
		for(int i = 0; i <untracked.size(); i++) {
			if(untracked.contains(arquivo)) {
				untracked.remove(arquivo);
				return "%s Arquivo foi removido";
			}
			else if(!untracked.contains(arquivo))
				return "Arquivo não existente";
			
		}
		return "Fim";
	}
	
	//TRACKED
	public String addStageZona(Arquivos arquivo) {
		tracked.add(arquivo);
		return "Arquivo adicionado";
	}
	public String removerStageZona(Arquivos arquivo) {
		for(int i =0; i < tracked.size(); i++) {
			if(tracked.contains(arquivo)) {
				tracked.remove(arquivo);
				return "Arquivo Removido";
			}else if(!tracked.contains(arquivo))
				return "Arquivo não existente";
		}
		return "Fim";
	}
	
}

