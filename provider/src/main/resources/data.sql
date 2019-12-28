INSERT INTO "product" ("description", "name", "price", "state") VALUES
('Healthy Orange Juice',	'Orange Juice',	10.00,	'SP');

INSERT INTO "product" ("description", "name", "price", "state") VALUES
('Pink Flower',	'Flower',	1.99,	'SP');

INSERT INTO "product" ("description", "name", "price", "state") VALUES
('Chicken Sandwich',	'Chicken Sandwich',	5.99,	'RJ');

INSERT INTO "orders" ("preparation_time", "status") VALUES
(2,	'RECEIVED');

INSERT INTO "order_item" ("amount", "product_id", "order_id") VALUES
(2,	1,	1);

INSERT INTO "provider_info" ("address", "name", "state") VALUES
('5th Street',	'Provider 1',	'SP');