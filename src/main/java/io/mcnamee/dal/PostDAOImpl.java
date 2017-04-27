/**
 * 
 */
package io.mcnamee.dal;

import io.mcnamee.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Luke
 */
@Repository
public class PostDAOImpl implements PostDAO {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PostDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Post> getPostsInRange(Long id1, Long id2) {

		final String sql = "SELECT * FROM posts WHERE id BETWEEN VALUES(?, ?)";

		return jdbcTemplate.query(
				sql,
				new Object[]{ id1, id2 },
				new PostRowMapper()
		);
	}

	@Override
	public List<Post> getPostById(Long id) {

		final String sql = "SELECT * FROM posts WHERE id = ?";

		return jdbcTemplate.query(
				sql,
				new Object[]{ id },
				new PostRowMapper()
		);
	}

	@Override
	public List<Post> get5RecentPosts() {

		final String sql = "SELECT * FROM posts ORDER BY created DESC LIMIT 5";

		return jdbcTemplate.query(
				sql,
				new PostRowMapper()
		);
	}

	@Override
	public List<Post> getRecentPostsStartingWith(Long id) {

		final String sql = "SELECT * FROM posts ORDER BY created DESC LIMIT 5";

		return jdbcTemplate.query(
				sql,
				new PostRowMapper()
		);
	}


	@Override
	public List<Post> get20RecentPosts() {

		final String sql = "SELECT * FROM posts ORDER BY created DESC LIMIT 20";

		return jdbcTemplate.query(
				sql,
				new PostRowMapper()
		);
	}

	@Override
	public void createPost(Post post) {

		final String sql = "INSERT INTO posts (author, title, body) VALUES (?,?,?)";

		jdbcTemplate.update(
				sql,
				post.getAuthor(),
				post.getTitle(),
				post.getBody()
		);
	}
}
