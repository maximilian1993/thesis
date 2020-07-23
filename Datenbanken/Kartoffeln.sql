/* ---------------------------------------------------------------------------
   Copyright (c) 2000 - 2016 by Burkhardt Renz, THM
   $Id: azamon-create.sql 3576 2016-02-22 06:39:16Z br $
   ---------------------------------------------------------------------------
*/

/* Tabellen erzeugen */
create table Kartoffeln(
  kundenId           char(13) primary key,
  vorname          char(80),
  nachname          char(40),
  menge          numeric(6,2),
  bezahlt        boolean
);

