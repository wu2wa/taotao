package com.taotao.service;

import com.taotao.pojo.LayuiResult;
import com.taotao.pojo.PictureResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

import java.util.Date;
import java.util.List;

public interface ItemService {
    TbItem findTbItemById(Long itemId);

    LayuiResult findTbItemByPage(int page,int limit);

    TaotaoResult updateItem(List<TbItem> tbItem, int type, Date date);


    LayuiResult findTbItemSearch(Integer page, Integer limit, String title, Integer priceMin, Integer priceMax, Long cId);

    PictureResult addPicture(String fileName, byte[] bytes);

    TaotaoResult addItem(TbItem tbItem, String itemDesc);
}
