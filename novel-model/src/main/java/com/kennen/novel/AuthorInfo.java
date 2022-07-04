package com.kennen.novel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("author_info")
public class AuthorInfo {

    @TableId(value = "author_id", type = IdType.AUTO)
    private int authorId;
    @TableField("author_name")
    private String authorName;
}
