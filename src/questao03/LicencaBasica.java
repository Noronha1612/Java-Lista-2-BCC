package questao03;

import java.time.LocalDateTime;

public class LicencaBasica extends Receita {

    int totalContas;

    public LicencaBasica(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        setTotalContas(totalContas);
    }

    @Override
    public String calcularTotal() {
        final double BASIC_PRICE = 20;

        return Double.toString(BASIC_PRICE * totalContas);
    }

    public int getTotalContas() {
        return totalContas;
    }

    public void setTotalContas(int totalContas) {
        this.totalContas = totalContas;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Total de contas:%d, valor:%.2f }", getTotalContas(), Double.parseDouble(this.calcularTotal()));
    }
}
