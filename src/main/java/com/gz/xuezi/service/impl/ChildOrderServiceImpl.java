package com.gz.xuezi.service.impl;

import com.gz.xuezi.entity.ChildOrder;
import com.gz.xuezi.mapper.ChildOrderMapper;
import com.gz.xuezi.service.IChildOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 子订单表（可以用于批量打款查看详情，交易订单查看详情， 服务账户查看详情，资金流水） 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2019-04-11
 */
@Service
public class ChildOrderServiceImpl extends ServiceImpl<ChildOrderMapper, ChildOrder> implements IChildOrderService {

}
