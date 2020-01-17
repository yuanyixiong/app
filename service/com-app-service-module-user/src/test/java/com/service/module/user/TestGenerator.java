package com.service.module.user;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 袁毅雄
 * @description
 * @date 2019/8/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceModuleUserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestGenerator {

    @Test
    public void userGenerator() {
        //创建用户
        String author = "yuanyixiong";
        //数据库用户名
        String username = "root";
        //数据库密码
        String password = "root";
        //数据库连接地址
        String url = "jdbc:mysql://172.16.89.151:3306/app_user?useUnicode=true&characterEncoding=gbk&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai";
        //表名前缀
        String[] excludePrefix = {""};
        //要生成的表名
        String tableNames = "user_base_info";

        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig(author))
                .setDataSource(getDataSourceConfig(username, password, url))
                .setStrategy(getStrategyConfig(excludePrefix, tableNames))
                .setPackageInfo(getPackageConfig())
                .setTemplate(getTemplateConfig())
                .setCfg(getInjectionConfig())
                .execute();
    }

    /**
     * 获取TemplateConfig
     *
     * @return
     */
    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig().setXml(null);
    }

    /**
     * 策略配置
     *
     * @param tableName
     * @return
     */
    private static StrategyConfig getStrategyConfig(String[] excludePrefix, String tableName) {
        return new StrategyConfig()
                //表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //需要生成的表
                .setInclude(tableName)
                // 此处可以修改为您的表前缀
                .setTablePrefix(excludePrefix)
                //全局大写命名
                .setCapitalMode(true)
                //【实体】是否为构建者模型
                .setEntityBuilderModel(true)
                //【实体】是否为lombok模型
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setSuperEntityClass("com.common.core.base.BaseEntity")
                .setSuperMapperClass("com.common.core.base.BaseMapper")
                .setSuperServiceImplClass("com.common.core.service.impl.BaseServiceImpl")
                .setSuperServiceClass("com.common.core.service.BaseService")
                .setSuperControllerClass("com.common.core.base.BaseController")
                .setSuperEntityColumns("id", "create_time", "update_time", "create_user", "update_user");
    }

    /**
     * 数据原配置
     */
    private static DataSourceConfig getDataSourceConfig(String username, String password, String url) {
        // 数据源配置
        return new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername(username)
                .setPassword(password)
                .setUrl(url);
    }

    /**
     * 全局配置
     */
    private static GlobalConfig getGlobalConfig(String author) {
        return new GlobalConfig()
                //文件输出路径
                .setOutputDir(getJavaPath())
                //是否打开文件目录
                .setOpen(false)
                //是否覆盖文件
                .setFileOverride(true)
                //不需要ActiveRecord特性的请改为false
                .setActiveRecord(false)
                //XML 二级缓存
                .setEnableCache(false)
                //XML ResultMap
                .setBaseResultMap(false)
                //XML columList
                .setBaseColumnList(false)
                //作者
                .setAuthor(author)
                .setSwagger2(true)
                //自定义文件命名，注意 %s 会自动填充表实体属性！
                .setControllerName("%sController")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper");
    }

    /**
     * 包配置
     */
    private static PackageConfig getPackageConfig() {
        return new PackageConfig()
                .setParent("com.service.module.user")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("dao")
                .setEntity("entity");
    }

    /**
     * 获取JAVA目录
     *
     * @return
     */
    private static String getJavaPath() {
        return getThisProjectRootPath() + "/src/main/java";
    }

    /**
     * 获取当前工程跟路径
     *
     * @return
     */
    private static String getThisProjectRootPath() {
        String file = Objects.requireNonNull(TestGenerator.class.getClassLoader().getResource("")).getFile();
        return new File(file).getParentFile().getParent();
    }

    /**
     * 获取InjectionConfig
     *
     * @return
     */
    private static InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getResourcePath() + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));
    }

    /**
     * 获取资源路径
     *
     * @return
     */
    private static String getResourcePath() {
        return getThisProjectRootPath() + "/src/main/resources";
    }
}
