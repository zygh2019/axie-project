package com.example.business;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 代码生成工具  运行后在控制台输入模块名和表名
 * 相同模块名的会在一个目录下，可以用于区分业务模块
 * @author Noctis
 * @date 2021/04/28
 */
public class MyBatisPlusGenerator {

    public static final String PROJECT_NAME = "demo";
    public static final String PROJECT_PARENT = "com.example.demo";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    public static final String DB_USERNAME = "root";
    public static final String DB_PWD = "123456";
    public static final String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());

        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (Strings.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String userDir = System.getProperty("user.dir");
        String projectPath =
            StrUtil.endWith(userDir, PROJECT_NAME) ? userDir : userDir + FileUtil.FILE_SEPARATOR + PROJECT_NAME;
        String author = scanner("作者名");
        gc.setOutputDir(projectPath + "/src/main/java") // 输出路径
            .setAuthor(author) // 作者
            .setActiveRecord(true) //AR模式
            .setOpen(false) //
            .setSwagger2(false) // 实体属性 Swagger2 注解
            .setFileOverride(false) // 文件覆盖
            .setIdType(IdType.ASSIGN_UUID) // 主键策略
            .setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I
            .setBaseResultMap(true)// 生成基本的resultMap
            .setBaseColumnList(true);// 生成基本的SQL片段


        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DB_DRIVER_NAME);
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PWD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        String moduleName = scanner("模块名");
        pc.setParent(PROJECT_PARENT).setMapper("daos" + StringPool.DOT + moduleName)// dao
            .setService("business" + StringPool.DOT + moduleName)// servcie
            .setServiceImpl("business" + StringPool.DOT + moduleName + StringPool.DOT + "impl")
            .setController("controller" + StringPool.DOT + moduleName)// controller
            .setEntity("pojo.entity" + StringPool.DOT + moduleName).setXml("mappers" + StringPool.DOT + moduleName);// mappers.xml
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + moduleName + "/"
                    + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
