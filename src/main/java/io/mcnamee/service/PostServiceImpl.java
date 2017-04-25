package io.mcnamee.service;

import io.mcnamee.dal.PostDAO;
import io.mcnamee.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService {

    @Autowired
    PostDAO postDAO;

    @Override
    public List<Post> getPostBoard(Long firstId) {
        return postDAO.getPostById(firstId);
    }

    @Override
    public Post getPost(Long firstId) {

        Post returnMe = new Post();

        List<Post> posts = postDAO.getPostById(firstId);

        for (Post p : posts)
            if (p.getId() == firstId)
                returnMe = p;

        return returnMe;
    }

    @Override
    public List<Post> getNewPosts() {
        return postDAO.getRecentPosts();
    }

    @Override
    public void createPost(String from, String to, String body, String subject) {

    }

    @Override
    public void createPost(Post post) {

        postDAO.createMessage(post);
    }
}
