package me.xiaohuang.companyframe.utils;

import com.github.pagehelper.Page;
import me.xiaohuang.companyframe.vo.resp.PageVO;

import java.util.List;

/**
 * @ClassName PageUtils
 * @Description PageUtils
 * @Author xiaohuang
 * @Date 2020/4/8 16:28
 * @Version 1.0
 */
public class PageUtils {
    private PageUtils(){}
    public static <T> PageVO<T> getPageVO(List<T> list){
        PageVO<T> result=new PageVO<>();
        if(list instanceof Page){
            Page<T> page= (Page<T>) list;
            result.setTotalRows(page.getTotal());
            result.setTotalPages(page.getPages());
            result.setPageNum(page.getPageNum());
            result.setCurPageSize(page.getPageSize());
            result.setPageSize(page.size());
            result.setList(page.getResult());
        }
        return result;
    }
}
