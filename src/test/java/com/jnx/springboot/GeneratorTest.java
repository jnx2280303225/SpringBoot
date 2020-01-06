package com.jnx.springboot;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


/**
 * Mybatis-Plus逆向工程
 * @author 蒋楠鑫
 * @date 2019-12-05
 */
public class GeneratorTest {
	
	/**
	 * 数据库类型(MySQL SQLServer Oracle等)
	 */
	private final static DbType DB_TYPE = DbType.SQL_SERVER;
	/**
	 * 数据库连接驱动类型
	 */
	private final static String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/**
	 * 数据库url
	 */
	private final static String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=user";
	/**
	 * 用户名
	 */
	private final static String DB_USER_NAME = "sa";
	/**
	 * 密码
	 */
	private final static String DB_PASSWORD = "123456";
	/**
	 * 生成的包名
	 */
	private final static String PACKAGE_NAME = "com.jnx";
	/**
	 * 要生成的表名
	 */
	private final static String[] TABLE_NAMES = {
			"user","student"
	};
	/**
	 * 要去掉的前缀
	 */
	private final static String[] TABLE_PREFIX = {"xxx","zzz","ddd"};
	/**
	 * 生成代码存放的硬盘位置
	 */
	private final static String OUT_PUT_DIR = "D:\\逆向工程";
	/**
	 * user -> UserService, 设置成true: user -> IUserService
	 */
	private final static boolean SERVICE_NAME_START_WITH_I = false;

	@Test
	public void generateCode() {
		generateByTables(SERVICE_NAME_START_WITH_I, PACKAGE_NAME, TABLE_NAMES);
	}

	private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
		GlobalConfig config = new GlobalConfig();
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DB_TYPE)
				.setUrl(DB_URL)
				.setUsername(DB_USER_NAME)
				.setPassword(DB_PASSWORD)
				.setDriverName(DB_DRIVER);
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig
				.setCapitalMode(true)
				// 逻辑删除字段
				.setLogicDeleteFieldName("isDeleted")
				.setEntityLombokModel(false)
				.setTablePrefix(TABLE_PREFIX)
				.setNaming(NamingStrategy.underline_to_camel)
				//修改替换成你需要的表名，多个表名传数组
				.setInclude(tableNames);

		//生成模板引擎,需要注入模板引擎的依赖,跳过模板引擎，后续自己手写
//		TemplateConfig tc = new TemplateConfig();
//		tc.setController("template/controller.java.vm");
//		tc.setEntity("template/entity.java.vm");
//		tc.setMapper("template/mapper.java.vm");
//		tc.setXml("template/mapper.xml.vm");
//		tc.setService("template/service.java.vm");
//		tc.setServiceImpl("template/serviceImpl.java.vm");
		config.setActiveRecord(false)
				.setAuthor("蒋楠鑫")
				.setOutputDir(OUT_PUT_DIR)
				.setFileOverride(true);
		if (!serviceNameStartWithI) {
			config.setServiceName("%sService");
		}
		new AutoGenerator().setGlobalConfig(config)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				//.setTemplate(tc)
				.setPackageInfo(
						new PackageConfig()
								.setParent(packageName)
								.setController("controller")
								.setEntity("entity")
				).execute();
	}
}
