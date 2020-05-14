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
        ParamGroupResult result = new ParamGroupResult();
        List<Data> data = tbItemParamMapper.getTbItemParamGroup(cId);
        if(data.size()<=0){
            result.setStatus(500);
        }else if (data.size()>0){
            result.setStatus(200);
        }
        for (Data data1:data) {
                List<ParamKeys> paramKeys1 = tbItemParamMapper.findTbItemParamKey(data1.getId());
                data1.setParamKeys(paramKeys1);
        }
        result.setMsg("");

        result.setStatus(200);
        result.setData(data);


        return result;
    }
}
