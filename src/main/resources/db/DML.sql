-- DML

insert into university (title, code) values ('Kaunas University of Technology', 'KTU');
insert into university (title, code) values ('Vilnius University', 'VU');
insert into university (title, code) values ('Software Development Academy', 'SDA');
insert into university (title, code) values ('Devbridge Sourcery Academy', 'DB_SA');

insert into person (name, surname, gender) values ('Rutenis', 'Turcinas', 'male');
insert into lecturer (person_id) values ((select max(id) from person));
insert into university_lecturer (level, salary, university_id, lecturer_id) values ('lecturer', 99.99, (select id from university where code = 'SDA'), (select max(id) from lecturer));
insert into person (name, surname, gender) values ('Gintaras', 'Kazlauskas', 'male');
insert into lecturer (person_id) values ((select max(id) from person));
insert into university_lecturer (level, salary, university_id, lecturer_id) values ('lecturer', 102.14, (select id from university where code = 'SDA'), (select max(id) from lecturer));
insert into person (name, surname, gender) values ('Tomas', 'Norkus', 'male');
insert into lecturer (person_id) values ((select max(id) from person));
insert into university_lecturer (level, salary, university_id, lecturer_id) values ('lecturer', 199, (select id from university where code = 'DB_SA'), (select max(id) from lecturer));
insert into person (name, surname, gender) values ('Paulius', 'Stabingis', 'male');
insert into lecturer (person_id) values ((select max(id) from person));
insert into university_lecturer (level, salary, university_id, lecturer_id) values ('lecturer', 185.2, (select id from university where code = 'DB_SA'), (select max(id) from lecturer));

insert into study_program (title, university_id) VALUES ('Java nuo pagrindų', (select id from university where code = 'SDA'));
insert into module (title) values ('Java - Fundamentals');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Gintaras'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Java - Fundamentals'));
insert into module (title) values ('Java - Fundamentals: Coding');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Gintaras'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Java - Fundamentals: Coding'));
insert into module (title) values ('Software Testing - Fundamentals');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Gintaras'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Software Testing - Fundamentals'));
insert into module (title) values ('Java - Advanced Features');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Rutenis'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Java - Advanced Features'));
insert into module (title) values ('Design Patterns & Good Practices');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Rutenis'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Design Patterns & Good Practices'));
insert into module (title) values ('Java - Advanced Features: Coding');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Rutenis'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Java - Advanced Features: Coding'));
insert into module (title) values ('Databases - SQL');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Rutenis'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'Databases - SQL'));
insert into module (title) values ('JDBC & Hibernate');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Rutenis'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Java nuo pagrindų'), (select id from module where title = 'JDBC & Hibernate'));
insert into study_program (title, university_id) VALUES ('Sourcery for Developers', (select id from university where code = 'DB_SA'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Sourcery for Developers'), (select id from module where title = 'Java - Advanced Features'));
insert into module (title) values ('Spring Framework');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Tomas'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Sourcery for Developers'), (select id from module where title = 'Spring Framework'));
insert into module (title) values ('J2EE');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Rutenis'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Sourcery for Developers'), (select id from module where title = 'J2EE'));
insert into module (title) values ('JavaScript');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Paulius'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Sourcery for Developers'), (select id from module where title = 'JavaScript'));
insert into module (title) values ('ReactJS');
insert into module_lecturer (module_id, lecturer_id) VALUES ((select max(id) from module), (select lecturer.id from lecturer inner join person p on lecturer.person_id = p.id where p.name='Paulius'));
insert into study_program_module (study_program_id, module_id) VALUES ((select id from study_program where title = 'Sourcery for Developers'), (select id from module where title = 'ReactJS'));

insert into study_program (title, university_id) VALUES ('Sourcery for Kids', (select id from university where code = 'DB_SA'));

insert into person (name, surname, gender) values ('Violeta', 'Baneliene', 'female');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Simonas', 'Penkinas', 'male');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Justina', 'Varnaite', 'female');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Vaida', 'Kameneckiene', 'female');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Valdemaras', 'Tauras', 'male');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Brigita', 'Sliauzyte', 'female');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Justinas', 'Pedisius', 'male');
insert into student (study_type, date_started, person_id, study_program_id) values ('vakarines', '2019-08-06', (select max(id) from person), (select id from study_program where title = 'Java nuo pagrindų'));
insert into person (name, surname, gender) values ('Kestutis', 'Valasinas', 'male');
insert into student (study_type, date_started, person_id, study_program_id) values ('dienines', '2017-10-04', (select max(id) from person), (select id from study_program where title = 'Sourcery for Developers'));
insert into person (name, surname, gender) values ('Konstantinas', 'Buivydas', 'male');
insert into student (study_type, date_started, person_id, study_program_id) values ('dienines', '2017-10-04', (select max(id) from person), (select id from study_program where title = 'Sourcery for Developers'));
insert into person (name, surname, gender) values ('Tautvydas', 'Eimutis', 'male');
insert into student (study_type, date_started, person_id, study_program_id) values ('dienines', '2016-10-06', (select max(id) from person), (select id from study_program where title = 'Sourcery for Developers'));
