package com.tl.service.domain;


import java.io.Serializable;

/**
 * 商品详情表
 */
public class GoodsSpecs  implements Serializable {

  private static final long serialVersionUID = 5604321033837147931L;
  private Integer goodsId;
  private String specification;
  private Integer price;
  private Integer stock;
  private Integer id;
  private String image;


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }


  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }


  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
