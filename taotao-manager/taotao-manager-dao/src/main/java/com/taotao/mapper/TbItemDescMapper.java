package com.taotao.mapper;



import com.taotao.pojo.TbItemDesc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbItemDescMapper {
    @Insert("INSERT INTO tbitemdesc(itemId,itemDesc,created,updated) value(#{tbItemDesc.itemId},#{tbItemDesc.itemDesc},#{tbItemDesc.created},#{tbItemDesc.updated})")
    int addItemDesc(@Param("tbItemDesc") TbItemDesc tbItemDesc);
}