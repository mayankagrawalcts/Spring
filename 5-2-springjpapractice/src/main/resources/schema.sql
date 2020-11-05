create or replace procedure "ITEMPROCEDURE"
(id out Integer,
 name OUT VARCHAR2,
 price OUT Integer)
    is
begin
    select id,name,price into id,name,price from item;
end;