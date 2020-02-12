package com.project.thymeBindingDemo.service;

import java.util.List;

import com.project.thymeBindingDemo.model.UserModel;

public interface EmployeeService {
	
	void save(UserModel user);
	
	List<UserModel> get();
	
	UserModel get(int id);
	
	void delete(int id);

}
