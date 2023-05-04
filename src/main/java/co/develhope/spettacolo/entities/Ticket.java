package co.develhope.spettacolo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @ManyToOne
    private Posto seat;
    @ManyToOne
    private Utente user;

}
