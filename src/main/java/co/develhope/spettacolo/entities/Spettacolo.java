package co.develhope.spettacolo.entities;

import co.develhope.spettacolo.enums.Genere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Spettacolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDateTime orario;
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Check(constraints = "price>=0")
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int minutes;
    @ManyToOne
    private Sala sala;
}
