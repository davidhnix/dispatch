
CREATE TABLE JOB (
	job_id BIGINT,
	job_name varchar(20) not null,
	cron_expression varchar(40) not null,
	target varchar(200) not null,
);

insert into JOB (job_id, job_name, cron_expression, target) VALUES (12345, 'david', '0/2 * * * * *', 'http://localhost:8080/test');