package com.example.demo.Responses;

import com.example.demo.User;
import java.util.List;

public class UserResponse {

    private Integer pageNumber;
    private Integer pagesCount;
    private Integer pageSize;
    private Integer totalCount;
    private List<User> users;

    public UserResponse(){

    }

    public UserResponse(Integer pageNumber, Integer pageCount, Integer pagesSize, Integer totalCount, List<User> users){
        this.pageNumber = pageNumber;
        this.pagesCount = pageCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.users = users;
    }

    public Integer getPageNumber(){
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber){
        this.pageNumber = pageNumber;
    }

    public Integer getPagesCount(){
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount){
        this.pagesCount = pagesCount;
    }

    public Integer getPageSize(){
        return pageSize;

    }
    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public Integer getTotalCount(){
        return totalCount;
    }

    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List <User> users){
        this.users = users;
    }
}
