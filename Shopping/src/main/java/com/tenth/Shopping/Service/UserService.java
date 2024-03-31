package com.tenth.Shopping.Service;


import com.tenth.Shopping.Entity.UserDetails;
import com.tenth.Shopping.Repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {



    public List<UserDetails> fetchUsers();
    public UserDetails findById(int userId);

    void save(UserDetails u2);
}
