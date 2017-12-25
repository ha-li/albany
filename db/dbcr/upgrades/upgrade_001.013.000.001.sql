  declare
       table_exists pls_integer;
  begin

      select count(*) into table_exists
      from "USER_TABLES"
      where TABLE_NAME = 'BACS_TRANSACTION';

      if table_exists = 1 then
         execute immediate 'drop table "BACS_TRANSACTION" cascade constraints';
      end if;

  end;

  /
  create table BACS_TRANSACTION (
     id                      varchar2(50) not null,
     sort_number             varchar2(50) not null,
     bank_account_num        varchar2(255) not null,
     account_name            varchar2(100) not null,
     society_ref_number      varchar2(100),
     amount                  number (19,4),
     payment_method          smallint,
     rti_hash                varchar2(25),
     outbound_bank_id        varchar2(50),
     remittance_date         date
  )
  /

  declare
       table_exists pls_integer;
  begin

      select count(*) into table_exists
      from "USER_TABLES"
      where TABLE_NAME = 'SYSTEM_PARAMETER';

      if table_exists = 1 then
         execute immediate 'drop table "SYSTEM_PARAMETER" cascade constraints';
      end if;

  end;

  /
  create table SYSTEM_PARAMETER (
     system_parameter_seq varchar2(255) not null,
     category varchar2(100),
     code varchar2(255) not null,
     value varchar2(1000) not null,
     created_date timestamp not null,
     creator_id varchar2(50) not null,
     is_encrypted number(1) not null,
     can_cache number(1) default 0,
     version smallint not null,
     volatile number(1) default 0,
     realm_id number (19) default -1
  )
  /


  commit
  /