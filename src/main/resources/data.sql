INSERT INTO menus(name) VALUES ("SHOP");

SET @FEATURED_TYPE = "FEATURED";
SET @TOPS_TYPE = "TOPS";
SET @BOTTOMS_TYPE = "BOTTOMS";

INSERT INTO collections (name, type) VALUES ("SPRING '23 COLLECTION",
@FEATURED_TYPE);
INSERT INTO collections (name, type) VALUES ("WINTER '22 COLLECTION",
@FEATURED_TYPE);
INSERT INTO collections (name, type) VALUES ("TANKS", @TOPS_TYPE);
INSERT INTO collections (name, type) VALUES ("SHORT SLEEVES", @TOPS_TYPE);
INSERT INTO collections (name, type) VALUES ("LONG SLEEVES", @TOPS_TYPE);
INSERT INTO collections (name, type) VALUES ("HOODIES", @TOPS_TYPE);
INSERT INTO collections (name, type) VALUES ("OUTERWEAR", @TOPS_TYPE);
INSERT INTO collections (name, type) VALUES ("SHORTS", @BOTTOMS_TYPE);
INSERT INTO collections (name, type) VALUES ("TECH JOGGERS", @BOTTOMS_TYPE);
INSERT INTO collections (name, type) VALUES ("LEGGINGS", @BOTTOMS_TYPE);

--INSERT INTO product_collections (product_uuid, catalog_id) VALUES ("a", 1);
--INSERT INTO product_collections (product_uuid, catalog_id) VALUES ("a", 2);
--
--INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "XS", 10);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "S", 0);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "M", 10);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "L", 10);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("a", "XL", 10);
--
--INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "XS", 0);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "S", 0);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "M", 0);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "L", 0);
--INSERT INTO items (product_uuid, size, quantity) VALUES ("b", "XL", 0);
