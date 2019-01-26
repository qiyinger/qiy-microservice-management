package swust.qiy.microservice.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swust.qiy.microservice.core.page.PageImpl;
import swust.qiy.microservice.core.result.Result;
import ${classFullName};
import swust.qiy.microservice.management.query.${classSimpleName}Query;
import swust.qiy.microservice.management.service.${classSimpleName}Service;

/**
 * @author qiying
 */
@RequestMapping("/${lowClassSimpleName}")
@RestController
public class ${classSimpleName}Controller {

  @Autowired
  private ${classSimpleName}Service ${lowClassSimpleName}Service;

  @RequestMapping("/page")
  @ResponseBody
  public Result<PageImpl<${classSimpleName}>> query(@RequestBody ${classSimpleName}Query query) {
    return ${lowClassSimpleName}Service.findPage(query);
  }

  @RequestMapping("/save")
  @ResponseBody
  public Result save(@RequestBody ${classSimpleName} ${lowClassSimpleName}) {
    return ${lowClassSimpleName}Service.save(${lowClassSimpleName});
  }

  @RequestMapping("/update")
  @ResponseBody
  public Result update(@RequestBody ${classSimpleName} ${lowClassSimpleName}) {
    return ${lowClassSimpleName}Service.update(${lowClassSimpleName});
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(@RequestBody BaseForm form) {
    if (CommonUtil.isEmpty(form.getIds())) {
      return ResultUtil.create(ResultCodeEnum.PARAM_ERROR);
    }
    return ${lowClassSimpleName}Service.deleteByIds(form.getIds());
  }
}
