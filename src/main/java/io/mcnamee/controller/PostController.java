package io.mcnamee.controller;

import io.mcnamee.domain.Post;
import io.mcnamee.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */
@Controller
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping("/")
	public String home(Model model) {

		List<Post> posts = postService.getNewPosts();

		model.addAttribute("miniPosts", posts);

		model.addAttribute("fullPosts", posts);

		return "index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String greetingSubmit2(@ModelAttribute Post post) {

		return "posts/create";
	}

	@PostMapping("/create")
	public String greetingSubmit(@ModelAttribute Post post) {

		postService.createPost(post);

		return "redirect:/";
	}

	@RequestMapping(value = "/posts/view/{id}", method = RequestMethod.GET)
	public String viewPost(@PathVariable("id") Long id, Model model) {

		Post post = postService.getPost(id);

		model.addAttribute("post", post);

		return "posts/index";
	}

}