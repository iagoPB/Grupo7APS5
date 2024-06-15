package com.grupo7.hospital.DTO;

public class UserRegisteredDTO {

	private int id;
	
    private String name;
	
	private String email_id;
	
	private String password;
	
	private String perfil;
	
	private String especialidade;

	public UserRegisteredDTO() {
		super();
	}

	public UserRegisteredDTO(String perfil) {
		super();
		this.perfil = perfil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
}
