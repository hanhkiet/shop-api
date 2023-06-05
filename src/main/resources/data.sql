-- CATEGORY DATA --
SET @FEATURED_TYPE = "FEATURED";
SET @TOPS_TYPE = "TOPS";
SET @BOTTOMS_TYPE = "BOTTOMS";

SET @BLUE_COLOR = "BLUE";
SET @BLACK_COLOR = "BLACK";
SET @WHITE_COLOR = "WHITE";
SET @RED_COLOR = "RED";
SET @GREEN_COLOR = "GREEN";
SET @GREY_COLOR = "GREY";
SET @OLIVE_COLOR = "OLIVE";

SET @SIZE_XS = "XS";
SET @SIZE_S = "S";
SET @SIZE_M = "M";
SET @SIZE_L = "L";
SET @SIZE_XL = "XL";

-- PRODUCT DATA --
SET @TANK_ID = 1;
INSERT INTO collections (id,name,type) VALUES (@TANK_ID,"TANKS",@TOPS_TYPE);
SET @SHORT_SLEEVE_ID = 2;
INSERT INTO collections (id,name,type) VALUES (@SHORT_SLEEVE_ID,"SHORT SLEEVES",@TOPS_TYPE);
SET @LONG_SLEEVE_ID = 3;
INSERT INTO collections (id,name,type) VALUES (@LONG_SLEEVE_ID,"LONG SLEEVES",@TOPS_TYPE);
SET @HOODIE_ID = 4;
INSERT INTO collections (id,name,type) VALUES (@HOODIE_ID,"HOODIES",@TOPS_TYPE);
SET @OUTERWEAR_ID = 5;
INSERT INTO collections (id,name,type) VALUES (@OUTERWEAR_ID,"OUTERWEAR",@TOPS_TYPE);
SET @SHORTS_ID = 6;
INSERT INTO collections (id,name,type) VALUES (@SHORTS_ID,"SHORTS",@BOTTOMS_TYPE);
SET @TECH_JOGGERS_ID = 7;
INSERT INTO collections (id,name,type) VALUES (@TECH_JOGGERS_ID,"TECH JOGGERS",@BOTTOMS_TYPE);
SET @LEGGINGS_ID = 8;
INSERT INTO collections (id,name,type) VALUES (@LEGGINGS_ID,"LEGGINGS",@BOTTOMS_TYPE);
SET @SPRING_22_ID = 9;
INSERT INTO collections (id,name,type) VALUES (@SPRING_22_ID,"SPRING '22 COLLECTION",@FEATURED_TYPE);
SET @SUMMER_22_ID = 10;
INSERT INTO collections (id,name,type) VALUES (@SUMMER_22_ID,"SUMMER '22 COLLECTION",@FEATURED_TYPE);

-- TANKS --
SET @TANK_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TANK_PRODUCT_1_UUID, '0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - BLACK "OTWR"',
68, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_Black_1000x.jpg?v=1683926407,https://asrv.com/cdn/shop/files/DSG0829_Black_SL_Cutoff_1000x.jpg?v=1684546644"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_1_UUID,@TANK_ID);

SET @TANK_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TANK_PRODUCT_2_UUID, '0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - GREY "OTWR"',
68, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_SpaceGrey_1400x.jpg?v=1683926417,https://asrv.com/cdn/shop/files/DSG0829_SpaceGrey_SL_Cutoff_1400x.jpg?v=1684546679"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_2_UUID,@TANK_ID);

-- SHORT SLEEVES --
SET @SHORT_SLEEVE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_1_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - BLACK",
78, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_Black_1400x.jpg?v=1683925498,https://asrv.com/cdn/shop/files/DSG0822_Black_SilverLiteOversized_700x.jpg?v=1684265767"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_1_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_2_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - GREY",
78, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_SpaceGrey_1400x.jpg?v=1683925548,https://asrv.com/cdn/shop/files/DSG0822_SpaceGrey_SilverLiteOversized_700x.jpg?v=1684265903"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_2_UUID,@SHORT_SLEEVE_ID);

-- LONG SLEEVES --
SET @LONG_SLEEVE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_1_UUID, "0725. CORE FITTED QUARTER ZIP - BLACK",
128, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_Black_1400x.jpg?v=1676402887,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-289-Edit_700x.jpg?v=1678824526"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@LONG_SLEEVE_PRODUCT_1_UUID,@LONG_SLEEVE_ID);

SET @LONG_SLEEVE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_2_UUID, "0725. CORE FITTED QUARTER ZIP - GREY",
128, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_SpaceGrey_700x.jpg?v=1676402904,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-289-Edit-Edit_700x.jpg?v=1678824657"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_2_UUID,@LONG_SLEEVE_ID);

-- HOODIES --
SET @HOODIE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_1_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - BLACK",
128, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_Black_1400x.jpg?v=1678904575,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-65-Edit_1400x.jpg?v=1678904575"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_1_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_2_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - GREY",
128, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_SpaceGrey_700x.jpg?v=1677199298,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-93-Edit_6ab52e19-feec-42e6-83ee-bf5a6ed03364_700x.jpg?v=1678839198"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_2_UUID,@HOODIE_ID);

-- OUTERWEAR --
SET @OUTERWEAR_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_1_UUID, "0717. WATERPROOF ANORAK JACKET - BLACK",
158, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0717Jacket_Black_1400x.jpg?v=1677003998,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-1-Edit_700x.jpg?v=1678747055"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_1_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_2_UUID, "0717. WATERPROOF ANORAK JACKET - OLIVE",
158, @OLIVE_COLOR, "https://asrv.com/cdn/shop/products/0717Jacket_Olive_700x.jpg?v=1678838939,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-27-Edit_700x.jpg?v=1678838939"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_2_UUID,@OUTERWEAR_ID);

-- SHORTS --
SET @SHORTS_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_1_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - BLACK "WINGS"/BLACK',
118, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Black_Wings_Black_1400x.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Black_700x.jpg?v=1683396279"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_1_UUID, @SHORTS_ID);

-- TECH JOGGERS --
SET @TECH_JOGGERS_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_1_UUID, "0654. TECH-TERRY™ CARGO HIGH RIB JOGGER - DUSK BLACK",
148, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0654Joggers_DuskBlack_11ef660a-d312-4bd6-aa7a-f2494c49675f_1400x.jpg?v=1683571064,https://asrv.com/cdn/shop/files/DSG0654_DuskBlack_Jogger_fa1e957d-2179-4045-8293-d6b4365fd471_700x.jpg?v=1683665249"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_1_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_2_UUID, "0654. TECH-TERRY™ CARGO HIGH RIB JOGGER - WHITE",
148, @WHITE_COLOR, "https://asrv.com/cdn/shop/files/0654Joggers_White_dc526bda-447a-468f-bb11-c48fbd393d32_700x.jpg?v=1685058120,https://asrv.com/cdn/shop/files/Fall-22-E-Comm-414-2-white_700x.jpg?v=1685062593"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_2_UUID,@TECH_JOGGERS_ID);

-- LEGGINGS --
SET @LEGGINGS_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_1_UUID, "0747. WARPFLEXX™ SIDE POCKET 3/4-LENGTH LEGGING - BLACK",
68, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0747Legging_Black_1400x.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-453-Edit-Edit_1400x.jpg?v=1678824824"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_1_UUID,@LEGGINGS_ID);

SET @LEGGINGS_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_2_UUID, "0747. WARPFLEXX™ SIDE POCKET 3/4-LENGTH LEGGING - WHITE",
68, @WHITE_COLOR, "https://asrv.com/cdn/shop/products/0747Legging_White_700x.jpg?v=1677697130,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-450-Edit_700x.jpg?v=1678824838"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_2_UUID,@LEGGINGS_ID);

