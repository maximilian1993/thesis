/* ---------------------------------------------------------------------------
   Copyright (c) 2000 - 2016 by Burkhardt Renz, THM
   $Id: azamon-create.sql 3576 2016-02-22 06:39:16Z br $
   ---------------------------------------------------------------------------
*/

/* Tabellen erzeugen */
create table Staffelpreise(
  staffelID          char(13) primary key,
  staffelbegin       numeric(6,2),
  staffelende        numeric(6,2),
  preis          numeric(6,2)
);

