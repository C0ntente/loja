package exceptions;

public class NomeCurtoException extends Exception {
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Nome inválido, muito curto";
	}

}
