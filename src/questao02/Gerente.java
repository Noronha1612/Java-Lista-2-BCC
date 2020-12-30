package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Gerente extends Funcionario {
    private String area;

    public Gerente() {
        this.setNome(null);
        this.setDataDeNascimento(null);
        this.setSalario(0);
        this.area = null;
    }

    public Gerente(String nome, LocalDate dataDeNascimento, double salario, String area) {
        this.setNome(nome);
        this.setDataDeNascimento(dataDeNascimento);
        this.setSalario(salario);
        this.area = area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Gerente gerente = (Gerente) o;

        return area != null ? area.equals(gerente.area) : gerente.area == null;
    }

    public String toString() {
        if ( area == null ) return "Gerente={}";

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("Gerente={ nome: %s, dataDeNascimento: %s, salarioBruto: %.2f," +
                        " impostoPago: %.2f, salarioLiquido: %.2f, area: %s }",
                this.getNome(),
                myFormatter.format(this.getDataDeNascimento()),
                this.getSalario(),
                calcularImpostoDevido(),
                this.getSalario() - calcularImpostoDevido(),
                this.getArea()
        );
    }
}
