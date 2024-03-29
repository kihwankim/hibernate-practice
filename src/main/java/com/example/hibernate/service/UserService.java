package com.example.hibernate.service;

import com.example.hibernate.domain.User;
import com.example.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackOn = RollbackException.class)
    public boolean save(User user) throws Exception {
        if (this.userRepository.save(user) == null) {
            throw new RollbackException();
        }

        return true;
    }

    @Transactional(rollbackOn = RollbackException.class)
    public User loadUserByUsername(String userName) throws RollbackException {
        Optional<User> user = this.userRepository.findByUserName(userName);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RollbackException();
    }
}
