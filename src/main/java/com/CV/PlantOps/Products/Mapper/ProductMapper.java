package com.CV.PlantOps.Products.Mapper;

import com.CV.PlantOps.Products.Dto.ProductRequest;
import com.CV.PlantOps.Products.Dto.ProductResponse;
import com.CV.PlantOps.Products.Entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "internalCode", ignore = true)
    Product toEntity(ProductRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "internalCode", ignore = true)
    void updateEntityFromRequest(ProductRequest request, @MappingTarget Product product);

    ProductResponse toResponse(Product product);
}
