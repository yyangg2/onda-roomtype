package onda.onda_yang.domain.roomType.entity;



import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import onda.onda_yang.domain.hotel.entity.Hotel;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityConverter;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityOption;
import onda.onda_yang.domain.roomType.enumeration.attraction.AttractionConverter;
import onda.onda_yang.domain.roomType.enumeration.attraction.AttractionOption;
import onda.onda_yang.domain.roomType.enumeration.facility.FacilityConverter;
import onda.onda_yang.domain.roomType.enumeration.facility.FacilityOption;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategoryConverter;
import onda.onda_yang.domain.roomType.enumeration.service.ServiceConverter;
import onda.onda_yang.domain.roomType.enumeration.service.ServiceOption;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(
        indexes = {
                @Index(name = "IDX_ROOMTYPE_HOTEL_ID", columnList = "hotel_id")
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("객실타입 식별자")
    private Long Id;

    @Comment("전체 객실 수")
    private Integer totalRoom;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Convert(converter = RoomTypeCategoryConverter.class)
    private RoomTypeCategory roomTypeCategory; // Enum 타입 사용

    @Convert(converter = FacilityConverter.class)
    private List<FacilityOption> facilityOptions = new ArrayList<>(); // Enum 타입 사용

    @Convert(converter = AttractionConverter.class)
    private List<AttractionOption> attractionOptions = new ArrayList<>(); // Enum 타입 사용

    @Convert(converter = ServiceConverter.class)
    private List<ServiceOption> serviceOptions = new ArrayList<>(); // Enum 타입 사용

    @Convert(converter = AmenityConverter.class)
    private List<AmenityOption> amenityOptions = new ArrayList<>(); // Enum 타입 사용




    // 생성자 오버로딩




    @Builder
    public RoomType(Integer totalRoom, RoomTypeCategory roomTypeCategory) {
        this.totalRoom = totalRoom;
        this.roomTypeCategory = roomTypeCategory;
        this.facilityOptions = new ArrayList<>();
        this.attractionOptions = new ArrayList<>();
        this.serviceOptions = new ArrayList<>();
        this.amenityOptions = new ArrayList<>();
    }


    public void edit(List<FacilityOption> facilityOptions, List<AttractionOption> attractionOptions, List<ServiceOption> serviceOptions, List<AmenityOption> amenityOptions) {
        this.facilityOptions = facilityOptions != null ? facilityOptions : new ArrayList<>();
        this.attractionOptions = attractionOptions != null ? attractionOptions : new ArrayList<>();
        this.serviceOptions = serviceOptions != null ? serviceOptions : new ArrayList<>();
        this.amenityOptions = amenityOptions != null ? amenityOptions : new ArrayList<>();
    }

    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public void addFacilityOption(FacilityOption facilityOption) {
        facilityOptions.add(facilityOption);
    }

    public void addAttractionOption(AttractionOption attractionOption) {
        attractionOptions.add(attractionOption);
    }

    public void addServiceOption(ServiceOption serviceOption) {
        serviceOptions.add(serviceOption);
    }

    public void addAmenityOption(AmenityOption amenityOption) {
        amenityOptions.add(amenityOption);
    }


}
