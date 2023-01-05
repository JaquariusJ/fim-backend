package com.money.fimsystem.consume.accounts.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.money.fimsystem.auth.LoginManager;
import com.money.fimsystem.common.entity.ResponseResult;
import com.money.fimsystem.common.utils.JsonUtils;
import com.money.fimsystem.consume.accounts.entity.AccountCategory;
import com.money.fimsystem.consume.enums.AccountCategoryEnum;
import com.money.fimsystem.consume.enums.AccountTypeEnum;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.money.fimsystem.consume.accounts.entity.AccountLogo;
import com.money.fimsystem.consume.accounts.service.IAccountLogoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wujian
* @since 2023-01-01
* @version v1.0
*/
@Api(tags = {""})
@RestController
@RequestMapping("/accounts/logo")
public class AccountLogoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IAccountLogoService accountLogoService;

    /**
    * 保存和修改公用的
    * @param accountLogo  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult save(@RequestBody AccountLogo accountLogo){
        accountLogo.setUserid(LoginManager.getCurrentUserId());
        if(accountLogo.getId()!=null){
            accountLogoService.updateById(accountLogo);
        }else{
            accountLogoService.save(accountLogo);
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
        accountLogoService.removeById(id);
        return ResponseResult.success();
    }


    /**
    * 批量删除
    * @param ids
    * @return
    */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public ResponseResult batchDelete(@PathVariable("ids") List <Integer> ids){
        accountLogoService.removeByIds(ids);
        return ResponseResult.success();
    }

        //根据id查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id) {
        AccountLogo accountLogo = null;
        accountLogo = accountLogoService.getById(id);
        return ResponseResult.success(accountLogo);
    }


        /**
        * 查看所有
        * @return
        */
    @PostMapping(value = "/list")
    public ResponseResult list(@RequestBody AccountLogo accountLogo){
        List<AccountLogo> list = null;
        list = accountLogoService.list(new LambdaQueryWrapper<>(accountLogo)
                .eq(AccountLogo::getUserid,LoginManager.getCurrentUserId())
        );
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
    public ResponseResult<IPage> selectPage(@RequestBody AccountLogo accountLogo,int pageNo,int PageNum) {
        IPage<AccountLogo> iPage = null;
        Page<AccountLogo> page = null;
        page = new Page<AccountLogo>(pageNo,PageNum);
        iPage = accountLogoService.page(page);
        return ResponseResult.success(iPage);
    }
    @GetMapping(value = "/getAllCategory")
    public ResponseResult getAllCategory(){
        AccountCategoryEnum[] categoryEnums = AccountCategoryEnum.values();
        List<AccountCategory> list = new ArrayList<>();
        for (AccountCategoryEnum categoryEnum : categoryEnums) {
            AccountCategory category = new AccountCategory();
            category.setName(categoryEnum.getName());
            category.setTitle(categoryEnum.getTitle());
            category.setCode(categoryEnum.getCode());
            list.add(category);
        }
        return ResponseResult.success(list);
    }

    @GetMapping(value = "/getAllType")
    public ResponseResult getAllType(){
        AccountTypeEnum[] categoryEnums = AccountTypeEnum.values();
        return ResponseResult.success(categoryEnums);
    }

}
