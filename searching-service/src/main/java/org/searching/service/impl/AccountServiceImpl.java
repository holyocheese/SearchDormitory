package org.searching.service.impl;

import org.searching.entity.Account;
import org.searching.mapper.AccountMapper;
import org.searching.service.IAccountService;

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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
