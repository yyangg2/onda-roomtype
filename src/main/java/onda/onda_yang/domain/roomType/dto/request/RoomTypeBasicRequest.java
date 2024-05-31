package onda.onda_yang.domain.roomType.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomTypeBasicRequest {

    @NotBlank(message = "호텔명을 입력하세요.")
    private String hotelName;

    @NotBlank(message = "지역을 입력하세요.")
    private String region;

//    @NotBlank(message = "객실타입을 선택하세요.")
//    private RoomTypeCategory roomTypeName;
//
//    @NotBlank(message = "객실개수를 입력하세요.")
//    private Integer totalRoom;

    @NotBlank(message = "객실타입을 선택하세요.")
    private List<RoomTypeCategory> roomTypeNames = new ArrayList<>();

    @NotBlank(message = "객실개수를 입력하세요.")
    private List<Integer> totalRooms = new ArrayList<>();

    @Builder
    public RoomTypeBasicRequest(String hotelName, String region, List<RoomTypeCategory> roomTypeNames, List<Integer> totalRooms) {
        this.hotelName = hotelName;
        this.region = region;
        this.roomTypeNames = roomTypeNames;
        this.totalRooms = totalRooms;
    }
}
