package com.taotao.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ItemCat implements Serializable {
    @JsonProperty("u")
    private String u;
    @JsonProperty("n")
    private String n;
    @JsonProperty("i")
    private List<?> i;

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public List<?> getI() {
        return i;
    }

    public void setI(List<?> i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "ItemCat{" +
                "u='" + u + '\'' +
                ", n='" + n + '\'' +
                ", i=" + i +
                '}';
    }
}
