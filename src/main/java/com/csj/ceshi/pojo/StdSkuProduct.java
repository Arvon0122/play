package com.csj.ceshi.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="standard_sku_product")
@Data
public class StdSkuProduct {
   @Id
   private String id;
   /**
    * sku商品编码
    */
   private String productNo;
   /**
    * 标准商品编码
    */
   private String stdProductNo;
   /**
    * sku图片-pictureUrl
    */
   private String pictureUrl;
   /**
    * 西域sku-skuCode
    */
   private String skuCode;
   /**
    * 型号-mfgSku
    */
   private String size;
   /**
    * 规格属性名称
    */
   private String ruleName;
   /**
    * 销售价-salePrice
    */
   private String salePrice;
   /**
    * 库存
    */
   private String stock;
   /**
    * 参考价
    */
   private String referencePrice ;
   /**
    * 条形码
    */
   private String barCode;
   /**
    * 商品货号
    */
   private String goodsNo;
   /**
    * 商品标题-productName
    */
   private String skuTitle;
   /**
    * 商品是否可用
    */
   /**
    * 级分类-categoryIds
    */
   private String lv1CategoryNo;
   private String lv2CategoryNo;
   private String lv3CategoryNo;
   private String lv1CategoryName;
   private String lv2CategoryName;
   private String lv3CategoryName;
   private String brandName;
   private String brandId;
   private String minUnit;
   private String productInfo;//上品详情  html
   private String isUsed;
   /**
    *     "packJson":[
    *         {
    *             "packKey" : "weight",
    *             "packValue" : "重量(kg)"
    *         },
    *         {
    *             "packKey" : "height",
    *             "packValue" : "高度(mm)"
    *         },
    *         {
    *             "packKey" : "width",
    *             "packValue" : "宽度(mm)"
    *         },
    *         {
    *             "packKey" : "length",
    *             "packValue" : "长度(mm)"
    *         }
    *     ]
    */
   private JSONArray packJson;
   /**
    *      "basicAttr" : [
    *         {
    *              "id":"id",
    *             "basicKey" : "基础属性key-specParam[].paramName",
    *             "basicValue" : "基础属性value-specParam[].paramValue"
    *         }
    *     ]
    */
   private JSONArray basicAttr;
   /**
    * [
    *       {
    *        "id":"",
    *       "saleKey":"销售属性key-attrGroup[].attrName",
    *       "saleValue":"销售属性value-attrGroup[].attrValue"
    *       }
    *     ]
    */
   private JSONArray saleAttr;
   /**
    * [
    *       {
    *       "levelName":"客户等级",
    *       "salePrice":"销售价格（元）"
    *       }
    *     ]
    */
   private JSONArray saleStrategy;
   /**
    * {num:**,unit:箱}
    */
   private JSONObject unitConvert;
   //其他相同型号的商品
   private List<StdSkuProduct> stdSkuProducts =new ArrayList<>();

}
