package org.mybatis.service;

import org.mybatis.domain.Node;

import java.util.List;


public interface NodeService {

    List<Node> getNodeTree();
}
