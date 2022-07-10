package pl.javaprojekt.javaprojekt.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javaprojekt.javaprojekt.Entity.Users;

import java.util.List;

@Repository
public class UsersRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Users> getAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                BeanPropertyRowMapper.newInstance(Users.class));
    }

    public Users getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
                BeanPropertyRowMapper.newInstance(Users.class), id);
    }

    public int save(List<Users> user) {
        user.forEach(users -> jdbcTemplate
                .update("INSERT INTO users(name, surname, telNumber) VALUES(?,?,?)", users.getName(), users.getSurname(),
                        users.getTelNumber()
                ));
        return 1;
    }

    public int update(Users users) {
        return jdbcTemplate.update("UPDATE users SET name=?, surname=?, telNumber=? WHERE id=?"
                , users.getName(), users.getSurname(), users.getTelNumber(), users.getId());
    }
    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

}