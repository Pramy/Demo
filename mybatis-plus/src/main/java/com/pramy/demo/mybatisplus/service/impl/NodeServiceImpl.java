package com.pramy.demo.mybatisplus.service.impl;

import com.pramy.demo.mybatisplus.po.Node;
import com.pramy.demo.mybatisplus.dao.NodeMapper;
import com.pramy.demo.mybatisplus.service.INodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 节点表  服务实现类
 * </p>
 *
 * @author pramy
 * @since 2018-02-05
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements INodeService {
	
}
