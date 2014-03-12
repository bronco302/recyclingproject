package rmos;

import java.io.Serializable;


public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public Admin(String username, String password){
		this.username = username;
		this.password = password;
	}

	public Admin(){
		username = "admin";
		password = "password";
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}
	
	public boolean validate(String username, String password){
		if(this.username.equals(username)&&(this.password.equals(password))){
			return true;
		}
		else{
			return false;
		}
	}

}