package org.mybatis.domain;

import java.util.List;

public class Node {


    private Long id;

    private String name;

    private List<Node> next;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNext() {
        return next;
    }

    public void setNext(List<Node> next) {
        this.next = next;
    }
}
