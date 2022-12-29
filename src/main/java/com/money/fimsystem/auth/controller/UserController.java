package com.money.fimsystem.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.money.fimsystem.auth.entity.User;
import com.money.fimsystem.auth.service.IUserService;
import com.money.fimsystem.common.entity.ResponseBuilder;
import com.money.fimsystem.common.entity.ResultResponse;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wujian
* @since 2022-12-26
* @version v1.0
*/
@Api(tags = {""})
@RestController
@RequestMapping("/auth")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IUserService userService;

    /**
    * 保存和修改公用的
    * @param user  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public ResultResponse save(@RequestBody User user){
        try {
            if(user.getId()!=null){
                userService.updateById(user);
            }else{
                userService.save(user);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.fail(e.getMessage());
        }
            return ResponseBuilder.success();
    }

    /**
    * id删除
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResultResponse delete(@PathVariable("id") Long id){
        try {
            userService.removeById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.fail(e.getMessage());
        }
        return ResponseBuilder.success();
    }


    /**
    * 批量删除
    * @param ids
    * @return
    */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public ResultResponse batchDelete(@PathVariable("ids") List<Integer> ids){
        try {
            userService.removeByIds(ids);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.fail(e.getMessage());
        }
            return ResponseBuilder.success();
    }

    //根据id查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResultResponse get(@PathVariable("id")Long id) {
        User user = null;
        try {
            user = userService.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.fail(e.getMessage());
        }
        return ResponseBuilder.success(user);
    }


    /**
    * 查看所有
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultResponse list(@RequestBody User user){
        List<User> list = null;
        try {
            list = userService.list(new LambdaQueryWrapper<>(user));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.fail(e.getMessage());
        }
            return ResponseBuilder.success(list);
     }


    /**
    *分页查询
    * @param pageNo
    * @param PageNum
    * @return
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResultResponse<User> selectPage(@RequestBody User user,int pageNo,int PageNum) {
        IPage<User> iPage = null;
        Page<User> page = null;
        try {
                page = new Page<User>(pageNo,PageNum);
                iPage = userService.page(page);
         } catch (Exception e) {
                logger.error(e.getMessage());
                ResponseBuilder.fail(e.getMessage());
          }
         return ResponseBuilder.success(iPage);
     }

}
