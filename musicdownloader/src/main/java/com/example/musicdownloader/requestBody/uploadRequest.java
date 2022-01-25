package com.example.musicdownloader.requestBody;

public class uploadRequest {
    private String title;
    private String address;

    public uploadRequest() {
    }

    public uploadRequest(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
