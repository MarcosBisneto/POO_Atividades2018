package Model;

public class ContaBancaria {
	
	public int numeroConta;
	public String titular;
	public int senha;
	public double saldo;
	
	//public int agencia;
	
	
	public ContaBancaria(String titular1,int senha1,int numeroConta1) {
		this.titular = titular1;
		this.senha = senha1;
		this.numeroConta = numeroConta1;
		
	}
	
	public void depositar(double valorDeposito) {
		if(valorDeposito >= 1) {
			this.saldo += valorDeposito;
		}
	}
	
	public void sacar(int valorSacar) {
		this.saldo -= valorSacar;
	}
	
	public void transferir(ContaBancaria conta1,double valorTransferir) {
		this.saldo -= valorTransferir;
		conta1.saldo += valorTransferir;
		
	}
	

}
