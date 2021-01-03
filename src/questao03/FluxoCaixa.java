package questao03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class FluxoCaixa {
    private String nomeEmpresa;
    private String cnpj;

    private ArrayList<Transacao> transacoes;

    public FluxoCaixa( String nomeEmpresa, String cnpj ) {
        setCnpj(cnpj);
        setNomeEmpresa(nomeEmpresa);

        transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public double calcularDespesas(LocalDate inicio, LocalDate fim) {
        double mountDespesas = 0;

        for ( Transacao transacao : transacoes ) {
            String transacaoTipo = transacao.getTipo();
            LocalDateTime transacaoData = transacao.getData();

            if (transacaoTipo.equals("Despesa") &&
                    inicio.isBefore(ChronoLocalDate.from(transacaoData))
                    && fim.isAfter(ChronoLocalDate.from(transacaoData))
            ) {
                mountDespesas += Double.parseDouble(transacao.calcularTotal());
            }
        }

        return mountDespesas;
    }

    public double calcularReceitas(LocalDate inicio, LocalDate fim) {
        double mountReceitas = 0;

        for ( Transacao transacao : transacoes ) {
            String transacaoTipo = transacao.getTipo();
            LocalDateTime transacaoData = transacao.getData();

            if (transacaoTipo.equals("Receita") &&
                    inicio.isBefore(ChronoLocalDate.from(transacaoData))
                    && fim.isAfter(ChronoLocalDate.from(transacaoData))
            ) {
                mountReceitas += Double.parseDouble(transacao.calcularTotal());
            }
        }

        return mountReceitas;
    }

    public double percentualReceitasNoMes(int mes, int ano) {
        double totalValueTransitioned = getTotalValueTransitionedInMonth(mes, ano);
        double totalReceitaValues = 0;

        for ( Transacao transacao : transacoes ) {
            LocalDateTime transacaoData = transacao.getData();
            String transacaoTipo = transacao.getTipo();

            if ( transacaoTipo.equals("Receita") &&
                    transacaoData.getMonthValue() == mes &&
                    transacaoData.getYear() == ano
            ) totalReceitaValues += Double.parseDouble(transacao.calcularTotal());
        }

        double percentageReceitasByTotal = totalReceitaValues / totalValueTransitioned;

        return percentageReceitasByTotal * 100;
    }

    public double percentualDespesaNoMes(int mes, int ano) {
        double totalValueTransitioned = getTotalValueTransitionedInMonth(mes, ano);
        double totalDespesaValues = 0;

        for ( Transacao transacao : transacoes ) {
            LocalDateTime transacaoData = transacao.getData();
            String transacaoTipo = transacao.getTipo();

            if ( transacaoTipo.equals("Despesa") &&
                    transacaoData.getMonthValue() == mes &&
                    transacaoData.getYear() == ano
            ) totalDespesaValues += Double.parseDouble(transacao.calcularTotal());
        }

        double percentageDespesasByTotal = totalDespesaValues / totalValueTransitioned;

        return percentageDespesasByTotal * 100;
    }

    public double saldoAtual() {
        double currentBalance = 0;

        for ( Transacao transacao : transacoes ) {
            String transacaoTipo = transacao.getTipo();

            double transacaoValor = Double.parseDouble(transacao.calcularTotal());

            if ( transacaoTipo.equals("Receita") ) currentBalance += transacaoValor;
            else if ( transacaoTipo.equals("Despesa") ) currentBalance -= transacaoValor;
        }

        return currentBalance;
    }

    public List<Transacao> listarTransacoesNoMes(int mes, int ano) {
        ArrayList<Transacao> transacoesNoMes = new ArrayList<>();

        for ( Transacao transacao : transacoes ) {
            LocalDateTime transacaoData = transacao.getData();

            if ( transacaoData.getMonthValue() == mes && transacaoData.getYear() == ano )
                transacoesNoMes.add(transacao);
        }

        return transacoesNoMes;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    private double getTotalValueTransitionedInMonth(int month, int year) {
        double value = 0;

        for ( Transacao transacao : transacoes ) {
            if ( transacao.getData().getYear() == year && transacao.getData().getMonthValue() == month )
                value += Double.parseDouble(transacao.calcularTotal());
        }

        return value;
    }
}
