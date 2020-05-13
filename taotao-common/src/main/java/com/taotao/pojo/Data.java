package com.taotao.pojo;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable{
    private int id;
    private String groupName;
    private int itemCatId;
    private List<ParamKeys> paramKeys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(int itemCatId) {
        this.itemCatId = itemCatId;
    }

    public List<ParamKeys> getParamKeys() {
        return paramKeys;
    }

    public void setParamKeys(List<ParamKeys> paramKeys) {
        this.paramKeys = paramKeys;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", itemCatId=" + itemCatId +
                ", paramKeys=" + paramKeys +
                '}';
    }
}
