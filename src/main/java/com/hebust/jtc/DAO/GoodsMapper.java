package com.hebust.jtc.DAO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.pojo.Goods;
import com.hebust.jtc.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/18 - 05 - 18 - 17:04
 * @Decsription: com.hebust.jtc.DAO
 * @version: 1.0
 */
@Mapper
public interface GoodsMapper {
    //    获取所有商品信息
    @Select("select * from goods")
    public IPage<Goods> showGoods(IPage page);
    //    获取通过审核的商品信息
    @Select("select * from goods where permission = 1")
    public List<Goods> showPermissionGoods();
    @Select("select * from goods where permission = 0")
    public List<Goods> showUnPermissionGoods();
    //    根据学生ID获取商品信息
    @Select("select * from goods where stuId = #{stuId} ")
    public List<Goods> getMyGoods(String stuId);
    //    根据学生ID获取商品信息
    @Select("select * from goods where stuId != #{stuId} and permission = 1")
    public List<Goods> getOtherGoods(String stuId);
    //    根据id获取商品信息
    @Select("select * from goods where goodsId = #{goodsId}")
    public List<Goods> getGoodsById(Integer goodsId);
    //    添加商品信息
    @Insert("insert into goods (stuId,deptId,goodsName,goodsPic,goodsDetail,goodsPrice) values (#{stuId},#{deptId},#{goodsName},#{goodsPic},#{goodsDetail},#{goodsPrice})")
    public int addGoods(Goods goods);
    //    删除商品信息
    @Delete("delete from goods where goodsId = #{goodsId}")
    public int deleteGoods(String goodsId);
    //    修改商品价格
    @Update("update goods set goodsPrice = #{goodsPrice}")
    public int updateGoods(Goods goods);
    //    审核商品
    @Update("update goods set permission = 1 where goodsId = #{goodsId}")
    public int verifyGoods(String goodsId);
    //    购买物品
    @Insert("insert into purchaseRecord (purchaserId,sellerId,goodsId,goodsPrice) values(#{purchaserId},#{sellerId},#{goodsId},#{goodsPrice})")
    public int buyGoods(PurchaseRecord purchaseRecord);
    //    购买者账户余额减少
    @Update("update student set account = account - #{goodsPrice} where stuId = #{purchaserId} ")
    public int purchaserAccount(String purchaserId,Double goodsPrice);
    //    出售者账户余额增多
    @Update("update student set account = account + #{goodsPrice} where stuId = #{purchaserId} ")
    public int sellerAccount(String purchaserId,Double goodsPrice);
    //    设置商品购买状态
    @Update("update goods set status = 1 where goodsId = #{goodsId}")
    public int setStatus(Integer goodsId);
}
