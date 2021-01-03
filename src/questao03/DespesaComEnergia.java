package questao03;

import java.time.LocalDateTime;

public class DespesaComEnergia extends Despesa {
    private double kWh;

    public DespesaComEnergia(LocalDateTime data, String descricao, double kWh) {
        super(data, descricao);
        setkWh(kWh);
    }

    @Override
    public String calcularTotal() {
        final double ADDITIONAL_VALUE_BY_100 = 1.2;
        final double VALUE_KWH = 0.5;
        final double ADDITIONAL_LOWEST_VALUE = 2;
        final double ADDITIONAL_NORMAL_VALUE = 15;
        final double ADDITIONAL_HIGHEST_VALUE = 35;
        final int CEIL_1 = 50;
        final int CEIL_2 = 200;

        double mainValue = VALUE_KWH * getkWh() + ( ((int)getkWh() / 100) * ADDITIONAL_VALUE_BY_100 );
        if ( getkWh() < CEIL_1 ) mainValue += ADDITIONAL_LOWEST_VALUE;
        else if ( getkWh() < CEIL_2 ) mainValue += ADDITIONAL_NORMAL_VALUE;
        else mainValue += ADDITIONAL_HIGHEST_VALUE;

        return Double.toString(mainValue);
    }

    public void setkWh(double kWh) {
        this.kWh = kWh > 0 ? kWh : 0;
    }

    public double getkWh() {
        return kWh;
    }
}
