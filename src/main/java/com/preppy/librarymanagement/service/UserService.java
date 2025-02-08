package com.preppy.librarymanagement.service;

import com.preppy.librarymanagement.entities.Book;
import com.preppy.librarymanagement.entities.User;
import com.preppy.librarymanagement.repository.BookRepository;
import com.preppy.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> getUsers(){
        List<User> users = findUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    private List<User> findUsers() {
        return userRepository.findAll();
    }
}
