package loja;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import dao.ProdutoDao;
import exceptions.EmailInvalidoException;
import exceptions.NomeCurtoException;
import exceptions.ProdutoExistenteException;
import model.Cliente;
import model.Pedido;
import model.Produto;
import model.enums.StatusPedido;

public class Main {

	public static void main(String[] args) {

		List<Cliente> clientes = ClienteDao.listar();
//		for (Cliente cliente : clientes) {
//			System.out.println(clientes.indexOf(cliente) + " - " + cliente.getNome() + " - " + cliente.getCpf());
//
//		}
		excluirCliente(clientes);
//		System.out.println();
		// cadastrarProduto();

		// List<Produto> produtos = ProdutoDao.listar();

//		Pedido pedido = cadastrarPedido(); // chamando o metodo cadastrar pedido, atribui a uma variavel nova (pedido)
//		System.out.println("Inicializando programa " + pedido.toString() + "\n");
//		Cliente cliente = cadastrarCliente();
//		ClienteDao.inserir(cliente);
//		clientes = ClienteDao.listar();
//		pedido.setCliente(cliente);// vinculei o cliente a este pedido, inclui um cliente a um pedido
//		System.out.println("Cliente cadastrado " + pedido.toString() + "\n");
//		adicionarProdutos(pedido); // chamando o m�todo de adi��o de produtos com o pedido que ja esta cadastrado e
//									// com cliente
//
//		System.out.printf(pedido.toString(), pedido.getCliente().toString());
		// System.out.println(clientes);
		// System.out.println(produtos);

	}

	public static Pedido cadastrarPedido() {

		Pedido ped1 = new Pedido();

		ped1.setId(1);
		ped1.setData(new Date());
		ped1.setStatus(StatusPedido.ANDAMENTO);
		return ped1;
	}

	public static Cliente cadastrarCliente() { // o final desse metodo retorna todo o cadastro do cliente 1 a quem
												// chamar

		Cliente cliente1 = new Cliente();
		// cliente1.setId(1);

		Scanner scanner = new Scanner(System.in);
		String entrada = ""; // criando String de entrada vazia, para inicializar
		System.out.println("Entre com nome do cliente?");
		entrada = scanner.nextLine();
		cliente1.setNome(entrada);
		System.out.println("Entre com cpf?");
		entrada = scanner.nextLine();
		cliente1.setCpf(entrada);
		System.out.println("Entre com email?");
		while (true) {
			try {
				entrada = scanner.nextLine();
				cliente1.setEmail(entrada);
				break;

			} catch (EmailInvalidoException e) {
				System.out.println(e.getMessage());
				System.out.println("Entre com email v�lido");
			}
		}
		System.out.println("Entre com senha?");
		entrada = scanner.nextLine();
		cliente1.setSenha(entrada);
		return cliente1;
	}

	public static void excluirCliente(List<Cliente> clientes) {
		Scanner scanner = new Scanner(System.in);
		int i;
		System.out.printf("\nInforme a posi��o a ser exclu�da: \n");
		i = scanner.nextInt();
		try {
			Cliente cliente = clientes.get(i);
			System.out.println(cliente.getNome());
			ClienteDao.excluir(cliente); 
		} catch (IndexOutOfBoundsException e) {
			System.out.println("N�o existe cliente para op��o selecionada");
		}
	}

	public static void cadastrarProduto() {
		Produto prod1 = new Produto();
		Scanner scanner = new Scanner(System.in);
		String entrada = "";
		double preco = 0;
		System.out.println("Entre com nome do produto:");
		while (true) {
			try {
				entrada = scanner.nextLine();
				prod1.setNome(entrada);
				break;
			} catch (NomeCurtoException e) {
				System.out.println(e.getMessage());
				System.out.println("Digite um nome v�lido:");
			}
		}
		while (true) {
			System.out.println("Entre com pre�o do produto:");
			try {
				preco = scanner.nextDouble();
				scanner.nextLine();
				prod1.setPreco(preco);
				break;

			} catch (InputMismatchException e1) {
				System.out.println("Digite um valor v�lido");
				scanner = new Scanner(System.in);
			}
		}
		boolean inserido = ProdutoDao.inserir(prod1);
		if (inserido == true) {
			System.out.println("Produto inserido com sucesso!!!");
		} else {
			System.out.println("Erro ao inserir produto!!");
		}

	}

	public static void adicionarProdutos(Pedido pedido) { // metodo da interface
		String cadastrar = "s";
		int idProduto = 0;

		while (cadastrar.equalsIgnoreCase("s")) { // metodo do java da classe string para comparar ignorando se �
													// maiusculo ou minusculo

			Produto p = new Produto();
			idProduto++;
			p.setId(idProduto);
			Scanner scanner = new Scanner(System.in);
			String entrada = "";
			double preco = 0;
			System.out.println("Entre com nome do produto?");
			while (true) {
				try {
					entrada = scanner.nextLine();
					p.setNome(entrada);
					break;
				} catch (NomeCurtoException e2) {
					System.out.println(e2.getMessage());
					System.out.println("Entre com nome do produto correto");
				}
			}

			System.out.println("Entre com pre�o do produto?");
			try {
				preco = scanner.nextDouble();
				scanner.nextLine();// quando for double, int ou sem ser um string
				p.setPreco(preco);
				try {
					pedido.addProd(p);
				} catch (ProdutoExistenteException e) {
					System.out.println(e.getMessage());
				}
			} catch (InputMismatchException e1) {
				System.out.println("Digite um valor v�lido");
				scanner = new Scanner(System.in); // reabrindo o scanner porque a classe scanner fecha ele
			}

			System.out.println("Voce quer comprar um novo produto?");
			cadastrar = scanner.nextLine();

		}

	}
}
