package co.develhope.spettacolo.repositories;


import co.develhope.spettacolo.entities.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpettacoloRepository  extends JpaRepository<Spettacolo,Long> {
}
