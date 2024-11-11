import java.util.ArrayList;

// Classe ContaBancaria
class ContaBancaria {
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque não permitido. Verifique o valor.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo da conta " + numeroConta + ": R$ " + saldo);
    }
}

// Classe Banco
class Banco {
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void criarConta(String numeroConta, double saldoInicial) {
        ContaBancaria novaConta = new ContaBancaria(numeroConta, saldoInicial);
        contas.add(novaConta);
        System.out.println("Conta " + numeroConta + " criada com saldo inicial de R$ " + saldoInicial);
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }

    public void depositar(String numeroConta, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        }
    }

    public void sacar(String numeroConta, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        }
    }

    public void exibirSaldo(String numeroConta) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.exibirSaldo();
        }
    }
}

// Classe Principal
public class BancoApp {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criar contas
        banco.criarConta("12345", 1000.0);
        banco.criarConta("67890", 500.0);

        // Depositar e sacar valores
        banco.depositar("12345", 200.0);
        banco.sacar("12345", 50.0);

        // Exibir saldo das contas
        banco.exibirSaldo("12345");
        banco.exibirSaldo("67890");
    }
}
