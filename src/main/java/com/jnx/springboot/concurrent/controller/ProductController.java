package com.jnx.springboot.concurrent.controller;

import com.jnx.springboot.common.message.Result;
import com.jnx.springboot.concurrent.form.ProductForm;
import com.jnx.springboot.concurrent.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Result<String> saveProduct(@RequestBody ProductForm productForm){
		productInfoService.saveProduct(productForm);
		return Result.ok("保存成功！");
	}
}