package hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import hotel.beans.Address;
import hotel.beans.HotelDetails;
import hotel.controller.BeanConfiguration;
import hotel.repository.HotelDetailsRepository;
import hotel.repository.HotelRepository;


@SpringBootApplication
public class HotelContactsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		/*SpringApplication.run(HotelContactsApplication.class, args);
		
		*ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		*HotelDetails hd = appContext.getBean("hotel", HotelDetails.class);
		
		*System.out.println(hd.toString());*/
	}
	@Autowired
	HotelDetailsRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
		//Using an existing bean
		HotelDetails c = appContext.getBean("hotel", HotelDetails.class);
		c.setRelationship("Location");
		repo.save(c);
	
		//Creating a bean to use – not managed by Spring
		HotelDetails d = new HotelDetails("Marriot Hotels", "USA", "Branch");
		Address a = new Address("1010 Broadway", "Marietta", "Georgia");
		d.setAddress(a);
		repo.save(d);
	
		List<HotelDetails> allLocations = repo.findAll();
		for(HotelDetails hotels: allLocations) {
			System.out.println(hotels.toString());	
		}
			((AbstractApplicationContext) appContext).close();
	}

}
