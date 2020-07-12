package com.tl.service.domain;


import java.io.Serializable;
import java.util.List;

/**
 * 商品表
 */
public class Goods  implements Serializable {

  private static final long serialVersionUID = -939578640083323583L;

  private Integer id;
  private String goodsName;
  private String goodsSno;
  private String description;
  private String unit;
  private Integer isSale;
  private String goodsImage;
  private Double price;
  private Double oldPrice;

  private List<GoodsSpecs> details;


  public List<GoodsSpecs> getDetails() {
    return details;
  }

  public void setDetails(List<GoodsSpecs> details) {
    this.details = details;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getOldPrice() {
    return oldPrice;
  }

  public void setOldPrice(Double oldPrice) {
    this.oldPrice = oldPrice;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public String getGoodsSno() {
    return goodsSno;
  }

  public void setGoodsSno(String goodsSno) {
    this.goodsSno = goodsSno;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  public Integer getIsSale() {
    return isSale;
  }

  public void setIsSale(Integer isSale) {
    this.isSale = isSale;
  }


  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }

}
