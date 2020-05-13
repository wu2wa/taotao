package com.taotao.mapper;


import com.taotao.pojo.Data;
import com.taotao.pojo.ParamKeys;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemParamMapper {

    @Select("SELECT * FROM tbitemparamgroup WHERE itemCatId = #{cId}")
    List<Data> getTbItemParamGroup(Integer cId);

    @Select("SELECT * FROM tbitemparamkey where groupId = #{id}")
    List<ParamKeys> findTbItemParamKey(int id);
}