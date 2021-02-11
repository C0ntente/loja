package loja;

import java.util.Date;
import java.util.Scanner;

import model.Cliente;
import model.Pedido;
import model.Produto;
import model.enums.StatusPedido;

public class Main {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		Pedido ped1 = new Pedido();

		ped1.setId(1);
		ped1.setData(new Date());
		ped1.setStatus(StatusPedido.ANDAMENTO);
		ped1.setCliente(cliente1);

		Scanner scanner = new Scanner(System.in);
		String entrada = ""; // criando String de entrada vazia, para inicializar
		System.out.println("Entre com nome?");
		entrada = scanner.nextLine();
		cliente1.setNome(entrada);
		System.out.println("Entre com cpf?");
		entrada = scanner.nextLine();
		cliente1.setCpf(entrada);
		System.out.println("Entre com email?");
		entrada = scanner.nextLine();
		cliente1.setEmail(entrada);
		System.out.println("Entre com senha?");
		entrada = scanner.nextLine();
		cliente1.setSenha(entrada);
		adicionarProdutos(ped1); // chamando o método de adição de produtos

		System.out.printf(ped1.toString(), cliente1.toString());

	}

	public static void adicionarProdutos(Pedido pedido) {
		String cadastrar = "s";
		int idProduto = 0;

		while (cadastrar.equalsIgnoreCase("s")) {
			Produto p = new Produto();
			idProduto++;
			p.setId(idProduto);
			Scanner scanner = new Scanner(System.in);
			String entrada = "";
			double preco = 0;
			System.out.println("Entre com nome do produto?");
			entrada = scanner.nextLine();
			p.setNome(entrada);
			System.out.println("Entre com preço do produto?");
			preco = Double.parseDouble(scanner.nextLine());
//			preco = scanner.nextDouble();
//			scanner.next(); // quando for double, int ou sem ser um string
			p.setPreco(preco);
			if (pedido.getProdutos().contains(p)) {
				System.out.println("Produto já inserido");
			} else {
				pedido.addProd(p);
			}
			System.out.println("Voce quer comprar um novo produto?");
			cadastrar = scanner.nextLine();

		}

	}
}
