package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exceptions.EmailInvalidoException;
import factory.ConnectionFactory;
import model.Cliente;

public class ClienteDao {
	public static List<Cliente> listar() {
		String listar = "select * from cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection conexaoBanco = ConnectionFactory.conexaoBanco();
		try {
			Statement stmt = conexaoBanco.createStatement();
			ResultSet rs = stmt.executeQuery(listar);
			while (rs.next()) {
				Cliente cliente = new Cliente();

				try {
					cliente.setId(rs.getInt(1));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					clientes.add(cliente);
				} catch (EmailInvalidoException e) {
					// TODO Auto-generated catch block
					System.out.println("Cliente " + rs.getString("nome") + " Com email inválido. Email: " + rs.getString("email"));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

}
