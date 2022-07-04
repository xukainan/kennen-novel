package com.kennen.novel.crawler;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("crawler_config")
public class CrawlerConfig {
    @TableId(value = "config_id", type = IdType.INPUT)
    private String configId;
    @TableField("config_name")
    private String configName;
    @TableField("config_index_url")
    private String configIndexUrl;
    @TableField("config_status")
    private int configStatus;
}
