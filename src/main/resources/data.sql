-- CATEGORY DATA --
INSERT INTO menus(name) VALUES ("SHOP");

SET @FEATURED_TYPE = "FEATURED";
SET @TOPS_TYPE = "TOPS";
SET @BOTTOMS_TYPE = "BOTTOMS";

SET @BLUE_COLOR = "BLUE";
SET @BLACK_COLOR = "BLACK";
SET @WHITE_COLOR = "WHITE";
SET @RED_COLOR = "RED";
SET @GREEN_COLOR = "GREEN";
SET @GREY_COLOR = "GREY";

-- PRODUCT DATA --
SET @TANK_ID = 1;
INSERT INTO collections (id, name, type) VALUES (@TANK_ID, "TANKS", @TOPS_TYPE);
SET @SHORT_SLEEVE_ID = 2;
INSERT INTO collections (id, name, type) VALUES (@SHORT_SLEEVE_ID, "SHORT SLEEVES", @TOPS_TYPE);
SET @LONG_SLEEVE_ID = 3;
INSERT INTO collections (id, name, type) VALUES (@LONG_SLEEVE_ID, "LONG SLEEVES",@TOPS_TYPE);
SET @HOODIE_ID = 4;
INSERT INTO collections (id, name, type) VALUES (@HOODIE_ID, "HOODIES",@TOPS_TYPE);
SET @OUTERWEAR_ID = 5;
INSERT INTO collections (id, name, type) VALUES (@OUTERWEAR_ID ,"OUTERWEAR",@TOPS_TYPE);
SET @SHORTS_ID = 6;
INSERT INTO collections (id, name, type) VALUES (@SHORTS_ID ,"SHORTS",@BOTTOMS_TYPE);
SET @TECH_JOGGERS_ID = 7;
INSERT INTO collections (id, name, type) VALUES (@TECH_JOGGERS_ID ,"TECH JOGGERS",@BOTTOMS_TYPE);
SET @LEGGINGS_ID = 8;
INSERT INTO collections (id, name, type) VALUES (@LEGGINGS_ID, "LEGGINGS",@BOTTOMS_TYPE);

-- TANKS --
SET @TANK_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TANK_PRODUCT_1_UUID, "0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - BLACK
\"OTWR\"",
68, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_Black_1000x.jpg?v=1683926407,https://asrv.com/cdn/shop/files/DSG0829_Black_SL_Cutoff_1000x.jpg?v=1684546644"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@TANK_PRODUCT_1_UUID, @TANK_ID);

SET @TANK_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TANK_PRODUCT_2_UUID, "0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - GREY
\"OTWR\"",
68, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_SpaceGrey_1400x.jpg?v=1683926417,https://asrv.com/cdn/shop/files/DSG0829_SpaceGrey_SL_Cutoff_1400x.jpg?v=1684546679"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@TANK_PRODUCT_2_UUID, @TANK_ID);

-- SHORT SLEEVES --
SET @SHORT_SLEEVE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_1_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - BLACK",
78, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_Black_1400x.jpg?v=1683925498,https://asrv.com/cdn/shop/files/DSG0822_Black_SilverLiteOversized_700x.jpg?v=1684265767"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_1_UUID, @SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_2_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - GREY",
78, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_SpaceGrey_1400x.jpg?v=1683925548,https://asrv.com/cdn/shop/files/DSG0822_SpaceGrey_SilverLiteOversized_700x.jpg?v=1684265903"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_2_UUID, @SHORT_SLEEVE_ID);

-- LONG SLEEVES --
SET @LONG_SLEEVE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_1_UUID, "0725. CORE FITTED QUARTER ZIP - BLACK",
128, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_Black_1400x.jpg?v=1676402887,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-289-Edit_700x.jpg?v=1678824526"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@LONG_SLEEVE_PRODUCT_1_UUID, @LONG_SLEEVE_ID);

SET @LONG_SLEEVE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_2_UUID, "0725. CORE FITTED QUARTER ZIP - GREY",
128, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_SpaceGrey_700x.jpg?v=1676402904,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-289-Edit-Edit_700x.jpg?v=1678824657"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@LONG_SLEEVE_PRODUCT_2_UUID, @LONG_SLEEVE_ID);

-- HOODIES --
SET @HOODIE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_1_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - BLACK",
128, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_Black_1400x.jpg?v=1678904575,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-65-Edit_1400x.jpg?v=1678904575"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@HOODIE_PRODUCT_1_UUID, @HOODIE_ID);

SET @HOODIE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_2_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - GREY",
128, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_SpaceGrey_700x.jpg?v=1677199298,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-93-Edit_6ab52e19-feec-42e6-83ee-bf5a6ed03364_700x.jpg?v=1678839198"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@HOODIE_PRODUCT_2_UUID, @HOODIE_ID);