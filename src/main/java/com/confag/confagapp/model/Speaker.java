package com.confag.confagapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity(name = "speakers")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}) // handles the error from ByteBuddyInterceptor
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
    @Lob // LARGE OBJECT
    @Type(type = "org.hibernate.type.BinaryType" )
    private byte[] speaker_photo;


    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JsonIgnore //to avoid cyclic serialization
    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;




}
