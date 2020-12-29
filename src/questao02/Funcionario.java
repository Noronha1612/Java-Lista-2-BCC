package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private final double SALARIO_TETO_IMPOSTO = 10000;
    private double salario;

    public Funcionario() {
        this.salario = -1;
        this.setNome(null);
        this.setDataDeNascimento(null);
    }

    public Funcionario(String nome, LocalDate dataDeNascimento, double salario) {
        this.salario = salario;
        this.setNome(nome);
        this.setDataDeNascimento(dataDeNascimento);
    }

    public void setSalario(double salario) {
        if ( salario > 0 ) this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public double calcularImpostoDevido() {
        float imposto = 0;

        if ( this.getSalario() <= SALARIO_TETO_IMPOSTO ) imposto = 5;
        else imposto = 7.5f;

        double saldoDevido = (this.getSalario() * imposto) / 100;

        return saldoDevido;
    }

    public String toString() {
        if ( salario == -1 ) return "Funcionario={}";

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

        return String.format("Funcionario={ nome: %s, dataDeNascimento: %s, salarioBruto: %.2f," +
                " impostoPago: %.2f, salarioLiquido: %.2f }",
                this.getNome(),
                myFormatter.format(this.getDataDeNascimento()),
                this.getSalario(),
                calcularImpostoDevido(),
                this.getSalario() - calcularImpostoDevido()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Funcionario that = (Funcionario) o;

        return Double.compare(that.salario, salario) == 0;
    }
}
