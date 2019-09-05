package br.com.frw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        ItemMenu opcao;

        do {

            for (ItemMenu item : ItemMenu.values()) {
                System.out.println(item.getOpcao() + " - " + item.getDescricao());
            }

            opcao = ItemMenu.buscarPorOpcao(Integer.parseInt(scanner.nextLine()));

            switch (opcao) {
                case CADASTRAR:
                    cadastrar();
                    break;
                case CONSULTAR:
                    consultar();
                    break;
                case LISTAR_APROVADOS:
                    listarAprovados();
                    break;
                case LISTAR_REPROVADOS:
                    listarReprovados();
                    break;
                case LISTAR_RECUPERACAO:
                    listarRecuperacao();
                    break;

            }

        } while (opcao != ItemMenu.SAIR);

    }

    private static void listarRecuperacao() {
        if (alunos.isEmpty()) {
            System.out.println("Ops... Nenhum aluno foi cadastrado ainda!");
            return;
        }

        for (Aluno aluno : alunos) {
            if (aluno.getStatus().equals(StatusAluno.RECUPERACAO_PROVA_1)
                    || aluno.getStatus().equals(StatusAluno.RECUPERACAO_PROVA_2)) {
                System.out.println(aluno.toString());
            }
        }
    }

    private static void listarReprovados() {
        for (Aluno aluno : alunos) {
            if (aluno.getStatus().equals(StatusAluno.REPROVADO)) {
                System.out.println(aluno.toString());
            }
        }
    }

    private static void listarAprovados() {
        List<Aluno> aprovados = alunos.stream()
                .filter(aluno -> aluno.getStatus().equals(StatusAluno.APROVADO))
                .collect(Collectors.toList());

        for (Aluno aluno : aprovados) {
            System.out.println(aluno.toString());
        }
    }

    private static void consultar() {
        System.out.println("Infome a Matricula: ");
        String matricula = scanner.nextLine();

        for (Aluno aluno: alunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println(aluno.toString());
                break;
            }
        }
    }

    private static void cadastrar() {
        System.out.println("Infome o Nome do Aluno: ");
        String nome = scanner.nextLine();

        System.out.println("Infome a Matricula: ");
        String matricula = scanner.nextLine();

        System.out.println("Infome a Turma: ");
        String turma = scanner.nextLine();

        System.out.println("Infome a Nota da Primeira Prova: ");
        Long notaProva1 = Long.parseLong(scanner.nextLine());

        System.out.println("Infome a Nota da Segunda Prova: ");
        Long notaProva2 = Long.parseLong(scanner.nextLine());

        System.out.println("Infome a Nota da Terceira Prova: ");
        Long notaProva3 = Long.parseLong(scanner.nextLine());

        System.out.println("Infome a Nota de Exercicios: ");
        Long notaExercicios = Long.parseLong(scanner.nextLine());

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setTurma(turma);
        aluno.setMatricula(matricula);
        aluno.setNotaProva1(notaProva1);
        aluno.setNotaProva2(notaProva2);
        aluno.setNotaProva3(notaProva3);
        aluno.setNotaExercicios(notaExercicios);

        aluno.calculaNotaTotal();
        System.out.println("Status: " + aluno.getStatus() + " Nota: " + aluno.getNotaTotal());

        alunos.add(aluno);
    }
}
