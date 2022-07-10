package pl.javaprojekt.javaprojekt.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javaprojekt.javaprojekt.Entity.Status;
import pl.javaprojekt.javaprojekt.Entity.Users;

import java.util.List;

@Repository
public class StatusRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Status> getAll() {
        return jdbcTemplate.query("SELECT * FROM status",
                BeanPropertyRowMapper.newInstance(Status.class));
    }

    public Status getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM status WHERE id=?",
                BeanPropertyRowMapper.newInstance(Status.class), id);
    }

    public int save(List<Status> status) {
        status.forEach(statuses -> jdbcTemplate
                .update("INSERT INTO status(ticketStatus) VALUES(?)", statuses.getTicketStatus()
                ));
        return 1;
    }

    public int update(Status status) {
        return jdbcTemplate.update("UPDATE status SET ticketStatus=? WHERE id=?"
                , status.getTicketStatus(), status.getId());
    }
    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM status WHERE id=?", id);
    }

}