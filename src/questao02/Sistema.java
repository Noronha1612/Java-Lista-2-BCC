package questao02;

import java.time.LocalDate;

public class Sistema {
    public static void main(String[] args) {
        RepositorioPessoas repositorioPessoas = new RepositorioPessoas();

        Cliente cliente1 = new Cliente("Noronha", LocalDate.of(2002, 12, 16), 1612);
        Cliente cliente2 = new Cliente("Igor", LocalDate.of(1980, 4, 17), 1572);
        Cliente cliente3 = new Cliente("Anne", LocalDate.of(1980, 4, 18), 1405);
        Cliente cliente4 = new Cliente("Fernanda", LocalDate.of(2005, 4, 11), 7255);
        Cliente cliente5 = new Cliente("Cadu", LocalDate.of(2001, 4, 1), 8886);

        repositorioPessoas.cadastrarPessoa(cliente1);
        repositorioPessoas.cadastrarPessoa(cliente2);
        repositorioPessoas.cadastrarPessoa(cliente3);
        repositorioPessoas.cadastrarPessoa(cliente4);
        repositorioPessoas.cadastrarPessoa(cliente5);

        Cliente cliente1Copia = new Cliente("Noronha", LocalDate.of(2002, 12, 16), 1612);

        repositorioPessoas.cadastrarPessoa(cliente1Copia);

        Funcionario funcionario1 = new Funcionario("Noronha", LocalDate.of(2002, 12, 16), 3750);
        Funcionario funcionario2 = new Funcionario("Igor", LocalDate.of(1980, 4, 17), 3750);
        Funcionario funcionario3 = new Funcionario("Anne", LocalDate.of(1980, 4, 18), 3750);
        Funcionario funcionario4 = new Funcionario("Fernanda", LocalDate.of(2005, 4, 11), 3750);
        Funcionario funcionario5 = new Funcionario("Cadu", LocalDate.of(2001, 1, 4), 3750);

        repositorioPessoas.cadastrarPessoa(funcionario1);
        repositorioPessoas.cadastrarPessoa(funcionario2);
        repositorioPessoas.cadastrarPessoa(funcionario3);
        repositorioPessoas.cadastrarPessoa(funcionario4);
        repositorioPessoas.cadastrarPessoa(funcionario5);

        Funcionario funcionario3Copia = new Funcionario("Anne", LocalDate.of(1980, 4, 18), 3750);

        repositorioPessoas.cadastrarPessoa(funcionario3Copia);

        Gerente gerente1 = new Gerente("Noronha", LocalDate.of(2002, 12, 16), 3750, "Programação");
        Gerente gerente2 = new Gerente("Igor", LocalDate.of(1980, 4, 17), 6000, "Alimentos");
        Gerente gerente3 = new Gerente("Anne", LocalDate.of(1980, 4, 18), 2250, "Alimentos");
        Gerente gerente4 = new Gerente("Fernanda", LocalDate.of(2005, 4, 11), 2000, "Pediatria");
        Gerente gerente5 = new Gerente("Cadu", LocalDate.of(2001, 1, 4), 2800.5, "Contabilidade");

        repositorioPessoas.cadastrarPessoa(gerente1);
        repositorioPessoas.cadastrarPessoa(gerente2);
        repositorioPessoas.cadastrarPessoa(gerente3);
        repositorioPessoas.cadastrarPessoa(gerente4);
        repositorioPessoas.cadastrarPessoa(gerente5);

        Gerente gerente3Copia = new Gerente("Anne", LocalDate.of(1980, 4, 18), 2250, "Alimentos");

        repositorioPessoas.cadastrarPessoa(gerente3Copia);

        System.out.println("Pessoas maiores de idade: " + repositorioPessoas.listarPessoasMaioresIdade());
        System.out.println();
        System.out.println("Clientes maiores de idade: " + repositorioPessoas.listarClienteMaioresIdade());
        System.out.println();
        System.out.println(String.format("Funcionários com salário maior que %d: ", 3000) + repositorioPessoas.listarFuncionariosComSalarioMaiorQue(3000));
        System.out.println();
        System.out.println(String.format("Gerentes da área de %s: ", "Alimentos") + repositorioPessoas.listarGerentesDaArea("Alimentos"));
        System.out.println();

        System.out.println("Repositório completo:");
        System.out.println(repositorioPessoas);

    }
}
