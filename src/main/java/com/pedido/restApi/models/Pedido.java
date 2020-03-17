package com.pedido.restApi.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO")
public class Pedido {

	private long id;
	private String cod_cliente;
	private String cod_produtos;
	private long valor_total;
	private String endereco;

	public Pedido() {
	}
	public Pedido(String cod_cliente,String cod_produtos,long valor_total,String endereco) {
		this.cod_produtos=cod_produtos;
		this.cod_cliente=cod_cliente;
		this.valor_total=valor_total;
		this.endereco=endereco;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;

	}
	@Column(name="cod_cliente", nullable=false)
	public String getCod_cliente () {
		return cod_cliente;
	}
	@Column(name="cod_produtos", nullable=false)
	public String getCod_produtos () {
		return cod_produtos;
	}
	@Column(name="endereco", nullable=false)
	public String getEndereco () {
		return endereco;
	}
	@Column(name="valor_total", nullable=false)
	public long getValor_total () {
		return valor_total;
	}

	public void setId (long id){
		this.id=id;
	}
	public void setCod_cliente (String cod_cliente){
		this.cod_cliente=cod_cliente;
	}
	public void setCod_produtos (String cod_produtos){
		this.cod_produtos=cod_produtos;
	}
	public void setValor_total (long valor_total){
		this.valor_total=valor_total;
	}
	public void setEndereco (String endereco){
		this.endereco=endereco;
	}
}
