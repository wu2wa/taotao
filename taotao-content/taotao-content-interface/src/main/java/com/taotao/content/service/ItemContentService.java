package com.taotao.content.service;

import com.taotao.pojo.Ad1Node;
import com.taotao.pojo.CommodityResult;
import com.taotao.pojo.LayuiResult;
import com.taotao.pojo.TbContent;

import java.util.List;

public interface ItemContentService {
    List<CommodityResult> findCommodityByAll(Long id);

    LayuiResult findContentByCategoryId(Long categoryId, Integer page, Integer limit);

    LayuiResult deleteContentByCategoryId(List<TbContent> tbContents, Integer page, Integer limit);

    /**
     * 新添加一个内容信息
     * @param tbContent 需要添加的内容对象
     * @param page  当前页
     * @param limit 每一页显示条数
     * @return
     */
    LayuiResult addContent(TbContent tbContent, Integer page, Integer limit);


    List<Ad1Node> showAd1Node();
}
