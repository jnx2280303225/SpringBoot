package com.jnx.springboot.concurrent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnx.springboot.common.constant.CommonStatusEnum;
import com.jnx.springboot.common.entity.Product;
import com.jnx.springboot.common.exception.ExceptionConstant;
import com.jnx.springboot.common.mapper.ProductMapper;
import com.jnx.springboot.concurrent.form.ProductForm;
import com.jnx.springboot.concurrent.service.ProductInfoService;
import com.jnx.springboot.concurrent.vo.ProductInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
	 * 自定义常量 --- 空集合长度
	 */
	private static final int EMPTY_LIST_SIZE = 0;

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
		wrapper.eq("name", productForm.getName()).eq("status", CommonStatusEnum.START_STATUS.getCode());
		int count = productMapper.selectCount(wrapper);
		if (count > 0) {
			throw ExceptionConstant.PRODUCT_NAME_EXISTS;
		}
		// 生成商品号
		String productNo = UUID.randomUUID().toString().replace("-", "");
		Product product = new Product();
		product.setStatus(productForm.getStatus()).setCreated(LocalDateTime.now()).setPrice(productForm.getPrice())
				.setProductNo(productNo).setName(productForm.getName()).setRemark(productForm.getRemark())
				.setNumber(productForm.getNumber());
		productMapper.insert(product);
	}

	/**
	 * 获取所有商品集合
	 *
	 * @return 商品信息集合
	 */
	@Override
	public List<ProductInfoVO> getProductList() {
		List<Product> productList = productMapper.selectList(null);
		// 为空就返回空集合
		if (CollectionUtils.isEmpty(productList)) {
			return new ArrayList<>(EMPTY_LIST_SIZE);
		}
		// 封装成VO对象
		List<ProductInfoVO> list = new ArrayList<>(productList.size());
		for (Product product : productList) {
			ProductInfoVO productInfoVO = new ProductInfoVO();
			productInfoVO.setProductNo(product.getProductNo()).setName(product.getName()).setNumber(product.getNumber())
					.setPrice(product.getPrice()).setRemark(product.getRemark());
			list.add(productInfoVO);
		}
		return list;
	}
}
