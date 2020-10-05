package com.example.springboot_aws_oauth2.web;

import com.example.springboot_aws_oauth2.config.auth.LoginUser;
import com.example.springboot_aws_oauth2.config.auth.dto.SessionUser;
import com.example.springboot_aws_oauth2.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index (Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        if(user != null){
            model.addAttribute("username", user.getName());
        }
        return "index";
    }
}
