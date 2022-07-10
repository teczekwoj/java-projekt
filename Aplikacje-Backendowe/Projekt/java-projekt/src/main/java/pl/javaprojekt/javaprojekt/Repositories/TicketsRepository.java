package pl.javaprojekt.javaprojekt.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javaprojekt.javaprojekt.Entity.Tickets;

import java.util.List;

@Repository
public class TicketsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Tickets> getAll() {
        return jdbcTemplate.query("SELECT * FROM tickets",
                BeanPropertyRowMapper.newInstance(Tickets.class));
    }

    public Tickets getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tickets WHERE id=?",
                BeanPropertyRowMapper.newInstance(Tickets.class), id);
    }

    public int save(List<Tickets> ticket) {
        ticket.forEach(tickets -> jdbcTemplate
                .update("INSERT INTO tickets(ticketNo, object, product, description, dateOfRegistration," +
                                "dateOfRealization) VALUES(?,?,?,?,?,?)", tickets.getTicketNo(), tickets.getObject(),
                        tickets.getProduct(), tickets.getDescription(), tickets.getDateOfRegistration(),
                        tickets.getDateOfRealization()
                ));
        return 1;
    }

    public int update(Tickets tickets) {
        return jdbcTemplate.update("UPDATE tickets SET ticketNo=?, object=?, product=?, description=?, dateOfRegistration=?, dateOfRealization=? WHERE id=?"
                , tickets.getTicketNo(), tickets.getObject(),
                tickets.getProduct(), tickets.getDescription(), tickets.getDateOfRegistration(),
                tickets.getDateOfRealization(), tickets.getId());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM tickets WHERE id=?", id);
    }

}