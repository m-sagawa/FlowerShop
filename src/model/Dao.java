package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	public String Login(String userID, String userPASS) {
		String loginType = "";
		String sql = "SELECT type FROM flowerdb.users WHERE user_id=? AND user_password=?";

		if(userID.equals("") || userPASS.equals("")) {

		}else {
			try(Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, userID);
				pstmt.setString(2, userPASS);

				ResultSet res = pstmt.executeQuery();
				while(res.next()) {
					loginType = res.getString("type");
				}
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return loginType;
	}

	public List<GoodsBean> GoodsList(String sarch, String sort) {
		GoodsBean goodsBean = new GoodsBean();
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
		String sql = null;
		if(sarch == null) {
			if(sort == null) {
				sql = "SELECT * FROM flowerdb.goods";
				try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){

					ResultSet res = pstmt.executeQuery();
					while(res.next()) {
						String goodsName = res.getString("goods_name");
						int goodsPrice = res.getInt("goods_price");
						String goodsImg = res.getString("goods_img");

						goodsBean.setGoodsName(goodsName);
						goodsBean.setGoodsPrice(goodsPrice);
						goodsBean.setGoodsImg(goodsImg);

						String n = goodsBean.getGoodsName();
						int p = goodsBean.getGoodsPrice();
						String i = goodsBean.getGoodsImg();

						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else {
				sql = "SELECT * FROM flowerdb.goods ORDER BY ?";
				try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setString(1, sort);

					ResultSet res = pstmt.executeQuery();
					while(res.next()) {
						goodsBean.setGoodsName(res.getString("goods_name"));
						goodsBean.setGoodsPrice(res.getInt("goods_price"));
						goodsBean.setGoodsImg(res.getString("goods_img"));
						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			if(sort == null) {
				sql = "SELECT * FROM flowerdb.goods WHERE goods_name=?";
				try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setString(1, sarch);

					ResultSet res = pstmt.executeQuery();
					while(res.next()) {
						goodsBean.setGoodsName(res.getString("goods_name"));
						goodsBean.setGoodsPrice(res.getInt("goods_price"));
						goodsBean.setGoodsImg(res.getString("goods_img"));
						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else {
				sql = "SELECT * FROM flowerdb.goods WHERE goods_name=? ORDER BY ?";
				try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setString(1, sarch);
					pstmt.setString(2, sort);

					ResultSet res = pstmt.executeQuery();
					while(res.next()) {
						goodsBean.setGoodsName(res.getString("goods_name"));
						goodsBean.setGoodsPrice(res.getInt("goods_price"));
						goodsBean.setGoodsImg(res.getString("goods_img"));
						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return goodsList;
	}
}
