package sparta.tixybatch.domain.event.enums;

import lombok.Getter;

@Getter
public enum EventStatus {
    SCHEDULED("오픈 예정"),
    OPEN("절찬상영중"),
    CLOSED("종료");

    private final String status;

    EventStatus(String status) {
        this.status = status;
    }

}
