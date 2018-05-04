CREATE KEYSPACE "scheduler" WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};

USE "scheduler";

CREATE TABLE scheduler (
  id uuid,
  semester int,
  week int,
  subject_name text,
  subject_type text,
  hours int,
  PRIMARY KEY (id)
);

CREATE TABLE subject (
   codeName text,
   credits int,
   PRIMARY KEY (codeName)
);