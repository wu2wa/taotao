package com.taotao.controller;

        import com.taotao.pojo.CommodityResult;
        import com.taotao.pojo.LayuiResult;
        import com.taotao.pojo.TbItem;
        import com.taotao.service.ItemCatService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.List;

@Controller
@RequestMapping("/itemCat")
public class CommodityController {
    @Autowired
    private ItemCatService itemCatService;



    @RequestMapping("/showZtree")
    @ResponseBody
    public List<CommodityResult> showZtree(@RequestParam(value = "id",defaultValue = "0") Long id){
        List<CommodityResult> results = itemCatService.findCommodityByAll(id);
        return results;
    }



}
