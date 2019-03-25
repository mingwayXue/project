package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICartService;
import com.mmall.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Mingway on 2018/3/12.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService iCartService;

    /**
     * 添加购物车
     * @param session
     * @param count
     * @param productId
     * @return
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public ServerResponse<CartVO> add(HttpSession session, Integer count, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.add(user.getId(), productId, count);
    }

    /**
     * 更新购物车
     * @param session
     * @param count
     * @param productId
     * @return
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public ServerResponse<CartVO> update(HttpSession session, Integer count, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.update(user.getId(), productId, count);
    }

    /**
     * 删除购物车中的商品
     * @param session
     * @param productIds
     * @return
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public ServerResponse<CartVO> delete(HttpSession session, String productIds){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.deleteProduct(user.getId(), productIds);
    }

    /**
     * 购物车展示
     * @param session
     * @return
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ServerResponse<CartVO> list(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.list(user.getId());
    }

    /**
     ** 全选
     * @param session
     * @return
     */
    @RequestMapping("/select_all.do")
    @ResponseBody
    public ServerResponse<CartVO> selectALL(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.selectOrUnselect(user.getId(), null, Const.Cart.CHECKED);
    }

    /**
     * 全反选
     * @param session
     * @return
     */
    @RequestMapping("/un_select_all.do")
    @ResponseBody
    public ServerResponse<CartVO> unSelectALL(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.selectOrUnselect(user.getId(),null, Const.Cart.UN_CHECKED);
    }

    /**
     * 单选
     * @param session
     * @return
     */
    @RequestMapping("/select.do")
    @ResponseBody
    public ServerResponse<CartVO> select(HttpSession session, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.selectOrUnselect(user.getId(), productId, Const.Cart.CHECKED);
    }

    /**
     * 单反选
     * @param session
     * @return
     */
    @RequestMapping("/un_select.do")
    @ResponseBody
    public ServerResponse<CartVO> unSelect(HttpSession session, Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
        }
        return iCartService.selectOrUnselect(user.getId(),productId, Const.Cart.UN_CHECKED);
    }

    /**
     * 查询购物车中的产品数量
     * @param session
     * @return
     */
    @RequestMapping("/get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }

}
