package Model;

public class ContaCorrente extends ContaBancaria {
	public int valorLimite;
	public boolean statusCont;
	
	public ContaCorrente(String titular2, int senha2, int numero2,int limiteCC) {
		super(titular2, senha2, numero2);
		this.valorLimite = limiteCC;
	}

}
