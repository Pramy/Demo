package com.pramy.demo.mybatisplus.service.impl;

import com.pramy.demo.mybatisplus.po.DbTest;
import com.pramy.demo.mybatisplus.dao.DbTestMapper;
import com.pramy.demo.mybatisplus.service.IDbTestService;
import com.baomidou.framework.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author pramy
 * @since 2018-02-04
 */
@Service
public class DbTestServiceImpl extends ServiceImpl<DbTestMapper, DbTest> implements IDbTestService {
	
}
