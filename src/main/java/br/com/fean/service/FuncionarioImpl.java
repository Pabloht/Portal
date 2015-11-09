package br.com.fean.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fean.dao.FuncionarioDAO;
import br.com.fean.model.Funcionario;

@Service
public class FuncionarioImpl implements FuncionarioService {
	
	private FuncionarioDAO funcionarioDAO;

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	@Override
	@Transactional
	public void addFuncionario(Funcionario p) {
		this.funcionarioDAO.addFuncionario(p);
	}

	@Override
	@Transactional
	public void updateFuncionario(Funcionario p) {
		this.funcionarioDAO.updateFuncionario(p);
	}

	@Override
	@Transactional
	public List<Funcionario> listFuncionarios() {
		return this.funcionarioDAO.listFuncionarios();
	}

	@Override
	@Transactional
	public Funcionario getFuncionarioByMatricula(int matricula) {
		return this.funcionarioDAO.getFuncionarioByMatricula(matricula);
	}

	@Override
	@Transactional
	public void removeFuncionario(int matricula) {
		this.funcionarioDAO.removeFuncionario(matricula);
	}

}
