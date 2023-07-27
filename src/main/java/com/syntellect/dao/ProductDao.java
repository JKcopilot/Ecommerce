package com.syntellect.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syntellect.Bean.ProductBean;

@Repository
public interface ProductDao extends JpaRepository<ProductBean, Long>{

}
