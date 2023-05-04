package co.develhope.spettacolo.repositories;

import co.develhope.spettacolo.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository  extends JpaRepository<Sala,Long> {
}
