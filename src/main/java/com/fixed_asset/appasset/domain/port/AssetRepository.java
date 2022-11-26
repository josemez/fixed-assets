package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Asset;

public interface AssetRepository {
    Asset searchAll();
    Asset searchByType();
    Asset searchByDate();
    Asset searchBySerial();
    Asset create();
    Asset Update();
}
