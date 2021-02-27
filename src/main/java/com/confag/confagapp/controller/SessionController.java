package com.confag.confagapp.controller;

import com.confag.confagapp.model.Session;
import com.confag.confagapp.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
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


    @RequestMapping(value = "/{session_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long session_id){
        //TODO: delete children records as well
         sessionRepository.deleteById(session_id);
    }

    @RequestMapping(value = "/{session_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Session update(@PathVariable long session_id, @RequestBody Session session) {
        //TODO: Add validation to check non of the values in the request body is null and if null throw  400 bad request to the client
        Session sessionFromDB = sessionRepository.getOne(session_id);
        BeanUtils.copyProperties(session, sessionFromDB, "session_id");
        return sessionRepository.saveAndFlush(sessionFromDB);
    }




}
