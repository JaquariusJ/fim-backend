package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.money.fimsystem.common.entity.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
* @version v1.0
*/
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    /**
    * 保存和修改公用的
    * @param ${table.entityPath}  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult save(@RequestBody ${entity} ${table.entityPath}){
        if(${table.entityPath}.getId()!=null){
            ${table.entityPath}Service.updateById(${table.entityPath});
        }else{
            ${table.entityPath}Service.save(${table.entityPath});
        }
        return ResponseResult.success();
    }

    /**
    * id删除
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        ${table.entityPath}Service.removeById(id);
        return ResponseResult.success();
    }


    /**
    * 批量删除
    * @param ids
    * @return
    */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public ResponseResult batchDelete(@PathVariable("ids") List <Integer> ids){
        ${table.entityPath}Service.removeByIds(ids);
        return ResponseResult.success();
    }

        //根据id查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id) {
        ${entity} ${table.entityPath} = null;
        ${table.entityPath} = ${table.entityPath}Service.getById(id);
        return ResponseResult.success(${table.entityPath});
    }


        /**
        * 查看所有
        * @return
        */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(@RequestBody ${entity} ${table.entityPath}){
        List<${entity}> list = null;
        list = ${table.entityPath}Service.list(new LambdaQueryWrapper<>(${table.entityPath}));
        return ResponseResult.success(list);
    }


        /**
        *分页查询
        * @param debt
        * @param pageNo
        * @param PageNum
        * @return
        */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult<IPage> selectPage(@RequestBody ${entity} ${table.entityPath},int pageNo,int PageNum) {
        IPage<${entity}> iPage = null;
        Page<${entity}> page = null;
        page = new Page<${entity}>(pageNo,PageNum);
        iPage = ${table.entityPath}Service.page(page);
        return ResponseResult.success(iPage);
    }
    }
</#if>