package com.fixed_asset.appasset.infrastructure.persistence.mapper;

import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AreaDB;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaMapper {


    Area toDomain(AreaDB areaDB);
    List<Area> toDomains(List<AreaDB> areas);

    @InheritInverseConfiguration
    AreaDB toDb(Area area);
}
