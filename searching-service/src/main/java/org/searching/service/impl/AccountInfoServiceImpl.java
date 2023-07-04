package org.searching.service.impl;

import org.searching.entity.AccountInfo;
import org.searching.mapper.AccountInfoMapper;
import org.searching.service.IAccountInfoService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ou
 * @since 2023-07-03
 */
@Service
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements IAccountInfoService {

}