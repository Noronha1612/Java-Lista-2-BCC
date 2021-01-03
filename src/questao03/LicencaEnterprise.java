package questao03;

import java.time.LocalDateTime;

public class LicencaEnterprise extends Receita {

    int totalContas;

    public LicencaEnterprise(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        setTotalContas(totalContas);
    }

    @Override
    public String calcularTotal() {
        final double ENTERPRISE_PRICE = 150;

        return Double.toString(ENTERPRISE_PRICE * totalContas);
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
