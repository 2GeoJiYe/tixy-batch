package sparta.tixybatch.domain.seat.entity;

import jakarta.persistence.*;
import lombok.*;
import sparta.tixybatch.domain.seat.enums.SessionSeatStatus;

import java.time.LocalDateTime;

@Table(name = "seat_sessions")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SessionSeatStatus status;

    private Long userId;

    private LocalDateTime expireAt;

}
