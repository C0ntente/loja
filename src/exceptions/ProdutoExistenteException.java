package exceptions;

public class ProdutoExistenteException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Produto já existente";
	}

	
	
	
}
