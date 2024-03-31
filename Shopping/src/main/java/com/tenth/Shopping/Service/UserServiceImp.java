package com.tenth.Shopping.Service;

import com.tenth.Shopping.Entity.UserDetails;
import com.tenth.Shopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDetails> fetchUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails findById(int userId){
        return userRepository.findById(userId).get();
    }

    @Override
    public void save(UserDetails u2) {
        userRepository.save(u2);
    }

}
