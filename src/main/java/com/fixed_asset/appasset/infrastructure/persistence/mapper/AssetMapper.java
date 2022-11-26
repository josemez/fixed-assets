package com.fixed_asset.appasset.infrastructure.persistence.mapper;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssetMapper {

    Asset toDomain(AssetDB assetDB);
    List<Asset> toDomains(List<AssetDB> assets);

    @InheritInverseConfiguration
    AssetDB toDb(Asset asset);
}
