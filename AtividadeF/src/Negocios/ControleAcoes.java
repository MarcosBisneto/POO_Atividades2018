package Negocios;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import Modelo.*;
import Modelo.Repositorio;

public class ControleAcoes {
	
	public ArrayList<Repositorio> repositorios = new ArrayList();
	
	public Repositorio AbrirRepositorio(String nome) {
		for(int i = 0; i < repositorios.size(); i++)
			if(repositorios.get(i).nome.equals(nome))
				return repositorios.get(i);
			return null;
	}
	
	//Atenção Para untracked aqui //para ajeitar
	public void mostrarRepositorios(ControleAcoes repositorio) {
		for (int i =0; i < repositorio.repositorios.size();i++)
			System.out.println("Nome: " + repositorio.repositorios.get(i).nome + 
					"\nQuantidade de Arquivos: " +repositorio.repositorios.get(i).untracked.size());	
	}
	
	public void listarArquivos(Repositorio arquivo) {
		for (int i =0; i <arquivo.untracked.size(); i++) {
			System.out.println("Arquivo: " + i + " " + arquivo.untracked.get(i).nome + arquivo.untracked.get(i).tipo +"\n" 
		+ "Conteudo" + arquivo.untracked.get(i).texto + "Status: " + arquivo.untracked.get(i).status);
		}
	}

	public void mudança(Arquivos arquivo) {
		for(int i = 0; i <arquivo.modificacoes.size(); i++) {
			System.out.println("Alterações realizadas no arquivo" + "Versão" + i + arquivo.modificacoes.get(i));
		}
	}
	public void mostrarAquivosCommited(Repositorio repositorio) {
		for(int i = 0;i<repositorio.untracked.size();i++) {
			this.mudança(repositorio.untracked.get(i));
		}
	}
	
	public String horaData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public String menuSistema() {
		return "-- SISTEMA MENU -- \n1-> Criar Repositório\n2-> Acessar Repositório"; 
	}

}
