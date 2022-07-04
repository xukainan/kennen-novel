package com.kennen.novel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("novel_info")
public class NovelInfo {

    @TableId(value = "novel_id", type = IdType.AUTO)
    private int novelId;
    @TableField("novel_name")
    private String novelName;
    @TableField("novel_type_id")
    private int novelTypeId;
    @TableField("novel_status")
    private int novelStatus;
    @TableField("novel_words")
    private int novelWords;
    @TableField("novel_popularity")
    private long novelPopularity;
    @TableField("novel_collect")
    private long novelCollect;
    @TableField("novel_support")
    private long novelSupport;
    @TableField("novel_tag_id")
    private int novelTagId;
    @TableField("novel_latest_chapter_id")
    private int novelLatestChapterId;
    @TableField("novel_author_id")
    private int novelAuthorId;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("is_delete")
    private int isDelete;

}
