package questao03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FluxoCaixaTest {
    public static void main(String[] args) {

        FluxoCaixa fluxoCaixa1 = new FluxoCaixa("KarneKeijo", "07114320000104");

        fluxoCaixa1.adicionarTransacao(new DespesaComAgua(
                LocalDateTime.of(2005, 6, 11, 14, 30, 25),
                "Conta de água",
                19
        ));

        fluxoCaixa1.adicionarTransacao(new DespesaComEnergia(
                LocalDateTime.of(2000, 5, 14, 16, 20, 30),
                "Conta de energia",
                150
        ));

        fluxoCaixa1.adicionarTransacao(new DespesaComInternet(
                LocalDateTime.of(2005, 22, 8, 11, 32, 35),
                "Conta de Internet",
                334
        ));

        fluxoCaixa1.adicionarTransacao(new DespesaComAgua(
                LocalDateTime.of(2005, 22, 15, 12, 40, 5),
                "Conta de Água",
                22
        ));

        fluxoCaixa1.adicionarTransacao(new LicencaBasica(
                LocalDateTime.of(2013, 8, 22, 23, 35, 5),
                "Contas básicas",
                50
        ));

        fluxoCaixa1.adicionarTransacao(new LicencaPlus(
                LocalDateTime.of(2013, 8, 20, 12, 5, 55),
                "Contas plus",
                34
        ));

        fluxoCaixa1.adicionarTransacao(new LicencaPlus(
                LocalDateTime.of(2016, 10, 2, 15, 0, 15),
                "Contas plus",
                39
        ));

        fluxoCaixa1.adicionarTransacao(new LicencaEnterprise(
                LocalDateTime.of(2013, 8, 10, 1, 17, 59),
                "Contas Enterprise",
                19
        ));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDateTime despesaPeriodBegin = LocalDateTime.of(2002, 2, 22, 15, 5, 11);
        LocalDateTime despesaPeriodFinish = LocalDateTime.of(2008, 9, 12, 22, 25, 21);
        System.out.printf("Despesas entre %s e %s:\n", dateFormatter.format(despesaPeriodBegin), dateFormatter.format(despesaPeriodFinish));


    }
}
