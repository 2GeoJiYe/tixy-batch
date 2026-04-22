package sparta.tixybatch.domain.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sparta.tixybatch.domain.event.entity.EventSession;

import java.time.LocalDateTime;

public interface EventSessionRepository extends JpaRepository<EventSession,Long> {
    @Modifying
    @Query(value = "UPDATE event_sessions SET status = 'ON_PERFORM' " +
            "WHERE status = 'SCHEDULED' AND session_open_date <= :now LIMIT :limit",
            nativeQuery = true)
    int updateToOnPerformBatch(@Param("now") LocalDateTime now, @Param("limit") int limit);

    @Modifying
    @Query(value = "UPDATE event_sessions SET status = 'CLOSED' " +
            "WHERE status = 'ON_PERFORM' AND session_close_date <= :now LIMIT :limit",
            nativeQuery = true)
    int updateToClosedBatch(@Param("now") LocalDateTime now, @Param("limit") int limit);
}