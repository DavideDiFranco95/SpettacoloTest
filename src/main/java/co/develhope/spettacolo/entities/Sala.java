package co.develhope.spettacolo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    private Sede sede;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Posto> posti;
}
