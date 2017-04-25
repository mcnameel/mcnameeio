package io.mcnamee.controller;

import io.mcnamee.domain.Post;
import io.mcnamee.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Controller handles messageCalls in html
 * Created by Andre Ellis on 04/06/2017
 */
@Controller
public class PostController {

	@Autowired
	private PostService postService;

	/*
	 *this method will handle call in messages.html and give an array of all messages
	 */
	@RequestMapping(value = "/intersections/templates.posts")
	public String posts(Model model) {

		model.addAttribute("templates/posts", postService.getNewPosts()); //find a way to get usernameService

		return "templates/posts";
	}

	@RequestMapping("/")
	public String home(Model model) {

		List<Post> latest5Posts = postService.getNewPosts();
		model.addAttribute("latest5posts", latest5Posts);

		List<Post> latest3Posts = latest5Posts.stream()
				.limit(3).collect(toList());
		model.addAttribute("latest3posts", latest3Posts);

		return "index";
	}

	@RequestMapping("/templates/posts/{id}")
	public String view(@PathVariable("id") Long id, Model model) {

		Post post = postService.getPost(id);

		model.addAttribute("post", post);

		return "posts/view";
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


	@RequestMapping("/posts/view/{id}")
	public String viewPost(@PathVariable("id") Long id, Model model) {
		Post post = postService.getPost(id);


		model.addAttribute("post", post);
		return "/posts/index";
	}

}