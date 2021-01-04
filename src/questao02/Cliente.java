package questao02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente extends Pessoa {
    private long codigo;

    public Cliente(String nome, LocalDate dataDeNascimento, long codigo) {
        super(nome, dataDeNascimento);
        this.codigo = codigo;
    }

    public void setCodigo(long codigo) {
        if ( codigo > 0 ) this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public String toString() {
        if ( codigo == -1 ) return "Cliente={}";

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("Cliente={ nome: %s, dataDeNascimento: %s, codigo: %d }",
                this.getNome(),
                myFormatter.format(this.getDataDeNascimento()),
                this.getCodigo()
        );
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cliente cliente = (Cliente) o;

        return codigo == cliente.codigo;
    }
}
