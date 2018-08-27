package edu.recicla.app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoguinModel {
	
  @NotNull(message="El campo usuario no puede ser nulo")
  @Email(message="Formato de correo invalido")
  private String user;
  
  @NotNull(message="El campo password no puede ser nulo")
  private String password;

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
