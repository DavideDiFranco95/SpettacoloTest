package co.develhope.spettacolo.repositories;


import co.develhope.spettacolo.entities.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository  extends JpaRepository<Sede,Long> {
}
