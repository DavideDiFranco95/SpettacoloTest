package co.develhope.spettacolo.controllers;


import co.develhope.spettacolo.entities.Utente;
import co.develhope.spettacolo.repositories.UtenteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    private UtenteRepository utenteRepository;

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable long id){
        return utenteRepository.getReferenceById(id);
    }
    @GetMapping("/all")
    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }

    @PostMapping("/create")
    public Utente createUtente(@RequestBody Utente utente){
        return utenteRepository.saveAndFlush(utente);
    }
    @DeleteMapping("/{id}")
    public void deleteUtenteById(@PathVariable long id){
        utenteRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Utente updateUtente(@RequestBody Utente utente){
        return utenteRepository.saveAndFlush(utente);
    }
}
