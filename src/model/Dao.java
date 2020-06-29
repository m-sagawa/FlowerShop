package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	//ログイン処理
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

	//条件に合った商品リストを返す
	public List<GoodsBean> GoodsList(String sarch, String sort) {
		//GoodsBean goodsBean = new GoodsBean();
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
		String sql = null;
		if(sarch == null || sarch == "") {
			if(sort == null || sort == "") {
				sql = "SELECT * FROM flowerdb.goods";
				try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){

					ResultSet res = pstmt.executeQuery();
					res.beforeFirst();
					while(res.next()) {
						GoodsBean goodsBean = new GoodsBean();
						String goodsName = res.getString("goods_name");
						int goodsPrice = res.getInt("goods_price");
						String goodsImg = res.getString("goods_img");
						int goodsNumber = res.getInt("goods_number");
						String goodsInfo = res.getString("goods_info");
						String goodsLang = res.getString("goods_lang");

						goodsBean.setGoodsName(goodsName);
						goodsBean.setGoodsPrice(goodsPrice);
						goodsBean.setGoodsImg(goodsImg);
						goodsBean.setGoodsNumber(goodsNumber);
						goodsBean.setGoodsInfo(goodsInfo);
						goodsBean.setGoodsLang(goodsLang);

						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}else {
				if(sort.equals("goods_name")) {
					sql = "SELECT * FROM flowerdb.goods ORDER BY goods_name";
				}else if(sort.equals("goods_price")) {
					sql = "SELECT * FROM flowerdb.goods ORDER BY goods_price";
				}

				try(Connection con = ConnectionManager.getConnection();
						Statement stmt = con.createStatement();
						ResultSet res = stmt.executeQuery(sql)){
					while(res.next()) {
						GoodsBean goodsBean = new GoodsBean();
						String goodsName = res.getString("goods_name");
						int goodsPrice = res.getInt("goods_price");
						String goodsImg = res.getString("goods_img");
						int goodsNumber = res.getInt("goods_number");
						String goodsInfo = res.getString("goods_info");
						String goodsLang = res.getString("goods_lang");

						goodsBean.setGoodsName(goodsName);
						goodsBean.setGoodsPrice(goodsPrice);
						goodsBean.setGoodsImg(goodsImg);
						goodsBean.setGoodsNumber(goodsNumber);
						goodsBean.setGoodsInfo(goodsInfo);
						goodsBean.setGoodsLang(goodsLang);

						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			if(sort == null || sort == "") {
				sql = "SELECT * FROM flowerdb.goods WHERE goods_name=?";
				try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setString(1, sarch);

					ResultSet res = pstmt.executeQuery();
					res.beforeFirst();
					while(res.next()) {
						GoodsBean goodsBean = new GoodsBean();
						String goodsName = res.getString("goods_name");
						int goodsPrice = res.getInt("goods_price");
						String goodsImg = res.getString("goods_img");
						int goodsNumber = res.getInt("goods_number");
						String goodsInfo = res.getString("goods_info");
						String goodsLang = res.getString("goods_lang");

						goodsBean.setGoodsName(goodsName);
						goodsBean.setGoodsPrice(goodsPrice);
						goodsBean.setGoodsImg(goodsImg);
						goodsBean.setGoodsNumber(goodsNumber);
						goodsBean.setGoodsInfo(goodsInfo);
						goodsBean.setGoodsLang(goodsLang);

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
					res.beforeFirst();
					while(res.next()) {
						GoodsBean goodsBean = new GoodsBean();
						String goodsName = res.getString("goods_name");
						int goodsPrice = res.getInt("goods_price");
						String goodsImg = res.getString("goods_img");
						int goodsNumber = res.getInt("goods_number");
						String goodsInfo = res.getString("goods_info");
						String goodsLang = res.getString("goods_lang");

						goodsBean.setGoodsName(goodsName);
						goodsBean.setGoodsPrice(goodsPrice);
						goodsBean.setGoodsImg(goodsImg);
						goodsBean.setGoodsNumber(goodsNumber);
						goodsBean.setGoodsInfo(goodsInfo);
						goodsBean.setGoodsLang(goodsLang);

						goodsList.add(goodsBean);
					}
				}catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return goodsList;
	}

	//商品新規登録
	public  int registrationGoods(GoodsBean goodsBean) {
		String sql = "INSERT INTO goods VALUE(?,?,?,?,?,?)";
		int count = 0;
		String goodsName = goodsBean.getGoodsName();
		int goodsPrice = goodsBean.getGoodsPrice();
		String goodsImg = goodsBean.getGoodsImg();
		int goodsNumber = goodsBean.getGoodsNumber();
		String goodsInfo = goodsBean.getGoodsInfo();
		String goodsLang = goodsBean.getGoodsLang();

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, goodsName);
			pstmt.setInt(2, goodsPrice);
			pstmt.setString(3, goodsImg);
			pstmt.setInt(4, goodsNumber);
			pstmt.setString(5, goodsInfo);
			pstmt.setString(6, goodsLang);

			count = pstmt.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	//商品変更
	public int updateGoods(GoodsBean goodsBean, String goods_name) {
		String sql = "UPDATE goods SET goods_name=?, goods_price=?, goods_img=?, goods_number=?, goods_info=?, goods_lang=? WHERE goods_name=?";
		int count = 0;
		String goodsName = goodsBean.getGoodsName();
		int goodsPrice = goodsBean.getGoodsPrice();
		String goodsImg = goodsBean.getGoodsImg();
		int goodsNumber = goodsBean.getGoodsNumber();
		String goodsInfo = goodsBean.getGoodsInfo();
		String goodsLang = goodsBean.getGoodsLang();

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, goodsName);
			pstmt.setInt(2, goodsPrice);
			pstmt.setString(3, goodsImg);
			pstmt.setInt(4, goodsNumber);
			pstmt.setString(5, goodsInfo);
			pstmt.setString(6, goodsLang);
			pstmt.setString(7, goods_name);

			count = pstmt.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	//商品削除
	public int deleteGoods(String[] dl) {
		String sql = "DELETE FROM goods WHERE goods_name=?";
		int count = 0;

		for(String goodsName : dl) {
			try(Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, goodsName);
				int c = pstmt.executeUpdate();
				count += c;
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	//会員登録
	public int registrationMember(String user_id, String user_password) {
		String sql = "INSERT INTO users VALUE(?,?,?)";
		int count = 0;

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_password);
			pstmt.setString(3, "customer");
			count = pstmt.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
