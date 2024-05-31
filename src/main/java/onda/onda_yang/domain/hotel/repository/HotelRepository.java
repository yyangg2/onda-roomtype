package onda.onda_yang.domain.hotel.repository;


import onda.onda_yang.domain.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
