package co.develhope.spettacolo.services;

import co.develhope.spettacolo.entities.Spettacolo;
import co.develhope.spettacolo.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private Utente utente;
    public double getShowPrice(Spettacolo spettacolo){
        return spettacolo.getPrice();
    }
}
