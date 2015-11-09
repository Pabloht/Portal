package br.com.fean.dao;

import java.util.List;

import br.com.fean.model.Funcionario;

public interface FuncionarioDAO {

	public void addFuncionario(Funcionario p);
	public void updateFuncionario(Funcionario p);
	public List<Funcionario> listFuncionarios();
	public Funcionario getFuncionarioByMatricula(int matricula);
	public void removeFuncionario(int id);
}
