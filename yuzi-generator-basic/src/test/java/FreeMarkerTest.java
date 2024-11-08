
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        //创建配置 版本号 模版所在路径 编码
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        cfg.setDefaultEncoding("UTF-8");
        cfg.setNumberFormat("0.##########");

        //根据配置 创建模版对象,加载指定模版
        Template template = cfg.getTemplate("myweb.html.ftl");
        //创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("user","yupeng");
        dataModel.put("currentYear",2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();

        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url","https://www.codefather.cn");
        menuItem1.put("label","编程导航");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url","https://laoyujianli.com");
        menuItem2.put("label","老鱼简历");

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems",menuItems);
        //输出
        FileWriter out = new FileWriter("myweb.html");
        template.process(dataModel,out);
        out.close();

    }
}
