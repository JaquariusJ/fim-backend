package com.money.fimsystem.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageHelperUtils {

    public static <DO, VO> PageInfo<VO> pageDO2pageVO(PageInfo<DO> pageInfoPo,List<VO> pageVos) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<VO> newPage = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        newPage.setTotal(pageInfoPo.getTotal());
        PageInfo<VO> voPageInfo = new PageInfo<>(newPage);

        if(pageInfoPo.getTotal()>0){
            voPageInfo.getList().addAll(pageVos);
        }
        return  voPageInfo;
    }
}
