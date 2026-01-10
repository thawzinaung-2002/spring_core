
insert into ACCOUNT values ('001', 'Thidar', '09123412344', 200000, 1);
insert into ACCOUNT values ('002', 'Aung Aung', '09779580179', 500000, 1);


insert into BALANCE_HISTORY(account_num, version, last_amount, trx_amount, debit) 
values ('001', 1, 0, 200000, true);


insert into BALANCE_HISTORY(account_num, version, last_amount, trx_amount, debit) 
values ('002', 1, 0, 500000, true);