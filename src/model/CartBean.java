package model;

public class CartBean {
	private GoodsBean goodsBean;
	private int goodsNumber;

	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public void setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
}
