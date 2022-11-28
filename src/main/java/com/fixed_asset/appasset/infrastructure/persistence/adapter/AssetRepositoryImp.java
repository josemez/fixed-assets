package com.fixed_asset.appasset.infrastructure.persistence.adapter;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.port.AssetRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;
import com.fixed_asset.appasset.exceptions.NotFoundException;
import com.fixed_asset.appasset.infrastructure.persistence.AssetCrudRepository;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import com.fixed_asset.appasset.infrastructure.persistence.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AssetRepositoryImp implements AssetRepository {

    @Autowired
    private AssetCrudRepository repository;

    @Autowired
    private AssetMapper mapper;


    @Override
    public List<Asset> searchAll(int page, int size) throws ApiException   {

        try {
            List<AssetDB> assets = repository.findAll(PageRequest.of(page, size)).getContent();
            if (assets.size() < 1) {
                throw new NotFoundException();
            }
            return mapper.toDomains(assets);
        }
        catch (NotFoundException e) {
        throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }

    @Override
    public List<Asset> searchByType(String type) throws ApiException  {


        try {
            List<AssetDB> assets =  repository.findByType(type);
            if (assets.size() < 1) {
                throw new NotFoundException();
            }
            return mapper.toDomains(assets);

        }
        catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }

    @Override
    public  List<Asset> searchByDate(LocalDateTime date) throws ApiException {

        try {
            List<AssetDB> assets  =  repository.findByDatePurchase(date);
            if (assets.size() < 1) {
                throw new NotFoundException();
            }
            return mapper.toDomains(assets);

        }
        catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }

    }

    @Override
    public Asset searchBySerial(String serial) throws ApiException  {

        try {
            AssetDB asset =  repository.findBySerial(serial);
            if (asset == null) {
                throw new NotFoundException();
            }
            return mapper.toDomain(asset);

        }
        catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }

    @Override
    public Asset create(Asset asset) throws ApiException {
        try {
            AssetDB a = repository.save(mapper.toDb(asset));
            return mapper.toDomain(a);
        } catch (Exception e) {
           throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }

    @Override
    public Asset Update(Asset asset) throws ApiException {

        try {
            return mapper.toDomain(repository.save(mapper.toDb(asset)));
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }

    @Override
    public Asset findById(Integer id) throws ApiException {
        Asset asset;
        try {
            Optional<AssetDB> assetDB = repository.findById(id);
            asset = assetDB.map(t -> mapper.toDomain(assetDB.get())).orElseThrow(() -> new NotFoundException() );
        }
        catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
        return asset;
    }


}
