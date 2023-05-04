package co.develhope.spettacolo.repositories;

import co.develhope.spettacolo.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository  extends JpaRepository<Utente,Long> {
}
