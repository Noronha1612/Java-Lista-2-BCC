package questao03;

import java.time.LocalDate;
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
                LocalDateTime.of(2005, 12, 8, 11, 32, 35),
                "Conta de Internet",
                334
        ));

        fluxoCaixa1.adicionarTransacao(new DespesaComAgua(
                LocalDateTime.of(2005, 12, 15, 12, 40, 5),
                "Conta de Água",
                22
        ));

        fluxoCaixa1.adicionarTransacao(new DespesaComInternet(
                LocalDateTime.of(2013, 8, 22, 23, 35, 5),
                "Conta de Internet",
                129
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

        LocalDate despesaPeriodBegin = LocalDate.of(2002, 2, 22);
        LocalDate despesaPeriodFinish = LocalDate.of(2008, 9, 12);
        System.out.printf("Despesas entre %s e %s: R$ %.2f\n\n",
                dateFormatter.format(despesaPeriodBegin),
                dateFormatter.format(despesaPeriodFinish),
                fluxoCaixa1.calcularDespesas(despesaPeriodBegin, despesaPeriodFinish)
        );

        LocalDate receitaPeriodBegin = LocalDate.of(2006, 2, 22);
        LocalDate receitaPeriodFinish = LocalDate.of(2015, 9, 12);
        System.out.printf("Receitas entre %s e %s: R$ %.2f\n\n",
                dateFormatter.format(receitaPeriodBegin),
                dateFormatter.format(receitaPeriodFinish),
                fluxoCaixa1.calcularReceitas(receitaPeriodBegin, receitaPeriodFinish)
        );

        System.out.printf("Percentual de receita por valor total de transações no Mes(%d) no Ano(%d): %f%%\n\n",
                8,
                2013,
                fluxoCaixa1.percentualReceitasNoMes(8, 2013)
        );

        System.out.printf("Percentual de despesa por valor total de transações no Mes(%d) no Ano(%d): %f%%\n\n",
                8,
                2013,
                fluxoCaixa1.percentualDespesaNoMes(8, 2013)
        );

        System.out.printf("Saldo atual de %s: R$ %.2f\n\n", fluxoCaixa1.getNomeEmpresa(), fluxoCaixa1.saldoAtual());

        System.out.printf("Transações no mês %d no ano %d:\n", 8, 2013);
        for ( Transacao transacao : fluxoCaixa1.listarTransacoesNoMes(8, 2013)) {
            System.out.printf("%s\n", transacao.toString());
        }

    }
}
