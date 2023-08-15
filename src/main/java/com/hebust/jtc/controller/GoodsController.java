package com.hebust.jtc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hebust.jtc.controller.Utils.PageResult;
import com.hebust.jtc.controller.Utils.R;
import com.hebust.jtc.pojo.Goods;
import com.hebust.jtc.pojo.PurchaseRecord;
import com.hebust.jtc.service.impl.GoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 小天
 * @Date: 2023/5/18 - 05 - 18 - 17:04
 * @Decsription: com.hebust.jtc.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/deptManage/goods")
public class GoodsController {
    @Autowired
    GoodsImpl goodsService;

    @GetMapping("/show")
    @ResponseBody
    public R showAllGoods(@RequestParam(required = false)Integer pageNum, @RequestParam(required = false) Integer pageSize){
        System.out.println("查询商品信息");
        PageResult selectGoodsResult = new PageResult();
        IPage<Goods> page = goodsService.showGoods(pageNum,pageSize);
        if (page == null){
            selectGoodsResult.setStatus(false);
            selectGoodsResult.setInfo("查询失败");
            selectGoodsResult.setCount(0);
            selectGoodsResult.setData(0);
            selectGoodsResult.setTotalRecordNum(0);
        } else if (page.getSize() == 0) {
            selectGoodsResult.setStatus(true);
            selectGoodsResult.setInfo("未添加数据");
            selectGoodsResult.setCount(0);
            selectGoodsResult.setData(0);
            selectGoodsResult.setTotalRecordNum(0);
        }else {
            selectGoodsResult.setStatus(true);
            selectGoodsResult.setInfo("查询成功");
            List<Goods> goodsList = page.getRecords();
            selectGoodsResult.setData(goodsList);
            selectGoodsResult.setCount(goodsList.size());
            selectGoodsResult.setTotalRecordNum(page.getTotal());
        }
        return selectGoodsResult;
    }
    @GetMapping("getUnPermittedGoods")
    @ResponseBody
    public R getUnPermittedGoods(){
        R selectGoodsByIdResult;
        List<Goods> goodsList = goodsService.showUnPermissionGoods();
        if (goodsList.size() > 0){
            selectGoodsByIdResult = new R(true,"查找成功",goodsList);
        }else {
            selectGoodsByIdResult = new R(false,"查找失败",goodsList);
        }
        return selectGoodsByIdResult;
    }

    @PostMapping("/add")
    @ResponseBody
    public R insertMaintainer(@RequestBody Goods goods){
        R addGoodsResult;
        int flag = goodsService.addGoods(goods);
        if (flag == 1){//成功
            addGoodsResult = new R(true,"添加成功",flag);
        }else{
            addGoodsResult = new R(false,"添加失败",0);
        }
        return addGoodsResult;
    }

    @GetMapping("getById")
    @ResponseBody
    public R getGoodsById(@RequestParam Integer id){
        R selectGoodsByIdResult;
        List<Goods> goodsList = goodsService.getGoodsById(id);
        if (goodsList.size() > 0){
            selectGoodsByIdResult = new R(true,"查找成功",goodsList);
        }else {
            selectGoodsByIdResult = new R(false,"查找失败",goodsList);
        }
        return selectGoodsByIdResult;
    }
//    购买商品
//    账户余额的改变
    @PostMapping("buyGoods")
    @ResponseBody
    public R buyGoods(@RequestBody PurchaseRecord purchaseRecord){
        R buyGoodsResult;
//        转账操作
        goodsService.purchaserAccount(purchaseRecord.getPurchaserId(),purchaseRecord.getGoodsPrice());
        goodsService.sellerAccount(purchaseRecord.getSellerId(),purchaseRecord.getGoodsPrice());
        goodsService.setStatus(purchaseRecord.getGoodsId());
//        记录
        int flag = goodsService.buyGoods(purchaseRecord);
        if (flag == 1){//成功
            buyGoodsResult = new R(true,"购买成功",flag);
        }else{
            buyGoodsResult = new R(false,"购买失败",0);
        }
        return buyGoodsResult;
    }

//    获取我的商品信息
    @GetMapping("getMyGoods")
    @ResponseBody
    public R getMyGoods(@RequestParam String stuId){
        R getMyGoodsResult;
        List<Goods> goodsList = goodsService.getMyGoods(stuId);
        System.out.println(goodsList);
        if(goodsList.size()>0){
            getMyGoodsResult = new R(true,"查找成功",goodsList);
        }else {
            getMyGoodsResult = new R(true,"查找成功",goodsList);
        }
        return getMyGoodsResult;
    }

    //    获取我的商品信息
    @GetMapping("getOtherGoods")
    @ResponseBody
    public R getOtherGoods(@RequestParam String stuId){
        R getMyGoodsResult;
        List<Goods> goodsList = goodsService.getOtherGoods(stuId);
        System.out.println(goodsList);
        if(goodsList.size()>0){
            getMyGoodsResult = new R(true,"查找成功",goodsList);
        }else {
            getMyGoodsResult = new R(true,"查找成功",goodsList);
        }
        return getMyGoodsResult;
    }


    //    审核商品信息
    @GetMapping("verifyGoods")
    @ResponseBody
    public R verifyGoods(@RequestParam String goodsId){
        R verifyGoodsResult;
        int flag  = goodsService.verifyGoods(goodsId);
        if (flag == 1){//成功
            verifyGoodsResult = new R(true,"审核成功",flag);
        }else{
            verifyGoodsResult = new R(false,"审核失败",0);
        }
        return verifyGoodsResult;
    }

    //    获取我的商品信息
    @GetMapping("deleteGoods")
    @ResponseBody
    public R deleteGoods(@RequestParam String goodsId){
        R deleteGoodsResult;
        int flag  = goodsService.deleteGoods(goodsId);
        if (flag == 1){//成功
            deleteGoodsResult = new R(true,"删除成功",flag);
        }else{
            deleteGoodsResult = new R(false,"删除失败",0);
        }
        return deleteGoodsResult;
    }

    //    获取我的商品信息
    @GetMapping("updateGoods")
    @ResponseBody
    public R updateGoods(@RequestBody Goods goods){
        R deleteGoodsResult;
        int flag  = goodsService.updateGoods(goods);
        if (flag == 1){//成功
            deleteGoodsResult = new R(true,"删除成功",flag);
        }else{
            deleteGoodsResult = new R(false,"删除失败",0);
        }
        return deleteGoodsResult;
    }


}
