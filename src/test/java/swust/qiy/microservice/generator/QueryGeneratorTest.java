package swust.qiy.microservice.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import swust.qiy.microservice.core.util.PackageUtil;
import swust.qiy.microservice.core.util.StringUtil;
import swust.qiy.microservice.management.ManagementApp;

/**
 * @author qiying
 * @create 2019/1/23
 */
public class QueryGeneratorTest {

  @Test
  public void testQuery() {
    Set<Class<?>> classes = PackageUtil.getClasses("swust.qiy.microservice.management.entity");
    classes.forEach(clazz -> {
      String classSimpleName = clazz.getSimpleName();
      String classFullName = clazz.getCanonicalName();
      List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
      // query类的属性
      List<String> queryFields = new ArrayList<>();
      // 属性对应的类型
      HashMap<String, String> fields2type = new HashMap<>();
      // 属性对应的表字段
      HashMap<String, String> fields2tableName = new HashMap<>();

      HashMap<String, String> fields2staticName = new HashMap<>();
      fields.forEach(field -> {
        String fieldName = field.getName();
        String tableName = StringUtil.camel2lowUndercore(fieldName);
        if (LocalDateTime.class == field.getType()) {
          String startFieldName =
            "start" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
          queryFields.add(startFieldName);
          fields2type.put(startFieldName, field.getType().getSimpleName());
          fields2tableName.put(startFieldName, tableName);
          fields2staticName.put(startFieldName, StringUtil.camel2upUndercore(startFieldName));

          String endFieldName =
            "end" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
          queryFields.add(endFieldName);
          fields2type.put(endFieldName, field.getType().getSimpleName());
          fields2tableName.put(endFieldName, tableName);
          fields2staticName.put(endFieldName, StringUtil.camel2upUndercore(endFieldName));
        }
        queryFields.add(fieldName);
        fields2type.put(fieldName, field.getType().getSimpleName());
        fields2tableName.put(fieldName, tableName);
        fields2staticName.put(fieldName, StringUtil.camel2upUndercore(fieldName));
      });

      Map<String, Object> map = new HashMap<>(32);
      map.put("classSimpleName", classSimpleName);
      map.put("classFullName", classFullName);
      map.put("queryFields", queryFields);
      map.put("fields2type", fields2type);
      map.put("fields2tableName", fields2tableName);
      map.put("fields2staticName", fields2staticName);

      // 通过Freemaker的Configuration读取相应的ftl
      Configuration cfg = new Configuration();
      // 设定去哪里读取相应的ftl模板文件
      cfg.setClassForTemplateLoading(ManagementApp.class, "/generator");
      // 在模板文件目录中找到名称为name的文件
      try {
        Template temp = cfg.getTemplate("query.ftl");
        File docFile = new File(
          "src/generator/query/" + classSimpleName
            + "Query.java");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        temp.process(map, out);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (TemplateException e) {
        e.printStackTrace();
      }

    });
    System.out.println();
  }

  @Test
  public void testController() {
    Set<Class<?>> classes = PackageUtil.getClasses("swust.qiy.microservice.management.entity");
    classes.forEach(clazz -> {
      String classSimpleName = clazz.getSimpleName();
      String classFullName = clazz.getCanonicalName();
      String lowClassSimpleName = StringUtil.up2lowCamel(classSimpleName);

      Map<String, String> map = new HashMap<>();
      map.put("classSimpleName", classSimpleName);
      map.put("classFullName", classFullName);
      map.put("lowClassSimpleName", lowClassSimpleName);

      // 通过Freemaker的Configuration读取相应的ftl
      Configuration cfg = new Configuration();
      // 设定去哪里读取相应的ftl模板文件
      cfg.setClassForTemplateLoading(ManagementApp.class, "/generator");
      // 在模板文件目录中找到名称为name的文件
      try {
        Template temp = cfg.getTemplate("controller.ftl");
        File docFile = new File(
          "src/generator/controller/" + classSimpleName
            + "Controller.java");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        temp.process(map, out);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (TemplateException e) {
        e.printStackTrace();
      }

    });
  }

}
