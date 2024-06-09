package onda.onda_yang.domain.roomType.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeEditResponse;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeResponse;
import onda.onda_yang.domain.roomType.entity.RoomType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomTypeMapper {

    public static RoomTypeResponse toRoomTypeResponse(RoomType roomType) {
        return RoomTypeResponse.builder()
                .id(roomType.getId())
                .roomTypeName(roomType.getRoomTypeCategory())
                .totalRoom(roomType.getTotalRoom())
                .facilityOptions(roomType.getFacilityOptions())
                .attractionOptions(roomType.getAttractionOptions())
                .serviceOptions(roomType.getServiceOptions())
                .amenityOptions(roomType.getAmenityOptions())
                .build();
    }

    public static RoomTypeEditResponse toRoomTypeEditResponse(RoomType roomType) {
        return RoomTypeEditResponse.builder()
                .id(roomType.getId())
                .roomTypeName(roomType.getRoomTypeCategory())
                .totalRoom(roomType.getTotalRoom())
                .facilityOptions(roomType.getFacilityOptions())
                .attractionOptions(roomType.getAttractionOptions())
                .serviceOptions(roomType.getServiceOptions())
                .amenityOptions(roomType.getAmenityOptions())
                .build();
    }

}
