package com.henry.news.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "NewsVideo")

public class NewsVideo extends News {

    private String titleVideo;
    private String urlVideo;

    @Override
    public NewsEnum newsEnum(){
        return NewsEnum.VIDEO;
    }
}
