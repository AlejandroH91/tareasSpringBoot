package com.CRUD.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Usuarios {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String username;

	    private String password;

	    private boolean esAdmin;
	    
	    public Usuarios() {}

	    public Usuarios(String username, String password, boolean esAdmin) {
	        this.username = username;
	        this.password = password;
	        this.esAdmin = esAdmin;
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

		public boolean isEsAdmin() {
			return esAdmin;
		}

		public void setEsAdmin(boolean esAdmin) {
			this.esAdmin = esAdmin;
		}
	    
	    
}
