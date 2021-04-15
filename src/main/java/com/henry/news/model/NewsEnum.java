package com.henry.news.model;

public enum NewsEnum {

    VIDEO("Video"),
    IMAGEN("Imagen"),
    TEXTO("Texto");

    private String descripcion;

    NewsEnum(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescription(){
        return descripcion;
    }

    public static NewsEnum find(String value){
        for(NewsEnum v: values()){
            if(v.toString().equalsIgnoreCase(value)){
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid NewsType: %s", value));

    }


}
