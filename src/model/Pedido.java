package model;

import java.util.ArrayList;
import java.util.Date;

import model.enums.StatusPedido;

public class Pedido {

	private int id;
	private Cliente cliente;
	private Date data;
	private StatusPedido status;
	private ArrayList<Produto> produtos;

	public Pedido() {
		super();
		this.produtos = new ArrayList<Produto>();

	}

	public Pedido(int id, Cliente cliente, Date data, StatusPedido status) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", data=" + data + ", status=" + status + ", produtos="
				+ produtos + "]";
	}

	public void addProd(Produto p) {
		this.produtos.add(p);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

}
