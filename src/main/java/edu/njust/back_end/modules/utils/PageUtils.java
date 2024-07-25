package edu.njust.back_end.modules.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
public class PageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("总记录数")
    private int total;

    @ApiModelProperty("每页记录数")
    private int limit;

    @ApiModelProperty("总页数")
    private int totalPage;

    @ApiModelProperty("当前页数")
    private int page;

    @ApiModelProperty("列表数据")
    private List<T> list;

    @Override
    public String toString() {
        return "PageUtils(total=" + getTotal() + ", limit=" + getLimit() + ", totalPage=" + getTotalPage() + ", page=" + getPage() + ", list=" + getList() + ")";
    }

    public PageUtils(Page<T> page) {
        this.list = page.getRecords();
        this.total = (int) page.getTotal();
        this.limit = (int) page.getSize();
        this.page = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
    }

    public PageUtils(PageInfo<T> page) {
        this.list = page.getList();
        this.total = (int) page.getTotal();
        this.limit = (int) page.getPageSize();
        this.page = (int) page.getPageNum();
        this.totalPage = (int) page.getPages();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
