CREATE TABLE ERS_USER_ROLES(
	ERS_USER_ROLE_ID SERIAL NOT NULL,
	USER_ROLE VARCHAR(10) NOT NULL,
	CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (ERS_USER_ROLE_ID)
);

INSERT INTO ers_user_roles(user_role) VALUES
	('employee'),
	('manager');

CREATE TABLE ERS_USERS(
	ERS_USERS_ID SERIAL NOT NULL,
	ERS_USERNAME VARCHAR(50) NOT NULL,
	ERS_PASSWORD VARCHAR(50) NOT NULL,
	USER_FIRST_NAME VARCHAR(100) NOT NULL,
	USER_LAST_NAME VARCHAR(100) NOT NULL,
	USER_EMAIL VARCHAR(150) NOT NULL,
	USER_ROLE_ID INT NOT NULL,
	CONSTRAINT ERS_USERS_PK PRIMARY KEY (ERS_USERS_ID),
	CONSTRAINT ERS_USERS_UNV1 UNIQUE (ERS_USERNAME, USER_EMAIL),
	CONSTRAINT USER_ROLES_FK FOREIGN KEY (USER_ROLE_ID) 
	REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID) 
);

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)VALUES
	('employee1', 'employee1','Phoenix','Wright','phoenixwright@aceattorney.com', 1),
	('employee2', 'employee2','Maya','Fey','mayafey@aceattorney.com', 1),
	('employee3', 'employee3','Dick','Gumshoe','detectivegumshoe@aceattorney.com', 1),
	('employee4', 'employee4','Franzsika','Von Karma','franzsikakarma@aceattorney.com', 2),
	('employee5', 'employee5','Miles','EdgeWorth','milesedgeworth@aceattorney.com', 2);

-------------------------------------------------------------
-------------------------------------------------------------

CREATE TABLE ERS_REIMBURSEMENT_STATUS(
	REIMB_STATUS_ID SERIAL NOT NULL,
	REIMB_STATUS VARCHAR(10) NOT NULL,
	CONSTRAINT REIMB_STATUS_PK PRIMARY KEY (REIMB_STATUS_ID) 
);

INSERT INTO ers_reimbursement_status(reimb_status) VALUES
	('Approved'),
	('Pending'),
	('Denied');

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
	REIMB_TYPE_ID SERIAL NOT NULL,
	REIMB_TYPE VARCHAR(10) NOT NULL,
	CONSTRAINT REIMB_TYPE_PK PRIMARY KEY (REIMB_TYPE_ID) 
);

INSERT INTO ers_reimbursement_type(reimb_type) VALUES
	('Food'),
	('Travel'),
	('Lodging'),
	('Other');

CREATE TABLE ERS_REIMBURSEMENT(
	REIMB_ID SERIAL,
	REIMB_AMOUNT INT NOT NULL,
	REIMB_SUBMITTED TIMESTAMP NOT NULL,
	REIMB_RESOLVED TIMESTAMP,
	REIMB_DESCRIPTION VARCHAR(250),
	REIMB_RECEIPT BYTEA,
	REIMB_AUTHOR INT NOT NULL,
	REIMB_RESOLVER INT,
	REIMB_STATUS_ID SERIAL NOT NULL,
	REIMB_TYPE_ID SERIAL NOT NULL,
	CONSTRAINT ERS_REIMBURSEMENT_PK PRIMARY KEY (REIMB_ID),
	CONSTRAINT ERS_USERS_FK_AUTH FOREIGN KEY (REIMB_AUTHOR) 
	REFERENCES ERS_USERS(ERS_USERS_ID),
	CONSTRAINT ERS_USERS_FK_RESLVR FOREIGN KEY (REIMB_RESOLVER)  
	REFERENCES ERS_USERS(ERS_USERS_ID),
	CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK FOREIGN KEY (REIMB_STATUS_ID) 
	REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
	CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK FOREIGN KEY (REIMB_TYPE_ID) 
	REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)
);

ALTER TABLE ers_reimbursement ALTER COLUMN reimb_amount TYPE NUMERIC(8,2);

INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_author,reimb_resolver, reimb_status_id,reimb_type_id) VALUES
	(250, current_timestamp, current_timestamp, 'client lunch', 1, 4,  1,1),
	(50, current_timestamp, current_timestamp, 'business trip', 1, NULL, 2,2),
	(150, current_timestamp, current_timestamp,'hotel conference', 2, NULL,  2, 3),
	(25, current_timestamp, current_timestamp, 'medical supplies', 3, 4,  1,4),
	(375, current_timestamp, current_timestamp, 'business group dining', 3, 5,  3,1);


DROP TABLE ers_reimbursement;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;

DROP TABLE ers_user_roles;
DROP TABLE ers_users;
