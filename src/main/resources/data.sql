INSERT INTO products (uuid, name, price, color, images) VALUES ("a", "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - BLACK", 128, 'BLACK', "https://cdn.shopify.com/s/files/1/0297/6293/products/0714Hoodie_Black.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-65-Edit.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-73.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-72-Edit-Edit.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-67-Edit.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-69-Edit.jpg");
INSERT INTO products (uuid, name, price, color, images) VALUES ("b", "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - GREY", 128, 'GREY', "https://asrv.com/cdn/shop/products/0714Hoodie_SpaceGrey.jpg,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-93-Edit_6ab52e19-feec-42e6-83ee-bf5a6ed03364.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-102-Edit-2.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-101-Edit.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-96-Edit.jpg,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-99-Edit-2.jpg");

INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "XS", 10);
INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "S", 0);
INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "M", 10);
INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "L", 10);
INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "XL", 10);


INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "XS", 0);
INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "S", 0);
INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "M", 10);
INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "L", 10);
INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "XL", 10);

INSERT INTO menus(name) VALUES ("SHOP");

INSERT INTO collection_types (name, menu_id) VALUES ("FEATURED", 1);
INSERT INTO collection_types (name, menu_id) VALUES ("TOPS", 1);
INSERT INTO collection_types (name, menu_id) VALUES ("BOTTOMS", 1);

INSERT INTO product_collections (name, collection_type_id) VALUES ("SPRING '23 COLLECTION", 1);

INSERT INTO product_collections (name, collection_type_id) VALUES ("TANKS", 2);
INSERT INTO product_collections (name, collection_type_id) VALUES ("SHORT SLEEVES", 2);
INSERT INTO product_collections (name, collection_type_id) VALUES ("LONG SLEEVES", 2);
INSERT INTO product_collections (name, collection_type_id) VALUES ("HOODIES", 2);
INSERT INTO product_collections (name, collection_type_id) VALUES ("OUTERWEAR", 2);

INSERT INTO product_collections (name, collection_type_id) VALUES ("SHORTS", 3);
INSERT INTO product_collections (name, collection_type_id) VALUES ("TECH JOGGERS", 3);
INSERT INTO product_collections (name, collection_type_id) VALUES ("LEGGINGS", 3);
