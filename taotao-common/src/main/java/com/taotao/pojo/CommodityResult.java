package com.taotao.pojo;

import java.io.Serializable;
import java.util.List;

public class CommodityResult implements Serializable{
    private Long id;
    private String name;
    private Boolean isParent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }



    @Override
    public String toString() {
        return "CommodityResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isParent=" + isParent +
                '}';
    }
}
