package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.LayuiResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper TbItemMapper;


    @Override
    public TbItem findTbItemById(Long itemId) {
        TbItem tbItem = TbItemMapper.findTbItemById(itemId);
        return tbItem;
    }

    @Override
    public LayuiResult findTbItemByPage(int page, int limit) {
        LayuiResult result = new LayuiResult();
        result.setMsg("");
        result.setCode(0);
        int count = TbItemMapper.findTbItemByCount();
        result.setCount(count);
        List<TbItem> itemList = TbItemMapper.findTbItemByPage((page - 1) * limit, limit);
        result.setData(itemList);
        return result;
    }

    @Override
    public TaotaoResult updateItem(List<TbItem> tbItems, int type, Date date) {
        if (tbItems.size() <= 0) {
            return TaotaoResult.build(500, "先勾选，再操作", null);
        }
        List<Long> ids = new ArrayList<Long>();
        for (TbItem tbItem : tbItems) {
            ids.add(tbItem.getId());
        }
        int count = TbItemMapper.updateItemByIds(ids, type, date);
        if (count > 0 && type == 0) {
            return TaotaoResult.build(200, "商品下架成功", null);
        } else if (count > 0 && type == 1) {
            return TaotaoResult.build(200, "商品上架成功", null);
        } else if (count > 0 && type == 2) {
            return TaotaoResult.build(200, "商品删除成功", null);
        }
        return TaotaoResult.build(500,"商品删除失败",null);
    }

    @Override
    public LayuiResult findTbItemSearch(Integer page, Integer limit, String title, Integer priceMin, Integer priceMax, Long cId) {
        if (priceMin == null){
            priceMin = 0;
        }
        if (priceMax == null){
            priceMax = 100000;
        }

        LayuiResult result = new LayuiResult();
        result.setCode(0);
        result.setMsg("");
        int count = TbItemMapper.findTbItemSearch(page,limit,title,priceMin,priceMax,cId);
        result.setCount(count);
        List<TbItem> date = TbItemMapper.findTbItemByDate(page,limit,title,priceMin,priceMax,cId);
        result.setData(date);

        return result;
    }


}