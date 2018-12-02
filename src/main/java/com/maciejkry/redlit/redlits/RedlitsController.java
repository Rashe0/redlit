package com.maciejkry.redlit.redlits;

import com.maciejkry.redlit.users.User;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/r")
public class RedlitsController {

    @Autowired
    RedlitsService service;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList listThreads() {
        return service.getThreads();
    }

    @RequestMapping(value = "/{threadID}", method = RequestMethod.GET)
    public ArrayList listPosts(@PathVariable(name = "threadID") String threadID) {
        return service.getPostsByThread(threadID);
    }

    @RequestMapping(value = "/{threadID}/{postID}", method = RequestMethod.GET)
    public ArrayList<Comment> showComments(@PathVariable(name = "threadID") String threadID,
                                        @PathVariable(name = "postID") String postID) {
        return service.getComments(threadID, postID);
    }

    @RequestMapping(value = "/{threadID}/{postID}", method = RequestMethod.POST)
    public ResponseEntity publishComment(@PathVariable(name = "threadID") String threadID,
                                         @PathVariable(name = "postID") String postID,
                                         @RequestBody Comment comment) {
        service.addComment(threadID, postID, comment);
        return new ResponseEntity(HttpStatus.OK);
    }

}
