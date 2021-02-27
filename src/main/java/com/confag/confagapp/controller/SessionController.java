package com.confag.confagapp.controller;

import com.confag.confagapp.model.Session;
import com.confag.confagapp.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {


    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }

    @GetMapping("/{session_id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getASession(@PathVariable long session_id){
        return sessionRepository.getOne(session_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody Session session){
        return sessionRepository.saveAndFlush(session);
    }


}
