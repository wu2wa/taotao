package com.taotao.controller;

import com.taotao.pojo.LayuiResult;
import com.taotao.pojo.PictureResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem findTbItemById(@PathVariable Long itemId) {
        //根据商品id查询商品信息
        TbItem result = itemService.findTbItemById(itemId);
        return result;
    }

    @RequestMapping("/showItemPage")
    @ResponseBody
    public LayuiResult findTbItemByPage(int page,int limit){
        LayuiResult result = itemService.findTbItemByPage(page,limit);
        return result;
    }

    @RequestMapping("/itemDelete")
    @ResponseBody
    public TaotaoResult itemDelete(@RequestBody List<TbItem> tbItem){
        Date date = new Date();
        TaotaoResult result = itemService.updateItem(tbItem,2,date);
        return result;
    }

    @RequestMapping("/commodityUpperShelves")
    @ResponseBody
    public TaotaoResult commodityUpperShelves(@RequestBody List<TbItem> tbItem){
        Date date = new Date();
        TaotaoResult result = itemService.updateItem(tbItem,1,date);
        return result;
    }




    @RequestMapping("/commodityShelves")
    @ResponseBody
    public TaotaoResult commodityLowerShelves(@RequestBody List<TbItem> tbItem){
        Date date = new Date();
        TaotaoResult result = itemService.updateItem(tbItem,0,date);
        return result;
    }
    @RequestMapping("/searchItem")
    @ResponseBody
    public LayuiResult getTbItem(Integer page, Integer limit, String title, Integer priceMin, Integer priceMax, Long cId){

        LayuiResult results = itemService.findTbItemSearch(page,limit,title,priceMin,priceMax,cId);

        return results;
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public PictureResult fileUpload(MultipartFile file){

        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            PictureResult result = itemService.addPicture(fileName,bytes);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/addItem")
    @ResponseBody
    public TaotaoResult addItem(TbItem tbItem,String itemDesc){
        TaotaoResult result = itemService.addItem(tbItem,itemDesc);
        return result;
    }


}