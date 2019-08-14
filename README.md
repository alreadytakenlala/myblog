# 巫师笔记

### 类型
> **博客平台**

### 技术栈
> 1. 后端：SpringBoot + thymleaf
> 2. 数据库: mysql
> 3. 服务器: tomcat

### 描述
这是我学习 SpringBoot 的时候做的第一个练手项目，当时经常看[纯洁的微笑](http://www.ityouknow.com/)的博客，非常羡慕，所以参考做了这个博客平台。
这个项目使用thymleaf模板技术， 使用公共组件页面拼接。项目不大，是一个适合初学者学习的项目。

### 展示地址
首页： http://127.0.0.1:8080
编辑页: 

### 部署
- 编辑 application.properties 文件，修改要连接的数据库用户名密码
```
spring.datasource.username=root
spring.datasource.password=root
```
- 创建数据库
```
create database blog;
```
- 选择使用数据库
```
use blog;
```
- 创建表
```
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` mediumtext NOT NULL,
  `topic_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_article` (`topic_id`),
  CONSTRAINT `topic_article` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for series
-- ----------------------------
DROP TABLE IF EXISTS `series`;
CREATE TABLE `series` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `topic_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_series` (`topic_id`),
  CONSTRAINT `topic_series` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `title` varchar(30) NOT NULL,
  `principal` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
```
