package com.confag.confagapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    //TODO: speaker_photo - a binary type data


    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;




}
