package sparta.tixybatch.domain.ticket.entity;

import jakarta.persistence.*;
import lombok.*;
import sparta.tixybatch.domain.ticket.enums.TicketTypeStatus;

import java.time.LocalDateTime;

@Table(name = "ticket_types")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketTypeStatus ticketTypeStatus;

    @Column(nullable = false)
    private LocalDateTime saleOpenDateTime;

    @Column(nullable = false)
    private LocalDateTime saleCloseDateTime;
}