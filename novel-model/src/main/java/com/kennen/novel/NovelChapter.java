package com.kennen.novel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("novel_chapter")
public class NovelChapter {

    @TableId(value = "chapter_id", type = IdType.INPUT)
    private String chapterId;
    @TableField("novel_id")
    private int novelId;
    @TableField("novel_id")
    private String chapterName;
    @TableField("chapter_num")
    private int chapterNum;
    @TableField("chapter_words")
    private int chapterWords;
    @TableField("is_vip")
    private int isVip;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;

}
