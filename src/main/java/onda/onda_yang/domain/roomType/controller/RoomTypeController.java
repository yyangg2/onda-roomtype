package onda.onda_yang.domain.roomType.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onda.onda_yang.domain.roomType.EnumDTO;
import onda.onda_yang.domain.roomType.EnumManager;
import onda.onda_yang.domain.roomType.dto.request.RoomTypeEdit;
import onda.onda_yang.domain.roomType.dto.request.RoomTypeRequest;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeListResponse;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeResponse;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;
import onda.onda_yang.domain.roomType.service.RoomTypeService;
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

    @GetMapping("/v1/room-types/{roomTypeId}")
    public RoomTypeResponse get(@PathVariable Long roomTypeId) {
        return roomTypeService.get(roomTypeId);
    }

    @GetMapping("/v1/hotel/{hotelId}/room-types")
    public List<RoomTypeListResponse> getList(@PathVariable Long hotelId) {
        return roomTypeService.getList(hotelId);
    }

    @PatchMapping("/v1/room-types/{roomTypeId}")
    public void edit(@PathVariable Long roomTypeId, @RequestBody @Valid RoomTypeEdit request) {
        roomTypeService.edit(roomTypeId, request);
    }

    @PostMapping("/v1/room-types/{roomTypeId}/delete")
    public void delete(@PathVariable Long roomTypeId) {
        roomTypeService.delete(roomTypeId);
    }


}
