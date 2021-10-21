package com.example.musicdownloader.model;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Song {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private final long id;

    private String name;

    private String genre;

    private String artist;

    private String downloadDate;

    private String songAddress;

    @ContentId
    private UUID contentId;

    @ContentLength
    private Long contnetLength;

    @MimeType
    private String mimeType;

    public interface SongRepository extends CrudRepository<Song, Long> {}


    public interface SongStore extends ContentStore<Song, UUID>{}

    public Song(long id) {
        this.id = id;
    }

    public Song(long id, String name, String genre, String artist, String downloadDate) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.downloadDate = downloadDate;
    }

    public String getSongAddress() {
        return songAddress;
    }

    public void setSongAddress(String songAddress) {
        this.songAddress = songAddress;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public UUID getContentId() {
        return contentId;
    }

    public void setContentId(UUID contentId) {
        this.contentId = contentId;
    }

    public Long getContnetLength() {
        return contnetLength;
    }

    public void setContnetLength(Long contnetLength) {
        this.contnetLength = contnetLength;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
