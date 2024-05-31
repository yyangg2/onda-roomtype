package onda.onda_yang.domain.roomType.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onda.onda_yang.domain.hotel.entity.Hotel;
import onda.onda_yang.domain.hotel.exception.HotelNotFound;
import onda.onda_yang.domain.hotel.repository.HotelRepository;
import onda.onda_yang.domain.roomType.dto.request.RoomTypeEdit;
import onda.onda_yang.domain.roomType.dto.request.RoomTypeRequest;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeListResponse;
import onda.onda_yang.domain.roomType.dto.response.RoomTypeResponse;
import onda.onda_yang.domain.roomType.entity.RoomType;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityGroup;
import onda.onda_yang.domain.roomType.enumeration.amenity.AmenityOption;
import onda.onda_yang.domain.roomType.enumeration.attraction.AttractionOption;
import onda.onda_yang.domain.roomType.enumeration.facility.FacilityOption;
import onda.onda_yang.domain.roomType.enumeration.roomType.RoomTypeCategory;
import onda.onda_yang.domain.roomType.enumeration.service.ServiceOption;
import onda.onda_yang.domain.roomType.exception.RoomTypeNotFound;
import onda.onda_yang.domain.roomType.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;
    private final HotelRepository hotelRepository;

//    @Transactional
//    public void basic(Long hotelId, RoomTypeBasicRequest request) {
//        Hotel hotel = hotelRepository.findById(hotelId)
//                .orElseThrow(HotelNotFound::new);
//
//        hotel.setHotelNameAndRegion(request.getHotelName(), request.getRegion());
//
//        RoomType roomType = RoomType.builder()
//                .roomTypeName(request.getRoomTypeName())
//                .totalRoom(request.getTotalRoom())
//                .build();
//
//        hotel.addRoomType(roomType);
//
//        roomTypeRepository.save(roomType);
//    }

//    @Transactional
//    public void basic(RoomTypeBasicRequest request) {
//        System.out.println("서비스 함수 시작");
//        System.out.println("request = " + request);
////        Hotel hotel = Hotel.builder()
////                .hotelName(request.getHotelName())
////                .region(request.getRegion())
////                .build();
////
////        hotelRepository.save(hotel);
////
////        List<RoomTypeCategory> roomTypeNames = request.getRoomTypeNames();
////        List<Integer> totalRooms = request.getTotalRooms();
////
////        if (roomTypeNames.size() != totalRooms.size()) {
////            throw new IllegalArgumentException("Room type names and total rooms lists must have the same size");
////        }
////
////        List<RoomType> roomTypes = new ArrayList<>();
////        for (int i = 0; i < roomTypeNames.size(); i++) {
////            RoomType roomType = RoomType.builder()
////                    .roomTypeCategory(roomTypeNames.get(i))
////                    .totalRoom(totalRooms.get(i))
////                    .build();
////            roomTypes.add(roomType);
////        }
////
////        for (RoomType roomType : roomTypes) {
////            hotel.addRoomType(roomType);
////            roomTypeRepository.save(roomType);
////        }
//
//    }


    public void post(Long hotelId, RoomTypeRequest request) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(HotelNotFound::new);

        RoomTypeCategory roomTypeName = request.getRoomTypeName();
        Integer totalRoom = request.getTotalRoom();

        RoomType roomType = RoomType.builder()
                .roomTypeCategory(roomTypeName)
                .totalRoom(totalRoom)
                .build();

        List<FacilityOption> facilityOptions = request.getFacilityOptions();
        List<AttractionOption> attractionOptions = request.getAttractionOptions();
        List<ServiceOption> serviceOptions = request.getServiceOptions();

//        List<AmenityGroup> amenityGroups = request.getAmenityGroups();
        List<AmenityOption> amenityOptions = request.getAmenityOptions();

        for (FacilityOption facilityOption : facilityOptions) {
            roomType.addFacilityOption(facilityOption);
        }

        for (AttractionOption attractionOption : attractionOptions) {
            roomType.addAttractionOption(attractionOption);
        }

        for (ServiceOption serviceOption : serviceOptions) {
            roomType.addServiceOption(serviceOption);
        }

        for (AmenityOption amenityOption : amenityOptions) {
            roomType.addAmenityOption(amenityOption);
        }

//        for (AmenityOption amenityOption : amenityOptions) {
//            AmenityGroup group = AmenityGroup.findGroup(amenityOption);
//
//        }



        hotel.addRoomType(roomType);

        roomTypeRepository.save(roomType);
    }

    public RoomTypeResponse get(Long roomTypeId) {
        RoomType roomType = roomTypeRepository.findById(roomTypeId)
                .orElseThrow(RoomTypeNotFound::new);

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

    public List<RoomTypeListResponse> getList(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
        .orElseThrow(HotelNotFound::new);

        return roomTypeRepository.findByHotelId(hotel.getId()).stream()
                .map(RoomTypeListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void edit(Long id, RoomTypeEdit roomTypeEdit) {
        RoomType roomType = roomTypeRepository.findById(id)
                .orElseThrow(RoomTypeNotFound::new);

        roomType.edit(roomTypeEdit.getFacilityOptions(), roomTypeEdit.getAttractionOptions(), roomTypeEdit.getServiceOptions(), roomTypeEdit.getAmenityOptions());
    }

    @Transactional
    public void delete(Long id) {
        RoomType roomType = roomTypeRepository.findById(id)
                .orElseThrow(RoomTypeNotFound::new);

        roomTypeRepository.delete(roomType);
    }

}



