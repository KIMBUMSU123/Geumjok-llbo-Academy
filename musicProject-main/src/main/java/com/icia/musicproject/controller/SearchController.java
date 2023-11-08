package com.icia.musicproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search")
public class SearchController {
    @GetMapping("/search")
    public String searchForm(@RequestParam("q") String q, Model model){
        model.addAttribute("q", q);
        return "/search/search";
    }

    @GetMapping("/search_test")
    public String search_testForm(@RequestParam("q") String q, Model model){
        model.addAttribute("q", q);
        return "/search/search_test";
    }

}
