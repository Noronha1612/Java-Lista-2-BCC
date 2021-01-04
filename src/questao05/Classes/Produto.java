package questao05.Classes;

public class Produto {
    private float valor;
    private int quantidade;
    private String descricao;

    public Produto( float valor, int quantidade, String descricao ) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public float calcularTotal() {
        return valor * quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
