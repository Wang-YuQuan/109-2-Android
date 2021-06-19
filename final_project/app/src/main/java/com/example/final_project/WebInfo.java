package com.example.final_project;

public class WebInfo {
    private String title,info,datetime,url;

    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     */
    public WebInfo(String title, String info, String datetime, String url) {
        this.title = title;
        this.info = info;
        this.datetime = datetime;
        this.url = url;
    }

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }
    String getDatetime() {
        return datetime;
    }
    String getUrl() {
        return url;
    }
}
