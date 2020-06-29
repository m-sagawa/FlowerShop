package model;

public class CartBean {
	private GoodsBean goodsBean;
	private int goodsBuyNumber;

	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public void setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
	}
	public int getGoodsBuyNumber() {
		return goodsBuyNumber;
	}
	public void setGoodsBuyNumber(int goodsBuyNumber) {
		this.goodsBuyNumber = goodsBuyNumber;
	}
}
