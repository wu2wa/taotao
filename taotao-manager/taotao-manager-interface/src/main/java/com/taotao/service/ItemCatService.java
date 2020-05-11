package com.taotao.service;

import com.taotao.pojo.CommodityResult;
import com.taotao.pojo.LayuiResult;
import com.taotao.pojo.TbItemCat;

import java.util.List;

public interface ItemCatService {
    List<CommodityResult> findCommodityByAll(Long id);

}
