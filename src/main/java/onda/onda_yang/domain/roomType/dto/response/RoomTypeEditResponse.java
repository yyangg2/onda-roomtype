package onda.onda_yang.domain.roomType.dto.response;

import lombok.Builder;
import lombok.Data;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityOption;
import onda.onda_yang.domain.roomType.enumeration.attraction.AttractionOption;
import onda.onda_yang.domain.roomType.enumeration.facility.FacilityOption;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;
import onda.onda_yang.domain.roomType.enumeration.service.ServiceOption;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomTypeEditResponse {

    private Long id;
    private RoomTypeCategory roomTypeName;
    private Integer totalRoom;

    private List<FacilityOption> facilityOptions = new ArrayList<>();

    private List<AttractionOption> attractionOptions = new ArrayList<>();

    private List<ServiceOption> serviceOptions = new ArrayList<>();

    private List<AmenityOption> amenityOptions = new ArrayList<>();


    @Builder
    public RoomTypeEditResponse(Long id, RoomTypeCategory roomTypeName, Integer totalRoom, List<FacilityOption> facilityOptions, List<AttractionOption> attractionOptions, List<ServiceOption> serviceOptions, List<AmenityOption> amenityOptions) {
        this.id = id;
        this.roomTypeName = roomTypeName;
        this.totalRoom = totalRoom;
        this.facilityOptions = facilityOptions;
        this.attractionOptions = attractionOptions;
        this.serviceOptions = serviceOptions;
        this.amenityOptions = amenityOptions;
    }
}
