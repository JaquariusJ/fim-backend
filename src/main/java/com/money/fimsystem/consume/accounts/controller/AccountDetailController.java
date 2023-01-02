package com.money.fimsystem.consume.accounts.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.money.fimsystem.common.entity.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.money.fimsystem.consume.accounts.service.IAccountDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wujian
* @since 2022-12-31
* @version v1.0
*/
@Api(tags = {""})
@RestController
@RequestMapping("/accounts/detail")
public class AccountDetailController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IAccountDetailService accountDetailService;

    /**
    * 保存和修改公用的
    * @param accountDetail  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult save(@RequestBody AccountDetail accountDetail){
        if(accountDetail.getId()!=null){
            accountDetailService.updateById(accountDetail);
        }else{
            accountDetailService.save(accountDetail);
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
        accountDetailService.removeById(id);
        return ResponseResult.success();
    }


    /**
    * 批量删除
    * @param ids
    * @return
    */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public ResponseResult batchDelete(@PathVariable("ids") List <Integer> ids){
        accountDetailService.removeByIds(ids);
        return ResponseResult.success();
    }

        //根据id查询
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id) {
        AccountDetail accountDetail = null;
        accountDetail = accountDetailService.getById(id);
        return ResponseResult.success(accountDetail);
    }


        /**
        * 查看所有
        * @return
        */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(@RequestBody AccountDetail accountDetail){
        List<AccountDetail> list = null;
        list = accountDetailService.list(new LambdaQueryWrapper<>(accountDetail));
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
    public ResponseResult<IPage> selectPage(@RequestBody AccountDetail accountDetail,int pageNo,int PageNum) {
        IPage<AccountDetail> iPage = null;
        Page<AccountDetail> page = null;
        page = new Page<AccountDetail>(pageNo,PageNum);
        iPage = accountDetailService.page(page);
        return ResponseResult.success(iPage);
    }
    }
