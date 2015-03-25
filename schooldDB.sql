-- Table: assignment

-- DROP TABLE assignment;

CREATE TABLE assignment
(
  id integer NOT NULL,
  date timestamp without time zone,
  assignedby_id integer,
  course_id integer,
  CONSTRAINT assignment_pkey PRIMARY KEY (id),
  CONSTRAINT fk_i92eyesgd75r3ja6dm8nfwurj FOREIGN KEY (course_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_k7x4fbldmsg9ylypiexqvr3tb FOREIGN KEY (assignedby_id)
      REFERENCES teacher (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE assignment
  OWNER TO postgres;

-- Table: course

-- DROP TABLE course;

CREATE TABLE course
(
  id integer NOT NULL,
  begindate timestamp without time zone,
  capacity integer NOT NULL,
  enddate timestamp without time zone,
  name character varying(255),
  CONSTRAINT course_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE course
  OWNER TO postgres;

-- Table: exam

-- DROP TABLE exam;

CREATE TABLE exam
(
  id integer NOT NULL,
  cariagedate timestamp without time zone,
  registrationfrom timestamp without time zone,
  registrationtill timestamp without time zone,
  course_id integer,
  teacher_id integer,
  CONSTRAINT exam_pkey PRIMARY KEY (id),
  CONSTRAINT fk_rubi9bjesp5ho2nnpdtjx1ifu FOREIGN KEY (teacher_id)
      REFERENCES teacher (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_s7ji2he4sbh5bjakkxw8vkcir FOREIGN KEY (course_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE exam
  OWNER TO postgres;


-- Table: course_exam

-- DROP TABLE course_exam;

CREATE TABLE course_exam
(
  course_id integer NOT NULL,
  examset_id integer NOT NULL,
  CONSTRAINT course_exam_pkey PRIMARY KEY (course_id, examset_id),
  CONSTRAINT fk_eqr1x2h7lcs4dpsl3ayc51t57 FOREIGN KEY (course_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tdhvn9loerps8ns4vsroilfqw FOREIGN KEY (examset_id)
      REFERENCES exam (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_tdhvn9loerps8ns4vsroilfqw UNIQUE (examset_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE course_exam
  OWNER TO postgres;

-- Table: examresult

-- DROP TABLE examresult;

CREATE TABLE examresult
(
  id integer NOT NULL,
  date timestamp without time zone,
  course_id integer,
  student_id integer,
  teacher_id integer,
  CONSTRAINT examresult_pkey PRIMARY KEY (id),
  CONSTRAINT fk_2vdp7jdptp1wiltbdn5y03il7 FOREIGN KEY (student_id)
      REFERENCES student (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_pv9il396aeotrtm2u64lqb8xf FOREIGN KEY (teacher_id)
      REFERENCES teacher (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_sgvy01mdubc42mti3a05pj3bf FOREIGN KEY (course_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE examresult
  OWNER TO postgres;


-- Table: student

-- DROP TABLE student;

CREATE TABLE student
(
  id integer NOT NULL,
  email character varying(255),
  firstname character varying(255),
  lastname character varying(255),
  markaverage double precision NOT NULL,
  CONSTRAINT student_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student
  OWNER TO postgres;


-- Table: exam_examresult

-- DROP TABLE exam_examresult;

CREATE TABLE exam_examresult
(
  exam_id integer NOT NULL,
  examresultset_id integer NOT NULL,
  CONSTRAINT exam_examresult_pkey PRIMARY KEY (exam_id, examresultset_id),
  CONSTRAINT fk_n3dys9i8syonxnxyqk98khvgk FOREIGN KEY (examresultset_id)
      REFERENCES examresult (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_pq3f1cwttsdurd90cry7noti3 FOREIGN KEY (exam_id)
      REFERENCES exam (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_n3dys9i8syonxnxyqk98khvgk UNIQUE (examresultset_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE exam_examresult
  OWNER TO postgres;

-- Table: exam_student

-- DROP TABLE exam_student;

CREATE TABLE exam_student
(
  exam_id integer NOT NULL,
  registeredstudents_id integer NOT NULL,
  CONSTRAINT exam_student_pkey PRIMARY KEY (exam_id, registeredstudents_id),
  CONSTRAINT fk_b8496atwbrl44p7whdnmd0y99 FOREIGN KEY (registeredstudents_id)
      REFERENCES student (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_fkj1qmytikmvo11339f4pvpva FOREIGN KEY (exam_id)
      REFERENCES exam (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE exam_student
  OWNER TO postgres;


-- Table: student_assignment

-- DROP TABLE student_assignment;

CREATE TABLE student_assignment
(
  student_id integer NOT NULL,
  assignedcourses_id integer NOT NULL,
  CONSTRAINT student_assignment_pkey PRIMARY KEY (student_id, assignedcourses_id),
  CONSTRAINT fk_bmfbddeoytkxp655yce6pv292 FOREIGN KEY (assignedcourses_id)
      REFERENCES assignment (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_m24n0vf82yyy83n0ctyhc6lp FOREIGN KEY (student_id)
      REFERENCES student (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_bmfbddeoytkxp655yce6pv292 UNIQUE (assignedcourses_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student_assignment
  OWNER TO postgres;



-- Table: student_course

-- DROP TABLE student_course;

CREATE TABLE student_course
(
  student_id integer NOT NULL,
  attendedcourses_id integer NOT NULL,
  CONSTRAINT student_course_pkey PRIMARY KEY (student_id, attendedcourses_id),
  CONSTRAINT fk_5qwplfy2bqpfbql9wg37e0gpa FOREIGN KEY (attendedcourses_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_7lwxxnu7wbg63k8so3tb6sn0g FOREIGN KEY (student_id)
      REFERENCES student (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student_course
  OWNER TO postgres;



-- Table: teacher

-- DROP TABLE teacher;

CREATE TABLE teacher
(
  id integer NOT NULL,
  address character varying(255),
  email character varying(255),
  firstname character varying(255),
  lastname character varying(255),
  sallary double precision NOT NULL,
  CONSTRAINT teacher_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE teacher
  OWNER TO postgres;

-- Table: teacher_course

-- DROP TABLE teacher_course;

CREATE TABLE teacher_course
(
  teacher_id integer NOT NULL,
  lecturedcourses_id integer NOT NULL,
  CONSTRAINT teacher_course_pkey PRIMARY KEY (teacher_id, lecturedcourses_id),
  CONSTRAINT fk_8e64njivkfw881ohytdx1g9rn FOREIGN KEY (teacher_id)
      REFERENCES teacher (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_euilstvhxqe02r9cnfwhtas4a FOREIGN KEY (lecturedcourses_id)
      REFERENCES course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE teacher_course
  OWNER TO postgres;








