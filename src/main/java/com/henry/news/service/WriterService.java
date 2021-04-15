package com.henry.news.service;

import com.henry.news.model.Writer;
import com.henry.news.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class WriterService {
    @Autowired
    private WriterRepository writerRepository;

    public void addWriter(Writer writer) {
        writerRepository.save(writer);
    }

    public List<Writer> getWriter() {
        return writerRepository.findAll();
    }
    public Writer getWriterById(Integer id){
        return writerRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
    public void deleteWriterById(Integer id){
        writerRepository.deleteById(id);
    }
}
