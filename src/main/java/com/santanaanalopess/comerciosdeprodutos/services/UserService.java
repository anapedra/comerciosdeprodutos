package com.santanaanalopess.comerciosdeprodutos.services;

import com.santanaanalopess.comerciosdeprodutos.model.User;
import com.santanaanalopess.comerciosdeprodutos.repositorys.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public User findById(Long id){
        Optional<User>user=userRepository.findById(id);
        return user.get();
    }
    public List<User> fimdAll(){
        List<User>users=userRepository.findAll();
        return users;
    }
    @Transactional
    public User atualizarUser(Long id,User user){
        user.setId(id);
        return user;
    }
    @Transactional
    public void daletUser(Long id){
        userRepository.deleteById(id);
    }
}
