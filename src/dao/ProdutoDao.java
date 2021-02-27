package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exceptions.NomeCurtoException;
import factory.ConnectionFactory;
import model.Cliente;
import model.Produto;


public class ProdutoDao {
	public static List<Produto> listar() {
	String listar = "select * from produto";
	List<Produto> produtos = new ArrayList<Produto>();
	Connection conexaoBanco = ConnectionFactory.conexaoBanco();
	try {
		Statement stmt = conexaoBanco.createStatement();
		ResultSet rs = stmt.executeQuery(listar);
		while (rs.next()) {
			Produto produto = new Produto();

			try {
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getInt("preço"));
				
				produtos.add(produto);
			} catch (NomeCurtoException e) {
				// TODO Auto-generated catch block
				System.out.println("Produto " + rs.getString("nome") + " Com nome curto. Nome: " + rs.getString("nome"));
			}

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return produtos;
}

}
