package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Arquivos {
		public String nome;
		public String tipo;
		public String status = "Untracked";
		public String texto;
		public boolean editado = false;
		public ArrayList<String> modificacoes = new ArrayList();
		Date hora = new Date();
		
		public Arquivos(String nome, String tipo, String status) {
			this.nome = nome;
			this.tipo = tipo;
			this.status = "Untracked";
		}
		public void add() {
			this.status = "Tracked";
		}
		public void reset() {
			this.status = "Untracked";
		}
		
		//editar texto dentro do arquivo
		public void editar(String novo) {
			this.texto= texto + novo;
			this.modificacoes.add((this.texto));
			this.editado = true;
		}
		
		public void commit() {
			this.status = "Commited";
		}
		
}


