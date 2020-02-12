package com.project.thymeBindingDemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.thymeBindingDemo.model.UserModel;
import com.project.thymeBindingDemo.service.EmployeeService;

@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/register")
	public ModelAndView registerForm(Model model)
	{
	    model.addAttribute("userModel", new UserModel());
	    return new ModelAndView("register");
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute UserModel user)
	{
		empService.save(user);
		return new ModelAndView("success");
		
	}
	@RequestMapping("/")
    public ModelAndView get(Model model) 
    {
        List<UserModel> list = empService.get();
        model.addAttribute("employees", list);
        return new ModelAndView("employeeList");
    }
	
	@GetMapping("/edit/{id}")
	public ModelAndView get(@PathVariable int id){
		
		UserModel user=empService.get(id);
		if(user==null){
			throw new RuntimeException("Employee with id"+id+"is not found");
		}
		return new ModelAndView("update","userModel",user);
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		
		empService.delete(id);
		return "Employee has been deleted with id"+id;
	}	
}

