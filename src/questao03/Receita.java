package questao03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Receita implements Transacao {
    private LocalDateTime data;
    private String descricao;

    public Receita(LocalDateTime data, String descricao) {
        setData(data);
        setDescricao(descricao);
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getTipo() {
        return "Receita";
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("%s = data:%s ", getDescricao(), dateFormatter.format(getData()));
    }
}
