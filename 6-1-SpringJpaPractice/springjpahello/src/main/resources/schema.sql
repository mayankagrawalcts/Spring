create or replace procedure "ITEMPROCEDURE"
(name IN VARCHAR2,
 count_out OUT Integer)
    is
begin
    select count(*) into count_out from item;
end;