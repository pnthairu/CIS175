package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Address;
import dmacc.beans.Contact;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.ContactRepository;

@SpringBootApplication
public class EmployeeContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeContactsApplication.class, args);
		
		/*ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
			Contact c = appContext.getBean("contact",
			Contact.class);
			System.out.println(c.toString());*/
	}
	
	/*@Autowired
	ContactRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	//Using an existing bean
		Contact c = appContext.getBean("contact", Contact.class);
		c.setRelationship("Hr Employee");
		repo.save(c);
		
	//Creating a bean to use – not managed by Spring
		Contact d = new Contact("Bessy Karambu", "555-333-888", "IT Employee");
		Address a = new Address("456 Hickman Road", "Johnstone", "New York");
		d.setAddress(a);
		repo.save(d);
		
		List<Contact> allMyContacts = repo.findAll();
		for(Contact people: allMyContacts) {
			System.out.println(people.toString());
		}

			((AbstractApplicationContext) appContext).close();
		}*/
}
