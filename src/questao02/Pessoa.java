package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;

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
        if ( nome == null ) return "Pessoa={}";

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("Pessoa={ nome: %s, dataDeNascimento: %s }",
                this.getNome(),
                myFormatter.format(this.getDataDeNascimento())
        );
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        return dataDeNascimento != null ? dataDeNascimento.equals(pessoa.dataDeNascimento) : pessoa.dataDeNascimento == null;
    }
}
