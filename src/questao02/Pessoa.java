package questao02;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;

    public Pessoa() {
        this.nome = null;
        this.dataDeNascimento = null;
    }

    public Pessoa(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String toString() {
        return "Pessoa{ " +
                "nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                " }";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) &&
                Objects.equals(dataDeNascimento, pessoa.dataDeNascimento);
    }
}
