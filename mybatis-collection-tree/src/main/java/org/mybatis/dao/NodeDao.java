package org.mybatis.dao;

import org.mybatis.domain.Node;

import java.util.List;


public interface NodeDao {


    List<Node> getNodeTree();
}
