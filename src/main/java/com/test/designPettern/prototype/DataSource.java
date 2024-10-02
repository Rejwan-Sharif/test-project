package com.test.designPettern.prototype;


import lombok.Data;

@Data
public class DataSource implements Cloneable{


    private String url;
    private String username;
    private String password;

    @Override
    protected DataSource clone() throws CloneNotSupportedException{
       return (DataSource) super.clone();
    }

}
