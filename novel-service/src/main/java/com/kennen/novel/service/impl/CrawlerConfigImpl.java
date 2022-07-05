package com.kennen.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennen.novel.common.STATUSENUMS;
import com.kennen.novel.crawler.CrawlerConfig;
import com.kennen.novel.crawler.CrawlerConfigMapper;
import com.kennen.novel.service.ICrawlerConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerConfigImpl extends ServiceImpl<CrawlerConfigMapper, CrawlerConfig> implements ICrawlerConfigService {

    @Override
    public List<CrawlerConfig> listActiveCrawlerConfig() {
        LambdaQueryWrapper<CrawlerConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CrawlerConfig::getConfigStatus, STATUSENUMS.Active.getStatus());
        return this.list(wrapper);
    }
}
