package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlunoTest {

	@Test
	void testAlunoConstrutorValido() throws Exception {
		Aluno aluno = new Aluno("1", "yanka", "ciência da computação");
		assertEquals("1", aluno.getMatricula());
		assertEquals("yanka", aluno.getNome());
		assertEquals("ciência da computação", aluno.getCurso());
		assertEquals("Aluno: 1 - yanka - ciência da computação", aluno.toString());

	}
	
	@Test
	void testAlunoConstrutorInvalido() {
		assertThrows(Exception.class, () -> new Aluno("", "yanka", "ciência da computação"));
		assertThrows(Exception.class, () -> new Aluno(null, "yanka", "ciência da computação"));
		assertThrows(Exception.class, () -> new Aluno("1", "", "ciência da computação"));
		assertThrows(Exception.class, () -> new Aluno("1", null, "ciência da computação"));
		assertThrows(Exception.class, () -> new Aluno("1", "yanka", ""));
		assertThrows(Exception.class, () -> new Aluno("1", "yanka", null));
	}
	
	@Test
	void testEqualsTrue() throws Exception {
		Aluno aluno1 = new Aluno("2", "yohana", "ciência da computação");
		Aluno aluno2 = new Aluno("2", "yohana", "ciência da computação");
		assertTrue(aluno1.equals(aluno2));
	 
	}
	
	@Test
	void testEqualsFalse() throws Exception {
		Aluno aluno1 = new Aluno("3", "yanka", "ciência da computação");
		Aluno aluno2 = new Aluno("4", "yohana", "ciência da computação");
		assertFalse(aluno1.equals(aluno2));
	}
}
