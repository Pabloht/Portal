package br.com.fean.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.fean.model.Funcionario;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(FuncionarioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addFuncionario(Funcionario p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Funcionario saved successfully, Funcionario Details="+p);
	}

	@Override
	public void updateFuncionario(Funcionario p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Funcionario updated successfully, Funcionario Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listFuncionarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Funcionario> funcionariosList = session.createQuery("from Funcionario").list();
		for(Funcionario p : funcionariosList){
			logger.info("Funcionario List::"+p);
		}
		return funcionariosList;
	}

	@Override
	public Funcionario getFuncionarioByMatricula(int matricula) {
		Session session = this.sessionFactory.getCurrentSession();		
		Funcionario p = (Funcionario) session.load(Funcionario.class, new Integer(matricula));
		logger.info("Funcionario loaded successfully, Funcionario details="+p);
		return p;
	}

	@Override
	public void removeFuncionario(int matricula) {
		Session session = this.sessionFactory.getCurrentSession();
		Funcionario p = (Funcionario) session.load(Funcionario.class, new Integer(matricula));
		if(null != p){
			session.delete(p);
		}
		logger.info("Funcionario deleted successfully, funcionario details="+p);
	}

}
