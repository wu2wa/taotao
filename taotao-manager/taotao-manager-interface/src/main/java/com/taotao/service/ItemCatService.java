package com.taotao.service;

import com.taotao.pojo.*;

import java.util.List;

public interface ItemCatService {
    List<CommodityResult> findCommodityByAll(Long id);


    ItemCatResult getItemCats();
}
