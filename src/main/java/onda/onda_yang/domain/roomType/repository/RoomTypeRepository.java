package onda.onda_yang.domain.roomType.repository;


import onda.onda_yang.domain.roomType.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long>{

    List<RoomType> findByHotelId(Long hotelId);
}