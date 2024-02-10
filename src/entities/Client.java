package entities;

public class Client {

	protected Integer id;
	protected String name;
	protected String email;
	
	
	
	
	public Client() {
		
	}


	public Client(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
