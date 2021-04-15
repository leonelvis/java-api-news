package com.henry.news.service;

import com.henry.news.model.News;
import com.henry.news.model.Writer;
import com.henry.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private WriterService writerService;

    public void addNews(News news){
        newsRepository.save(news);
    }
    public List<News> getAllNews(){
        return newsRepository.findAll();
    }
    public News getNewsById(Integer id){
        return newsRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
    public void putWriter(Integer id, Integer idWriter){
       News news = getNewsById(id);
        Writer writer = writerService.getWriterById(idWriter);
        news.setOwner(writer);
        newsRepository.save(news);

    }
    public void deleteWriteByid(Integer id) {
        newsRepository.deleteById(id);
    }
}
