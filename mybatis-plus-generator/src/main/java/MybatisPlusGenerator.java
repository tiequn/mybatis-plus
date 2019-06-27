import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MybatisPlusGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MybatisPlusGenerator.class);

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static class ExtendedAutoGenerator extends AutoGenerator {
        @Override
        public ConfigBuilder pretreatmentConfigBuilder(ConfigBuilder config) {
            return super.pretreatmentConfigBuilder(config);
        }
    }

    @Data
    private static class Cfg {
        private String[] tableNames;
        private String projectPath;
        private boolean needToGenEntity = true;
        private boolean needToGenMapperXml = false;
        private boolean needToGenMapperJava = true;
        private boolean needToGenService = false;
        private boolean needToGenController = false;
    }

    public static void main(String[] args) {
        //[config]
        final String projectPath = "/Users/gz/study/学习项目/mybatis-plus";
        if (true) {
            // 所有表
            String[] tableNames = {"child", "main"};
            Cfg cfg = new Cfg();
            cfg.setTableNames(tableNames);
            cfg.setProjectPath(projectPath);
            //[config]
            cfg.setNeedToGenEntity(true);
            cfg.setNeedToGenMapperXml(false);
            cfg.setNeedToGenMapperJava(true);
            cfg.setNeedToGenService(true);
            cfg.setNeedToGenController(true);
            gen(cfg);
        }
        if (false) {
            String[] tableNames = {"T_EPBill"};
            Cfg cfg = new Cfg();
            cfg.setTableNames(tableNames);
            cfg.setProjectPath(projectPath);
            cfg.setNeedToGenEntity(true);
            cfg.setNeedToGenMapperXml(true);
            cfg.setNeedToGenMapperJava(true);
            cfg.setNeedToGenService(true);
            cfg.setNeedToGenController(true);
            gen(cfg);
        }
    }

    private static void gen(Cfg cfg) {
        // 代码生成器
        ExtendedAutoGenerator mpg = new ExtendedAutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = cfg.projectPath;
        gc.setOutputDir(projectPath + "/src/main/java");
        //[config]
        gc.setAuthor("gjb");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setKotlin(false);
        gc.setFileOverride(true); // 是否覆盖已有文件
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //[config]
        // 必须指定dbType，否则 DataSourceConfig 会报错：MybatisPlusException: Unknown type of database!
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://47.112.2.102:3306/yali");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("yali");
        dsc.setPassword("yali");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        //[config]
        pc.setParent("com.gz.xuezi");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        if (cfg.isNeedToGenMapperXml()) {
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);
        TemplateConfig templateConfig = new TemplateConfig().setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        if (cfg.getTableNames() != null) {
            strategy.setInclude(cfg.getTableNames());
        } else {
            strategy.setInclude(scanner("表名"));
        }
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix("T_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine();
        mpg.setTemplateEngine(templateEngine);

        // 忽略service跟controller生成，把mpg.execute()方法拆解开自行定制
        //mpg.execute();
        logger.debug("==========================准备生成文件...==========================");
        ConfigBuilder configBuilder = new ConfigBuilder(pc, dsc, strategy, templateConfig, gc);
        configBuilder.setInjectionConfig(injectionConfig);
        List<TableInfo> tableInfoList = configBuilder.getTableInfoList();
        for (TableInfo tableInfo : tableInfoList) {
            if (!cfg.isNeedToGenEntity()) {
                tableInfo.setEntityName(null);
            }
            if (!cfg.isNeedToGenMapperXml()) {
                tableInfo.setXmlName(null);
            }
            if (!cfg.isNeedToGenMapperJava()) {
                tableInfo.setMapperName(null);
            }
            if (!cfg.isNeedToGenService()) {
                tableInfo.setServiceName(null);
                tableInfo.setServiceImplName(null);
            }
            if (!cfg.isNeedToGenController()) {
                tableInfo.setControllerName(null);
            }
        }
        // 模板引擎初始化执行文件输出
        templateEngine.init(mpg.pretreatmentConfigBuilder(configBuilder)).mkdirs().batchOutput().open();
        logger.debug("==========================文件生成完成！！！==========================");
    }

}
