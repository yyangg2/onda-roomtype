package onda.onda_yang.domain.roomType.dto.response;

import lombok.Builder;
import lombok.Data;
import onda.onda_yang.domain.roomType.entity.RoomType;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;




@Data
public class RoomTypeListResponse {
    private Long id;
    private RoomTypeCategory roomTypeName;
    private Integer totalRoom;


    // 생성자 오버로딩
    public RoomTypeListResponse(RoomType roomType) {
        this.id = roomType.getId();
        this.roomTypeName = roomType.getRoomTypeCategory();
        this.totalRoom = roomType.getTotalRoom();
    }

    @Builder
    public RoomTypeListResponse(Long id, RoomTypeCategory roomTypeName, Integer totalRoom) {
        this.id = id;
        this.roomTypeName = roomTypeName;
        this.totalRoom = totalRoom;
    }
}
