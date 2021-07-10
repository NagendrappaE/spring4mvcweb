package com.evolvus.mvcweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.evolvus.mvcweb.model.TaStudent;

@Transactional
@Repository
public class StudentDaoImpl   implements StudentDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public void save(TaStudent entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		
	}
	
	
	
	
	
}
