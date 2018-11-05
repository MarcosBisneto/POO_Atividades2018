package Aplicação;

import javax.swing.JOptionPane;

import Negocio.BancoTransações;

public class Aplicação {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BancoTransações itau = new BancoTransações();
		
		int op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
		while(op != 0) {
			switch(op){
			case 1:
				
				int escolher = Integer.parseInt(JOptionPane.showInputDialog("Selecione tipo de conta:\n1->Conta Poupança\n2-> Conta Corrente\n"
						+ "3->Conta Digital"));
				switch(escolher) {
				case 1:
					String nome = JOptionPane.showInputDialog("Nome Completo: ");
					int senha = Integer.parseInt(JOptionPane.showInputDialog("Crie uma Senha: "));
					int numConta = Integer.parseInt(JOptionPane.showInputDialog("Criar Número Conta: "));
					itau.nova_contaPoupança(nome, senha, numConta);
					JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso!");
					op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
					break;
					
				case 2:
					String nome1 = JOptionPane.showInputDialog("Nome Completo: ");
					int senha1 = Integer.parseInt(JOptionPane.showInputDialog("Crie uma senha: "));
					int numConta1 = Integer.parseInt(JOptionPane.showInputDialog("Digite número Conta : "));
					int limite = Integer.parseInt(JOptionPane.showInputDialog("Valor Limite da conta: "));
					itau.nova_contaCorrente(nome1, senha1, numConta1,limite);
					JOptionPane.showMessageDialog(null, "Conta Criada com sucesso!");
					op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
					break;
					
					
				case 3:
					String nome2 = JOptionPane.showInputDialog("Digite seu nome: ");
					int senha2 = Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha: "));
					int numConta2 = Integer.parseInt(JOptionPane.showInputDialog("Digite Número Conta: "));
					int limite2 = Integer.parseInt(JOptionPane.showInputDialog("Valor Limite da conta: "));
					itau.nova_contaDigital(nome2, senha2, numConta2,limite2);
					JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso!");
					op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
					break;
					
				}
			break;
			
			case 2:
				int conta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
				for(int i = 0;i < itau.CP; i++) {
					if(conta == itau.contasPoupanca[i].numeroConta) {
						double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do Deposito: "));
						itau.depositarPoupança(valor, itau.contasPoupanca[i]);
						JOptionPane.showMessageDialog(null, " >> O R$" +valor+" depositado com sucesso");
					}
			}
				op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
				break;
				
			case 3:
				int conta1 = Integer.parseInt(JOptionPane.showInputDialog("Digite número da conta: "));
				for(int i = 0;i < itau.CC; i++) {
					if(conta1 == itau.contasCCorrente[i].numeroConta) {
						double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser depositado: "));
						itau.depositarCorrente(valor, itau.contasCCorrente[i]);
						JOptionPane.showMessageDialog(null, ">> R$" +valor+" depositado com sucesso");
					}
			}
				op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
				break;
				
			case 4:
				int conta2 = Integer.parseInt(JOptionPane.showInputDialog("Digite número da conta: "));
				for(int i = 0;i < itau.CD; i++) {
					if(conta2 == itau.contasDigital[i].numero) {
						double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser depositado: "));
						itau.depositarPoupança(valor, itau.contasDigital[i]);
						JOptionPane.showMessageDialog(null, "R$" +valor+" depositado com sucesso");
					}
			}
				op = Integer.parseInt(JOptionPane.showInputDialog(itau.menuBanco()));
				break;
			}
		}
	}

}
