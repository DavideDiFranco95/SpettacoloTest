package co.develhope.spettacolo.repositories;

import co.develhope.spettacolo.entities.Posto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoRepository extends JpaRepository<Posto,Long> {
}
