package co.develhope.spettacolo.interceptors;

import co.develhope.spettacolo.controllers.PostoController;
import co.develhope.spettacolo.controllers.SpettacoloController;
import co.develhope.spettacolo.controllers.TicketController;
import co.develhope.spettacolo.controllers.UtenteController;
import co.develhope.spettacolo.entities.Posto;
import co.develhope.spettacolo.entities.Spettacolo;
import co.develhope.spettacolo.entities.Ticket;
import co.develhope.spettacolo.entities.Utente;
import co.develhope.spettacolo.exceptions.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UtenteInterceptor implements HandlerInterceptor {

    @Autowired
    private UtenteController utenteController;
    @Autowired
    private SpettacoloController spettacoloController;
    @Autowired
    private PostoController postoController;
    @Autowired
    private TicketController ticketController;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String kindOfOperation = request.getHeader("kind");
       if (kindOfOperation.equals("purchase")){
           /*
           1) controllare che l'utente sia registrato
           2) controllare che lo spettacolo non sia nel passato
           3) controllare che il posto per quello spettacolo non sia già prenotato
           4) controllare che l'utente non abbia già prenotato 4 posti per quello spettacolo
            */
           try {
               // cerchiamo se esiste già un ticket riferito al posto p nello spettacolo s
               Integer idUser = Integer.parseInt(request.getHeader("user"));
               Utente u = utenteController.getUtenteById(idUser);
               Integer idSpettacolo = Integer.parseInt(request.getHeader("show"));
               Spettacolo s = spettacoloController.getSpettacoloById(idSpettacolo);
               if (s.getOrario().isBefore(LocalDateTime.now())){
                   throw new ShowInThePastException();
               }
               Integer idPosto = Integer.parseInt(request.getHeader("seat"));
               Posto p = postoController.getPostoById(idPosto);
               List<Ticket> ticketsShow = ticketController.ticketShow(idSpettacolo,idPosto);
               if (ticketsShow.size()>0){
                   throw new SeatBookedYetException();
               }
               List<Ticket> ticketsUser = ticketController.ticketUserShow(idSpettacolo,idUser);
               if (ticketsUser.size()>= 4){
                   throw new TooMuchTicketException();
               }
           }
           catch (EntityNotFoundException e){
               e.getMessage();
               e.printStackTrace();
               return false;
           }

           catch (SeatBookedYetException e){
               e.getMessage();
               e.printStackTrace();
               return false;
           }
           catch (TooMuchTicketException e){
               e.getMessage();
               e.printStackTrace();
               return false;
           }
           catch (ShowInThePastException e){
               e.getMessage();
               e.printStackTrace();
               return false;
           }
       }
       return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {

    }
}
