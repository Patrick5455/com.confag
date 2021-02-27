package com.confag.confagapp.controller;

import com.confag.confagapp.model.Speaker;
import com.confag.confagapp.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker post(@RequestBody Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Speaker> getAllSpeakers(){
        return speakerRepository.findAll();
    }

    @GetMapping("/{speaker_id}")
    @ResponseStatus(HttpStatus.OK)
    public Speaker getASpeaker(@PathVariable long speaker_id){
        return speakerRepository.getOne(speaker_id);
    }

    @RequestMapping(value = "/{speaker_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker update(@PathVariable long speaker_id, @RequestBody Speaker speaker) {
        //TODO: Add validation to check non of the values in the request body is null and if null throw  400 bad request to the client
        Speaker speakerFromDB = speakerRepository.getOne(speaker_id);
        BeanUtils.copyProperties(speaker, speakerFromDB);
        return speakerRepository.saveAndFlush(speakerFromDB);
    }



}
