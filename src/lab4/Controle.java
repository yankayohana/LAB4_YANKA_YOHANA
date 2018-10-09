package lab4;

import java.util.HashSet;
import java.util.Set;

public class Controle {

	private Set<Aluno> alunos;
	private Set<Grupo> grupos;

	public Controle() {
		this.alunos = new HashSet<>();

	}

	public boolean cadastraAluno(String nome, String matricula, String curso) {
		Aluno aluno = new Aluno(nome, matricula, curso);
		return alunos.add(aluno);
	}

	public boolean consultaAluno(String matricula) {
		for (Aluno aluno : this.alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno.getMatricula().equals(matricula);

			}

		}
		return false;
	}

	public boolean cadastraGrupo(String nomeGrupo) {
		Grupo grupo = new Grupo(nomeGrupo);
		return grupos.add(grupo);
	}

	public boolean getGrupo(String nomeGrupo) { 
		for (Grupo grupo : this.grupos) {
			if (grupo.getNomeGrupo().equals(nomeGrupo)) {
				return true;
			}
			
		}
		return false;
	}

	public boolean alocaAluno(String nomeGrupo, String matricula) {
		

	}

}