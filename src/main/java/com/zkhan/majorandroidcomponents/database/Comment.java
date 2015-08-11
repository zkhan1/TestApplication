package com.zkhan.majorandroidcomponents.database;

/**
 * Created by Zeeshan Khan on 8/01/2015.
 * This class is a model and contains the data I will save in the database and show in
 * the user interface
 */
public class Comment {
    private long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return comment;
    }
}
