package com.icia.musicproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/display")

public class DisplayController {

    @GetMapping("/songList")
    public String SongList(){
        return "display/songList";
    }

    @GetMapping("/playList")
    public String PlayList(){
        return "display/playList";
    }
}