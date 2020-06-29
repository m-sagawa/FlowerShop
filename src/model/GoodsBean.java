package model;

import java.io.Serializable;

public class GoodsBean implements Serializable {
	private String goodsName;
	private int goodsPrice;
	private String goodsImg;
	private int goodsNumber;
	private String goodsInfo;
	private String goodsLang;

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public String getGoodsLang() {
		return goodsLang;
	}
	public void setGoodsLang(String goodsLang) {
		this.goodsLang = goodsLang;
	}
}
