package com.yarns.december.mapper;

import com.yarns.december.entity.system.SysParams;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * 系统参数表 Mapper
 *
 * @author yarns
 * @date 2023-05-08 20:28:36
 */
public interface SysParamsMapper extends BaseMapper<SysParams> {

    /**
     * 查询（分页）
     *
     * @param page Page
     * @param sysParams sysParams
     * @return IPage<SysParams>
     */
    IPage<SysParams> findSysParamsDetailPage(Page page,@Param("sysParams")  SysParams sysParams);
}
