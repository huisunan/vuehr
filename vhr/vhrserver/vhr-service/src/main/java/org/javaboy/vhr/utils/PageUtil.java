package org.javaboy.vhr.utils;

import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.model.RespPageBean;

import java.util.List;

public class PageUtil {
    public static RespPageBean create(PageInfo pageInfo){
        RespPageBean bean = new RespPageBean();
        bean.setData(pageInfo.getList());
        bean.setTotal(pageInfo.getTotal());
        return bean;
    }
}
