package hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.beans.HotelDetails;

public interface HotelDetailsRepository extends JpaRepository<HotelDetails, Long> {

}
