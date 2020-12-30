package questao02;

import com.sun.jdi.ArrayReference;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RepositorioPessoas {
    ArrayList<Pessoa> pessoas;

    public RepositorioPessoas() {
        pessoas = new ArrayList<>();
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
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

            if ( idadePessoa >= 18 ) maioresDeIdade.add(pessoa);
        }

        return maioresDeIdade;
    }

    public ArrayList<Cliente> listarClienteMaioresIdade() {
        ArrayList<Cliente> maioresDeIdade = new ArrayList<>();

        for ( Pessoa pessoa : pessoas ) {
            long idadePessoa = calcularIdade(pessoa.getDataDeNascimento());

            if ( idadePessoa >= 18 && pessoa instanceof Cliente ) maioresDeIdade.add((Cliente) pessoa);
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepositorioPessoas that = (RepositorioPessoas) o;

        return pessoas != null ? pessoas.equals(that.pessoas) : that.pessoas == null;
    }

    public String toString() {
        if ( pessoas.size() == 0 ) return "Pessoas=[]";

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String mainString = "[\n";

        for ( Pessoa pessoa : pessoas ) {
            mainString = mainString + "    ";

            if ( pessoa instanceof Funcionario ) {
                if ( (Funcionario) pessoa instanceof Gerente ) mainString = mainString + "Gerente = ";
                else mainString = mainString + "Funcionário = ";
            }
            else if ( pessoa instanceof Cliente ) mainString = mainString + "Cliente = ";
            else mainString = mainString + "Pessoa = ";

            mainString = mainString + String.format("{ nome: %s, dataDeNascimento: %s",
                    pessoa.getNome(),
                    myFormatter.format(pessoa.getDataDeNascimento())
            );

            if ( pessoa instanceof Funcionario ) {
                if ( (Funcionario) pessoa instanceof Gerente ) {
                    mainString = mainString + String.format(", salarioBruto: %.2f, impostoPago: %.2f, salarioLiquido: %.2f, area: %s",
                            ((Funcionario) pessoa).getSalario(),
                            ((Funcionario) pessoa).calcularImpostoDevido(),
                            ((Funcionario) pessoa).getSalario() - ((Funcionario) pessoa).calcularImpostoDevido(),
                            ((Gerente) pessoa).getArea()
                    );
                } else {
                    mainString = mainString + String.format(", salarioBruto: %.2f, impostoPago: %.2f, salarioLiquido: %.2f",
                            ((Funcionario) pessoa).getSalario(),
                            ((Funcionario) pessoa).calcularImpostoDevido(),
                            ((Funcionario) pessoa).getSalario() - ((Funcionario) pessoa).calcularImpostoDevido()
                    );
                }
            }

            if ( pessoa instanceof Cliente ) {
                mainString = mainString + String.format(", codigo: %d",
                        ((Cliente) pessoa).getCodigo()
                );
            }

            mainString = mainString + " }\n";
        }

        mainString = mainString + "]";

        return mainString;
    }
}
