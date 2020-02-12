package com.project.thymeBindingDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.thymeBindingDemo.dbo.EmpDbo;
import com.project.thymeBindingDemo.model.UserModel;

@Service
public class EmpServiceImp implements EmployeeService {
	
	@Autowired
	private EmpDbo empDbo;

	@Transactional
	@Override
	public void save(UserModel user) {
		// TODO Auto-generated method stub
		empDbo.save(user);
	}

	@Transactional
	@Override
	public List<UserModel> get() {
		// TODO Auto-generated method stub
		return empDbo.get();
	}

	@Transactional
	@Override
	public UserModel get(int id) {
		// TODO Auto-generated method stub
		return empDbo.get(id);
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		empDbo.delete(id);
	}
	
	
}
