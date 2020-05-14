package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.*;
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





    @Override
    public ItemCatResult getItemCats() {

        ItemCatResult result = new ItemCatResult();
        result.setData(getItemCatList(0L));
        System.out.println(result.getData());
        return result;
    }





    private List<?> getItemCatList(Long parentId){
        List<TbItemCat> list = tbItemCatMapper.findCommodityByAll(parentId);
        List data = new  ArrayList();
        int count = 0;
        for (TbItemCat item:list){
            ItemCat itemCat = new ItemCat();
            if (item.getIsParent()){
                itemCat.setU("/products/"+item.getId()+".html");
                if (parentId == 0){
                    itemCat.setN("<a href='/products/"+item.getId()+".html'>"+item.getName()+"</a>");
                }else {
                    itemCat.setN(item.getName());
                }
                count++;
                itemCat.setI(getItemCatList(item.getId()));

                data.add(itemCat);

                if (parentId == 0 && count >= 14) {
                    break;
                }

            }else {
                data.add("/products/"+item.getId()+".html|"+item.getName());
            }
        }
        return data;
    }

}
