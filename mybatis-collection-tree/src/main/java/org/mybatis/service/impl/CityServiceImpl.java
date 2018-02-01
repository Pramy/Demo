package org.mybatis.service.impl;

import org.mybatis.dao.NodeDao;
import org.mybatis.domain.Node;
import org.mybatis.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements NodeService {

    @Autowired
    private NodeDao nodeDao;

    @Override
    public List<Node> getNodeTree() {
        return nodeDao.getNodeTree();
    }
}
