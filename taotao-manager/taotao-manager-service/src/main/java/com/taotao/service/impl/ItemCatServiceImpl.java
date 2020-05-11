package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.CommodityResult;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<CommodityResult> findCommodityByAll(Long id) {
        List<CommodityResult> results = new ArrayList<CommodityResult>();
        List<TbItemCat> list = tbItemCatMapper.findCommodityByAll(id);
        for (TbItemCat commodityResult:list){
            CommodityResult result = new CommodityResult();
            result.setId(commodityResult.getId());
            result.setName(commodityResult.getName());
            result.setIsParent(commodityResult.getIsParent());
            results.add(result);
        }




        return results;
    }
}
