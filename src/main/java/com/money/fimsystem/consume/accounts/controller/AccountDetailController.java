package com.money.fimsystem.consume.accounts.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.money.fimsystem.auth.LoginManager;
import com.money.fimsystem.common.entity.ResponseResult;
import com.money.fimsystem.consume.accounts.entity.AccountDetail;
import com.money.fimsystem.consume.accounts.entity.AccountTotal;
import com.money.fimsystem.consume.accounts.mapstruct.AccountDetailMS;
import com.money.fimsystem.consume.accounts.service.IAccountDetailService;
import com.money.fimsystem.consume.accounts.vo.AccountDetailVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wujian
* @since 2023-01-03
* @version v1.0
*/
@Api(tags = {""})
@RestController
@RequestMapping("/accounts/detail")
@Slf4j
public class AccountDetailController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IAccountDetailService accountDetailService;

    @Autowired
    private AccountDetailMS accountDetailMS;



    /**
    * 保存和修改公用的
    * @param accountDetail  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult save(@RequestBody AccountDetail accountDetail){
        accountDetail.setUserid(LoginManager.getCurrentUserId());
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
    public ResponseResult<List<AccountDetail>> list(@RequestBody AccountDetail accountDetail){
        List<AccountDetail> list = null;
        list = accountDetailService.list(new LambdaQueryWrapper<>(accountDetail));
        return ResponseResult.success(list);
    }


        /**
        *分页查询
        * @param pageNo
        * @param PageNum
        * @return
        */
    @GetMapping(value = "/pagelist")
    public ResponseResult<PageInfo<AccountDetailVo>> selectPage(AccountDetail accountDetail,int pageNo,int pageNum) {
        accountDetail.setUserid(LoginManager.getCurrentUserId());
        PageInfo<AccountDetailVo> iPage = accountDetailService.pageList(accountDetail,pageNo,pageNum);
        return ResponseResult.success(iPage);
    }

    /**
     * 查询总信息
     * @return
     */
    @GetMapping(value = "/totalInfo")
    public ResponseResult<AccountTotal> getTotalInfo(LocalDate accountDate) {
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setAccountDate(accountDate);
        AccountTotal accountTotal = accountDetailService.getTotalInfo(accountDetail);
        return ResponseResult.success(accountTotal);
    }

    }
