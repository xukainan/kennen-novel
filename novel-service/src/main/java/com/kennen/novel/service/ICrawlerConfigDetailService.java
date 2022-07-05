package com.kennen.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennen.novel.crawler.CrawlerConfigDetail;

import java.util.List;

public interface ICrawlerConfigDetailService extends IService<CrawlerConfigDetail> {

    List<CrawlerConfigDetail> listByConfigId(int id);
}
