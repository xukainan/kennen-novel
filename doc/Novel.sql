CREATE SCHEMA `tnoveldev1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;


-- ----------------------------
-- Table structure for novel_info
-- ----------------------------

create table novel_info
(
    novel_id int,
    novel_name varchar(30) null,
    novel_type_id int null,
    novel_status tinyint null comment '0:暂无资源 1：完结 2：连载中',
    novel_words int null comment '总字数',
    novel_popularity bigint null comment '人气',
    novel_collect bigint null comment '收藏',
    novel_support bigint null comment '点赞',
    novel_tag_id int null,
    novel_latest_chapter_id int null,
    novel_author_id int null,
    create_time datetime null,
    update_time datetime null,
    is_delete tinyint null
);

create unique index novel_info_novel_id_uindex
    on novel_info (novel_id);

alter table novel_info
    add constraint novel_info_pk
        primary key (novel_id);

alter table novel_info modify novel_id int auto_increment;

-- ----------------------------
-- Table structure for author_info
-- ----------------------------

create table author_info
(
    author_id int,
    author_name varchar(30) null
);

create unique index author_info_author_id_uindex
    on author_info (author_id);

alter table author_info
    add constraint author_info_pk
        primary key (author_id);

alter table author_info modify author_id int auto_increment;

-- ----------------------------
-- Table structure for novel_tag
-- ----------------------------
create table novel_tag
(
    tag_id int,
    tag_name nvarchar(30) null,
    tag_type tinyint null comment '0: type 1: tag'
);

create unique index novel_tag_tag_id_uindex
    on novel_tag (tag_id);

alter table novel_tag
    add constraint novel_tag_pk
        primary key (tag_id);

alter table novel_tag modify tag_id int auto_increment;

-- ----------------------------
-- Table structure for novel_chapter
-- ----------------------------

create table novel_chapter
(
    chapter_id binary(16) not null,
    novel_id int null,
    chapter_name nvarchar(50) null,
    chapter_num int null comment '章节号',
    chapter_words int null comment '章节字数',
    is_vip tinyint null,
    create_time datetime null,
    update_time datetime null
);

create unique index novel_chapter_chapter_id_uindex
    on novel_chapter (chapter_id);

alter table novel_chapter
    add constraint novel_chapter_pk
        primary key (chapter_id);

-- ----------------------------
-- Table structure for crawler_config
-- ----------------------------

create table crawler_config
(
    config_id int,
    crawler_name nvarchar(10) null,
    crawler_index_url nvarchar(30) null,
    crawler_status tinyint null comment '0：停用 1：启用'
);

create unique index crawler_config_config_id_uindex
    on crawler_config (config_id);

alter table crawler_config
    add constraint crawler_config_pk
        primary key (config_id);

alter table crawler_config modify config_id int auto_increment;

INSERT INTO `tnoveldev1`.`crawler_config` (`crawler_name`, `crawler_index_url`, `crawler_status`) VALUES ('笔下文学', 'https://www.bixiabook.com/', '1');

-- ----------------------------
-- Table structure for crawler_config_detail
-- ----------------------------
create table crawler_config_detail
(
    condig_detail_id int,
    config_id int null,
    config_type_id int null,
    config_url nvarchar(50) null,
    config_xpath nvarchar(50) null,
    config_suffix nvarchar(30) null,
    config_attribute varchar(10) null,
    config_regex varchar(30) null,
    create_time DATETIME default now() null,
    update_time DATETIME default now() null,
    is_delete tinyint default 0 null
);

create unique index crawler_config_detail_condig_detail_id_uindex
    on crawler_config_detail (condig_detail_id);

alter table crawler_config_detail
    add constraint crawler_config_detail_pk
        primary key (condig_detail_id);

alter table crawler_config_detail modify condig_detail_id int auto_increment;


INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '1', 'xuanhuanxiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '2', 'xiuzhenxiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '3', 'dushixiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '4', 'chuanyuexiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '5', 'wangyouxiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '6', 'kehuanxiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`, `config_suffix`) VALUES ('1', '7', 'qitaxiaoshuo/', '//*[@id=\"newscontent\"]/div[1]/ul/li', '%d/');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_url`, `config_xpath`,`config_attribute`) VALUES ('1', '16', '', '/span[2]/a', 'href');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_xpath`, `config_attribute`, `config_regex`) VALUES ('1', '17', '//*[@id=\"fanye\"]/div[2]', 'innerText', '\\d+');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_xpath`) VALUES ('1', '18', '//*[@id=\"list\"]/dl/dd');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_id`, `config_type_id`, `config_xpath`, `config_attribute`) VALUES ('1', '19', '/a', 'innerText');
INSERT INTO `tnoveldev1`.`crawler_config_detail` (`config_type_id`, `config_xpath`, `config_attribute`) VALUES ('20', '/a', 'href');


-- ----------------------------
-- Table structure for crawler_config_type
-- ----------------------------

create table crawler_config_type
(
    condig_type_id int,
    type_name nvarchar(10) null
);

create unique index crawler_config_type_condig_type_id_uindex
    on crawler_config_type (condig_type_id);

alter table crawler_config_type
    add constraint crawler_config_type_pk
        primary key (condig_type_id);

alter table crawler_config_type modify condig_type_id int auto_increment;

INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('玄幻小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('修真小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('都市小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('历史小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('网游小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('科幻小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('其它小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('同人小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('魔幻小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('校园小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('悬疑小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('武侠小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('现实小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('军事小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('体育小说');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('小说详情页');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('总页数');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('主图');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('名字');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('作者');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('最后更新时间');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('最新章节');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('简介');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('章节');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('章节名');
INSERT INTO `tnoveldev1`.`crawler_config_type` (`type_name`) VALUES ('章节链接');
