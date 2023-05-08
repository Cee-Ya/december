package com.yarns.december.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yarns.december.entity.base.QueryRequest;
import com.yarns.december.entity.system.SysParams;
import com.yarns.december.mapper.SysParamsMapper;
import com.yarns.december.service.SysParamsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * 系统参数表 Service实现
 *
 * @author yarns
 * @date 2023-05-08 20:28:36
 */
@Service("sysParamsService")
public class SysParamsServiceImpl extends ServiceImpl<SysParamsMapper, SysParams> implements SysParamsService {

    @Override
    public IPage<SysParams> findSysParamss(QueryRequest request, SysParams sysParams) {
        Page<SysParams> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.baseMapper.findSysParamsDetailPage(page,sysParams);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void createSysParams(SysParams sysParams) {
        this.save(sysParams);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateSysParams(SysParams sysParams) {
        this.updateById(sysParams);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteSysParamss(String[] sysParamsIds) {
        this.removeByIds(Arrays.asList(sysParamsIds));
    }

    @Override
    public String getSysParamsValueByKey(String key) {
        SysParams sysParams = this.baseMapper.selectOne(new LambdaQueryWrapper<SysParams>().eq(SysParams::getName, key));
        return sysParams == null ? null : sysParams.getParamsValue();
    }
}
