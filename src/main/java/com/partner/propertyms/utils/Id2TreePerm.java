package com.partner.propertyms.utils;

import com.partner.propertyms.entity.SpPermission;

import java.util.ArrayList;
import java.util.List;


public class Id2TreePerm {

    // 流程：数据库查出的菜单记录装载在承载菜单的列表中---
    //         构建树（获取根节点，遍历根节点，对每一个根节点构建子树）---得到最终树形菜单

    // 承载菜单的列表
    private List<SpPermission> menuList;
    private String mark;

    // 带参构造器，将数据库中的菜单数据记录，装载在我们承载菜单的列表中
    public Id2TreePerm(List<SpPermission> menuList, String mark) {
        this.menuList = menuList;
        this.mark = mark;
    }

    // 获取根节点
    public List<SpPermission> getRootNode() {
        List<SpPermission> rootNode = new ArrayList<>();
        for (SpPermission menu : menuList) {
            if (menu.getPsPid() == 0) {
                rootNode.add(menu);
            }
        }
        return rootNode;
    }

    // 构建子树
    public SpPermission buildChildren(SpPermission rootNode) {
        List<SpPermission> childrenTree = new ArrayList<>();
        for (SpPermission menu : menuList) {
            if(mark.equals("2")){
                if (menu.getPsLevel().equals("2")) continue;
            }
            if (menu.getPsPid() == rootNode.getPsId()) {
                childrenTree.add(buildChildren(menu));
            }
        }
        rootNode.setChildren(childrenTree);
        return rootNode;
    }

    // 构建树
    public List<SpPermission> buildTree() {
        List<SpPermission> menus = getRootNode();
        for (SpPermission menu : menus) {
            buildChildren(menu);
        }
        return menus;
    }

}
