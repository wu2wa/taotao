package com.taotao.controller;

import com.taotao.pojo.ParamGroupResult;
import com.taotao.service.ItemGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/itemGroup")
public class ItemGroupController {
    @Autowired
    private ItemGroupService itemGroupService;
    @RequestMapping("/showItemGroup")
    @ResponseBody
    public ParamGroupResult showItemGroup(Integer cId){
        ParamGroupResult result = itemGroupService.getItemGroup(cId);
        return result;
    }




}
