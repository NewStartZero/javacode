CREATE DATABASE test2 DEFAULT CHARSET=utf8;
USE test2;
CREATE TABLE users
(uid VARCHAR(6) PRIMARY KEY,pw VARCHAR(15),root VARCHAR(20) NOT NULL DEFAULT '普通用户')
ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO users (uid, pw, root) VALUES
('158468', '123456', '管理员'),
('158464', '123456', '普通用户'),
('158466', '123456', '普通用户'),
('158465', '123456', '普通用户'),
('158463', '123456', '普通用户');



CREATE TABLE depart(did VARCHAR(5) PRIMARY KEY,dname VARCHAR(30));
INSERT INTO depart (did, dname) VALUES
('1001', '销售部门'),
('1002', '市场部门'),
('1003', '财务部门'),
('1004', '人力资源部'),
('1005', '研发部门');

CREATE TABLE position1(pid VARCHAR(5) PRIMARY KEY,pname VARCHAR(20));
INSERT INTO position1 (pid, pname) VALUES
('2001', '经理'),
('2002', '工程师'),
('2003', '销售代表'),
('2004', '分析师'),
('2005', '员工');

CREATE TABLE Employee
(eid VARCHAR(5) PRIMARY KEY,ename VARCHAR(10),sex CHAR(2),idNumber VARCHAR(10),
pid VARCHAR(4),did VARCHAR(4),uid VARCHAR(6));
INSERT INTO Employee (eid, ename, sex, idNumber, pid, did, uid) VALUES
('3001', '张三', '男', '1234567890', '2001', '1005', '158468'),
('3002', '李四', '男', '0987654321', '2002', '1001', '158466'),
('3003', '王五', '男', '9876543210', '2003', '1002', '158465'),
('3004', '赵六', '女', '6789012345', '2004', '1003', '158464'),
('3005', '刘七', '女', '5432109876', '2005', '1004', '158463');


CREATE TABLE notice(nid VARCHAR(5),txtSave VARCHAR(1000));
INSERT INTO notice (nid, txtSave) VALUES
('5001', '这是第一条通知内容。'),
('5002', '这是第二条通知内容。'),
('5003', '这是第三条通知内容。');
COMMIT;


SELECT * FROM users;
SELECT * FROM employee;
SELECT * FROM depart;
SELECT * FROM notice;
SELECT * FROM position1;


DROP TABLE users;
DROP TABLE employee;
DROP TABLE depart;
DROP TABLE notice;
DROP TABLE position1;

SELECT uid FROM users WHERE uid = '158468';
SELECT * FROM users WHERE root LIKE %'管'%;
SELECT COUNT(root) ct FROM users GROUP BY root HAVING root='管理员';

