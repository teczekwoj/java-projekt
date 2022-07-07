package com.example.demo.Controllers;

import com.example.demo.Responses.UserResponse;
import com.example.demo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class UsersService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    private void onCreate(){
        users.add(new User(1L, "Andrzej"));
        users.add(new User(2L, "Jacek"));
        }



    public UserResponse getUsersPage(Integer pageNumber, Integer pageSize){

        int pageOffset = (pageNumber -1) * pageSize;

        pageNumber = Math.max(1, pageNumber);
        pageSize = Math.min(100, pageSize);
        pageSize = Math.max(1, pageSize);

        Integer pageCount = 0;
        Integer totalCount = 0;

        List<User> users = Collections.emptyList();
        return new UserResponse(pageNumber, pageCount, pageSize, totalCount, users);
    }
}
