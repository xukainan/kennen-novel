package com.kennen.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennen.novel.common.DELETEENUMS;
import com.kennen.novel.crawler.CrawlerConfigDetail;
import com.kennen.novel.dao.crawler.CrawlerConfigDetailMapper;
import com.kennen.novel.service.ICrawlerConfigDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerConfigDetailServiceImpl extends ServiceImpl<CrawlerConfigDetailMapper, CrawlerConfigDetail> implements ICrawlerConfigDetailService {

    @Override
    public List<CrawlerConfigDetail> listByConfigId(int id) {
        LambdaQueryWrapper<CrawlerConfigDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CrawlerConfigDetail::getConfigId, id).eq(CrawlerConfigDetail::getIsDelete,
                DELETEENUMS.NotDelete.getStatus()).orderByAsc(CrawlerConfigDetail::getCondigDetailId);
        return list(wrapper);
    }
}
