package lab4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controle {

	private Set<Aluno> alunos;
	private Set<Grupo> grupos;
	private ArrayList<Aluno> alunosQueResponderamQuadro;

	public Controle() {
		this.alunos = new HashSet<>();
		this.grupos = new HashSet<>();
		this.alunosQueResponderamQuadro = new ArrayList<>();

	}

	public boolean cadastraAluno(String nome, String matricula, String curso) throws Exception {
		Aluno aluno = new Aluno(nome, matricula, curso);
		return alunos.add(aluno);
	}

	public String consultaAluno(String matricula) throws Exception {
		Aluno aluno = this.getAluno(matricula);
		return aluno.toString();
	}

	public boolean cadastraGrupo(String nomeGrupo) {
		Grupo grupo = new Grupo(nomeGrupo);
		return grupos.add(grupo);
	}

	public Grupo getGrupo(String nomeGrupo) throws Exception {
		for (Grupo grupo : this.grupos) {
			if (grupo.getNomeGrupo().equals(nomeGrupo)) {
				return grupo;
			}

		}
		throw new Exception("Grupo Inexistente");
	}

	public Aluno getAluno(String matricula) throws Exception {
		for (Aluno aluno : this.alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;

			}
		}
		throw new Exception("Aluno não cadastrado");

	}

	public boolean alocaAluno(String nomeGrupo, String matricula) throws Exception {
		Grupo grupo = this.getGrupo(nomeGrupo);
		Aluno aluno = this.getAluno(matricula);
		return grupo.cadastraAlunoGrupo(aluno);

	}

	public String exibeAluno(String matricula) throws Exception {
		Aluno aluno = getAluno(matricula);
		return aluno.toString();

	}

	public String getToStringGrupo(String nomeGrupo) throws Exception {
		Grupo grupo = getGrupo(nomeGrupo);
		return grupo.toString();
	}

	public void cadastraAlunoQuadro(String matricula) throws Exception {
		Aluno alunoQuadro = this.getAluno(matricula);
		this.alunosQueResponderamQuadro.add(alunoQuadro);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((alunosQueResponderamQuadro == null) ? 0 : alunosQueResponderamQuadro.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Controle other = (Controle) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (alunosQueResponderamQuadro == null) {
			if (other.alunosQueResponderamQuadro != null)
				return false;
		} else if (!alunosQueResponderamQuadro.equals(other.alunosQueResponderamQuadro))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}

	public ArrayList<String> getAlunosQuadro() {
		ArrayList<String> alunosToString = new ArrayList<>();
		for (Aluno aluno : this.alunosQueResponderamQuadro) {
			alunosToString.add(aluno.toString());

		}
		return alunosToString;
	}
}