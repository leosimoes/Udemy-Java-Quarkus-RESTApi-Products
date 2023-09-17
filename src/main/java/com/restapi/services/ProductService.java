package com.restapi.services;

import com.restapi.dtos.ProductDTO;
import com.restapi.entities.ProductEntity;
import com.restapi.mappers.ProductMapper;
import com.restapi.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Inject
    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = this.productMapper.toEntity(productDTO);
        this.productRepository.persist(productEntity);

        return this.productMapper.toDTO(productEntity);
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = this.productRepository.listAll();
        return this.productMapper.toDTOList(productEntities);
    }

    public ProductDTO getProductById(Long id) {
        Optional<ProductEntity> productEntityOpt = this.productRepository.findByIdOptional(id);

        if (productEntityOpt.isEmpty()) {
            // Lidar com o caso em que o produto não foi encontrado
            // Retorne null ou lance uma exceção adequada
            return null;
        }

        ProductEntity productEntity = productEntityOpt.get();

        return this.productMapper.toDTO(productEntity);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<ProductEntity> productEntityOpt = this.productRepository.findByIdOptional(id);

        if (productEntityOpt.isEmpty()) {
            // Lidar com o caso em que o produto não foi encontrado
            // Retorne null ou lance uma exceção adequada
            return null;
        }

        ProductEntity productEntity = productEntityOpt.get();

        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setCategory(productDTO.getCategory());
        productEntity.setModel(productDTO.getModel());
        productEntity.setPrice(new BigDecimal(productDTO.getPrice()));

        this.productRepository.persist(productEntity);

        return this.productMapper.toDTO(productEntity);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Optional<ProductEntity> productEntityOpt = this.productRepository.findByIdOptional(id);

        if (productEntityOpt.isPresent()) {
            this.productRepository.deleteById(id);
        }
    }
}