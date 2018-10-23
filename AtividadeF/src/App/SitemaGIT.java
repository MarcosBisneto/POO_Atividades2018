package App;

import javax.swing.JOptionPane;

import Modelo.Repositorio;
import Negocios.ControleAcoes;

public class SitemaGIT {

	public static void main(String[] args) {
		menuSistema();
	}
	
	public static void menuSistema() {
		ControleAcoes master = new ControleAcoes();
		int opcao = Integer.valueOf(JOptionPane.showInputDialog(null, master.menuSistema()));
		
		while(opcao!=0) { 
			if(opcao == 1) {
				String nome = JOptionPane.showInputDialog("Nome do Diretorio: ");
				String descricao = JOptionPane.showInputDialog("Descrição: ");
				Repositorio repositorio1 = new Repositorio(nome,descricao);
				master.repositorios.add(repositorio1);
				JOptionPane.showMessageDialog(null, "O Repositorio " + nome + " foi criado com Sucesso!");
				opcao = Integer.valueOf(JOptionPane.showInputDialog(null, master.menuSistema()));
				
			}else if(opcao ==2) {
				master.mostrarRepositorios(master);
				
				break;
				
			}else if(opcao ==3) {
				
				
			}
			
		}
		
		
		
	}
	
	public void menuDiretorio() {
		JOptionPane.showMessageDialog(null,"1-> Adicionar Arquivo\n2-> Listar Arquivos\n3-> Editar ou Remover\n4-> Git add\n5-> Reset\n6-> Commit\n7-> Status\n"
				+ "8-> Log\n0-> Sair ");
	}

}
