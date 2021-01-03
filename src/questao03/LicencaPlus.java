package questao03;

import java.time.LocalDateTime;

public class LicencaPlus extends Receita {

    int totalContas;

    public LicencaPlus(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        setTotalContas(totalContas);
    }

    @Override
    public String calcularTotal() {
        final double PLUS_PRICE = 35;

        return Double.toString(PLUS_PRICE * totalContas);
    }

    public int getTotalContas() {
        return totalContas;
    }

    public void setTotalContas(int totalContas) {
        this.totalContas = totalContas;
    }
}
