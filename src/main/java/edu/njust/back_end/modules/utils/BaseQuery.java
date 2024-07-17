package edu.njust.back_end.modules.utils;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("页码")
    @TableField(exist = false)
    private Integer page;

    @ApiModelProperty("每页条数")
    @TableField(exist = false)
    private Integer limit;

    @ApiModelProperty("排序的列名")
    @TableField(exist = false)
    private String sidx;

    @ApiModelProperty("排序规则 asc desc")
    @TableField(exist = false)
    private String sortOrder;

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "BaseQuery(page=" + getPage() + ", limit=" + getLimit() + ", sidx=" + getSidx() + ", sortOrder=" + getSortOrder() + ")";
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getSidx() {
        return this.sidx;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }
}
