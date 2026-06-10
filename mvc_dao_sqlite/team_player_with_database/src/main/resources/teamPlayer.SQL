create table player(
    ID INTEGER,
  NAME TEXT,
  NUMBER INTEGER not null,
  POSITION TEXT,
  IS_FIELD INTEGER default 0,
  TEAM_NAME TEXT default null,
  constraint player_pk primary key(ID),
    constraint player_team_name_fk foreign key (TEAM_NAME) references TEAM(NAME) on delete set null
);

create table team(
    NAME TEXT,
    BASE_LOCATION TEXT,
    COACH_NAME TEXT,
    CAPTAIN INTEGER default null,
    CONSTRAINT team_pk primary key (NAME),
    CONSTRAINT team_captain_fk foreign key (CAPTAIN) REFERENCES player(ID) on delete set null
);