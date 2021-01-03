package questao03;

import java.time.LocalDateTime;

public class DespesaComInternet extends Despesa {
    private double dadosTrafegados;

    public DespesaComInternet(LocalDateTime data, String descricao, double dadosTrafegados) {
        super(data, descricao);
        setDadosTrafegados(dadosTrafegados);
    }

    @Override
    public String calcularTotal() {
        final int CEIL_1 = 20;
        final int CEIL_2 = 100;
        final int CEIL_3 = 500;
        final double FIX_VALUE_1 = 90.9;
        final double FIX_VALUE_2 = 240.9;
        final double FIX_VALUE_3 = 590.9;
        final double TAX_1 = 3.9;
        final double TAX_2 = 4.4;
        final double TAX_3 = 5.1;

        if ( getDadosTrafegados() < CEIL_2 ) return Double.toString(FIX_VALUE_1 + (getDadosTrafegados() - CEIL_1) * TAX_1);
        else if ( getDadosTrafegados() < CEIL_3 ) return Double.toString(FIX_VALUE_2 + (getDadosTrafegados() - CEIL_2) * TAX_2);
        else return Double.toString(FIX_VALUE_3 + (getDadosTrafegados() - CEIL_3) * TAX_3);
    }

    public void setDadosTrafegados(double dadosTrafegados) {
        this.dadosTrafegados = dadosTrafegados > 0 ? dadosTrafegados : 0;
    }

    public double getDadosTrafegados() {
        return dadosTrafegados;
    }
}
