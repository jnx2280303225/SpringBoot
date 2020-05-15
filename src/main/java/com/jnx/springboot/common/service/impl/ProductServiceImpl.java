package com.jnx.springboot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnx.springboot.common.entity.Product;
import com.jnx.springboot.common.mapper.ProductMapper;
import com.jnx.springboot.common.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author 蒋楠鑫
 * @since 2020-05-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
