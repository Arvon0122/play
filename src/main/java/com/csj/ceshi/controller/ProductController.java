package com.csj.ceshi.controller;

import com.csj.ceshi.dao.StdSkuProductDao;
import com.csj.ceshi.pojo.StdSkuProduct;
import com.csj.ceshi.utils.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "商品controller",tags = {"商品中心接口"})
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private StdSkuProductDao stdSkuProductDao;
    @RequestMapping(value = "/queryProductPageList",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页码",defaultValue = "1",dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize",value = "分页大小",defaultValue = "20",dataType = "Integer")
    })
    public Page<StdSkuProduct> queryProductPageList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                    @RequestParam(required = false,defaultValue = "20") Integer pageSize,
                                                    @RequestParam(required = false) String stdProductNo){
        Map<String,Object> parames=new HashMap<>();
        if(StringUtils.isNotBlank(stdProductNo)){
            parames.put("stdProductNo",stdProductNo);
        }
        Page<StdSkuProduct> spupage =stdSkuProductDao.findPage(pageNum,pageSize,parames);
        return spupage;
    }

}
