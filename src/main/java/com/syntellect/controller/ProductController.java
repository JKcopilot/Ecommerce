package com.syntellect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntellect.Bean.ProductBean;
import com.syntellect.dao.ProductDao;
import com.syntellect.exception.GlobalException;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductBean> createProduct(@RequestBody ProductBean productBean)throws GlobalException {
    	ProductBean saveProduct = productDao.save(productBean);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductBean> getProductById(@PathVariable Long id) {
        Optional<ProductBean> product = productDao.findById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/getAllProducts")
    public List<ProductBean> getAllProducts(){
    	return productDao.findAll();
    }
    
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductBean> updateProduct(@PathVariable Long id, @RequestBody ProductBean updatedProduct) 
    		throws GlobalException {
        Optional<ProductBean> product = productDao.findById(id);
        if (product.isPresent()) {
            updatedProduct.setProduct_id(id);
            ProductBean savedProduct = productDao.save(updatedProduct);
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<ProductBean> product = productDao.findById(id);
        if (product.isPresent()) {
            productDao.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
