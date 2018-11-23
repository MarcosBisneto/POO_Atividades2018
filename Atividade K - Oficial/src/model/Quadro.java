package model;

import java.util.ArrayList;

public class Quadro {

	private String titulo;
	private ArrayList<Lista> tarefas = new ArrayList<>();
	private int tarefaSelecionada;

	public Quadro(String titulo){
		this.titulo = titulo;
	}


	public void cadastrarTarefa(Lista tarefa){
		this.tarefas.add(tarefa);
	}


	public ArrayList<Lista> getTarefas() {
		return tarefas;
	}


	public Lista getTarefaSelecionada(){
		return tarefas.get(tarefaSelecionada);
	}


	public boolean alternarTarefa(int indice){
		if (indice < 0 || indice >= tarefas.size()){
			return false;
		}
		this.tarefaSelecionada = indice;
		return true;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void moverCartao(int tarefa, int cartao){
		Card card = tarefas.get(tarefaSelecionada).getCartaoPorIndiceEDeletar(cartao);
		tarefas.get(tarefa).cadastrarCartao(card);
	}

}
