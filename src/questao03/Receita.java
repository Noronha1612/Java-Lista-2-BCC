package questao03;

import java.time.LocalDateTime;

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
}
