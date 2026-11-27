package com.CV.PlantOps.Products.Service.Interface;

import com.CV.PlantOps.Products.Dto.ProductRequest;
import com.CV.PlantOps.Products.Dto.ProductResponse;
import com.CV.PlantOps.Products.Entity.Product;
import com.CV.PlantOps.Products.Dto.MessageResponse;

import java.util.List;

public interface IProductService {
    //Create
    ProductResponse createProduct(ProductRequest request);

    //Read
    List<ProductResponse> getAllProduct();
    ProductResponse getProductById(Long id);

    //Update
    ProductResponse updateProduct(Long id, ProductRequest request);

    //Delete
    MessageResponse deleteProduct(Long id);
}
