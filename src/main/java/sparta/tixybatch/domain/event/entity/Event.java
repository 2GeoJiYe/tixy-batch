package sparta.tixybatch.domain.event.entity;


import jakarta.persistence.*;
import lombok.*;
import sparta.tixybatch.domain.event.enums.EventStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    @Column(updatable = false)
    private LocalDateTime openDate;

    @Column(updatable = false)
    private LocalDateTime endDate;
}