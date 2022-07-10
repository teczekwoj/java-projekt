package pl.javaprojekt.javaprojekt.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javaprojekt.javaprojekt.Entity.Users;
import pl.javaprojekt.javaprojekt.Repositories.UsersRepository;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("")
    public List<Users> getAll(){
        return usersRepository.getAll();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable("id") int id){
        return usersRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Users> users){
        return usersRepository.save(users);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Users updatedUsers)
    {
        Users users = usersRepository.getById(id);
        if (users != null)
        {
            users.setName(updatedUsers.getName());
            users.setSurname(updatedUsers.getSurname());
            users.setTelNumber(updatedUsers.getTelNumber());

            usersRepository.update(users);
            return 1;
        }
        else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Users updatedUsers){
        Users users = usersRepository.getById(id);

        if (users != null){
            if (updatedUsers.getName() != null) users.setName(updatedUsers.getName());
            if (updatedUsers.getSurname() != null) users.setSurname(updatedUsers.getSurname());
            if (updatedUsers.getTelNumber() != null) users.setTelNumber(updatedUsers.getTelNumber());

            usersRepository.update(users);
            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return usersRepository.delete(id);
    }
}
