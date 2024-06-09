package onda.onda_yang.domain.roomType.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onda.onda_yang.domain.roomType.EnumDTO;
import onda.onda_yang.domain.roomType.EnumManager;
import onda.onda_yang.domain.roomType.dto.request.RoomTypeEdit;
import onda.onda_yang.domain.roomType.dto.request.RoomTypeRequest;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeEditResponse;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeListResponse;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeResponse;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;
import onda.onda_yang.domain.roomType.service.RoomTypeService;
import onda.onda_yang.global.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping("/categories")
    public List<EnumDTO> categoryList() {
        Class<? extends EnumManager> e = RoomTypeCategory.class;
        return Arrays
                .stream(e.getEnumConstants())
                .map(EnumDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/v1/hotel/{hotelId}/room-types/create")
    public void postRoomType(@PathVariable Long hotelId, @RequestBody @Valid RoomTypeRequest request) {
        roomTypeService.post(hotelId, request);
    }

//    @GetMapping("/v1/room-types/{roomTypeId}")
//    public RoomTypeResponse get(@PathVariable Long roomTypeId) {
//        return roomTypeService.get(roomTypeId);
//    }

//    @GetMapping("/v1/room-types/{roomTypeId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseDTO<RoomTypeResponse> get(@PathVariable Long roomTypeId) {
//        RoomTypeResponse response = roomTypeService.get(roomTypeId);
//        return ResponseDTO.res(response, "객실타입 조회에 성공했습니다.");
//    }
    @GetMapping("/v1/room-types/{roomTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<RoomTypeResponse> get(@PathVariable Long roomTypeId) {
        return ResponseDTO.res(roomTypeService.get(roomTypeId), "객실타입 조회에 성공했습니다.");
    }

//    @GetMapping("/v1/hotel/{hotelId}/room-types")
//    public List<RoomTypeListResponse> getList(@PathVariable Long hotelId) {
//        return roomTypeService.getList(hotelId);
//    }

    @GetMapping("/v1/hotel/{hotelId}/room-types")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<List<RoomTypeListResponse>> getList(@PathVariable Long hotelId) {
        return ResponseDTO.res(roomTypeService.getList(hotelId), "객실타입 리스트 조회에 성공했습니다.");
    }
//
//    @PatchMapping("/v1/room-types/{roomTypeId}")
//    public void edit(@PathVariable Long roomTypeId, @RequestBody @Valid RoomTypeEdit request) {
//        roomTypeService.edit(roomTypeId, request);
//    }

    @PatchMapping("/v1/room-types/{roomTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<RoomTypeEditResponse> edit(@PathVariable Long roomTypeId, @RequestBody @Valid RoomTypeEdit request) {
        return ResponseDTO.res(roomTypeService.edit(roomTypeId, request), "객실타입 수정에 성공했습니다.");
    }


//    @PostMapping("/v1/room-types/{roomTypeId}/delete")
//    public void delete(@PathVariable Long roomTypeId) {
//        roomTypeService.delete(roomTypeId);
//    }

    @PostMapping("/v1/room-types/{roomTypeId}/delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<String> delete(@PathVariable Long roomTypeId) {
        roomTypeService.delete(roomTypeId);
        return ResponseDTO.res("객실타입 삭제에 성공했습니다.");
    }


}


//@GetMapping("/v1/room-types/{roomTypeId}")
//@Operation(summary = "객실타입 단건 조회 API")
//public RoomTypeResponse get(@RequestHeader(AUTHORIZATION_HEADER) final String accessToken, @PathVariable Long roomTypeId) {
//    return roomTypeService.get(roomTypeId);
//}
//
//@GetMapping("/v1/hotel/{hotelId}/room-types")
//@Operation(summary = "객실타입 리스트 조회 API")
//public List<RoomTypeListResponse> getList(@RequestHeader(AUTHORIZATION_HEADER) final String accessToken, @PathVariable Long hotelId) {
//    return roomTypeService.getList(hotelId);
//}
//
//@PatchMapping("/v1/room-types/{roomTypeId}")
//@Operation(summary = "객실타입 수정 API")
//public void edit(@RequestHeader(AUTHORIZATION_HEADER) final String accessToken, @PathVariable Long roomTypeId, @RequestBody @Valid RoomTypeEdit request) {
//    roomTypeService.edit(roomTypeId, request);
//}
//
//@PostMapping("/v1/room-types/{roomTypeId}/delete")
//@Operation(summary = "객실타입 삭제 API")
//public void delete(@RequestHeader(AUTHORIZATION_HEADER) final String accessToken, @PathVariable Long roomTypeId) {
//    roomTypeService.delete(roomTypeId);
//}
