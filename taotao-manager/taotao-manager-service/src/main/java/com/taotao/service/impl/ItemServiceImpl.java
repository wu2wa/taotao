package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.LayuiResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;



    @Override
    public TbItem findTbItemById(Long itemId) {
        TbItem tbItem = itemMapper.findTbItemById(itemId);
        return tbItem;
    }

    @Override
    public LayuiResult findTbItemByPage(int page, int limit) {
        LayuiResult result = new LayuiResult();
        result.setMsg("");
        result.setCode(0);
        int count = itemMapper.findTbItemByCount();
        result.setCount(count);
        List<TbItem> itemList = itemMapper.findTbItemByPage((page-1)*limit,limit);
        result.setData(itemList);
        return result;
    }
}
