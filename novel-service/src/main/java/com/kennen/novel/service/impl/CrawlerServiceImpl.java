package com.kennen.novel.service.impl;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.kennen.novel.common.ListHelper;
import com.kennen.novel.crawler.CrawlerConfig;
import com.kennen.novel.crawler.CrawlerConfigDetail;
import com.kennen.novel.crawler.HtmlUnitHelper;
import com.kennen.novel.service.ICrawlerConfigDetailService;
import com.kennen.novel.service.ICrawlerConfigService;
import com.kennen.novel.service.ICrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class CrawlerServiceImpl implements ICrawlerService {

    @Autowired
    ICrawlerConfigService crawlerConfigService;

    @Autowired
    ICrawlerConfigDetailService crawlerConfigDetailService;

    @Override
    public void crawlerNovelsAll() {
        WebClient webClient = HtmlUnitHelper.getWebClient();
        List<CrawlerConfig> crawlerConfigs = crawlerConfigService.listActiveCrawlerConfig();
        if(ListHelper.isEmpty(crawlerConfigs)){
            log.info("爬取当前crawlerConfigs为空");
            return;
        }
        crawlerConfigs.stream().forEach(crawlerConfig -> {
            String indexUrl = crawlerConfig.getConfigIndexUrl();
            List<CrawlerConfigDetail> crawlerConfigDetails =
                    crawlerConfigDetailService.listByConfigId(crawlerConfig.getConfigId());
            if(ListHelper.isEmpty(crawlerConfigDetails)){
                log.info("爬取当前crawlerConfigDetails为空:{}", crawlerConfig.getConfigId());
                return;
            }
            crawlerConfigDetails.stream().filter(item -> item.getCondigDetailId() <= 15).forEach(crawlerConfigDetail -> {
                String fullUrl = indexUrl + crawlerConfigDetail.getConfigUrl();
                Document documentByUrl = HtmlUnitHelper.getDocumentByUrl(fullUrl, webClient);
            });
        });


    }


}
