insert into tb_address (city, complement, neighborhood, number, state, street, zipcode) values ('São Thomás', 'S/COMPLEMENTO', 'Centro', 'S/N', 'MG', 'Rua Terrão', '37960000');
insert into tb_address (city, complement, neighborhood, number, state, street, zipcode) values ('São Thomás', 'S/COMPLEMENTO', 'Centro', '250', 'MG', 'Rua Terrão', '37960000');

insert into tb_client (name, passport, birth_date, country_of_origin, document, email,phone, address_id) values ('Seu Madruga', null, '1970-01-01', 'Brazil', '12345678899', 'contato@hotmail.com', '35988774455', 1);
insert into tb_locality (name, address_id) values ('ID001', 2)
insert into tb_amenities (description, locality_id) values ('1 x Piscina Adulto, aquecida e coberta', 1)
insert into tb_building (name, locality_id) values ('BUILDING01', 1)
insert into tb_room (daily_value, people_capacity, building_id, amount_beds, type_room, bathroom_description) values (100.00, 4, 1, 2, 'Standard Duplo', 'Simples (Box com Ducha, Privada, Ducha higiênica e pia com espelho)');
insert into tb_mobile (description) values ('1 x Sofá');
insert into tb_mobile (description) values ('2 x poltronas');
insert into tb_mobile (description) values ('1 x Frigobar');
insert into tb_room_mobile (room_id, mobile_id) values (1,1);
insert into tb_room_mobile (room_id, mobile_id) values (1,2);
insert into tb_room_mobile (room_id, mobile_id) values (1,3);

insert into tb_itens (description, item_value) values ('Refrigerantes', 9.00)
insert into tb_itens (description, item_value) values ('Sucos', 13.00)
insert into tb_itens (description, item_value) values ('Cervejas Nacionais', 15.00)

insert into tb_services (description, service_value) values ('Café da manhã', 65.00)
insert into tb_services (description, service_value) values ('Almoço', 13.00)
insert into tb_services (description, service_value) values ('Jantar', 15.00)

insert into tb_reservation (client_id, reservation_at, send_email_confirmation, value_total, room_id) values (1, now(), true, 100.00, 1);

insert into tb_reservation_itens (reservation_id, item_id) values (1,1);
insert into tb_reservation_itens (reservation_id, item_id) values (1,2);
insert into tb_reservation_itens (reservation_id, item_id) values (1,3);

insert into tb_reservation_services (reservation_id, service_id) values (1,1);
insert into tb_reservation_services (reservation_id, service_id) values (1,2);
insert into tb_reservation_services (reservation_id, service_id) values (1,3);


