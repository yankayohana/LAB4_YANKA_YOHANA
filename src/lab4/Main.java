package lab4;

import java.util.ArrayList;

public class Main {

	private static void printaOpcoes() {

		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
	}

	public static void main(String[] args) {

		Input input = new Input();
		Controle controle = new Controle();
		Boolean rodando = true;
		while (rodando) {

			printaOpcoes();

			String opcao = input.leString("Opção> ");

			switch (opcao) {
			case "C":
				cadastraAluno(controle, input);
				break;
			case "E":
				exibeAluno(controle, input);
				break;
			case "N":
				novoGrupo(controle, input);
				break;
			case "A":
				alocarAlunoOuImprimirGrupos(controle, input);
				break;
			case "R":
				registrarAlunoQueRespondeu(controle, input);
				break;
			case "I":
				imprimeAlunosQueResponderam(controle, input);
				break;
			case "O":
				rodando = false;
				break;
			}
		}

	}

	public static void cadastraAluno(Controle controle, Input input) {
		String matricula = input.leString("Matrícula: ");
		String nome = input.leString("Nome: ");
		String curso = input.leString("Curso: ");
		try {
			if (controle.cadastraAluno(matricula, nome, curso)) {
				System.out.println("CADASTRO REALIZADO!");
			} else {
				System.out.println("MATRÍCULA JÁ CADASTRADA");
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());;
		}

	}

	public static void exibeAluno(Controle controle, Input input) {
		String matricula = input.leString("Matrícula: ");
		try {
			System.out.println(controle.exibeAluno(matricula));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void novoGrupo(Controle controle, Input input) {
		String nomeGrupo = input.leString("Grupo: ");
		if (controle.cadastraGrupo(nomeGrupo)) {
			System.out.println("CADASTRO REALIZADO!");
		} else {
			System.out.println("GRUPO JÁ CADASTRADO!");
		}
	}

	public static void alocarAlunoOuImprimirGrupos(Controle controle, Input input) {
		String opcao = input.leString("Opção> ");
		if (opcao.equalsIgnoreCase("a")) {
			String nomeGrupo = input.leString("Nome: ");
			String matricula = input.leString("Matrícula: ");
			try {
				controle.alocaAluno(nomeGrupo, matricula);
				System.out.println("Aluno alocado com sucesso");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (opcao.equalsIgnoreCase("i")) {
			String nomeGrupo = input.leString("Nome: ");
			try {
				System.out.println(controle.getToStringGrupo(nomeGrupo));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public static void registrarAlunoQueRespondeu(Controle controle, Input input) {
		String matricula = input.leString("Mátricula: ");
		try {
			controle.cadastraAlunoQuadro(matricula);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void imprimeAlunosQueResponderam(Controle controle, Input input) {
		ArrayList<String> alunos = controle.getAlunosQuadro();
		System.out.println("Alunos: " + System.lineSeparator());
		for (int i = 0; i < alunos.size(); i++) {
			System.out.println((i + 1) + ". " + alunos.get(i));
		}
	}

}
