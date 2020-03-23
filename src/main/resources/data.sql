MERGE INTO banks
VALUES (1, 'Sberbank', '000000000'),
       (2, 'VTB', '111111111'),
       (3,  'Tinkoff', '222222222');

MERGE INTO clients
VALUES (1, 'client1', 'client1', 'address1', 'ooo'),
       (2, 'client2', 'client2', 'address2', 'zao'),
       (3, 'client3', 'client3', 'address3', 'pao');

MERGE INTO deposits
VALUES (1, 1, 1, current_timestamp(), 10, 12),
       (2, 2, 2, current_timestamp(), 11, 11),
       (3, 3, 3, current_timestamp(), 15, 24);
