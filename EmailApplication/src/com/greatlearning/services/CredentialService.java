package com.greatlearning.services;

import java.util.Random;
import java.util.Scanner;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;

public class CredentialService implements ICredentials {
	private String firstName;
	private String lastName;
	private String department;
	
	Scanner sc = new Scanner(System.in);

	@Override
	public String generateEmailAddress(String firstName, String lastName, String department) {
		return firstName+lastName+"@"+department+".gl.com";
	}

	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters ="!@#$%^&*_=+-/.?<>"; 
		String values = capitalLetters+smallLetters+numbers+specialCharacters;
		Random random = new Random();
		
		String password= "";
		char temp;
		for(int i=0; i<8; i++)
		{
			password += String.valueOf(values.charAt(random.nextInt(values.length())));
		}
		
		return password;
	}

	@Override
	public void showCredentials(Employee employee) {
		System.out.println("Dear " + employee.getfirstName() +" your generated credentials are as follows");
		System.out.println("Email :- "+employee.getemail());
		System.out.println("Password :- "+employee.getPassword());
	}
	

}