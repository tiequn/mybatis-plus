package com.gz.xuezi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.xuezi.entity.ChildOrder;
import com.gz.xuezi.mapper.ChildOrderMapper;
import com.gz.xuezi.util.HttpResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 子订单表（可以用于批量打款查看详情，交易订单查看详情， 服务账户查看详情，资金流水） 前端控制器
 * </p>
 *
 * @author gjb
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/child-order")
@Api(value = "/mainOrder", description = "线下打款数据上传")
public class ChildOrderController {


}




