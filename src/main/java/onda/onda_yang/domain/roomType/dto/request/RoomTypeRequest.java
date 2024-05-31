package onda.onda_yang.domain.roomType.dto.request;


import lombok.Builder;
import lombok.Data;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityGroup;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityOption;
import onda.onda_yang.domain.roomType.enumeration.attraction.AttractionOption;
import onda.onda_yang.domain.roomType.enumeration.facility.FacilityOption;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;
import onda.onda_yang.domain.roomType.enumeration.service.ServiceOption;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomTypeRequest {

//    @NotBlank(message = "객실타입을 선택하세요.")
    private RoomTypeCategory roomTypeName;

//    @NotBlank(message = "객실개수를 입력하세요.")
    private Integer totalRoom;


    private List<FacilityOption> facilityOptions = new ArrayList<>();

    private List<AttractionOption> attractionOptions = new ArrayList<>();

    private List<ServiceOption> serviceOptions = new ArrayList<>();

    private List<AmenityGroup> amenityGroups = new ArrayList<>();

    private List<AmenityOption> amenityOptions = new ArrayList<>();

    @Builder
    public RoomTypeRequest(RoomTypeCategory roomTypeName, Integer totalRoom, List<FacilityOption> facilityOptions, List<AttractionOption> attractionOptions, List<ServiceOption> serviceOptions, List<AmenityGroup> amenityGroups, List<AmenityOption> amenityOptions) {
        this.roomTypeName = roomTypeName;
        this.totalRoom = totalRoom;
        this.facilityOptions = facilityOptions;
        this.attractionOptions = attractionOptions;
        this.serviceOptions = serviceOptions;
        this.amenityGroups = amenityGroups;
        this.amenityOptions = amenityOptions;
    }
}


