package Model;

public class ContaDigital {
	public int titular;
	public int senha;
	public int numero;
	public double saldo;
	public int limite;
	public ContaCorrente contaC;
	
	public ContaDigital(String titular3,int senha3,int numeroConta,int limiteD) {
		 this.contaC = new ContaCorrente(titular3,senha3,numeroConta,limiteD);
	}
	
	public void depositarDigital(double valorDepositar) {
		contaC.depositar(valorDepositar);
	}
	
	public void transferir(ContaBancaria conta,double valorTransferir) {
		this.saldo -= valorTransferir;
		conta.saldo += valorTransferir;
	}

}
