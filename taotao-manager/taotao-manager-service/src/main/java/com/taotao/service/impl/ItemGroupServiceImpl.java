package com.taotao.service.impl;

import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.Data;
import com.taotao.pojo.ParamGroupResult;
import com.taotao.pojo.ParamKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemGroupServiceImpl implements com.taotao.service.ItemGroupService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public ParamGroupResult getItemGroup(Integer cId) {
        List<Data> data = tbItemParamMapper.getTbItemParamGroup(cId);
        for (Data data1:data) {
                List<ParamKeys> paramKeys1 = tbItemParamMapper.findTbItemParamKey(data1.getId());
                data1.setParamKeys(paramKeys1);

        }

        ParamGroupResult result = new ParamGroupResult();
        result.setMsg("");
        result.setStatus(200);
        result.setData(data);


        return result;
    }
}
