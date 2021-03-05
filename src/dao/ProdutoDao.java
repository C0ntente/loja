package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection conexaoBanco = null;
		String listar = "select * from produto";
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			 conexaoBanco = ConnectionFactory.conexaoBanco();
			Statement stmt = conexaoBanco.createStatement();
			ResultSet rs = stmt.executeQuery(listar);
			while (rs.next()) {
				Produto produto = new Produto();

				try {
					produto.setId(rs.getInt(1));
					produto.setNome(rs.getString("nome"));
					produto.setPreco(rs.getInt("preco"));
					produtos.add(produto);
				} catch (NomeCurtoException e) {
					// TODO Auto-generated catch block
					System.out.println(
							"Produto " + rs.getString("nome") + " Com nome curto. Nome: " + rs.getString("nome"));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (conexaoBanco != null) {
					conexaoBanco.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return produtos;
	}

	public static boolean inserir(Produto produto) {
		Connection conexaoBanco = null;
		String inserir = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
		try {
			conexaoBanco = ConnectionFactory.conexaoBanco();
			PreparedStatement preparedStatement = conexaoBanco.prepareStatement(inserir);
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setDouble(2, produto.getPreco());
			preparedStatement.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conexaoBanco != null) {
					conexaoBanco.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
