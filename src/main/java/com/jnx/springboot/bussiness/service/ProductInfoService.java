package com.jnx.springboot.bussiness.service;

import com.jnx.springboot.bussiness.form.ProductForm;
import com.jnx.springboot.bussiness.vo.ProductInfoVO;

import java.util.List;

/**
 * 商品信息业务逻辑层接口
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
public interface ProductInfoService {

	/**
	 * 保存商品信息
	 *
	 * @param productForm 商品信息
	 */
	void saveProduct(ProductForm productForm);

	/**
	 * 获取所有商品集合
	 *
	 * @return 商品信息集合
	 */
	List<ProductInfoVO> getProductList();
}
