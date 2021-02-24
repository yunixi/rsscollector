package com.yunixi.rsscollector.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/blog", produces = MediaType.APPLICATION_JSON_VALUE)
public class RssFeedController {

    @GetMapping("/naver")
    public ResponseEntity<String> getNaverRssFeed(@RequestParam("userid") String userid) {
        String url = "https://rss.blog.naver.com/" + userid;
        try {
            return ResponseEntity.ok(new String());
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
