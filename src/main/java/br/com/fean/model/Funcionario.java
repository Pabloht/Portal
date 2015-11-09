package br.com.fean.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="funcionario")
public class Funcionario {

	@Id
	@Column(name="matricula")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int matricula;
	@Column(name="nome")
	private String nome;
	@Column(name="dataNascimento")
	private Date dataNascimento;
	@Column(name="cpf")
	private String cpf;
	@Column(name="rg")
	private String rg;	

	
	
	public int getMatricula() {
		return matricula;
	}



	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString(){
		return "matricula="+matricula+", nome="+nome+", dataNascimento="+dataNascimento+",cpf="+getCpf()+", rg="+getRg();
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}
}
