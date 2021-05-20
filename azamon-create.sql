/* ---------------------------------------------------------------------------
   Copyright (c) 2000 - 2016 by Burkhardt Renz, THM
   $Id: azamon-create.sql 3576 2016-02-22 06:39:16Z br $
   ---------------------------------------------------------------------------
*/

/* Tabellen erzeugen */
create table Material(
  teilId          char(13) primary key,
  materialName    char(60),
  kosten          numeric(6,2),
  amort           char(13)
);

