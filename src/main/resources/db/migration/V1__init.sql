
CREATE TABLE JOB (
	job_id BIGINT,
	job_name varchar(20) not null,
	cron_expression varchar(40) not null,
	target varchar(200) not null,
	timezone varchar(10) not null
);

insert into JOB (job_id, job_name, cron_expression, target, timezone) VALUES (1, 'davidEST', '0 35 12 * * *', 'http://localhost:8080/test', 'EST5EDT');
insert into JOB (job_id, job_name, cron_expression, target, timezone) VALUES (2, 'davidCST', '0 35 12 * * *', 'http://localhost:8080/test', 'CST6CDT');
insert into JOB (job_id, job_name, cron_expression, target, timezone) VALUES (3, 'davidMST', '0 35 12 * * *', 'http://localhost:8080/test', 'MST7');