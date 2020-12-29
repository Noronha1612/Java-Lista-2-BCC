package questao02;

import com.sun.jdi.ArrayReference;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RepositorioPessoas {
    ArrayList<Pessoa> pessoas;

    public RepositorioPessoas() {
        pessoas = new ArrayList<>();
    }

    private long calcularIdade(LocalDate dataDeNascimento) {
        return dataDeNascimento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public void cadastrarPessoa(Pessoa p) {
        boolean alreadyExist = false;

        for ( Pessoa pessoa : pessoas ) {
            if ( pessoa.equals(p) ) alreadyExist = true;
        }

        if ( !alreadyExist ) pessoas.add(p);
    }

    public ArrayList<Pessoa> listarPessoasMaioresIdade() {
        ArrayList<Pessoa> maioresDeIdade = new ArrayList<>();

        for ( Pessoa pessoa : pessoas ) {
            long idadePessoa = calcularIdade(pessoa.getDataDeNascimento());

            if ( idadePessoa > 18 ) maioresDeIdade.add(pessoa);
        }

        return maioresDeIdade;
    }

    public ArrayList<Cliente> listarClienteMaioresIdade() {
        ArrayList<Cliente> maioresDeIdade = new ArrayList<>();

        for ( Pessoa pessoa : pessoas ) {
            long idadePessoa = calcularIdade(pessoa.getDataDeNascimento());

            if ( idadePessoa > 18 && pessoa instanceof Cliente ) maioresDeIdade.add((Cliente) pessoa);
        }

        return maioresDeIdade;
    }

    public ArrayList<Funcionario> listarFuncionariosComSalarioMaiorQue(double salario) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        for ( Pessoa pessoa : pessoas ) {
            if ( pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;

                double salarioFuncionario = funcionario.getSalario();

                if ( salarioFuncionario > salario ) funcionarios.add(funcionario);
            }
        }

        return funcionarios;
    }

    public ArrayList<Gerente> listarGerentesDaArea(String area) {
        ArrayList<Gerente> gerentes = new ArrayList<>();

        for ( Pessoa pessoa : pessoas ) {
            if ( pessoa instanceof Gerente ) {
                Gerente gerente = (Gerente) pessoa;

                if ( gerente.getArea() == area ) gerentes.add(gerente);
            }
        }

        return gerentes;
    }

}
