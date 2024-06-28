package com.example.hhhack.controller;


import com.example.hhhack.entity.Article;
import com.example.hhhack.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Optional<Article> article = articleService.findById(id);
        return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.save(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        Optional<Article> article = articleService.findById(id);
        if (article.isPresent()) {
            Article updatedArticle = article.get();
            updatedArticle.setUserId(articleDetails.getUserId());
            updatedArticle.setCategoryId(articleDetails.getCategoryId());
            updatedArticle.setTitle(articleDetails.getTitle());
            updatedArticle.setBody(articleDetails.getBody());
            updatedArticle.setStatus(articleDetails.getStatus());
            updatedArticle.setArticlePrice(articleDetails.getArticlePrice());
            articleService.save(updatedArticle);
            return ResponseEntity.ok(updatedArticle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        Optional<Article> article = articleService.findById(id);
        if (article.isPresent()) {
            articleService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}