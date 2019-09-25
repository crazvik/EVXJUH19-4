package se.ec.jonatan.fourth_app;

public class Student {
	private int id;
	private String name;
	private String email;
	private String adress;
	
	public Student(int id, String name, String email, String adress) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.adress = adress;
	}
	
	public void setId(int n) {
		id = n;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String mail) {
		email = mail;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setAdress(String ad) {
		adress = ad;
	}
	
	public String getAdress() {
		return adress;
	}
}