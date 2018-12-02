package com.maciejkry.redlit.redlits;

import com.mongodb.BasicDBObject;
import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    public String id;

    public String username;
    public String message;

    public Comment() {}

    public Comment(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
