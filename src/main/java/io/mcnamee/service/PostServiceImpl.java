package io.mcnamee.service;

import io.mcnamee.dal.DatabaseController;
import io.mcnamee.dal.PostDAO;
import io.mcnamee.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    private DatabaseController databaseController;

    @Autowired
    public PostServiceImpl(PostDAO postDAO, DatabaseController databaseController) {
        this.postDAO = postDAO;
        this.databaseController = databaseController;
    }

    @Override
    public List<Post> getPostBoard(Long firstId) {
        return postDAO.getPostById(firstId);
    }

    @Override
    public Post getPost(Long firstId) {

        Post returnMe = new Post();

        List<Post> posts = postDAO.getPostById(firstId);

        for (Post p : posts)
            if (Objects.equals(p.getId(), firstId))
                returnMe = p;

        return returnMe;
    }

    @Override
    public List<Post> getNewPosts() {
        return postDAO.getRecentPosts();
    }

    @Override
    public void createPost(Post post) {

        postDAO.createPost(post);

        databaseController.saveDataToScript();
    }
}
