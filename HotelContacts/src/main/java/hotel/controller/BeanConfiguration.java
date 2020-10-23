package hotel.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hotel.beans.Address;
import hotel.beans.HotelDetails;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public HotelDetails hotel() {
		HotelDetails bean = new HotelDetails();
		bean.setHotelName("Intercontinental Hotel");
		bean.setCountry("United States");
		bean.setRelationship("location");		
		return bean;
	}	
	@Bean
	public Address address() {
		Address bean = new Address("4569 Main Street", "Reno", "Nevada");		
		return bean;
	}
}
