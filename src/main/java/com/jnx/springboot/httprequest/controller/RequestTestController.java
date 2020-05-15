package com.jnx.springboot.httprequest.controller;

import com.jnx.springboot.common.message.Result;
import com.jnx.springboot.httprequest.vo.InfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试用的控制器
 *
 * @author 蒋楠鑫
 * @date 2020/3/31
 */
@RestController
@RequestMapping("test")
@Api(tags = "前后端交互请求测试")
public class RequestTestController {

	@ApiOperation("枚举类型测试-Get请求")
	@GetMapping("getInfo")
	public Result<String> getInfo(InfoVO infoVO) {
		System.out.println(infoVO);
		return Result.ok("成功");
	}

	@ApiOperation("枚举类型测试-Post请求")
	@PostMapping("postInfo")
	public Result<String> postInfo(@RequestBody InfoVO infoVO) {
		System.out.println(infoVO);
		return Result.ok("成功");
	}

	@ApiOperation("集合类型测试-Get请求")
	@GetMapping("getList")
	public Result<String> getList(List<Integer> list) {
		System.out.println(list);
		return Result.ok("成功");
	}

}
