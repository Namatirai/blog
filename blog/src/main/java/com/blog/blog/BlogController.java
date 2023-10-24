package com.blog.blog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {

    private  final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @GetMapping("/blogs")
    public  String getBlogs(Model model){
        List<Blog> blogs = blogRepository.findAll();
        model.addAttribute("blogs",blogs);
        return "blogs";
    }

    @GetMapping("/addblog")
    public String getBlogForm(Model model){
        model.addAttribute("newBlog",new Blog());
        return "addblog";
    }

    @PostMapping("/addblog")
    public String saveblog(@ModelAttribute("newBlog") Blog blog){
        blogRepository.save(blog);
        return "redirect:/blogs";

    }
}
