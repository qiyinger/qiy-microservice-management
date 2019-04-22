/*******************************************************************************
 * 2018年8月23日
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2017 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on 2018年8月23日
 *******************************************************************************/
package swust.qiy.microservice.management.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.ArrayModel;
import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.Operation;
import io.swagger.models.RefModel;
import io.swagger.models.Response;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.AbstractSerializableParameter;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.RefParameter;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * Swagger工具类
 *
 * @author yewt (mailto:yewt@primeton.com)
 */
public class SwaggerUtils {

  public static final String SWAGGER_CONSUMER = "Content-Type";
  public static final String SWAGGER_PRODUCES = "Accept";

  /**
   * 获取请求头部
   */
  public static String getHead(Operation operation) throws JsonProcessingException {
    Map<String, Object> headers = new HashMap<String, Object>();
    if (operation.getConsumes() != null) {
      headers.put(SWAGGER_CONSUMER, operation.getConsumes());
    }
    if (operation.getProduces() != null) {
      headers.put(SWAGGER_PRODUCES, operation.getProduces());
    }
    return createObjectMapper().writeValueAsString(headers);
  }

  /**
   * 获取请求参数
   */
  @SuppressWarnings("rawtypes")
  public static String getParameters(Operation operation) throws JsonProcessingException {
    Map<String, Object> parameters = new HashMap<String, Object>();
    List<Map<String, Object>> paramList = new ArrayList<Map<String, Object>>();
    for (Parameter parameter : operation.getParameters()) {
      Map<String, Object> paramMap = new HashMap<String, Object>();
      paramMap.put("name", parameter.getName());
      paramMap.put("in", parameter.getIn());
      paramMap.put("description", parameter.getDescription());
      paramMap.put("required", parameter.getRequired());
      String format = "";
      if (parameter instanceof BodyParameter) {
        Model model = ((BodyParameter) parameter).getSchema();
        String typeName = "";
        if (model instanceof ArrayModel) {
          Property property = ((ArrayModel) model).getItems();
          if (property instanceof RefProperty) {
            String reference = ((RefProperty) property).get$ref();
            typeName = StringUtils.substringAfterLast(reference, "/");
          } else {
            typeName = ((ArrayModel) model).getItems().getType();
            format = ((ArrayModel) model).getItems().getFormat();
          }
          paramMap.put("isArray", true);
        } else {
          String reference = model.getReference();
          typeName = StringUtils.substringAfterLast(reference, "/");
          paramMap.put("isArray", false);
        }
        paramMap.put("type", typeName);
      } else if (parameter instanceof RefParameter) {
        String ref = ((RefParameter) parameter).getSimpleRef();
        paramMap.put("isArray", false);
        paramMap.put("type", ref);
      } else if (parameter instanceof AbstractSerializableParameter) {
        String typeName = ((AbstractSerializableParameter) parameter).getType();
        if (StringUtils.equals(typeName, "array")) {
          paramMap.put("isArray", true);
          paramMap.put("type", ((AbstractSerializableParameter) parameter).getItems().getType());
          format = ((AbstractSerializableParameter) parameter).getItems().getFormat();
        } else {
          paramMap.put("isArray", false);
          paramMap.put("type", typeName);
          format = ((AbstractSerializableParameter) parameter).getFormat();
        }
      }
      paramMap.put("format", format);
      paramList.add(paramMap);
    }
    parameters.put("parameters", paramList);
    return createObjectMapper().writeValueAsString(parameters);
  }

  /**
   * 获取返回参数和错误码
   */
  public static Map<String, String> getReturnAndError(Operation operation)
    throws JsonProcessingException {
    Map<String, String> result = new HashMap<String, String>();
    Map<String, Response> responses = operation.getResponses();
    Map<String, Object> returnMap = new HashMap<String, Object>();
    Map<String, String> codeMap = new HashMap<String, String>();
    for (String code : responses.keySet()) {
      Response response = responses.get(code);
      if (StringUtils.equals(code, "200")) {
        //返回参数
        Model model = response.getResponseSchema();
        if (model != null) {
          if (model instanceof ArrayModel) {
            String typeName = "";
            Property property = ((ArrayModel) model).getItems();
            if (property instanceof RefProperty) {
              String reference = ((RefProperty) property).get$ref();
              typeName = StringUtils.substringAfterLast(reference, "/");
            } else {
              typeName = ((ArrayModel) model).getItems().getType();
              returnMap.put("format", ((ArrayModel) model).getItems().getFormat());
            }
            returnMap.put("type", typeName);
            returnMap.put("isArray", true);
          } else if (model instanceof ModelImpl) {
            returnMap.put("type", ((ModelImpl) model).getType());
            returnMap.put("isArray", false);
            returnMap.put("format", ((ModelImpl) model).getFormat());
          } else if (model instanceof RefModel) {
            returnMap.put("type", ((RefModel) model).getSimpleRef());
            returnMap.put("isArray", false);
          }
          returnMap.put("description", response.getDescription());
        }
      } else {
        //错误码描述
        codeMap.put(code, response.getDescription());
      }
    }
    result.put("returnMap", createObjectMapper().writeValueAsString(returnMap));
    result.put("codeMap", createObjectMapper().writeValueAsString(codeMap));
    return result;
  }

  /**
   * 获取复杂参数
   */
  public static String getTypeObj(Swagger swagger) throws JsonProcessingException {
    Map<String, Object> typeObjMap = new HashMap<String, Object>();
    Map<String, Model> definitions = swagger.getDefinitions();
    for (String typeObj : definitions.keySet()) {
      Model model = definitions.get(typeObj);
      List<Map<String, Object>> proList = new ArrayList<Map<String, Object>>();
      Map<String, Property> properties = model.getProperties();
      if (properties != null) {
        for (String proName : properties.keySet()) {
          Map<String, Object> item = new HashMap<String, Object>();
          item.put("name", proName);
          Property property = properties.get(proName);
          String format = property.getFormat();
          if (property instanceof ArrayProperty) {
            Property arrayItem = ((ArrayProperty) property).getItems();
            if (arrayItem instanceof RefProperty) {
              item.put("type", ((RefProperty) arrayItem).getSimpleRef());
            } else {
              format = arrayItem.getFormat();
              item.put("type", arrayItem.getType());
            }
            item.put("isArray", true);
          } else if (property instanceof RefProperty) {
            item.put("type", ((RefProperty) property).getSimpleRef());
            item.put("isArray", false);
          } else {
            item.put("type", property.getType());
            item.put("isArray", false);
          }
          item.put("format", format);
          item.put("description", property.getDescription());
          proList.add(item);
        }
      }
      typeObjMap.put(typeObj, proList);
    }
    return createObjectMapper().writeValueAsString(typeObjMap);
  }

  private static ObjectMapper createObjectMapper() {
    return new ObjectMapper();
  }
}
