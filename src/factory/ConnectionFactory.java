package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/loja";
	private static final String USUARIO = "root";
	private static final String SENHA = "delpiero";

	public static Connection conexaoBanco() {
		try {
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
