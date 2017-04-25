package io.mcnamee.dal;

import io.mcnamee.domain.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PostDAO {
	
	List<Post> getPostById(Long id);

	List<Post> getPostsInRange(Long id1, Long id2);

	List<Post> getRecentPosts();

	List<Post> getRecentPostsStartingWith(Long id);

		/**
         * creates a new post
         * @param post
         */
	void createMessage(Post post);

	class PostRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

			Post post = new Post();

			post.setId(rs.getLong("id"));
			post.setAuthor(rs.getString("author"));
			post.setTitle(rs.getString("title"));
			post.setBody(rs.getString("body"));

			return post;
		}
	}
}
