package Negocio;

import Model.ContaCorrente;
import Model.ContaDigital;
import Model.ContaPoupan�a;

public class BancoTransa��es {
	
	public ContaPoupan�a contasPoupanca[] = new ContaPoupan�a[20];
	public ContaCorrente contasCCorrente[]= new ContaCorrente[20];
	public ContaDigital contasDigital[] = new ContaDigital[20];
	
	public int CP; 
	public int CD;
	public int CC;
	
	// criar contas 
	public void nova_contaPoupan�a(String titular,int senha,int numeroConta){
		this.contasPoupanca[CP]= new ContaPoupan�a(titular,senha,numeroConta);
	}
	
	public void nova_contaCorrente(String titular,int senha,int numeroConta, int limite){
		this.contasCCorrente[CC]= new ContaCorrente(titular,senha,numeroConta,limite);
	}
	
	public void nova_contaDigital(String titular,int senha,int numeroConta, int limite){
		this.contasDigital[CD]= new ContaDigital(titular,senha,numeroConta,limite);
	}
	
	//transa��es
	
	public void depositarPoupan�a(double valor,ContaDigital contasDigital2) {
		for(int i = 0;i <CP;i++) {
			if(this.contasPoupanca[i]== contasDigital2)
				this.contasPoupanca[i].depositar(valor);
		}
	}
	
	public void depositarCorrente(double valor,ContaCorrente conta) {
		for(int i = 0;i <CC;i++) {
			if(this.contasCCorrente[i]== conta)
				this.contasCCorrente[i].depositar(valor);
		}
	}
	
	public String menuBanco() {
		return "SEJA BEM VINDO! ITAU BANK\n1-> Criar Conta\n2-> Deposito Poupan�a\n3-> Deposito Corrente\n"
				+ "\n0-> Sair"
				+ "\nEscolha sua op��o: ";
	}
	
	
}
