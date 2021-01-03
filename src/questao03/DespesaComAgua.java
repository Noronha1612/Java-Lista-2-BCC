package questao03;

import java.time.LocalDateTime;

public class DespesaComAgua extends Despesa {
    private double totalM3;

    public DespesaComAgua(LocalDateTime data, String descricao, double totalM3) {
        super(data, descricao);
        setTotalM3(totalM3);
    }

    @Override
    public String calcularTotal() {
        final double FIX_VALUE = 45;
        final double TAX_1 = 5;
        final double TAX_2 = 6;
        final int CEIL_1 = 10;
        final int CEIL_2 = 20;

        if ( getTotalM3() < CEIL_1 ) return Double.toString(FIX_VALUE);
        else if ( getTotalM3() < CEIL_2 ) return Double.toString(FIX_VALUE + TAX_1 * (getTotalM3() -  CEIL_1));
        else return Double.toString(FIX_VALUE + TAX_1 * CEIL_1 + TAX_2 * (getTotalM3() - CEIL_2));
    }

    public void setTotalM3(double totalM3) {
        this.totalM3 = totalM3 > 0 ? totalM3 : 0;
    }

    public double getTotalM3() {
        return totalM3;
    }
}
