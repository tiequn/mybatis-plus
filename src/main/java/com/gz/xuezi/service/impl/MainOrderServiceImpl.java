package com.gz.xuezi.service.impl;

import com.gz.xuezi.entity.MainOrder;
import com.gz.xuezi.mapper.MainOrderMapper;
import com.gz.xuezi.service.IMainOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 主订单表（可以用于批量打款，交易订单，服务账户） 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2019-04-11
 */
@Service
public class MainOrderServiceImpl extends ServiceImpl<MainOrderMapper, MainOrder> implements IMainOrderService {

}
