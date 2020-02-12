package com.project.thymeBindingDemo.dbo;

import java.util.List;

import com.project.thymeBindingDemo.model.UserModel;

public interface EmpDbo {
	
	void save(UserModel user);
	
	List<UserModel> get();
	
	UserModel get(int id);
	
	void delete(int id);

}
