package com.pramy.demo.mybatisplus.service.impl;

import com.pramy.demo.mybatisplus.po.Person;
import com.pramy.demo.mybatisplus.dao.PersonMapper;
import com.pramy.demo.mybatisplus.service.IPersonService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author pramy
 * @since 2018-02-05
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {
	
}
