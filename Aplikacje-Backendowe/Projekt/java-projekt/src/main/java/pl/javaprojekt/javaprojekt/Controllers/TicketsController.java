package pl.javaprojekt.javaprojekt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javaprojekt.javaprojekt.Entity.Tickets;
import pl.javaprojekt.javaprojekt.Repositories.TicketsRepository;

import java.util.List;

    
    @RestController
    @RequestMapping("/tickets")

    public class TicketsController {

        @Autowired
        TicketsRepository ticketsRepository;

        @GetMapping("")
        public List<Tickets> getAll(){
            return ticketsRepository.getAll();
        }

        @GetMapping("/{id}")
        public Tickets getById(@PathVariable("id") int id){
            return ticketsRepository.getById(id);
        }

        @PostMapping("")
        public int add(@RequestBody List<Tickets> tickets){
            return ticketsRepository.save(tickets);
        }

        @PutMapping("/{id}")
        public int update(@PathVariable("id") int id, @RequestBody Tickets updatedTickets)
        {
            Tickets tickets = ticketsRepository.getById(id);
            if (tickets != null)
            {
                tickets.setTicketNo(updatedTickets.getTicketNo());
                tickets.setObject(updatedTickets.getObject());
                tickets.setProduct(updatedTickets.getProduct());
                tickets.setDescription(updatedTickets.getDescription());
                tickets.setDateOfRegistration(updatedTickets.getDateOfRegistration());
                tickets.setDateOfRealization(updatedTickets.getDateOfRealization());

                ticketsRepository.update(tickets);
                return 1;
            }
            else {
                return -1;
            }
        }

        @PatchMapping("/{id}")
        public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Tickets updatedTickets){
            Tickets tickets = ticketsRepository.getById(id);

            if (tickets != null){
                if (updatedTickets.getTicketNo() != null) tickets.setTicketNo(updatedTickets.getTicketNo());
                if (updatedTickets.getObject() != null) tickets.setObject(updatedTickets.getObject());
                if (updatedTickets.getProduct() != null) tickets.setProduct(updatedTickets.getProduct());
                if (updatedTickets.getDescription() != null) tickets.setDescription(updatedTickets.getDescription());
                if (updatedTickets.getDateOfRegistration() != null) tickets.setDateOfRegistration(updatedTickets.getDateOfRegistration());
                if (updatedTickets.getDateOfRealization() != null) tickets.setDateOfRealization(updatedTickets.getDateOfRealization());
                ticketsRepository.update(tickets);
                return 1;
            } else {
                return -1;
            }
        }

        @DeleteMapping("/{id}")
        public int delete(@PathVariable("id") int id){
            return ticketsRepository.delete(id);
        }
    }
