INSERT INTO course (name, hours, fees) VALUES ('Introduction to Java', 40, 500);
INSERT INTO course (name, hours, fees) VALUES ('Advanced Hibernate', 30, 700);
INSERT INTO course (name, hours, fees) VALUES ('Spring Boot Basics', 35, 600);
INSERT INTO course (name, hours, fees) VALUES ('Data Structures', 50, 800);
INSERT INTO course (name, hours, fees) VALUES ('SQL Mastery', 25, 450);
INSERT INTO course (name, hours, fees) VALUES ('Docker for Beginners', 20, 300);
INSERT INTO course (name, hours, fees) VALUES ('Microservices Arch', 45, 900);
INSERT INTO course (name, hours, fees) VALUES ('React Frontend', 40, 650);
INSERT INTO course (name, hours, fees) VALUES ('Python Data Science', 60, 1000);
INSERT INTO course (name, hours, fees) VALUES ('AWS Cloud Practitioner', 25, 550);


-- Section for Java
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (1, '2026-03-01', 'MONDAY', '09:00', '12:00', '2026-06-01', 500);

-- Section for Hibernate
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (2, '2026-03-15', 'THURSDAY', '14:00', '17:00', '2026-05-15', 700);

-- Section for Spring Boot
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (3, '2026-04-01', 'SATURDAY', '09:00', '16:00', '2026-07-01', 600);

-- Section for Data Structures
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (4, '2026-03-10', 'FRIDAY', '10:00', '13:00', '2026-06-10', 800);

-- Section for SQL
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (5, '2026-03-20', 'WEDNESDAY', '18:00', '21:00', '2026-05-20', 450);

-- Section for Docker
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (6, '2026-04-05', 'TUESDAY', '09:00', '12:00', '2026-06-05', 300);

-- Section for Microservices
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (7, '2026-04-10', 'THURSDAY', '13:00', '17:00', '2026-07-10', 900);

-- Section for React
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (8, '2026-03-05', 'WEDNESDAY', '09:00', '11:00', '2026-05-05', 650);

-- Section for Python
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (9, '2026-03-01', 'THURSDAY', '17:00', '19:00', '2026-08-01', 1000);

-- Section for AWS
INSERT INTO section (course_id, start_at, days, start_time, end_time, end_at, fees) VALUES (10, '2026-05-01', 'SATURDAY', '10:00', '14:00', '2026-07-01', 550);