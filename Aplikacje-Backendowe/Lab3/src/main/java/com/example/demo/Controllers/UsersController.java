package com.example.demo.Controllers;

import com.example.demo.Responses.UserResponse;
import com.example.demo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.Map;

@Controller
public class UsersController {

    List<User> users = new ArrayList<>();

    @PostConstruct
    private void onCreate(){
        users.add(new User(1L, "Andrzej"));
        users.add(new User(2L, "Jacek"));
    }

    //http://localhost:8080/api/users?page-number=1&page-size=20
    @RequestMapping(
        value = "api/users",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Object getUsers(
        @RequestParam(value = "page-number", defaultValue = "1") Integer pageNumber,
        @RequestParam(value = "page-size", defaultValue = "20") Integer pageSize
        )
    {
        pageNumber = Math.max(1, pageNumber);
        pageSize = Math.min(100, pageSize);
        pageSize = Math.max(1, pageSize);

        Integer pagesCount = 0;
        Integer totalCount = 0;


        return new UserResponse(pageNumber, pagesCount, pageSize, totalCount, users);
    }

    @RequestMapping( value = "api/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseBody
    public User GetUserById(
            @PathVariable Long id
    ) {
        return new users.get(id);
    }




}

