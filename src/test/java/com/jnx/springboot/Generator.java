package com.jnx.springboot;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


/**
 * Mybatis-Plus逆向工程
 *
 * @author 蒋楠鑫
 * @date 2019-12-05
 */
public class Generator {

	/**
	 * 数据库类型(MySQL SQLServer Oracle等)
	 */
	private final static DbType DB_TYPE = DbType.MYSQL;

	/**
	 * 数据库连接驱动类型
	 */
	private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	/**
	 * 数据库url
	 */
	private final static String DB_URL = "jdbc:mysql://localhost:3306/springboot";

	/**
	 * 用户名
	 */
	private final static String DB_USER_NAME = "root";

	/**
	 * 密码
	 */
	private final static String DB_PASSWORD = "Jiang950813";

	/**
	 * 生成的包名
	 */
	private final static String PACKAGE_NAME = "com.jnx.springboot.common";

	/**
	 * 要生成的表名
	 */
	private final static String[] TABLE_NAMES = {
			"order", "product", "order_detail"
	};

	/**
	 * 要去掉的前缀
	 */
	private final static String[] TABLE_PREFIX = {"xxx", "yyy"};

	/**
	 * 生成代码存放的硬盘位置
	 */
	private final static String OUT_PUT_DIR = "/Users/jiangnanxin/Desktop";

	/**
	 * user -> UserService, 设置成true: user -> IUserService
	 */
	private final static boolean SERVICE_NAME_START_WITH_I = false;

	@Test
	public void generateCode() {
		generateByTables(TABLE_NAMES);
	}

	private void generateByTables(String... tableNames) {
		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DB_TYPE)
				.setUrl(DB_URL)
				.setUsername(DB_USER_NAME)
				.setPassword(DB_PASSWORD)
				.setDriverName(DB_DRIVER);
		// 生成实体类的策略配置
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true)
				.entityTableFieldAnnotationEnable(true)
				.setSkipView(true)
				.setEntityLombokModel(true)
				.setTablePrefix(TABLE_PREFIX)
				// 表名和字段名的映射规则
				.setNaming(NamingStrategy.underline_to_camel)
				.setColumnNaming(NamingStrategy.nochange)
				// 修改替换成你需要的表名，多个表名传数组
				.setInclude(tableNames);
		// 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setIdType(IdType.AUTO)
				.setAuthor("蒋楠鑫")
				// 日期时间对应hJava类型
				.setDateType(DateType.TIME_PACK)
				.setOutputDir(OUT_PUT_DIR)
				.setFileOverride(true);
		if (!SERVICE_NAME_START_WITH_I) {
			config.setServiceName("%sService");
		}
		// 包名配置
		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setParent(PACKAGE_NAME)
				.setController("controller")
				.setEntity("entity")
				.setService("service")
				.setServiceImpl("service.impl")
				.setMapper("mapper");
		// 执行代码生成器
		new AutoGenerator().setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(packageConfig)
				.execute();
	}
}
