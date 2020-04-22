BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `system` (
	`mac_address`	TEXT,
	`date`	TEXT,
	`type`	TEXT,
	PRIMARY KEY(`mac_address`)
);
INSERT INTO `system` VALUES ('ea5e8e092a222cea7e4de4a4e9fbeabea6406ea32ee4601','04 February 2019',NULL);
INSERT INTO `system` VALUES ('032ea0e89e6be5fe682ae680dea2e9f26d080ea6e41ea9e4a','08 February 2019',NULL);
CREATE TABLE IF NOT EXISTS `student` (
	`s_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`s_name`	TEXT,
	`surname`	TEXT,
	`gender`	TEXT,
	`guardian`	TEXT,
	`guardian_relation`	TEXT,
	`guardian_contact`	TEXT,
	`dob`	TEXT,
	`cnic`	TEXT,
	`contact_no`	TEXT,
	`address`	TEXT,
	`doa`	TEXT,
	`religion`	TEXT,
	`nationality`	TEXT,
	`pic_path`	TEXT,
	`matric_board`	TEXT,
	`matric_marks`	INTEGER,
	`matric_pass_year`	TEXT,
	`matric_seat_no`	TEXT,
	`inter_board`	TEXT,
	`inter_marks`	INTEGER,
	`inter_pass_year`	TEXT,
	`inter_seat_no`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `student` VALUES (1,'Amjad','Dahri','Male','Ghullam Shabir','Father','3456-7543213','01 January 1995','83492-4908123-4','4920-5243092','DPur','31 January 2019','Islam','Pakistani',NULL,'BISE Sukkur',123,'2010','123','BISE Larkana',123,'2010','123','0',41,'Thu Jan 17 19:40:07 PKT 2019',41,'Fri Feb 08 22:23:52 PKT 2019');
INSERT INTO `student` VALUES (2,'Javed Ali','Dahri','Male','Taj Muhammad Dahri','Father','0302-3454354','06 March 1997','45401-3535834-3','0302-3545931','Shahpur Chakar','07 February 2019','Islam','Pakistani',NULL,'BISE Hyderabad',123,'2010','123','BISE Hyderabad',123,'2010','12','0',41,'Sat Feb 02 14:50:21 PKT 2019',41,'Fri Feb 08 22:23:49 PKT 2019');
INSERT INTO `student` VALUES (15,'Eman','Dahri','Female','Ghullam Shabir','Father','0342-3492304','01 January 1995','29342-0498204-9','0323-4424982','Daulat Pur','08 February 2019','Islam','Pakistani',NULL,'BISE Hyderabad',23,'2010','4567','BISE Hyderabad',23,'2010','23','0',41,'Thu Feb 07 23:38:27 PKT 2019',41,'Fri Feb 08 22:23:36 PKT 2019');
INSERT INTO `student` VALUES (23,'Amjad Ali','Dahri','Male','Ghullam Shabir','Father','0342-4234920','02 October 1998','32423-4239402-4','0323-4234293','SBA','08 February 2019','Islam','Pakistani','D:\Programing Material\NetBeansProjects\MSStarAcademy\StudentImages\32423-4239402-4_Amjad Ali.jpg','BISE Hyderabad',684,'2014','3345','BISE Hyderabad',944,'2016','5678','1',41,'Fri Feb 08 22:27:04 PKT 2019',NULL,NULL);
INSERT INTO `student` VALUES (24,'Muhammad Bilal','Bhatti','Male','Wasi','Father','0344-2342348','07 October 1998','45401-3429820-3','0302-3432423','Sukkur','08 February 2019','Islam','Pakistani','D:\Programing Material\NetBeansProjects\MSStarAcademy\StudentImages\45401-3429820-3_Muhammad Bilal.jpg','BISE Sukkur',690,'2014','3434','BISE Sukkur',911,'2016','43242','1',41,'Fri Feb 08 22:28:50 PKT 2019',NULL,NULL);
CREATE TABLE IF NOT EXISTS `shift` (
	`shift_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`shift_title`	TEXT,
	`start_time`	TEXT,
	`end_time`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `shift` VALUES (1,'Morning Shift','9:00am','11:00 am','1',1,NULL,NULL,NULL);
INSERT INTO `shift` VALUES (2,'New Shift','7:00 AM','9:00 AM','1',41,'Fri Jan 18 16:51:39 PKT 2019',NULL,NULL);
INSERT INTO `shift` VALUES (3,'Evening Shift','3:00 PM','5:00 PM','1',41,'Fri Jan 18 16:55:10 PKT 2019',NULL,NULL);
INSERT INTO `shift` VALUES (4,'Evening Shift','3:00 PM','5:00 PM','0',41,'Wed Feb 06 03:12:15 PKT 2019',11,'Wed Feb 06 03:12:21 PKT 2019');
CREATE TABLE IF NOT EXISTS `sbsc_bridge` (
	`bt_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`student_id`	INTEGER,
	`batch_id`	INTEGER,
	`shift_id`	INTEGER,
	`course_id`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	INTEGER,
	FOREIGN KEY(`student_id`) REFERENCES `student`(`s_id`),
	FOREIGN KEY(`shift_id`) REFERENCES `shift`(`shift_id`),
	FOREIGN KEY(`course_id`) REFERENCES `course`(`course_id`),
	FOREIGN KEY(`batch_id`) REFERENCES `batch`(`batch_id`)
);
INSERT INTO `sbsc_bridge` VALUES (4,23,19,1,18,'1',41,'Fri Feb 08 22:35:18 PKT 2019',NULL,NULL);
INSERT INTO `sbsc_bridge` VALUES (5,24,38,3,20,'1',41,'Fri Feb 08 22:35:45 PKT 2019',NULL,NULL);
CREATE TABLE IF NOT EXISTS `role_permission` (
	`role_permission_id`	INTEGER,
	`role_id`	INTEGER,
	`permission_id`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT,
	PRIMARY KEY(`role_permission_id`),
	FOREIGN KEY(`role_id`) REFERENCES `role`(`role_id`),
	FOREIGN KEY(`permission_id`) REFERENCES `permission`(`permission_id`)
);
INSERT INTO `role_permission` VALUES (3,3,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (11,3,4,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (12,3,2,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (13,3,5,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (14,5,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (15,5,2,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (17,5,4,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (18,5,5,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (19,5,6,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (21,5,8,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (22,7,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (23,7,2,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (24,7,3,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (25,7,4,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (26,7,5,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (27,7,6,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (28,7,7,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (29,7,8,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (30,1,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (31,1,2,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (32,1,3,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (33,1,4,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (34,1,5,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (35,1,6,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (36,1,7,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (37,1,8,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (38,5,38,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (40,5,9,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (41,5,10,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (43,5,12,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (44,5,13,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (45,5,14,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (46,5,15,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (48,5,17,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (49,5,18,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (51,5,20,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (52,5,21,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (53,5,22,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (55,5,24,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (56,5,25,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (57,5,26,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (58,5,27,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (59,5,28,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (60,5,29,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (61,5,30,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (62,5,31,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (63,5,32,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (65,5,34,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (66,5,35,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (67,5,36,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (68,5,37,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (69,5,40,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (70,5,41,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (71,5,42,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (73,5,7,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (74,5,3,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (75,5,11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (76,5,16,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (77,5,19,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (78,5,23,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (79,5,33,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (80,5,44,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (81,5,39,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (82,5,43,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (83,5,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (84,5,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (85,5,9,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (86,5,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (87,5,1,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `role_permission` VALUES (88,5,18,NULL,NULL,NULL,NULL,NULL);
CREATE TABLE IF NOT EXISTS `role` (
	`role_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`role`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `role` VALUES (1,'Admin','0',1,'25 December','',NULL);
INSERT INTO `role` VALUES (3,'Teacher','1',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Fri Feb 08 00:00:00 PKT 2019');
INSERT INTO `role` VALUES (4,'User','0',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `role` VALUES (5,'Admin','1',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Sun Jan 06 00:00:00 PKT 2019');
INSERT INTO `role` VALUES (6,'User','0',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `role` VALUES (7,'User','1',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Fri Feb 08 00:00:00 PKT 2019');
INSERT INTO `role` VALUES (8,'Owner','1',1,'Wed Jan 09 00:00:00 PKT 2019',1,'Fri Feb 08 00:00:00 PKT 2019');
INSERT INTO `role` VALUES (9,'Manager','1',1,'Fri Feb 08 00:00:00 PKT 2019',NULL,NULL);
CREATE TABLE IF NOT EXISTS `permission` (
	`permission_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`permission_title`	TEXT
);
INSERT INTO `permission` VALUES (1,'View Student');
INSERT INTO `permission` VALUES (2,'Update Student');
INSERT INTO `permission` VALUES (3,'Add Student');
INSERT INTO `permission` VALUES (4,'Delete Student');
INSERT INTO `permission` VALUES (5,'View Batch');
INSERT INTO `permission` VALUES (6,'Update Batch');
INSERT INTO `permission` VALUES (7,'Add Batch');
INSERT INTO `permission` VALUES (8,'Delete Batch');
INSERT INTO `permission` VALUES (9,'View Expenses');
INSERT INTO `permission` VALUES (10,'Update Expenses');
INSERT INTO `permission` VALUES (11,'Add Expenses');
INSERT INTO `permission` VALUES (12,'Delete Expenses');
INSERT INTO `permission` VALUES (13,'View Profit');
INSERT INTO `permission` VALUES (14,'View Employee');
INSERT INTO `permission` VALUES (15,'Update Employee');
INSERT INTO `permission` VALUES (16,'Add Employee');
INSERT INTO `permission` VALUES (17,'Delete Employee');
INSERT INTO `permission` VALUES (18,'View Shift');
INSERT INTO `permission` VALUES (19,'Update Shift');
INSERT INTO `permission` VALUES (20,'Add Shift');
INSERT INTO `permission` VALUES (21,'Delete Shift');
INSERT INTO `permission` VALUES (22,'View Expense Type');
INSERT INTO `permission` VALUES (23,'Update Expense Type');
INSERT INTO `permission` VALUES (24,'Add Expense Type');
INSERT INTO `permission` VALUES (25,'Delete Expense Type');
INSERT INTO `permission` VALUES (26,'View Course Assignment');
INSERT INTO `permission` VALUES (27,'Update Course Assignment');
INSERT INTO `permission` VALUES (28,'Add Course Assignment');
INSERT INTO `permission` VALUES (29,'Delete Course Assignment');
INSERT INTO `permission` VALUES (30,'View Course');
INSERT INTO `permission` VALUES (31,'Update Course');
INSERT INTO `permission` VALUES (32,'Add Course');
INSERT INTO `permission` VALUES (33,'Delete Course');
INSERT INTO `permission` VALUES (34,'View Fees');
INSERT INTO `permission` VALUES (35,'Update Fees');
INSERT INTO `permission` VALUES (36,'Add Fees');
INSERT INTO `permission` VALUES (37,'Delete Fees');
INSERT INTO `permission` VALUES (38,'View Permissions');
INSERT INTO `permission` VALUES (39,'Update Permissions');
INSERT INTO `permission` VALUES (40,'View Role');
INSERT INTO `permission` VALUES (41,'Update Role');
INSERT INTO `permission` VALUES (42,'Add Role');
INSERT INTO `permission` VALUES (43,'Delete Role');
INSERT INTO `permission` VALUES (44,'Print Slip');
CREATE TABLE IF NOT EXISTS `fees` (
	`fees_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`fee_type_id`	INTEGER,
	`bt_id`	INTEGER,
	`amount`	INTEGER,
	`date_of_paid`	TEXT,
	`no_of_months`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT,
	FOREIGN KEY(`fee_type_id`) REFERENCES `fee_type`(`fee_type_id`),
	FOREIGN KEY(`bt_id`) REFERENCES `sbsc_bridge`(`bt_id`)
);
INSERT INTO `fees` VALUES (13,1,4,1200,'13 February 2019',1,'1',41,'08 February 2019',NULL,NULL);
CREATE TABLE IF NOT EXISTS `fee_type` (
	`fee_type_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`fee_title`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `fee_type` VALUES (1,'Admission','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (2,'Monthly Tution','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (3,'ID Card Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (4,'Form Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (5,'Board Registration Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (6,'Board Exam Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (7,'Board Late Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (8,'Certificate Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (9,'Marks Sheet Fee','1',NULL,NULL,NULL,NULL);
INSERT INTO `fee_type` VALUES (10,'Test Exam Fee','1',NULL,NULL,NULL,NULL);
CREATE TABLE IF NOT EXISTS `expense_type` (
	`exp_type_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`exp_type_title`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `expense_type` VALUES (1,'Electricity Bill','1',1,'26 December 2018',NULL,NULL);
INSERT INTO `expense_type` VALUES (2,'Sui Gas Bill','1',1,'Wed Dec 26 00:00:00 PKT 2018',NULL,NULL);
INSERT INTO `expense_type` VALUES (3,'hallaa thaii','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (4,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (5,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (6,'New Bill','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (7,'hhahahah','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (8,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (9,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (10,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (11,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (12,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (13,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (14,'Enter expense type here','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (15,'Guest Bill','0',1,'Wed Dec 26 00:00:00 PKT 2018',1,'Wed Dec 26 00:00:00 PKT 2018');
INSERT INTO `expense_type` VALUES (16,'Guest Bill','1',1,'Wed Dec 26 00:00:00 PKT 2018',NULL,NULL);
INSERT INTO `expense_type` VALUES (17,'Rent','1',1,'Thu Jan 03 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `expense_type` VALUES (18,'Utility Bill','1',1,'Thu Jan 03 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `expense_type` VALUES (19,'Other Expense','1',1,'Thu Jan 03 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `expense_type` VALUES (20,'Employee Salary','1',1,'Sat Jan 05 00:00:00 PKT 2019',1,'Thu Jan 31 00:00:00 PKT 2019');
CREATE TABLE IF NOT EXISTS `expense` (
	`expense_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`exp_type_id`	INTEGER,
	`expense_title`	TEXT,
	`emp_id`	INTEGER,
	`amount`	INTEGER,
	`status`	TEXT,
	`date_of_payment`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT,
	FOREIGN KEY(`emp_id`) REFERENCES `employee`(`emp_id`),
	FOREIGN KEY(`exp_type_id`) REFERENCES `expense_type`(`exp_type_id`)
);
INSERT INTO `expense` VALUES (48,2,NULL,NULL,1200,'monthly','08 January 2019','1',1,'2019-01-08 23:55:00.649',NULL,NULL);
INSERT INTO `expense` VALUES (49,18,NULL,NULL,2500,'monthly','31 January 2019','1',1,'2019-01-08 23:55:23.079',1,'2019-01-09 01:25:04.962');
INSERT INTO `expense` VALUES (50,NULL,'Guest Bills',NULL,100,'daily','08 January 2019','1',1,'2019-01-08 23:56:01.546',1,'2019-01-19 18:10:22.553');
INSERT INTO `expense` VALUES (51,20,NULL,1,12000,'monthly','04 January 2019','1',1,'2019-01-09 00:03:05.256',1,'2019-02-02 18:19:20.656');
INSERT INTO `expense` VALUES (52,2,NULL,NULL,2000,'monthly','03 February 2019','0',1,'2019-01-09 00:21:35.804',1,'2019-01-09 01:31:32.221');
INSERT INTO `expense` VALUES (62,NULL,NULL,2,12,'owner','04 January 2019','1',1,'2019-01-09 02:46:05.002',NULL,NULL);
INSERT INTO `expense` VALUES (63,NULL,NULL,2,12,'owner','04 January 2019','1',1,'2019-01-09 02:46:06.761',NULL,NULL);
INSERT INTO `expense` VALUES (64,20,NULL,1,1234,'monthly','13 January 2019','1',1,'2019-01-13 20:01:48.27',NULL,NULL);
INSERT INTO `expense` VALUES (65,NULL,NULL,4,1200,'owner','02 January 2019','0',1,'2019-01-18 17:45:36.636',1,'2019-01-19 15:21:18.423');
INSERT INTO `expense` VALUES (66,20,NULL,3,1200,'monthly','11 January 2019','1',1,'2019-01-18 17:46:26.362',1,'2019-01-30 23:31:42.296');
INSERT INTO `expense` VALUES (67,NULL,'New Expense',NULL,1200,'daily','18 January 2019','1',1,'2019-01-18 17:47:40.135',NULL,NULL);
INSERT INTO `expense` VALUES (68,NULL,'New Expense',NULL,1200,'daily','18 January 2019','0',1,'2019-01-18 17:48:04.813',1,'2019-01-19 18:09:58.007');
INSERT INTO `expense` VALUES (69,NULL,NULL,2,1234,'owner','19 January 2019','0',1,'2019-01-19 15:20:42.436',1,'2019-01-19 16:32:47.812');
INSERT INTO `expense` VALUES (70,NULL,'Water Expense',NULL,1500,'daily','19 January 2019','0',1,'2019-01-19 18:10:15.969',1,'2019-01-19 20:51:47.345');
INSERT INTO `expense` VALUES (71,NULL,'Guest Bills',NULL,100,'daily','08 January 2019','0',1,'2019-01-19 18:10:28.532',1,'2019-01-19 18:10:46.133');
INSERT INTO `expense` VALUES (72,NULL,'Guest Bills',NULL,100,'daily','08 January 2019','0',1,'2019-01-19 18:10:41.221',1,'2019-01-19 18:10:44.386');
INSERT INTO `expense` VALUES (73,NULL,'Computer Repair',NULL,123,'daily','19 January 2019','0',1,'2019-01-19 18:17:06.825',1,'2019-01-30 23:30:24.451');
INSERT INTO `expense` VALUES (75,18,NULL,NULL,1000,'monthly','01 February 2019','1',1,'2019-02-02 17:16:33.6',NULL,NULL);
INSERT INTO `expense` VALUES (76,19,NULL,NULL,112,'monthly','21 February 2019','1',1,'2019-02-02 17:16:47.827',NULL,NULL);
INSERT INTO `expense` VALUES (77,NULL,'XYZ ',NULL,1200,'daily','08 February 2019','0',1,'2019-02-02 17:20:32.476',1,'2019-02-06 01:41:55.384');
INSERT INTO `expense` VALUES (78,NULL,NULL,4,100,'owner','01 February 2019','1',1,'2019-02-02 17:20:50.584',NULL,NULL);
INSERT INTO `expense` VALUES (79,NULL,'Sudden Guest',NULL,200,'daily','20 January 2019','1',1,'2019-02-02 18:11:53.453',NULL,NULL);
INSERT INTO `expense` VALUES (80,20,NULL,3,1200,'monthly','01 February 2019','1',1,'2019-02-02 19:18:45.058',NULL,NULL);
CREATE TABLE IF NOT EXISTS `employee` (
	`emp_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`emp_name`	TEXT,
	`surname`	TEXT,
	`cnic`	TEXT,
	`sal_type`	TEXT,
	`sal_value`	INTEGER,
	`contact`	TEXT,
	`dob`	TEXT,
	`gender`	TEXT,
	`address`	TEXT,
	`specialization`	TEXT,
	`experience`	TEXT,
	`hire_date`	TEXT,
	`role_id`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT,
	`user_name`	TEXT,
	`password`	TEXT,
	`q_id`	TEXT,
	`answer`	TEXT,
	`pic_path`	TEXT,
	FOREIGN KEY(`role_id`) REFERENCES `role`(`role_id`)
);
INSERT INTO `employee` VALUES (1,'Amjad','Dahri','45401-9915447-7','Fixed',15000,'0305-8328689','02 October 2018','Male','Daulat Pur','None','2 ','05 February 2019',5,'1',1,'02 Nov 2018',41,'Tue Feb 05 15:24:52 PKT 2019','admin','admin','Nick Name?','Ali','');
INSERT INTO `employee` VALUES (2,'Javed','Dahri','45401-9915447-7','Fixed',NULL,'03058328689','02 October 2018','Male',NULL,NULL,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `employee` VALUES (3,'Mushahid','Drigh','23456-7876543-4','Fixed',2345,'2345-6765433','01 February 1985','Male','Ghotki','Poetry','2 Years','17 January 2019',3,'1',41,'Thu Jan 17 20:03:49 PKT 2019',41,'Thu Jan 17 20:04:15 PKT 2019','','','-1','','');
INSERT INTO `employee` VALUES (4,'Waqar','Bhatti','54502-4982437-2','Fixed',12000,'0333-4544345','01 February 1985','Male','Badin','None','2 Years','18 January 2019',8,'0',41,'Fri Jan 18 17:44:45 PKT 2019',41,'Sat Jan 19 19:18:23 PKT 2019','','','-1','','');
INSERT INTO `employee` VALUES (5,'Jawad','Zour','45401-4234782-9','Fixed',1234,'0323-8239283','01 February 1985','Male','sujawal','Nothing','2','02 February 2019',3,'0',41,'Sat Feb 02 15:09:13 PKT 2019',41,'Fri Feb 08 09:27:06 PKT 2019','','','-1','','');
INSERT INTO `employee` VALUES (6,'Tahir','Magsi','45454-0234892-4','Fixed',123,'0302-3324234','04 February 1985','Male','Karachi','Programming','5 year','03 February 2019',7,'1',41,'Sun Feb 03 23:22:40 PKT 2019',NULL,NULL,'','','-1','','');
INSERT INTO `employee` VALUES (7,'Faiz','Korai','31984-8923374-1','Percentage',12,'4239-8472948','15 February 1985','Male','Larkana','Hawal','12','05 February 2019',7,'0',41,'Tue Feb 05 14:04:01 PKT 2019',41,'Tue Feb 05 15:24:55 PKT 2019','','','-1','','');
INSERT INTO `employee` VALUES (8,'Jawad','Zour','45401-4234782-9','Fixed',1234,'0323-8239283','01 February 1985','Male','sujawal','Nothing','2','06 February 2019',3,'0',41,'Wed Feb 06 02:49:03 PKT 2019',41,'Fri Feb 08 01:41:39 PKT 2019','','','-1','','');
INSERT INTO `employee` VALUES (9,'Nandlal','Khatri','45403-5903249-2','Fixed',12000,'0342-4234249','13 February 1985','Male','Umarkot','Mathematics','1','08 February 2019',3,'1',41,'Fri Feb 08 09:26:29 PKT 2019',41,'Fri Feb 08 09:26:45 PKT 2019','','','-1','','');
INSERT INTO `employee` VALUES (10,'Muhammad Waqar','Bhatti','45400-3442423-4','Fixed',12000,'0332-2334324','22 February 1985','Male','Badin','Programming','','08 February 2019',7,'0',41,'Fri Feb 08 21:35:41 PKT 2019',41,'Fri Feb 08 21:53:49 PKT 2019','waqarali','iloveyou','Best Teacher Name?','kaleemullah','');
INSERT INTO `employee` VALUES (11,'Muhammad Waqar','Bhatti','45400-3442423-4','Fixed',12000,'0332-2334324','22 February 1985','Male','Badin','Programming','','08 February 2019',7,'0',41,'Fri Feb 08 21:40:40 PKT 2019',41,'Fri Feb 08 21:40:46 PKT 2019','fdsfdsf','iloveyou','Best Teacher Name?','kaleemullah','');
INSERT INTO `employee` VALUES (12,'Nandlal','Khatri','45403-5903249-2','Fixed',12000,'0342-4234249','13 February 1985','Male','Umarkot','Mathematics','1','08 February 2019',3,'0',41,'Fri Feb 08 21:53:53 PKT 2019',41,'Fri Feb 08 21:53:56 PKT 2019','','','','','');
INSERT INTO `employee` VALUES (13,'Nandlal','Khatri','45403-5903249-2','Fixed',12000,'0342-4234249','13 February 1985','Male','Umarkot','Mathematics','1','08 February 2019',3,'0',41,'Fri Feb 08 22:02:26 PKT 2019',41,'Fri Feb 08 22:02:31 PKT 2019','','','','','');
INSERT INTO `employee` VALUES (14,'Nandlal','Khatri','45403-5903249-2','Fixed',12000,'0342-4234249','13 February 1985','Male','Umarkot','Mathematics','1','08 February 2019',3,'0',41,'Fri Feb 08 22:04:28 PKT 2019',41,'Fri Feb 08 22:04:42 PKT 2019','','','','','');
INSERT INTO `employee` VALUES (15,'Nandlal','Khatri','45403-5903249-2','Fixed',12000,'0342-4234249','13 February 1985','Male','Umarkot','Mathematics','1','08 February 2019',3,'0',41,'Fri Feb 08 22:04:35 PKT 2019',41,'Fri Feb 08 22:04:38 PKT 2019','','','','','');
CREATE TABLE IF NOT EXISTS `course` (
	`course_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`course_title`	TEXT,
	`duration`	TEXT,
	`main_course`	INTEGER,
	`active`	INTEGER,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT,
	FOREIGN KEY(`main_course`) REFERENCES `course`(`course_id`)
);
INSERT INTO `course` VALUES (1,'MS Word','10',NULL,0,NULL,NULL,1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (2,'programming','1 Year',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (3,'Enter sub course here','Enter duration of the course',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (4,'Enter sub course here','Enter duration of the course',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (5,'English Language','4',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (6,'Communication Skills','20',5,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (7,'Networking','6 months',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (8,'Digital Communication','4 months',7,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (9,'Java','6 months',2,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (10,'Web developement',' 2 years',2,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (11,'MOS','6 Months',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (12,'PPT','1 Month',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (13,'DIT','12 Months',NULL,1,1,'Tue Dec 25 00:00:00 PKT 2018',NULL,NULL);
INSERT INTO `course` VALUES (14,'CIT','06 Months',NULL,1,1,'Tue Dec 25 00:00:00 PKT 2018',NULL,NULL);
INSERT INTO `course` VALUES (15,'CSC','04 Monhts',NULL,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (16,'Office Automation','04 Months',NULL,0,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (17,'Office Automations','04 Months',15,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (18,'A+ Hardware & Networking','04 Months',13,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Mon Jan 07 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (19,'Web Designing & DP','04 Months',15,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Feb 05 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (20,'English Language','------',NULL,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Dec 25 00:00:00 PKT 2018');
INSERT INTO `course` VALUES (21,'ELC','----',20,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Feb 05 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (22,'Basic Grammer & Conversation','-----',20,1,1,'Tue Dec 25 00:00:00 PKT 2018',NULL,NULL);
INSERT INTO `course` VALUES (23,'Coaching','------',NULL,1,1,'Tue Dec 25 00:00:00 PKT 2018',1,'Tue Feb 05 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (24,'eng ','4 year',15,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (25,'java  ','3/3/2',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (26,'djdj','322',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (27,'shdf','djfhdsf',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (28,'hdfjds','ndsbfsdnb',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (29,'dbfsdbf','sdbfnsmbf',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (30,'ndsbfsmnf','sbdfsnbfs',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (31,'sdbfks','sdmbfsdf',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (32,'nsdbfmnsf','nsbfsnf',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (33,'sdhbfsj','sbsdfbs',NULL,0,1,'Fri Jan 04 00:00:00 PKT 2019',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `course` VALUES (34,'Java','6 Months',NULL,1,1,'Sun Jan 06 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `course` VALUES (35,'Literature','2 Months',20,1,1,'Mon Jan 07 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `course` VALUES (36,'Java','6Months',NULL,1,1,'Thu Jan 17 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `course` VALUES (37,'Data structures','6 months',36,1,1,'Thu Jan 17 00:00:00 PKT 2019',NULL,NULL);
INSERT INTO `course` VALUES (38,'Speaking Classes','4 Months',20,1,1,'Thu Jan 17 00:00:00 PKT 2019',NULL,NULL);
CREATE TABLE IF NOT EXISTS `batch` (
	`batch_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`batch_title`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `batch` VALUES (19,'Java','1',1,'Tue Dec 25 15:03:45 PKT 2018',NULL,NULL);
INSERT INTO `batch` VALUES (20,'Spiders Batch','1',1,'Tue Dec 25 15:04:44 PKT 2018',1,'Fri Jan 04 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (21,'PHP Batch','1',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Mon Feb 04 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (36,'Debuggers Batch','1',1,'Tue Dec 25 00:00:00 PKT 2018',1,'Sat Jan 19 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (38,'Leet Solutions Batch','1',1,'Fri Jan 04 00:00:00 PKT 2019',1,'Thu Jan 17 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (39,'Java Freshers','1',1,'Fri Jan 04 00:00:00 PKT 2019',1,'Mon Jan 07 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (40,'Leet Solutions Batch','1',1,'Mon Jan 07 00:00:00 PKT 2019',1,'Thu Jan 31 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (41,'Java Freshers','1',1,'Mon Jan 07 00:00:00 PKT 2019',1,'Mon Feb 04 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (42,'PHP Batch','1',1,'Mon Jan 07 00:00:00 PKT 2019',1,'Mon Jan 07 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (43,'Java Freshers','1',1,'Mon Jan 07 00:00:00 PKT 2019',1,'Mon Feb 04 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (44,'Leet Solutions Batch','1',1,'Mon Jan 07 00:00:00 PKT 2019',1,'Thu Jan 17 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (45,'Java SE batch','1',1,'Thu Jan 17 00:00:00 PKT 2019',1,'Fri Feb 08 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (46,'stzfdf','0',1,'Thu Jan 31 00:00:00 PKT 2019',1,'Mon Feb 04 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (47,'12121','0',1,'Thu Jan 31 00:00:00 PKT 2019',1,'Mon Feb 04 00:00:00 PKT 2019');
INSERT INTO `batch` VALUES (48,'Web Development Batch','0',1,'Fri Feb 08 00:00:00 PKT 2019',1,'Fri Feb 08 00:00:00 PKT 2019');
COMMIT;
