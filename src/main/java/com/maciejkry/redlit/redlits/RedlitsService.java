package com.maciejkry.redlit.redlits;

import java.util.ArrayList;

public interface RedlitsService {
    ArrayList<String> getThreads();
    ArrayList<String> getPostsByThread(String threadID);
    ArrayList<Comment> getComments(String threadID, String postID);
    void addComment(String threadID, String postID, Comment comment);
}
