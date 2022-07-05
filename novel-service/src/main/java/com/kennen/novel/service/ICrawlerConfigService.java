package com.kennen.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennen.novel.crawler.CrawlerConfig;

import java.util.List;

public interface ICrawlerConfigService extends IService<CrawlerConfig> {

    List<CrawlerConfig> listActiveCrawlerConfig();
}
