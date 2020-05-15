package com.taotao.mapper;


import com.taotao.pojo.TbContent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbContentMapper {
    @Select("SELECT COUNT(*) FROM tbcontent WHERE categoryId = #{categoryId}")
    int findContentByCount(Long categoryId);
    @Select("SELECT * FROM tbcontent WHERE categoryId = #{categoryId} limit #{page},#{limit}")
    List<TbContent> findContentByPage(@Param("categoryId") Long categoryId, @Param("page") Integer page, @Param("limit") Integer limit);

    int deleteContentByCategoryId(@Param("tbContents") List<TbContent> tbContents);
    @Insert("INSERT INTO tbcontent(categoryId, title, subTitle, titleDesc, url, pic, pic2, content, created, updated) VALUE (#{categoryId},#{title},#{subTitle},#{titleDesc},#{url},#{pic},#{pic2},#{content},#{created},#{updated})")
    int addContent(TbContent tbContent);
}