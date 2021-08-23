package com.example.classschedule.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) { this.repository = repository;}

    public List<User> findAll(){
        return repository.findAll();
    }

    public User add(User user){
        return repository.save(user);
    }

    public User update(User user){
        return repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }

    public User findById(User user){
        repository.findById(user.getId());
        return repository.save(user);
    }

    public boolean findExistUser(String username, String password){
        Optional<User> userOptional = repository.findUserAndPassword(username, password);
        if (userOptional.isPresent()){
            return true;
        } else {
            return false;
        }
    }

}
