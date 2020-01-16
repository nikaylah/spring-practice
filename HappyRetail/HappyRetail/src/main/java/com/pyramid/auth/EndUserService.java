package com.pyramid.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EndUserService {
    @Autowired
    EndUserRepository eur;

    public void addUser(EndUser user){
        eur.save(user);
    }

    public List<EndUser> getUserDetails(){
        List<EndUser> userList = new ArrayList<>();
        eur.findAll().forEach(userList::add);
        return userList;
    }
}
