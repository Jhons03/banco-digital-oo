import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	public Set<String> transacoes = new LinkedHashSet<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		if (valor > 0) {
			transacoes.add("Saque de R$ " + valor);
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		if (valor > 0) {
			transacoes.add("Deposito de R$ " + valor);
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}


	public Set<String> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(Set<String> transacoes) {
		this.transacoes = transacoes;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}




	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s%n", this.cliente.getNome());
		System.out.printf("Agencia: %d%n", this.agencia);
		System.out.printf("Numero: %d%n", this.numero);
		System.out.printf("Saldo: %.2f%n", this.saldo);
		System.out.println("=== Transacoes ===");
		transacoes.stream()
				.map(Object::toString)
				.forEach(System.out::println);
	}
}
