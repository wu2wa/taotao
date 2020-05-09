package com.taotao.mapper;


import com.taotao.pojo.TbItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface TbItemMapper {


    @Select("SELECT * FROM tbitem WHERE id = #{id}")
    TbItem findTbItemById(Long itemId);
    @Select("SELECT count(*) from tbitem")
    int findTbItemByCount();
    @Select("SELECT * from tbitem limit #{page},#{limit}")
    List<TbItem> findTbItemByPage(@Param("page") int page,@Param("limit") int limit);

    int updateItemByIds(@Param("ids") List<Long> ids,@Param("type") int type,@Param("date") Date date);
}