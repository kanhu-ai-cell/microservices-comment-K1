package com.microservice.comment.controller;

import com.microservice.comment.entity.Comment;
import com.microservice.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/save")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        Comment comment1 = service.saveComment(comment);
        return new ResponseEntity<>(comment1, HttpStatus.OK);
    }

    @GetMapping ("/list/{postId}")
    public List<Comment> saveComment(@PathVariable String postId){
        List<Comment> listByPostId = service.getCommentListByPostId(postId);
        return listByPostId;
    }
}
