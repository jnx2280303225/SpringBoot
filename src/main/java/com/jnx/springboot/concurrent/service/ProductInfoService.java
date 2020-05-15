package com.jnx.springboot.concurrent.service;

import com.jnx.springboot.concurrent.form.ProductForm;

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
}
