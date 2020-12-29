package questao02;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Pessoa {
    private long codigo;

    public Cliente() {
        this.codigo = -1;
        this.setDataDeNascimento(null);
        this.setNome(null);
    }

    public Cliente(String nome, LocalDate dataDeNascimento, long codigo) {
        this.setNome(nome);
        this.setDataDeNascimento(dataDeNascimento);
        this.codigo = codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public String toString() {
        return "Cliente{" +
                "nome='" + this.getNome() + '\'' +
                ", dataDeNascimento=" + this.getDataDeNascimento() +
                ", codigo=" + codigo +
                " }";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(this.getNome(), cliente.getNome()) &&
                Objects.equals(this.getDataDeNascimento(), cliente.getDataDeNascimento()) &&
                Objects.equals(codigo, cliente.codigo);
    }
}
