package com.kennen.novel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("novel_tag")
public class NovelTag {

    @TableId(value = "tag_id", type = IdType.AUTO)
    private int tagId;
    @TableField("tag_name")
    private String tagName;
    @TableField("tag_type")
    private int tagType;

}
