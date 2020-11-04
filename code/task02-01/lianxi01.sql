/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : lianxi01

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 04/11/2020 17:25:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES (1, '语文', 1);
INSERT INTO `course` VALUES (2, '数学', 1);
INSERT INTO `course` VALUES (3, '生物', 2);
INSERT INTO `course` VALUES (4, '化学', 2);
INSERT INTO `course` VALUES (5, '物理', 2);
INSERT INTO `course` VALUES (6, '英语', 3);
COMMIT;

-- ----------------------------
-- Table structure for curriculum
-- ----------------------------
DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum` (
  `id` int(11) NOT NULL,
  `lecturer_id` int(11) DEFAULT NULL,
  `curriculum_class_id` int(11) DEFAULT NULL,
  `curriculum_title` varchar(20) DEFAULT NULL,
  `curriculum_num` int(11) DEFAULT NULL,
  `browse_num` int(11) DEFAULT NULL,
  `curriculum_state` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lecturer_id` (`lecturer_id`),
  KEY `curriculum_class_id` (`curriculum_class_id`),
  KEY `curriculum_title` (`curriculum_title`),
  CONSTRAINT `curriculum_ibfk_1` FOREIGN KEY (`lecturer_id`) REFERENCES `lecturer` (`id`),
  CONSTRAINT `curriculum_ibfk_2` FOREIGN KEY (`curriculum_class_id`) REFERENCES `curriculum_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of curriculum
-- ----------------------------
BEGIN;
INSERT INTO `curriculum` VALUES (1, 1, 1, 'Java', 300, 250000, '1');
INSERT INTO `curriculum` VALUES (2, 2, 2, 'VUE', 400, 200000, '1');
COMMIT;

-- ----------------------------
-- Table structure for curriculum_class
-- ----------------------------
DROP TABLE IF EXISTS `curriculum_class`;
CREATE TABLE `curriculum_class` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `class_describe` varchar(20) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of curriculum_class
-- ----------------------------
BEGIN;
INSERT INTO `curriculum_class` VALUES (1, '后端开发', '后端课程包括 Java Python', '2020-03-27 00:44:04', '2020-03-27 00:44:04');
INSERT INTO `curriculum_class` VALUES (2, '前端开发', '前端课程包括 JQuery VUE', '2020-02-27 10:00:04', '2020-02-27 18:44:04');
COMMIT;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '开发部');
INSERT INTO `dept` VALUES (2, '市场部');
INSERT INTO `dept` VALUES (3, '财务部');
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES (1, '孙悟空', '男', 7200, '2013-02-24', 1);
INSERT INTO `employee` VALUES (2, '猪八戒', '男', 3600, '2010-12-02', 2);
INSERT INTO `employee` VALUES (3, '唐僧', '男', 9000, '2008-08-08', 2);
INSERT INTO `employee` VALUES (4, '白骨精', '女', 5000, '2015-10-07', 3);
INSERT INTO `employee` VALUES (5, '蜘蛛精', '女', 4500, '2011-03-14', 1);
COMMIT;

-- ----------------------------
-- Table structure for lecturer
-- ----------------------------
DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `synopsis` varchar(20) DEFAULT NULL,
  `level` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lecturer
-- ----------------------------
BEGIN;
INSERT INTO `lecturer` VALUES (1, '刘德华', '毕业于清华大学，主攻前端技术', '高级讲师');
INSERT INTO `lecturer` VALUES (2, '郭富城', '毕业于北京大学，多年的IT经验', '首席讲师');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pname` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_name` varchar(32) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('联想电脑', 5000, '电脑办公', 1);
INSERT INTO `product` VALUES ('海尔电脑', 3000, '电脑办公', 2);
INSERT INTO `product` VALUES ('雷神电脑', 5000, '电脑办公', 3);
INSERT INTO `product` VALUES ('JACK JONES', 800, '服装', 4);
INSERT INTO `product` VALUES ('真维斯', 200, '服装', 5);
INSERT INTO `product` VALUES ('花花公子', 440, '服装', 6);
INSERT INTO `product` VALUES ('劲霸', 2000, '服装', 7);
INSERT INTO `product` VALUES ('香奈儿', 800, '女士用品', 8);
INSERT INTO `product` VALUES ('相宜本草', 200, '女士用品', 9);
INSERT INTO `product` VALUES ('面霸', 5, '女士用品', 10);
INSERT INTO `product` VALUES ('雪碧', 56, '饮料饮品', 11);
INSERT INTO `product` VALUES ('香飘飘奶茶', 1, '饮料饮品', 12);
INSERT INTO `product` VALUES ('iPhone9', 8000, NULL, 13);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, '小王', '北京', 20);
INSERT INTO `student` VALUES (2, '小李', '上海', 18);
INSERT INTO `student` VALUES (3, '小周', '北京', 22);
INSERT INTO `student` VALUES (4, '小刘', '北京', 21);
INSERT INTO `student` VALUES (5, '小张', '上海', 22);
INSERT INTO `student` VALUES (6, '小赵', '北京', 17);
INSERT INTO `student` VALUES (7, '小蒋', '上海', 23);
INSERT INTO `student` VALUES (8, '小韩', '北京', 25);
INSERT INTO `student` VALUES (9, '小魏', '上海', 25);
INSERT INTO `student` VALUES (10, '小明', '北京', 20);
COMMIT;

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `student_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
BEGIN;
INSERT INTO `student_course` VALUES (1, 1, 80);
INSERT INTO `student_course` VALUES (1, 2, 90);
INSERT INTO `student_course` VALUES (1, 3, 85);
INSERT INTO `student_course` VALUES (1, 4, 78);
INSERT INTO `student_course` VALUES (2, 2, 53);
INSERT INTO `student_course` VALUES (2, 3, 77);
INSERT INTO `student_course` VALUES (2, 5, 80);
INSERT INTO `student_course` VALUES (3, 1, 71);
INSERT INTO `student_course` VALUES (3, 2, 70);
INSERT INTO `student_course` VALUES (3, 4, 80);
INSERT INTO `student_course` VALUES (3, 5, 65);
INSERT INTO `student_course` VALUES (3, 6, 75);
INSERT INTO `student_course` VALUES (4, 2, 90);
INSERT INTO `student_course` VALUES (4, 3, 80);
INSERT INTO `student_course` VALUES (4, 4, 70);
INSERT INTO `student_course` VALUES (4, 6, 95);
INSERT INTO `student_course` VALUES (5, 1, 60);
INSERT INTO `student_course` VALUES (5, 2, 70);
INSERT INTO `student_course` VALUES (5, 5, 80);
INSERT INTO `student_course` VALUES (5, 6, 69);
INSERT INTO `student_course` VALUES (6, 1, 76);
INSERT INTO `student_course` VALUES (6, 2, 88);
INSERT INTO `student_course` VALUES (6, 3, 87);
INSERT INTO `student_course` VALUES (7, 4, 80);
INSERT INTO `student_course` VALUES (8, 2, 71);
INSERT INTO `student_course` VALUES (8, 3, 58);
INSERT INTO `student_course` VALUES (8, 5, 68);
INSERT INTO `student_course` VALUES (9, 2, 88);
INSERT INTO `student_course` VALUES (10, 1, 77);
INSERT INTO `student_course` VALUES (10, 2, 76);
INSERT INTO `student_course` VALUES (10, 3, 80);
INSERT INTO `student_course` VALUES (10, 4, 85);
INSERT INTO `student_course` VALUES (10, 5, 83);
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES (1, '关羽');
INSERT INTO `teacher` VALUES (2, '张飞');
INSERT INTO `teacher` VALUES (3, '赵云');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

-- 以下为2-1的题目

-- 第一大题
-- 查询练习
	#1.查询所有的商品
    select * from product;
	#2.查询商品名和商品价格
    select pname,price from product;
	#3.别名查询.使用的关键字是as（as可以省略的）.	
    select pname 商品名称,price 商品价格 from product;
	#4.查询商品价格，对价格去除重复；
    select distinct price 商品价格 from product;
	#5.查询结果是表达式（运算查询）：将所有商品的价格+10元进行显示.
    select pname 商品名称, price+10 商品价格 from product;
	#6.查询商品名称为“花花公子”的商品所有信息：
    select * from product where pname = '花花公子';
	#7.查询价格为800商品
    select * from product where price = 800;
	#8.查询价格不是800的所有商品
    select * from product where price != 800;
	#9.查询商品价格大于60元的所有商品信息
    select * from product where price > 60;
	#10.查询商品价格在200到1000之间所有商品
    select * from product where price > 200 and price < 1000;
	#11.查询商品价格是200或800的所有商品
    select * from product where price = 200 or price = 800;
	#12.查询含有'霸'字的所有商品
    select * from product where pname like '%霸%';
	#13.查询以'香'开头的所有商品
    select * from product where pname like '香%';
	#14.查询第二个字为'想'的所有商品
    select * from product where pname like '_想%';
	#15.商品没有分类的商品
    select * from product where category_name is null;
	#16.查询有分类的商品
		select * from product where category_name is not null;
-- 排序练习：
    #1.使用价格对商品信息排序(降序)
    -- 提示：使用order by语句 
		select * from product order by price desc;
    #2.在价格排序(降序)的基础上，以主键排序(降序)
    -- 提示：若价格相同，相同价格的数据以pid降序排序
		select * from product order by price desc, pid desc;
    #3.显示商品的价格(去重复)，并排序(降序)
    -- 提示：DISTINCT 关键字去重 
		select distinct price from product order by price desc;
-- 聚合函数/分组函数练习：
    #1 查询商品的总条数(两种方式)
    -- 提示：使用count()
select count(pname) from product;
select count(price) from product;
    #2 查看price商品的总价格
    -- 提示：使用sum();
select sum(price) from product;
    #3 查看price的最大值和最小值
    -- 提示：使用max()  min()
select max(price) from product;
select min(price) from product;
    #4 查看price的平均值
    -- 提示：使用 AVG() 
select avg(price) from product;
    #5 查询价格大于200商品的总条数
    -- 提示：使用 COUNT(*)统计条数
select count(pid) from product where price > 200;
-- 分组练习：
    #1 统计各个分类商品的个数
select category_name, count(pid) from product GROUP BY category_name;
    #2 统计各个分类商品的个数,且只显示个数大于1的信息
    select category_name, count(pid) from product where category_name is not null GROUP BY category_name;
		
		
-- 第二大题
-- 1) 查询工资最高的员工是谁？
select * from employee where salary = (select max(salary) from employee);
-- 2) 查询工资小于平均工资的员工有哪些？
select * from employee where salary < (select avg(salary) from employee);
-- 3) 查询大于5000的员工，来至于哪些部门，输出部门的名字
select name from (select dept_id from employee where salary > 5000) b LEFT JOIN dept a on a.id = b.dept_id;
-- 4) 查询开发部与财务部所有的员工信息，分别使用子查询和表连接实现
-- 子查询：
select * from employee where dept_id = (select id from dept where name = '开发部') or dept_id = (select id from dept where name = '财务部');
-- 表连接查询：
-- 5) 查询2011年以后入职的员工信息和部门信息，分别使用子查询和表连接实现

-- 第三大题

-- 第一题
-- 1、查询平均成绩大于70分的同学的学号,姓名,和平均成绩
select 
s.name, avg(sc.score), s.id
from student_course sc join student s
on sc.student_id = s.id
GROUP BY sc.student_id 
HAVING avg(sc.score) > 70;
-- 1.1 分组查询每个学生的 学号,姓名,平均分
select 
s.name, avg(sc.score), s.id
from student_course sc join student s
on sc.student_id = s.id
GROUP BY sc.student_id;
-- 1.2 增加条件：平均成绩大于70
select 
s.name, avg(sc.score), s.id
from student_course sc join student s
on sc.student_id = s.id
GROUP BY sc.student_id 
HAVING avg(sc.score) > 70;

-- 第二题
-- 2. 查询所有同学的学号、姓名、选课数、总成绩
select 
s.id, s.name, count(sc.course_id), sum(sc.score) 
from student as s join student_course as sc 
on s.id = sc.student_id 
group by sc.student_id;
-- 2.1 需要查询两张表 student表和 student_course表
-- 2.2 需要使用 student_id 学号字段,进行分组
-- 2.3 需要使用到 count函数 sum函数

-- 第三题
-- 3. 查询学过赵云老师课程的同学的学号、姓名
select 
s.id, s.name 
from student s join student_course sc 
on s.id = sc.student_id 
where sc.course_id = (select 
co.id
from teacher te join course co
on te.id = co.teacher_id
where te.name = '赵云');
-- 3.1 查询赵云老师的id
-- 3.2 根据老师ID,在课程表中查询所教的课程编号
-- 3.3 将上面的子查询作为 where 后面的条件

-- 第四题
-- 4. 查询选课 少于三门学科的学员		
select 
s.id, s.name
from student_course sc join student s 
on sc.student_id = s.id 
group by sc.student_id 
having count(sc.course_id) < 3;
-- 4.1 查询每个学生学了几门课 条件1：小于等于三门
-- 4.2 查询 学号和姓名， 将4.1 作为临时表


-- 第四大题

-- 讲师表
		-- 讲师ID 主键 int类型
		-- 讲师姓名 VARCHAR类型
		-- 讲师简介 VARCHAR类型
		-- 讲师级别 char类型 高级讲师&首席讲师
		-- 为讲师姓名添加索引
		
		create table lecturer(
	id int primary key,
	name varchar(20),
	synopsis varchar(20),
	level char(20),
	INDEX(name)
)
		
-- 课程分类表
		-- 课程分类ID 主键 int类型
		-- 课程分类名称 VARCHAR类型 比如前端开发 后端开发 数据库DBA......
		-- 课程分类描述 VARCHAR类型 
		-- 创建时间 datetime类型
		-- 更新时间 datetime类型
		
		create table curriculum_class (
	id int primary key,
	name varchar(20),
	class_describe varchar(20),
	creation_time datetime,
	update_time datetime
);
		
-- 课程表
		-- 课程ID 主键 int类型
		-- 课程讲师ID 外键 用于描述课程的授课老师
		-- 课程分类ID 外键 用于描述课程所属的分类 比如 Java课程就属于后端分类
		-- 课程标题 VARCHAR类型 比如Java VUE PHP ......
		-- 总课时 int类型 
		-- 浏览数量 bigint类型
		-- 课程状态 char 类型,  0 未发布(默认)  1 已发布
		-- 为 课程标题字段添加索引
		-- 为 teacher_id & subject_id,添加外键约束
		
		create table curriculum (
	id int primary key,
	lecturer_id int,
	curriculum_class_id int,
	curriculum_title varchar(20),
	curriculum_num int,
	browse_num int,
	curriculum_state char(5),
	foreign key (lecturer_id) REFERENCES lecturer(id),
	foreign key (curriculum_class_id) references curriculum_class(id),
	index(curriculum_title)
);

-- 查询刘德华老师所教的课程属于哪个课程分类
select 
name
from curriculum_class 
where id = (select 
curriculum_class_id
from lecturer le join curriculum cu 
on le.id = cu.lecturer_id 
where le.name = '刘德华');

