package pres.haimi.csc.task.model.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import pres.haimi.csc.task.model.user.User;

import java.util.Date;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data
@AllArgsConstructor
public class CollectGoods {
    private Integer id;
    private SecondGoods collect_goods;
    private User collect_goods_user;
    private Date collectDate;
}
