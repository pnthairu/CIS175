package hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.beans.HotelDetails;

public interface HotelRepository extends JpaRepository<HotelDetails, Long>{

}
