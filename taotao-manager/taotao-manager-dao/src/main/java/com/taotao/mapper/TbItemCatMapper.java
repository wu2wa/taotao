package com.taotao.mapper;


import com.taotao.pojo.CommodityResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemCatMapper {
    @Select("SELECT * FROM tbitemcat where parentId = #{id}")
    List<TbItemCat> findCommodityByAll(@Param("id") Long id);


}