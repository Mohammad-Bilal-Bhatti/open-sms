BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `system` (
	`mac_address`	TEXT,
	`date`	TEXT,
	`type`	TEXT,
	PRIMARY KEY(`mac_address`)
);
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
	FOREIGN KEY(`course_id`) REFERENCES `course`(`course_id`),
	FOREIGN KEY(`shift_id`) REFERENCES `shift`(`shift_id`),
	FOREIGN KEY(`batch_id`) REFERENCES `batch`(`batch_id`)
);
CREATE TABLE IF NOT EXISTS `role_permission` (
	`role_permission_id`	INTEGER,
	`role_id`	INTEGER,
	`permission_id`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT,
	FOREIGN KEY(`permission_id`) REFERENCES `permission`(`permission_id`),
	PRIMARY KEY(`role_permission_id`),
	FOREIGN KEY(`role_id`) REFERENCES `role`(`role_id`)
);
INSERT INTO `role_permission` VALUES (1,1,1,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (2,1,2,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (3,1,3,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (4,1,4,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (5,1,5,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (6,1,6,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (7,1,7,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (8,1,8,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (9,1,9,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (10,1,10,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (11,1,11,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (12,1,12,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (13,1,13,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (14,1,14,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (15,1,15,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (16,1,16,'1',1,NULL,1,NULL);
INSERT INTO `role_permission` VALUES (17,1,17,'1',1,NULL,1,NULL);
CREATE TABLE IF NOT EXISTS `role` (
	`role_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`role`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `role` VALUES (1,'admin','1',1,'',1,'');
CREATE TABLE IF NOT EXISTS `permission` (
	`permission_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`permission_title`	TEXT
);
INSERT INTO `permission` VALUES (1,'student');
INSERT INTO `permission` VALUES (2,'batch');
INSERT INTO `permission` VALUES (3,'expenses');
INSERT INTO `permission` VALUES (4,'profit');
INSERT INTO `permission` VALUES (5,'employee');
INSERT INTO `permission` VALUES (6,'shift');
INSERT INTO `permission` VALUES (7,'expenseType');
INSERT INTO `permission` VALUES (8,'courseAssignment');
INSERT INTO `permission` VALUES (9,'course');
INSERT INTO `permission` VALUES (10,'fees');
INSERT INTO `permission` VALUES (11,'permissions');
INSERT INTO `permission` VALUES (12,'role');
INSERT INTO `permission` VALUES (13,'add');
INSERT INTO `permission` VALUES (14,'update');
INSERT INTO `permission` VALUES (15,'delete');
INSERT INTO `permission` VALUES (16,'read');
INSERT INTO `permission` VALUES (17,'print');
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
CREATE TABLE IF NOT EXISTS `fee_type` (
	`fee_type_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`fee_title`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
CREATE TABLE IF NOT EXISTS `expense_type` (
	`exp_type_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`exp_type_title`	INTEGER,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
INSERT INTO `expense_type` VALUES (1,'owner','1',1,'',1,NULL);
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
	FOREIGN KEY(`exp_type_id`) REFERENCES `expense_type`(`exp_type_id`),
	FOREIGN KEY(`emp_id`) REFERENCES `employee`(`emp_id`)
);
INSERT INTO `expense` VALUES (1,1,'salary',1,0,'1',NULL,'1',1,'',1,NULL);
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
INSERT INTO `employee` VALUES (1,'Admin
','Doe',NULL,'1',NULL,NULL,NULL,'Male',NULL,NULL,NULL,NULL,1,'1',1,'',1,'','admin','root','','','');
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
CREATE TABLE IF NOT EXISTS `batch` (
	`batch_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`batch_title`	TEXT,
	`active`	TEXT,
	`created_by`	INTEGER,
	`created_date`	TEXT,
	`modified_by`	INTEGER,
	`modified_date`	TEXT
);
COMMIT;
