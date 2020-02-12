package com.project.thymeBindingDemo.dbo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.thymeBindingDemo.model.UserModel;

@Repository
public class EmpDboImp implements EmpDbo{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(UserModel user) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(user);
	}

	@Override
	public List<UserModel> get() {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Query<UserModel> query=currentSession.createQuery("from UserModel",UserModel.class);
		List<UserModel> list=query.getResultList();
		return list;
	}

	@Override
	public UserModel get(int id) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		UserModel user=currentSession.get(UserModel.class, id);
		return user;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		UserModel user=currentSession.get(UserModel.class, id);
		currentSession.delete(user);
		
	}

}
