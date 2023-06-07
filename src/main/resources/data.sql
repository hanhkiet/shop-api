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
SET @NAVY_COLOR = "NAVY";
SET @CHAI_COLOR = "CHAI";
SET @PLUM_COLOR = "PLUM";
SET @TAUPE_COLOR = "TAUPE";
SET @SAGE_COLOR = "SAGE";
SET @CREAM_COLOR = "CREAM";
SET @RAVEN_COLOR = "RAVEN";
SET @SMOKE_COLOR = "SMOKE";
SET @SKY_COLOR = "SKY";
SET @STONE_COLOR = "STONE";

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
SET @SPRING_23_ID = 9;
INSERT INTO collections (id,name,type) VALUES (@SPRING_23_ID,"SPRING '23 COLLECTION",@FEATURED_TYPE);
SET @WINTER_22_ID = 10;
INSERT INTO collections (id,name,type) VALUES (@WINTER_22_ID,"WINTER '22 COLLECTION",@FEATURED_TYPE);
SET @CORE_ID = 11;
INSERT INTO collections (id,name,type) VALUES (@CORE_ID,"CORE COLLECTION",@FEATURED_TYPE);

-- TANKS --
SET @TANK_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TANK_PRODUCT_1_UUID, '0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - BLACK "OTWR"',
68, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_Black.jpg?v=1683926407,https://asrv.com/cdn/shop/files/DSG0829_Black_SL_Cutoff.jpg?v=1684546644"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_1_UUID,@TANK_ID);

SET @TANK_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TANK_PRODUCT_2_UUID, '0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - GREY "OTWR"',
68, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_SpaceGrey.jpg?v=1683926417,https://asrv.com/cdn/shop/files/DSG0829_SpaceGrey_SL_Cutoff.jpg?v=1684546679"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_2_UUID,@TANK_ID);

SET @TANK_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_3_UUID, '0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - WHITE "OTWR"',
     68, @WHITE_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_White.jpg?v=1683926429,https://asrv.com/cdn/shop/files/DSG0829_White_SL_Cutoff.jpg?v=1684546690"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_3_UUID,@TANK_ID);

SET @TANK_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_4_UUID, '0829. SILVER-LITE™ 2.0 OVERSIZED CUTOFF - NAVY "OTWR"',
     68, @NAVY_COLOR, "https://asrv.com/cdn/shop/files/0829Cutoff_Navy.jpg?v=1683926412,https://asrv.com/cdn/shop/files/DSG0829_Navy_SL_Cutoff.jpg?v=1684546669"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_4_UUID,@TANK_ID);

SET @TANK_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_5_UUID, '0757. SILVER-LITE™ 2.0 CUTOFF TANK - BLACK',
     58, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0757Tank_Black.jpg?v=1681235594,https://asrv.com/cdn/shop/products/Black_DSG0757_Tank.jpg?v=1681336545"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_5_UUID,@TANK_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_5_UUID,@SPRING_23_ID);

SET @TANK_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_6_UUID, '0757. SILVER-LITE™ 2.0 CUTOFF TANK - GREY',
     58, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0757Tank_SpaceGrey.jpg?v=1681235600,https://asrv.com/cdn/shop/products/SpaceGrey_DSG0757_Tank.jpg?v=1681336551"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_6_UUID,@TANK_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_6_UUID,@SPRING_23_ID);

SET @TANK_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_7_UUID, '0757. SILVER-LITE™ 2.0 CUTOFF TANK - OLIVE',
     58, @OLIVE_COLOR, "https://asrv.com/cdn/shop/products/0757Tank_Olive.jpg?v=1681235605,https://asrv.com/cdn/shop/products/Olive_DSG0757_Tank.jpg?v=1681336556"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_7_UUID,@TANK_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_7_UUID,@SPRING_23_ID);

SET @TANK_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_8_UUID, '0757. SILVER-LITE™ 2.0 CUTOFF TANK - CHAI',
     58, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0757Tank_Chai.jpg?v=1681235607,https://asrv.com/cdn/shop/products/Chai_DSG0757_Tank-Edit.jpg?v=1681258817"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_8_UUID,@TANK_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_8_UUID,@SPRING_23_ID);

SET @TANK_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_9_UUID, '0754. SILVER-LITE™ 2.0 TRAINING SINGLET - BLACK',
     58, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0754Tank_Black.jpg?v=1681235692,https://asrv.com/cdn/shop/products/Black_DSG0754_Tank.jpg?v=1681336473"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_9_UUID,@TANK_ID);

SET @TANK_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@TANK_PRODUCT_10_UUID, '0754. SILVER-LITE™ 2.0 TRAINING SINGLET - GREY',
     58, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0754Tank_SpaceGrey.jpg?v=1681235697,https://asrv.com/cdn/shop/products/SpaceGrey_DSG0754_Tank.jpg?v=1681336478"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TANK_PRODUCT_10_UUID,@TANK_ID);

-- SHORT SLEEVES --
SET @SHORT_SLEEVE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_1_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - BLACK",
78, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_Black.jpg?v=1683925498,https://asrv.com/cdn/shop/files/DSG0822_Black_SilverLiteOversized.jpg?v=1684265767"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_1_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_2_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - GREY",
78, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_SpaceGrey.jpg?v=1683925548,https://asrv.com/cdn/shop/files/DSG0822_SpaceGrey_SilverLiteOversized.jpg?v=1684265903"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_2_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_3_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - NAVY",
78, @NAVY_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_Navy.jpg?v=1683925550,https://asrv.com/cdn/shop/files/DSG0822_Navy_SilverLiteOversized.jpg?v=1684265905"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_3_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_4_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - WHITE",
78, @WHITE_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_White.jpg?v=1683925552,https://asrv.com/cdn/shop/files/DSG0822_White_SilverLiteOversized.jpg?v=1684265907"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_4_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_5_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - PLUM",
78, @PLUM_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_FadedPlum.jpg?v=1683925536,https://asrv.com/cdn/shop/files/DSG0822_FadedPlum_SilverLiteOversized.jpg?v=1684265859"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_5_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_6_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - TAUPE",
78, @TAUPE_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_DeepTaupe.jpg?v=1683925510,https://asrv.com/cdn/shop/files/DSG0822_DeepTaupe_SilverLiteOversized.jpg?v=1684265802"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_6_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_7_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - SAGE",
78, @SAGE_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_Sage.jpg?v=1683925520,https://asrv.com/cdn/shop/files/DSG0822_Sage_SilverLiteOversized.jpg?v=1684265820"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_7_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_8_UUID, "0822. SILVER-LITE™ 2.0 OVERSIZED TEE - CREAM",
78, @CREAM_COLOR, "https://asrv.com/cdn/shop/files/0822Shirt_IvoryCream.jpg?v=1683925515,https://asrv.com/cdn/shop/files/DSG0822_IvoryCream_SilverLiteOversized.jpg?v=1684265829"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_8_UUID,@SHORT_SLEEVE_ID);

SET @SHORT_SLEEVE_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_9_UUID, "0824. SUPIMA® OVERSIZED TEE - BLACK",
78, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0824Shirt_DuskBlack.jpg?v=1683925560,https://asrv.com/cdn/shop/files/DSG0824_DuskBlack_SupimaOversized.jpg?v=1684265915"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_9_UUID,@SHORT_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_9_UUID,@CORE_ID);

SET @SHORT_SLEEVE_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORT_SLEEVE_PRODUCT_10_UUID, "0824. SUPIMA® OVERSIZED TEE - NAVY",
78, @NAVY_COLOR, "https://asrv.com/cdn/shop/files/0824Shirt_Navy.jpg?v=1683925749,https://asrv.com/cdn/shop/files/DSG0824_Navy_SupimaOversized-1.jpg?v=1683925919"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_10_UUID,@SHORT_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@SHORT_SLEEVE_PRODUCT_10_UUID,@CORE_ID);

-- LONG SLEEVES --
SET @LONG_SLEEVE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_1_UUID, "0725. CORE FITTED QUARTER ZIP - BLACK",
128, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_Black.jpg?v=1676402887,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-289-Edit.jpg?v=1678824526"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@LONG_SLEEVE_PRODUCT_1_UUID,@LONG_SLEEVE_ID);

SET @LONG_SLEEVE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_2_UUID, "0725. CORE FITTED QUARTER ZIP - GREY",
128, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_SpaceGrey.jpg?v=1676402904,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-289-Edit-Edit.jpg?v=1678824657"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_2_UUID,@LONG_SLEEVE_ID);

SET @LONG_SLEEVE_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_3_UUID, "0725. CORE FITTED QUARTER ZIP - TAUPE",
128, @TAUPE_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_DeepTaupe.jpg?v=1676402915,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-277-Edit.jpg?v=1678832181"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_3_UUID,@LONG_SLEEVE_ID);

SET @LONG_SLEEVE_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_4_UUID, "0725. CORE FITTED QUARTER ZIP - CHAI",
128, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0725QZip_Chai.jpg?v=1676402925,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-271.jpg?v=1678839262"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_4_UUID,@LONG_SLEEVE_ID);

SET @LONG_SLEEVE_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
    (@LONG_SLEEVE_PRODUCT_5_UUID, "0683. SILVER-LITE™ 2.0 EXTENDED LONG SLEEVE - BLACK",
     78, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0683Shirt_Black.jpg?v=1676402897,https://asrv.com/cdn/shop/products/ASRVE-Comm-271-Edit.jpg?v=1670979493"
    );
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_5_UUID,@LONG_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_5_UUID,@WINTER_22_ID);

SET @LONG_SLEEVE_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_6_UUID, "0683. SILVER-LITE™ 2.0 EXTENDED LONG SLEEVE - NAVY",
78, @NAVY_COLOR, "https://asrv.com/cdn/shop/products/0683Shirt_Navy.jpg?v=1676402897,https://asrv.com/cdn/shop/products/ASRVE-Comm-284-Edit.jpg?v=1670979450"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_6_UUID,@LONG_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_6_UUID,@WINTER_22_ID);

SET @LONG_SLEEVE_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_7_UUID, "0683. SILVER-LITE™ 2.0 EXTENDED LONG SLEEVE - SKY",
78, @SKY_COLOR, "https://asrv.com/cdn/shop/products/0683Shirt_LightNavy.jpg?v=1670541775,https://asrv.com/cdn/shop/products/ASRVE-Comm-301.jpg?v=1670979430"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_7_UUID,@LONG_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_7_UUID,@WINTER_22_ID);

SET @LONG_SLEEVE_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_8_UUID, "0683. SILVER-LITE™ 2.0 EXTENDED LONG SLEEVE - CHAI",
78, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0683Shirt_Chai.jpg?v=1676402897,https://asrv.com/cdn/shop/products/ASRV-E-Comm-308.jpg?v=1670979404"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_8_UUID,@LONG_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_8_UUID,@WINTER_22_ID);

SET @LONG_SLEEVE_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_9_UUID, "0683. SILVER-LITE™ 2.0 EXTENDED LONG SLEEVE - STONE",
78, @STONE_COLOR, "https://asrv.com/cdn/shop/products/0683Shirt_Stone.jpg?v=1676402897,https://asrv.com/cdn/shop/products/ASRV-E-Comm-314.jpg?v=1670979476"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_9_UUID,@LONG_SLEEVE_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_9_UUID,@WINTER_22_ID);

SET @LONG_SLEEVE_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LONG_SLEEVE_PRODUCT_10_UUID, "0685. CORE MOCK NECK LONG SLEEVE - BLACK",
68, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0685Shirt_Black.jpg?v=1676402897,https://asrv.com/cdn/shop/products/ASRVE-Comm-77-Edit.jpg?v=1670875517"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LONG_SLEEVE_PRODUCT_10_UUID,@LONG_SLEEVE_ID);

-- HOODIES --
SET @HOODIE_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_1_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - BLACK",
128, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_Black.jpg?v=1678904575,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-65-Edit.jpg?v=1678904575"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_1_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_2_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - GREY",
128, @GREY_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_SpaceGrey.jpg?v=1677199298,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-93-Edit_6ab52e19-feec-42e6-83ee-bf5a6ed03364.jpg?v=1678839198"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_2_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_3_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - TAUPE",
128, @TAUPE_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_DeepTaupe.jpg?v=1677199315,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-84-Edit.jpg?v=1678839141"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_3_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_4_UUID, "0714. TECH-TERRY™ WATERPROOF HOODIE - NAVY",
138, @NAVY_COLOR, "https://asrv.com/cdn/shop/products/0680Hoodie_Navy.jpg?v=1673462291,https://asrv.com/cdn/shop/products/ASRVE-Comm-342-Edit.jpg?v=1673462291"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_4_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_5_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - OLIVE",
128, @OLIVE_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_Olive.jpg?v=1677199315,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-93-Edit.jpg?v=1678839175"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_5_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_6_UUID, "0714. TECH-TERRY™ WATERPROOF PANEL HOODIE - CHAI",
128, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0714Hoodie_Chai_9c66f676-68cb-44ad-9c13-c4ece52416a9.jpg?v=1678219160,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-112.jpg?v=1678839109"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_6_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_7_UUID, "0714. TECH-TERRY™ WATERPROOF HOODIE - BLACK",
138, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0680Hoodie_Black.jpg?v=1673462291,https://asrv.com/cdn/shop/products/ASRVE-Comm-375-Edit.jpg?v=1673462282"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_7_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_8_UUID, "0714. TECH-TERRY™ WATERPROOF HOODIE - SKY",
138, @SKY_COLOR, "https://asrv.com/cdn/shop/products/0680Hoodie_LightSky.jpg?v=1673462306,https://asrv.com/cdn/shop/products/ASRVE-Comm-391-Edit-Edit.jpg?v=1673462306"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_8_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_9_UUID, "0714. TECH-TERRY™ WATERPROOF HOODIE - CHAI",
138, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0680Hoodie_Chai.jpg?v=1673462291,https://asrv.com/cdn/shop/products/ASRV-E-Comm-357.jpg?v=1673462317"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_9_UUID,@HOODIE_ID);

SET @HOODIE_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@HOODIE_PRODUCT_10_UUID, "0714. TECH-TERRY™ WATERPROOF HOODIE - STONE",
138, @STONE_COLOR, "https://asrv.com/cdn/shop/products/0680Hoodie_Stone.jpg?v=1673462291,https://asrv.com/cdn/shop/products/ASRV-E-Comm-323.png?v=1673462329"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@HOODIE_PRODUCT_10_UUID,@HOODIE_ID);

-- OUTERWEAR --
SET @OUTERWEAR_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_1_UUID, "0717. WATERPROOF ANORAK JACKET - BLACK",
158, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0717Jacket_Black.jpg?v=1677003998,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-1-Edit.jpg?v=1678747055"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_1_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_2_UUID, "0717. WATERPROOF ANORAK JACKET - OLIVE",
158, @OLIVE_COLOR, "https://asrv.com/cdn/shop/products/0717Jacket_Olive.jpg?v=1678838939,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-27-Edit.jpg?v=1678838939"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_2_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_3_UUID, "0717. WATERPROOF ANORAK JACKET - TAUPE",
158, @TAUPE_COLOR, "https://asrv.com/cdn/shop/products/0717Jacket_DeepTaupe.jpg?v=1678838939,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-15-Edit.jpg?v=1678832121"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_3_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_4_UUID, "0717. WATERPROOF ANORAK JACKET - CHAI",
158, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0717Jacket_Chai_c9209fba-cabe-4daa-ba7d-7d09915d1218.jpg?v=1678219134,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-52.jpg?v=1678812798"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_4_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_5_UUID, "0720. WATERPROOF INSULATED RUN VEST - BLACK",
198, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0720Vest_Black.jpg?v=1678219134,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-150.jpg?v=1678839727"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_5_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_6_UUID, "0720. WATERPROOF INSULATED RUN VEST - OLIVE",
198, @OLIVE_COLOR, "https://asrv.com/cdn/shop/products/0720Vest_Olive.jpg?v=1678219134,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-129-Edit-Edit.jpg?v=1678829523"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_6_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_7_UUID, "0720. WATERPROOF INSULATED RUN VEST - TAUPE",
198, @TAUPE_COLOR, "https://asrv.com/cdn/shop/products/0720Vest_DeepTaupe.jpg?v=1678219134,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-129-Edit.jpg?v=1678829463"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_7_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_8_UUID, "0720. WATERPROOF INSULATED RUN VEST - CHAI",
198, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0720Vest_Chai_86425d32-677d-4713-8640-772204b8f1ff.jpg?v=1678219153,https://asrv.com/cdn/shop/products/ASRV-Spring-23-E-Comm-120.jpg?v=1678829315"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_8_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_9_UUID, "0677. KINTERRA™ WEATHERPROOF BOMBER JACKET - BLACK",
248, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0677Bomber_Black.jpg?v=1670550769,https://asrv.com/cdn/shop/products/ASRVE-Comm-65-Edit.jpg?v=1670871263"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_9_UUID,@OUTERWEAR_ID);

SET @OUTERWEAR_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@OUTERWEAR_PRODUCT_10_UUID, "0677. KINTERRA™ WEATHERPROOF BOMBER JACKET - NAVY",
248, @NAVY_COLOR, "https://asrv.com/cdn/shop/products/0677Bomber_Navy.jpg?v=1670550769,https://asrv.com/cdn/shop/products/ASRVE-Comm-27-Edit.jpg?v=1670871232"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@OUTERWEAR_PRODUCT_10_UUID,@OUTERWEAR_ID);

-- SHORTS --
SET @SHORTS_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_1_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - BLACK "WINGS"/BLACK',
118, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Black_Wings_Black.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Black.jpg?v=1683396279"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_1_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_1_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_2_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - RAVEN "WINGS"/BLACK',
118, @RAVEN_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Raven_Wings_Black.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Raven.jpg?v=1683396475"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_2_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_2_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_3_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - NAVY "WINGS"/BLACK',
118, @NAVY_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Navy_Wings_Black.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Navy.jpg?v=1683396375"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_3_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_3_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_4_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - TAUPE "WINGS"/BLACK',
118, @TAUPE_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_DeepTaupe_Wings_Black.jpg?v=1683142298,https://asrv.com/cdn/shop/files/DSG0865_Wings_DeepTaupe.jpg?v=1683396328"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_4_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_4_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_5_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - OLIVE "WINGS"/BLACK',
118, @OLIVE_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Olive_Wings_Black.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Olive.jpg?v=1683396425"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_5_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_5_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_6_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - SAGE "WINGS"/BLACK',
118, @SAGE_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Sage_Wings_Black.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Sage.jpg?v=1683396520"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_6_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_6_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_7_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - SMOKE "WINGS"/BLACK',
118, @SMOKE_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_SandSmoke_Wings_Black.jpg?v=1683142256,https://asrv.com/cdn/shop/files/DSG0865_Wings_Sand_8e6d5a3f-7c54-437f-80e7-961afe6ad98d.jpg?v=1683829812"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_7_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_7_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_8_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - GREY "WINGS"/BLACK',
118, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Slate_Wings_Black.jpg?v=1683142476,https://asrv.com/cdn/shop/files/DSG0865_Wings_Slate.jpg?v=1683396633"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_8_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_8_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_9_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - BLACK "BRACKET"/BLACK',
118, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Black_Bracket_Black.jpg?v=1683142235,https://asrv.com/cdn/shop/files/DSG0865_Black_Bracket.jpg?v=1683570469"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_9_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_9_UUID, @CORE_ID);

SET @SHORTS_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@SHORTS_PRODUCT_10_UUID, '0865. TETRA-LITE™ 5" LINER SHORT - RAVEN "BRACKET"/BLACK',
118, @RAVEN_COLOR, "https://asrv.com/cdn/shop/files/0865Shorts_Raven_Bracket_White.jpg?v=1683142379,https://asrv.com/cdn/shop/files/DSG0865_Brackets_Raven.jpg?v=1683396148"
);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_10_UUID, @SHORTS_ID);
INSERT INTO product_collection(product_uuid, collection_id) VALUES (@SHORTS_PRODUCT_10_UUID, @CORE_ID);

-- TECH JOGGERS --
SET @TECH_JOGGERS_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_1_UUID, "0654. TECH-TERRY™ CARGO HIGH RIB JOGGER - DUSK BLACK",
148, @BLACK_COLOR, "https://asrv.com/cdn/shop/files/0654Joggers_DuskBlack_11ef660a-d312-4bd6-aa7a-f2494c49675f.jpg?v=1683571064,https://asrv.com/cdn/shop/files/DSG0654_DuskBlack_Jogger_fa1e957d-2179-4045-8293-d6b4365fd471.jpg?v=1683665249"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_1_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_2_UUID, "0654. TECH-TERRY™ CARGO HIGH RIB JOGGER - WHITE",
148, @WHITE_COLOR, "https://asrv.com/cdn/shop/files/0654Joggers_White_dc526bda-447a-468f-bb11-c48fbd393d32.jpg?v=1685058120,https://asrv.com/cdn/shop/files/Fall-22-E-Comm-414-2-white.jpg?v=1685062593"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_2_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_3_UUID, "0654. TECH-TERRY™ CARGO HIGH RIB JOGGER - SMOKE",
148, @SMOKE_COLOR, "https://asrv.com/cdn/shop/files/0654Joggers_SandSmoke.png?v=1685058106,https://asrv.com/cdn/shop/files/Etherea_Tech_Terry_High_Rib_Main-SS.jpg?v=1685063031"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_3_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_4_UUID, "0654. TECH-TERRY™ CARGO HIGH RIB JOGGER - RAVEN",
148, @RAVEN_COLOR, "https://asrv.com/cdn/shop/files/0654Joggers_Raven.jpg?v=1685058119,https://asrv.com/cdn/shop/files/Red_Earth_Terry_Cargo_High_Rib_Mainraven.jpg?v=1685063504"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_4_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_5_UUID, "0655. TECH-TERRY™ OVERSIZED SWEATS - BLACK",
138, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0655Jogger_Black.jpg?v=1663281290,https://asrv.com/cdn/shop/products/Fall-22-E-Comm-13.jpg?v=1663281290"
);

SET @TECH_JOGGERS_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_6_UUID, "0655. TECH-TERRY™ OVERSIZED SWEATS - RAVEN",
138, @RAVEN_COLOR, "https://asrv.com/cdn/shop/files/0655Jogger_Raven.jpg?v=1683967430,https://asrv.com/cdn/shop/files/DSG0655_Raven_Sweats_Darker_1.jpg?v=1683967430"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_6_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_7_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_7_UUID, "0655. TECH-TERRY™ OVERSIZED SWEATS - SMOKE",
138, @SMOKE_COLOR, "https://asrv.com/cdn/shop/files/0655Jogger_SandSmoke.jpg?v=1683141320,https://asrv.com/cdn/shop/files/DSG0655_SandSmoke_Sweats_LessYellow_Front1.jpg?v=1683969236"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_7_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_8_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_8_UUID, "0655. TECH-TERRY™ OVERSIZED SWEATS - WHITE",
138, @WHITE_COLOR, "https://asrv.com/cdn/shop/files/0655Jogger_White.jpg?v=1683967430,https://asrv.com/cdn/shop/files/DSG0655_White_Sweats.jpg?v=1683658118"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_8_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_9_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_9_UUID, "0655. TECH-TERRY™ OVERSIZED SWEATS - GREY",
138, @GREY_COLOR, "https://asrv.com/cdn/shop/files/0655Jogger_Heather.jpg?v=1683304914,https://asrv.com/cdn/shop/files/DSG0655_HeatherGrey_Sweats_99866c06-bdfc-4c6b-8eee-6e78392a641f.jpg?v=1684191678"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_9_UUID,@TECH_JOGGERS_ID);

SET @TECH_JOGGERS_PRODUCT_10_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_10_UUID, "0739. ALL CONDITION MOTO JOGGER - BLACK",
148, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0739Jogger_Black.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-197-Edit.jpg?v=1678831277"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_10_UUID,@TECH_JOGGERS_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_10_UUID,@SPRING_23_ID);

SET @TECH_JOGGERS_PRODUCT_11_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_11_UUID, "0693. KINTERRA™ WEATHERPROOF SNAP PANT - BLACK",
98, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0693Pant_Black.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRVE-Comm-83.jpg?v=1670871838"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_11_UUID,@TECH_JOGGERS_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_11_UUID,@WINTER_22_ID);

SET @TECH_JOGGERS_PRODUCT_12_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_12_UUID, "0693. KINTERRA™ WEATHERPROOF SNAP PANT - NAVY",
98, @NAVY_COLOR, "https://asrv.com/cdn/shop/products/0693Pant_Navy.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRVE-Comm-44-Edit.jpg?v=1670871801"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_12_UUID,@TECH_JOGGERS_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_12_UUID,@WINTER_22_ID);

SET @TECH_JOGGERS_PRODUCT_13_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_13_UUID, "0693. KINTERRA™ WEATHERPROOF SNAP PANT - CHAI",
98, @CHAI_COLOR, "https://asrv.com/cdn/shop/products/0693Pant_Chai.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRV-E-Comm-19.jpg?v=1670871732"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_13_UUID,@TECH_JOGGERS_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_13_UUID,@WINTER_22_ID);

SET @TECH_JOGGERS_PRODUCT_14_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@TECH_JOGGERS_PRODUCT_14_UUID, "0693. KINTERRA™ WEATHERPROOF SNAP PANT - STONE",
98, @STONE_COLOR, "https://asrv.com/cdn/shop/products/0693Pant_Stone.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRV-E-Comm-57.jpg?v=1670871702"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_14_UUID,@TECH_JOGGERS_ID);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@TECH_JOGGERS_PRODUCT_14_UUID,@WINTER_22_ID);

-- LEGGINGS --
SET @LEGGINGS_PRODUCT_1_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_1_UUID, "0747. WARPFLEXX™ SIDE POCKET 3/4-LENGTH LEGGING - BLACK",
68, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0747Legging_Black.jpg?v=1677697123,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-453-Edit-Edit.jpg?v=1678824824"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_1_UUID,@LEGGINGS_ID);

SET @LEGGINGS_PRODUCT_2_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_2_UUID, "0747. WARPFLEXX™ SIDE POCKET 3/4-LENGTH LEGGING - WHITE",
68, @WHITE_COLOR, "https://asrv.com/cdn/shop/products/0747Legging_White.jpg?v=1677697130,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-450-Edit.jpg?v=1678824838"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_2_UUID,@LEGGINGS_ID);

SET @LEGGINGS_PRODUCT_3_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_3_UUID, "0746. WARPFLEXX™ SIDE POCKET 1/2-LENGTH LEGGING - BLACK",
58, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0746HalfLiner_Black.jpg?v=1677697106,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-448-Edit.jpg?v=1678813477"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_3_UUID,@LEGGINGS_ID);

SET @LEGGINGS_PRODUCT_4_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_4_UUID, "0746. WARPFLEXX™ SIDE POCKET 1/2-LENGTH LEGGING - WHITE",
58, @WHITE_COLOR, "https://asrv.com/cdn/shop/products/0746HalfLiner_White.jpg?v=1677697113,https://asrv.com/cdn/shop/products/ASRVSpring23E-Comm-446-Edit-Edit.jpg?v=1678813517"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_4_UUID,@LEGGINGS_ID);

SET @LEGGINGS_PRODUCT_5_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_5_UUID, "0691. WARPFLEXX® SIDE POCKET LEGGING - BLACK",
78, @BLACK_COLOR, "https://asrv.com/cdn/shop/products/0691Leggings_Black.jpg?v=1670614257,https://asrv.com/cdn/shop/products/ASRVE-Comm-266-Edit.jpg?v=1670876945"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_5_UUID,@LEGGINGS_ID);

SET @LEGGINGS_PRODUCT_6_UUID = UUID();
INSERT INTO products (uuid, name, price, color, images) VALUES
(@LEGGINGS_PRODUCT_6_UUID, "0691. WARPFLEXX® SIDE POCKET LEGGING - WHITE",
78, @WHITE_COLOR, "https://asrv.com/cdn/shop/products/0691Leggings_White.jpg?v=1670614264,https://asrv.com/cdn/shop/products/ASRVE-Comm-263-Edit.jpg?v=1670876968"
);
INSERT INTO product_collection(product_uuid,collection_id) VALUES (@LEGGINGS_PRODUCT_6_UUID,@LEGGINGS_ID);
