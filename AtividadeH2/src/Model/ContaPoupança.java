package Model;

public class ContaPoupança extends ContaBancaria{
	
	public double renderValor;
	public final double taxaPorcetagem = 0.42;
	

	public ContaPoupança(String titular4, int senha4, int numeroConta) {
		super(titular4, senha4, numeroConta);
	}

	public void render(){
		super.depositar(this.saldo * this.taxaPorcetagem);
	}
	
	public double getRendimento() {
		this.renderValor = saldo * taxaPorcetagem;
		return renderValor;
	}

}
