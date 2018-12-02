package com.maciejkry.redlit.redlits;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RedlitsServiceImpl implements RedlitsService {

    private MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://maciejkry:aP57KZgxuFnOosMBFLTzEELC7f9NhdgvUu1y48bamj00zcTeVYBXSx4tQWYpxvT1vLdmglxSeQ4qfOAdBIcpng==@maciejkry.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));

    @Override
    public ArrayList<String> getThreads() {
        ArrayList threads = new ArrayList();
        Iterable ti = mongo.listDatabaseNames();
        ((MongoIterable) ti).into(threads);
        return threads;
    }

    @Override
    public ArrayList<String> getPostsByThread(String threadID) {
        ArrayList posts = new ArrayList();
        Iterable pi = mongo.getDatabase(threadID).listCollectionNames();
        ((MongoIterable) pi).into(posts);
        return posts;
    }

    @Override
    public ArrayList<Comment> getComments(String threadID, String postID) {
        ArrayList comments = new ArrayList();
        Iterable di = mongo.getDatabase(threadID).getCollection(postID).find();
        ((FindIterable) di).into(comments);
        return comments;
    }

    @Override
    public void addComment(String threadID, String postID, Comment comment) {
        Document doc = new Document();
        doc.append("id", comment.id);
        doc.append("username", comment.username);
        doc.append("message", comment.message);
        mongo.getDatabase(threadID).getCollection(postID).insertOne(doc);
    }
}
