package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	private String relationship;
	@Autowired
	private Address address; 
	
	public Contact() {
		super();
		this.relationship = "Employee";

	}
	
	public Contact(String name, String phone, String relationship) {
		super();
		this.name = name;
		this.phone = phone;
		this.relationship = relationship;
	}
	
	public Contact(int id, String name, String phone, String relationship) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.relationship = relationship;
	}	
}
