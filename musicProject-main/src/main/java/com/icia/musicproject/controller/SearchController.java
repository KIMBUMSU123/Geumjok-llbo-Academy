package com.icia.musicproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search")
public class SearchController {
    @GetMapping("/search")
    public String searchForm(){
        return "search/search";
    }

}
