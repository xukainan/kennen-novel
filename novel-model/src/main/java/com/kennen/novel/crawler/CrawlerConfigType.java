package com.kennen.novel.crawler;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("crawler_config_type")
public class CrawlerConfigType {
    @TableId(value = "condig_type_id", type = IdType.AUTO)
    private int condigTypeId;
    @TableField("type_name")
    private String typeName;
}
