package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long id;


    private String name;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;



    @ManyToOne(targetEntity = Playlist.class,cascade =CascadeType.ALL)
    @JoinColumn(name = "user_id",
            nullable = true)
    @JsonIgnoreProperties("user")
    private User user;

    @OneToMany(mappedBy = "playlist",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("playlist")
    private List <AddSong> songs = new ArrayList<>();



    public Playlist() {
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<AddSong> getSongs() {
        return songs;
    }

    public void setSongs(List<AddSong> songs) {
        this.songs = songs;
    }
}
