package com.eduloan.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduloan.demo.Model.LoanApplicationModel;
import com.eduloan.demo.Model.LoginModel;
import com.eduloan.demo.Model.UserModel;
import com.eduloan.demo.Service.Services;

@CrossOrigin
@RestController
public class Controller {

	@Autowired Services s;
	
	
	@PostMapping("/user/login")
	public String userLogin(@RequestBody Map<String, String> mp)
	{
		String mail = mp.get("email");
		String pass = mp.get("password");
		return s.validateUser(mail, pass);
	}
	
	@PostMapping("/user/signup")
	public String userSignup(@RequestBody LoginModel lm)
	{
			return s.newUser(lm);
	}
	
	@GetMapping("/user/getProfile")
	public Optional<UserModel> getProf()
	{
		
			return s.getUserProf();
		
	}
	
	@GetMapping("user/viewLoan")
	public Optional<LoanApplicationModel> viewLoan()
	{
			return s.viewLoan();
		
	}
	
	@GetMapping("/admin/getAllLoans")
	public List<LoanApplicationModel> getAllLoans()
	{
			return s.getAllLoans();
		
	}
	
	@PostMapping("/admin/login")
	public String adminLogin(@RequestBody Map<String, String> mp)
	{
		String mail = mp.get("email");
		String pass = mp.get("password");
		return s.validateAdmin(mail, pass);
	}
	
	@DeleteMapping("admin/deleteUser/{id}")
	public String delUser(@PathVariable int id)
	{
		return s.delUser(id);
	}
	
	@PutMapping("admin/updateUser")
	public String update(@RequestBody UserModel um)
	{
		return s.update(um);
	}
}
