package cn.edu.seu.sky.common.bean;

import cn.edu.seu.sky.common.utils.BeanUtils;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author xiaotian on 2022/6/6
 */
@Data
public final class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 结果集
     */
    private List<T> list;
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 是否有上一页
     */
    private boolean hasPreviousPage;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    public static <S, T> PageResult<T> of(PageInfo<S> pageInfo, Supplier<T> supplier) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setList(BeanUtils.copyList(pageInfo.getList(), supplier));
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setPages(pageInfo.getPages());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setHasPreviousPage(pageInfo.isHasPreviousPage());
        pageResult.setHasNextPage(pageInfo.isHasNextPage());
        return pageResult;
    }
}
