package Model;

public class ContaPoupan�a extends ContaBancaria{
	
	public double renderValor;
	public final double taxaPorcetagem = 0.42;
	

	public ContaPoupan�a(String titular4, int senha4, int numeroConta) {
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
