package sparta.tixybatch.domain.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sparta.tixybatch.domain.event.entity.Event;

import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Modifying
    @Query("UPDATE Event e SET e.eventStatus = 'OPEN' " +
            "WHERE e.eventStatus = 'SCHEDULED' AND e.openDate <= :now")
    int updateToOpen(@Param("now") LocalDateTime today);

    @Modifying
    @Query("UPDATE Event e SET e.eventStatus = 'CLOSED' " +
            "WHERE e.eventStatus = 'OPEN' AND e.endDate <= :now")
    int updateToClosed(@Param("now") LocalDateTime today);
}
