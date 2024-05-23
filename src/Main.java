
public class Main {

	public static void main(String[] args) {
		Cliente edson = new Cliente();
		edson.setNome("Edson");
		
		Conta cc = new ContaCorrente(edson);
		Conta poupanca = new ContaPoupanca(edson);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		cc.depositar(250);
		cc.sacar(50);
		poupanca.sacar(30);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
