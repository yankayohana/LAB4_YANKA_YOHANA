package lab4;

public class Validator {

	public static void verificaString(String string, String atributo) throws Exception {
		if (string == null || string.equals("")) {
			throw new Exception(atributo + " INVÁLIDO!");
		}
	}
}
