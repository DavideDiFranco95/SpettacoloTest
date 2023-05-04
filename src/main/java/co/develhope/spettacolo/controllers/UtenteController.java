package co.develhope.spettacolo.controllers;


import co.develhope.spettacolo.entities.Posto;
import co.develhope.spettacolo.entities.Spettacolo;
import co.develhope.spettacolo.entities.Ticket;
import co.develhope.spettacolo.entities.Utente;
import co.develhope.spettacolo.repositories.TicketRepository;
import co.develhope.spettacolo.repositories.UtenteRepository;
import co.develhope.spettacolo.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UtenteService utenteService;

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
    @PostMapping("/purchase")
    public double buyTicket(@RequestBody Spettacolo spettacolo,
                            @RequestBody Posto posto,
                            @RequestBody Utente user){
        Ticket ticket = new Ticket();
        ticket.setTimestamp(LocalDateTime.now());
        ticket.setSeat(posto);
        ticket.setUser(user);
        ticketRepository.saveAndFlush(ticket);
        return utenteService.getShowPrice(spettacolo);
    }
}
