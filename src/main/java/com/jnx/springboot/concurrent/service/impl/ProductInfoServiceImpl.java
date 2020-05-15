package com.jnx.springboot.concurrent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnx.springboot.common.constant.CommonStatusEnum;
import com.jnx.springboot.common.entity.Product;
import com.jnx.springboot.common.exception.ExceptionConstant;
import com.jnx.springboot.common.mapper.ProductMapper;
import com.jnx.springboot.concurrent.form.ProductForm;
import com.jnx.springboot.concurrent.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 商品信息业务逻辑层实现类
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	/**
	 * 商品信息公共数据层
	 */
	@Autowired
	private ProductMapper productMapper;

	/**
	 * 保存商品信息
	 *
	 * @param productForm 商品信息
	 */
	@Override
	public void saveProduct(ProductForm productForm) {
		// 先判断名称是否重复
		QueryWrapper<Product> wrapper = new QueryWrapper<>();
		wrapper.select("COUNT(id)").eq("name", productForm.getName()).eq("status", CommonStatusEnum.START_STATUS);
		int count = productMapper.selectCount(wrapper);
		if (count > 0) {
			throw ExceptionConstant.PRODUCT_NAME_EXISTS;
		}
		// 生成商品号
		String productNo = UUID.randomUUID().toString().replace("-", "");
		Product product = new Product();
		product.setStatus(productForm.getStatus()).setCreated(LocalDateTime.now()).setPrice(productForm.getPrice())
				.setProductNo(productNo).setName(productForm.getName()).setRemark(productForm.getRemark());
	}
}
