package onda.onda_yang.domain.roomType.enumeration.attraction;


import lombok.Getter;
import onda.onda_yang.domain.roomType.EnumManager;

import java.util.Arrays;

@Getter
public enum AttractionOption implements EnumManager {
    BEACH("해수욕장"),
    FOREST_LODGE("수목원/휴양림"),
    GOLF("골프장"),
    SKI("스키장"),
    RIVER("강/호수"),
    FISHING("낚시장"),
    VALLEY("계곡"),
    WATER_LEISURE("수상 레져");

    AttractionOption(String viewName) {
        this.viewName = viewName;
    }

    private final String viewName;

    public static AttractionOption fromCode(String dbData) {
        return Arrays.stream(AttractionOption.values())
                .filter(v -> v.getViewName().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("어트랙션 옵션에 %s가 존재하지 않습니다.", dbData)));
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return viewName;
    }
}
