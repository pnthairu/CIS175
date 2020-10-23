package hotel.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class HotelDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hotelName;
	private String country;
	private String relationship;
	@Autowired
	private Address address;
	
	
	public HotelDetails() {
		super();	
		this.relationship = "Location";
	}
	
	public HotelDetails(String hotelName) {
		super();	
		this.hotelName = hotelName;
	}
	
	public HotelDetails(String hotelName, String country, String relationship) {
		super();		
		this.hotelName = hotelName;
		this.country = country;
		this.relationship = relationship;
	}
	
	public HotelDetails(Long id, String hotelName, String country, String relationship) {
		super();	
		this.id = id;
		this.hotelName = hotelName;
		this.country = country;
		this.relationship = relationship;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "HotelDetails [id=" + id + ", hotelName=" + hotelName + ", country=" + country + ", relationship="
				+ relationship + ", address=" + address + "]";
	}
	

}
