package sparta.tixybatch.domain.seat.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import sparta.tixybatch.domain.seat.entity.SeatSession;
import sparta.tixybatch.domain.seat.enums.SessionSeatStatus;

import java.time.LocalDateTime;

public interface SeatSessionRepository extends JpaRepository<SeatSession,Long> {

    @Modifying
    @Query("UPDATE SeatSession s SET s.status = 'AVAILABLE', s.userId = null, s.expireAt = null " +
            "WHERE s.status = 'HELD' AND s.expireAt <= :now")
    int releaseExpiredHolds(@Param("now") LocalDateTime now);

    long countByStatus(SessionSeatStatus status);
}
