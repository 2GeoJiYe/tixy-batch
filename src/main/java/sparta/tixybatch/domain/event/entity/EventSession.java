package sparta.tixybatch.domain.event.entity;


import jakarta.persistence.*;
import lombok.*;
import sparta.tixybatch.domain.event.enums.EventSessionStatus;

import java.time.LocalDateTime;

@Table(name = "event_sessions")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EventSessionStatus status;

    @Column(updatable = false)
    private LocalDateTime sessionOpenDate;

    @Column(updatable = false)
    private LocalDateTime sessionCloseDate;

}