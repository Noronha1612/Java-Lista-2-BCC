package questao03;

import java.time.LocalDateTime;

public abstract class Despesa implements Transacao {
    private LocalDateTime data;
    private String descricao;

    public Despesa(LocalDateTime data, String descricao) {
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
        return "Despesa";
    }
}
