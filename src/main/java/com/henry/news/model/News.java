package com.henry.news.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "newsEnum")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewsImage.class, name = "IMAGEN"),
        @JsonSubTypes.Type(value = NewsVideo.class,  name = "VIDEO")
})
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id")
    private Writer owner;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract NewsEnum newsEnum();
}
