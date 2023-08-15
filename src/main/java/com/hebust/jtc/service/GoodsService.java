package com.hebust.jtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Goods;
import com.hebust.jtc.pojo.PurchaseRecord;

import java.awt.geom.IllegalPathStateException;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/18 - 05 - 18 - 17:04
 * @Decsription: com.hebust.jtc.service
 * @version: 1.0
 */
public interface GoodsService {
//    获取所有商品信息
    public IPage<Goods> showGoods(Integer pageNum, Integer pageSize);
//    获取没有审核的物品信息
    public List<Goods> showUnPermissionGoods();
//    根据id获取商品信息
    public List<Goods> getGoodsById(Integer goodsId);
//    添加商品信息
    public int addGoods(Goods goods);
//    删除商品信息
    public int deleteGoods(String goodsId);
//    修改商品信息
    public int updateGoods(Goods goods);
//    审核商品
    public int verifyGoods(String goodsId);
//    购买物品
    public int buyGoods(PurchaseRecord purchaseRecord);
//    获取自己的商品信息
    public List<Goods> getMyGoods(String stuId);
//    获取他人售卖的物品
    public List<Goods> getOtherGoods(String stuId);
//    购买者账户余额减少
    public int purchaserAccount(String purchaserId,Double goodsPrice);
//      卖家账户余额增多
    public int sellerAccount(String purchaserId,Double goodsPrice);
//    设置商品状态
    public int setStatus(Integer stuId);
}
