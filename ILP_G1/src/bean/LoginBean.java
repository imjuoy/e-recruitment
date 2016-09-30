package bean;

import java.io.Serializable;


public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role;
	
	public LoginBean(){
		super();
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getRole() {
		return role;
	}
}
