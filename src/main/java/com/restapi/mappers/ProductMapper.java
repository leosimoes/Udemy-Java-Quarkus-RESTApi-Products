package com.restapi.mappers;

import com.restapi.dtos.ProductDTO;
import com.restapi.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper
@Mapper(componentModel = "CDI")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(ProductEntity productEntity);

    ProductEntity toEntity(ProductDTO productDTO);

    List<ProductDTO> toDTOList(List<ProductEntity> productEntities);
    List<ProductEntity> toEntityList(List<ProductDTO> productDTOs);

}
