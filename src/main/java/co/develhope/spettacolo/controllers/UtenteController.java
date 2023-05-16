package co.develhope.spettacolo.controllers;


import co.develhope.spettacolo.entities.Posto;
import co.develhope.spettacolo.entities.Spettacolo;
import co.develhope.spettacolo.entities.Ticket;
import co.develhope.spettacolo.entities.Utente;
import co.develhope.spettacolo.repositories.PostoRepository;
import co.develhope.spettacolo.repositories.SpettacoloRepository;
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
    private TicketController ticketController;
    @Autowired
    private UtenteController utenteController;
    @Autowired
    private PostoController postoController;
    @Autowired
    private SpettacoloController spettacoloController;
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
    public double buyTicket(@RequestHeader("user") long idUser,
                            @RequestHeader("seat") long idSeat,
                            @RequestHeader("show") long idShow){
        Ticket ticket = new Ticket();
        ticket.setTimestamp(LocalDateTime.now());
        Utente u = getUtenteById(idUser);
        Spettacolo s = spettacoloController.getSpettacoloById(idShow);
        Posto p = postoController.getPostoById(idSeat);
        ticket.setUser(u);
        ticket.setSeat(p);
        ticket.setSpettacolo(s);
        ticketController.createTicket(ticket);
        return utenteService.getShowPrice(s);
    }
}
