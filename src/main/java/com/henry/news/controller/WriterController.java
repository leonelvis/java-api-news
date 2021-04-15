package com.henry.news.controller;

import com.henry.news.model.Writer;
import com.henry.news.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer")

public class WriterController {
    @Autowired
    private WriterService writerService;

    @PostMapping
    @Operation(summary = "Guardar un Escritor")
    public void addWriter(@RequestBody Writer writer){
        writerService.addWriter(writer);
    }

    @GetMapping
    @Operation(summary = "Busca los escritores")
    public List<Writer> getWriter(){
       return writerService.getWriter();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca Escritor por Id")
    public Writer getWriterById(@PathVariable Integer id){
        return writerService.getWriterById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Escritor por Id")
    public String deleteWriterById(@PathVariable Integer id){
         writerService.deleteWriterById(id);
         return ("Escritor borrado");
    }

}
