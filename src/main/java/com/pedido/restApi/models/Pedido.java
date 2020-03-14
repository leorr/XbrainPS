package com.pedido.restApi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_Pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private String id;
	private String cod_cliente;
	private String cod_produtos;
	private long valor_total;
	private String endereco;

	private String getId () {
		return  id;
	}
	private String getCod_cliente () {
		return cod_cliente;
	}
	private String getCod_produtos () {
		return cod_produtos;
	}
	private String getEndereco () {
		return endereco;
	}
	private long getValor_total () {
		return valor_total;
	}

	public void setId (String id){
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
