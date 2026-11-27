package com.CV.PlantOps.Products.Service;

import com.CV.PlantOps.Products.Dto.MessageResponse;
import com.CV.PlantOps.Products.Dto.ProductRequest;
import com.CV.PlantOps.Products.Dto.ProductResponse;
import com.CV.PlantOps.Products.Entity.Product;
import com.CV.PlantOps.Products.Exceptions.ProductNotFoundException;
import com.CV.PlantOps.Products.Mapper.ProductMapper;
import com.CV.PlantOps.Products.Repository.ProductRepository;
import com.CV.PlantOps.Products.Service.Interface.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        Product savedAndFlushed = productRepository.saveAndFlush(product);
        return productMapper.toResponse(savedAndFlushed);
        //return new MessageResponse("Product created correctly");
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productMapper.updateEntityFromRequest(request, product);
        Product updatedAndFlushed = productRepository.saveAndFlush(product);
        return productMapper.toResponse(updatedAndFlushed);
    }

    @Override
    public MessageResponse deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return new MessageResponse("Product deleted correctly");
    }
}
