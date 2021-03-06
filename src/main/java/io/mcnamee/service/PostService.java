package io.mcnamee.service;

import io.mcnamee.domain.Post;

import java.util.List;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/23/2017.
 */
public interface PostService {

    List<Post> getPostBoard(Long firstId);

    Post getPost(Long firstId);

    /**
     * not sure what you want for param
     *
     * @return  Get all messages which have not been opened
     */
    // will be implimented later upon need
    List<Post> getNewPosts();

    /**
     * This method adds the message to the sql table and should also create call upon the
     * hashMe to create the hash code for the string
     * @param post to add to the database
     */
    void createPost(Post post);
}
