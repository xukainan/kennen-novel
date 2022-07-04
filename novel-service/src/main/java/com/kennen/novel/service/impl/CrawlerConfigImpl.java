package com.kennen.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennen.novel.crawler.CrawlerConfig;
import com.kennen.novel.crawler.CrawlerConfigMapper;
import com.kennen.novel.service.ICrawlerConfigService;
import org.springframework.stereotype.Service;

@Service
public class CrawlerConfigImpl extends ServiceImpl<CrawlerConfigMapper, CrawlerConfig> implements ICrawlerConfigService {
}
