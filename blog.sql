/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-12-11 17:44:33

创建数据库语句
CREATE DATABASE blog;

使用数据库语句
use blog;
*/

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
