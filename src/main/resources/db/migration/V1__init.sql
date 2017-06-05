
CREATE TABLE JOB (
	job_id BIGINT,
	job_name varchar(20) not null,
	cron_expression varchar(40) not null,
	target varchar(200) not null,
	timezone varchar(10) not null,
	dc_number varchar(4) null
);

CREATE TABLE PARAM_TYPE (
	param_type_id BIGINT not null,
	param_type_description varchar(20) not null
);

CREATE TABLE REQUEST_PARAM (
	param_id BIGINT,
	job_id BIGINT,
	param_type_id BIGINT not null,
	param_name varchar(50) not null,
	param_value varchar(50) not null
);



insert into JOB (job_id, job_name, cron_expression, target, timezone, dc_number) VALUES (1, 'davidEST', '0 35 12 * * *', 'http://localhost:8080/test/dcNumber', 'EST5EDT', '5085');
insert into JOB (job_id, job_name, cron_expression, target, timezone, dc_number) VALUES (2, 'davidCST', '0 35 12 * * *', 'http://localhost:8080/test', 'CST6CDT', '5086');
insert into JOB (job_id, job_name, cron_expression, target, timezone, dc_number) VALUES (3, 'davidMST', '0 35 12 * * *', 'http://localhost:8080/test', 'MST7', '5643');
insert into JOB (job_id, job_name, cron_expression, target, timezone, dc_number) VALUES (4, 'davidPST', '0 35 12 * * *', 'http://localhost:8080/test', 'PST8PDT', '5639');

insert into PARAM_TYPE (param_type_id, param_type_description) VALUES (1, 'URI');

insert into REQUEST_PARAM (param_id, job_id, param_type_id, param_name, param_value) VALUES (1, 1, 1, 'dcNumber', '{dcNumber}');