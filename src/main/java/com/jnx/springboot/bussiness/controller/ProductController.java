package com.jnx.springboot.bussiness.controller;

import com.jnx.springboot.common.message.Result;
import com.jnx.springboot.bussiness.form.ProductForm;
import com.jnx.springboot.bussiness.service.ProductInfoService;
import com.jnx.springboot.bussiness.vo.ProductInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品模块控制器
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@RequestMapping("product")
@Api(tags = "商品模块控制器")
@RestController
@Validated
public class ProductController {

	/**
	 * 商品模块私有业务层
	 */
	@Autowired
	private ProductInfoService productInfoService;

	@ApiOperation("保存商品信息")
	@PostMapping("saveProduct")
	public Result<String> saveProduct(@RequestBody ProductForm productForm) {
		productInfoService.saveProduct(productForm);
		return Result.ok("商品信息保存成功！");
	}

	@ApiOperation("获取所有商品信息")
	@GetMapping("getProductList")
	public Result<List<ProductInfoVO>> getProductList() {
		return Result.ok(productInfoService.getProductList());
	}
}
