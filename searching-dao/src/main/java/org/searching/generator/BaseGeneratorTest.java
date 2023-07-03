package org.searching.generator;

import java.sql.SQLException;
import java.util.Collections;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * 基础测试类
 *
 * @author Ou
 * @since 3.5.3
 */
public class BaseGeneratorTest {

    /**
     * 执行数据库脚本
     */
    protected static void initDataSource(DataSourceConfig dataSourceConfig) throws SQLException {
        // Connection conn = dataSourceConfig.getConn();
        // InputStream inputStream = H2CodeGeneratorTest.class.getResourceAsStream("/sql/init.sql");
        // ScriptRunner scriptRunner = new ScriptRunner(conn);
        // scriptRunner.setAutoCommit(true);
        // scriptRunner.runScript(new InputStreamReader(inputStream));
        // conn.close();
    }

    /**
     * 策略配置
     */
    protected static StrategyConfig strategyConfig() {
        return new StrategyConfig.Builder()
        .entityBuilder().enableFileOverride().build();
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String daoPath = "\\demo-dao\\src\\main\\java";
        return new GlobalConfig.Builder()
                .author("ou")
                .outputDir(projectPath+daoPath);
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig() {
        String servicePath = ("gen");
        String serviceImplPath = ("gen");
        String controllerPath = ("gen");
        String entityPath = ("entity");
        String mapperPath = ("mapper");
        String xmlPath = ("xml");

        return new PackageConfig.Builder()
                .parent("org.searching")
                .service(servicePath)
                .entity(entityPath)
                .controller(controllerPath)
                .serviceImpl(serviceImplPath)
                .xml(xmlPath)
                .mapper(mapperPath)
                .pathInfo(Collections.singletonMap(OutputFile.xml, ""));
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder();
    }

    /**
     * 注入配置
     */
    protected static InjectionConfig.Builder injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        });
    }
}
