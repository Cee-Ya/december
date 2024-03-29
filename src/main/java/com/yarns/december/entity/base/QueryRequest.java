package com.yarns.december.entity.base;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用查询参数类
 * @author Yarns
 */
@Data
@ToString
public class QueryRequest implements Serializable {
    private static final long serialVersionUID = 4336034977073742036L;
    /**
     * 当前页面数据量
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;

    /**
     * 分页起点（前端不用传  后端计算）
     */
    private int limitNum = 0;


    public void initLimitNum() {
        this.limitNum = (this.pageNum-1) * this.pageSize;
    }




}
