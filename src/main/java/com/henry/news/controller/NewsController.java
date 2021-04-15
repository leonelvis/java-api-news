package com.henry.news.controller;

import com.henry.news.model.News;
import com.henry.news.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    public NewsService newsService;

    @PostMapping
    @Operation(summary = "Agregar Noticia")
    public void addNews(@RequestBody News news){
        newsService.addNews(news);
    }

    @GetMapping
    @Operation(summary = "Buscar Todas las noticias")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar noticias por id")
    public News getNewsById(@PathVariable Integer id){
        return newsService.getNewsById(id);
    }

    @PutMapping("/{id}/writer/{idWriter}")
    @Operation(summary = "Cambiar el escritor en la noticia")
        private String addWriter(@PathVariable Integer id, @PathVariable Integer idWriter) {
            newsService.putWriter(id, idWriter);
            return ("Se ha modificado el escritor");
        }
    @DeleteMapping("/{id}")
    @Operation(summary = "Borra noticia por id")
    public String deleteNoticia(@PathVariable Integer id){
        newsService.deleteWriteByid(id);
        return ("Noticia Borrada");
    }

}
