package lab4;

import java.util.HashSet;
import java.util.Set;

public class Grupo {

	private Set<Aluno> grupo;
	private String nomeGrupo;

	public Grupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.grupo = new HashSet<>();
	}

	public boolean cadastraAlunoGrupo(Aluno aluno) {
		return this.grupo.add(aluno);
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}

	public String toString() {
		return "Grupo: " + this.nomeGrupo;
	}

}
