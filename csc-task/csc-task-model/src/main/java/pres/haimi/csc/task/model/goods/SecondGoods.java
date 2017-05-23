package pres.haimi.csc.task.model.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import pres.haimi.csc.task.model.user.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data
@AllArgsConstructor
public class SecondGoods {
    private Integer id;//编号
    private String title;//商品标题
    private Date publisurDate;//发布时间
    private String description;//商品描述
    private String goods_photo;//商品图片
    private Double price;//商品价格
    private String state;//商品状态
    private User sell_user;//卖家
    private	User buy_user;//买家
    private Integer collectTimes;//收藏次数
    private Integer goodsNum;//商品个数

    private Set<CollectGoods> goods_users=new HashSet<>();

}
