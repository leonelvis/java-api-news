package com.henry.news.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "newsImages")

public class NewsImage extends News{

    @ElementCollection
    private List<String> urlImage;

    @Override
    public NewsEnum newsEnum() {
        return NewsEnum.IMAGEN;
    }
}

