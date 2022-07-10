package pl.javaprojekt.javaprojekt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javaprojekt.javaprojekt.Entity.Status;
import pl.javaprojekt.javaprojekt.Repositories.StatusRepository;


import java.util.List;


@RestController
@RequestMapping("/status")

public class StatusController {

    @Autowired
    StatusRepository statusRepository;

    @GetMapping("")
    public List<Status> getAll(){
        return statusRepository.getAll();
    }

    @GetMapping("/{id}")
    public Status getById(@PathVariable("id") int id){
        return statusRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Status> status){
        return statusRepository.save(status);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Status updatedStatus)
    {
        Status status = statusRepository.getById(id);
        if (status != null)
        {
            status.setTicketStatus(updatedStatus.getTicketStatus());

            statusRepository.update(status);
            return 1;
        }
        else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Status updatedStatus){
        Status status = statusRepository.getById(id);

        if (status != null){
            if (updatedStatus.getTicketStatus() != null) status.setTicketStatus(updatedStatus.getTicketStatus());

            statusRepository.update(status);
            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return statusRepository.delete(id);
    }
}
