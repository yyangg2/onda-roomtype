package onda.onda_yang.domain.hotel.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import onda.onda_yang.domain.roomType.entity.RoomType;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("호텔 식별자")
    private Long id;

    @Column(nullable = false)
    @Comment("호텔 이름")
    private String hotelName;

    @Comment("지역")
    private String region;

    @Comment("도시")
    private String city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<RoomType> roomTypes = new ArrayList<>();

    @Builder
    public Hotel(Long id, String hotelName, String region, String city) {
        this.id = id;
        this.hotelName = hotelName;
        this.region = region;
        this.city = city;
    }

    // 호텔이름 및 지역 설정하는 함수
    public void setHotelNameAndRegion(String hotelName, String region) {
        this.hotelName = hotelName;
        this.region = region;
    }

    public void addRoomType(RoomType roomType) {
        roomType.setHotel(this);
        this.roomTypes.add(roomType);
    }
}
