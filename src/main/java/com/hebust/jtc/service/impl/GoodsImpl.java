package com.hebust.jtc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hebust.jtc.DAO.GoodsMapper;
import com.hebust.jtc.pojo.Goods;
import com.hebust.jtc.pojo.PurchaseRecord;
import com.hebust.jtc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/18 - 05 - 18 - 17:04
 * @Decsription: com.hebust.jtc.service.impl
 * @version: 1.0
 */
@Component
public class GoodsImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public IPage<Goods> showGoods(Integer pageNum, Integer pageSize) {
        IPage page = new Page(pageNum,pageSize);
        return goodsMapper.showGoods(page);
    }

    @Override
    public List<Goods> showUnPermissionGoods() {
        return goodsMapper.showUnPermissionGoods();
    }

    @Override
    public List<Goods> getGoodsById(Integer goodsId) {
        return goodsMapper.getGoodsById(goodsId);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int deleteGoods(String goodsId) {
        return goodsMapper.deleteGoods(goodsId);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int verifyGoods(String goodsId) {
        return goodsMapper.verifyGoods(goodsId);
    }

    @Override
    public int buyGoods(PurchaseRecord purchaseRecord) {
        return goodsMapper.buyGoods(purchaseRecord);
    }

    @Override
    public List<Goods> getMyGoods(String stuId) {
        return goodsMapper.getMyGoods(stuId);
    }

    @Override
    public List<Goods> getOtherGoods(String stuId) {
        return goodsMapper.getOtherGoods(stuId);
    }

    @Override
    public int purchaserAccount(String purchaserId, Double goodsPrice) {
        return goodsMapper.purchaserAccount(purchaserId,goodsPrice);
    }

    @Override
    public int sellerAccount(String sellerId, Double goodsPrice) {
        return goodsMapper.sellerAccount(sellerId,goodsPrice);
    }

    @Override
    public int setStatus(Integer stuId) {
        return goodsMapper.setStatus(stuId);
    }
}
