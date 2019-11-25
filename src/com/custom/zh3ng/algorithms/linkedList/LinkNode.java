package com.custom.zh3ng.algorithms.linkedList;

/*
 * created by zhangxingang on 2019/04/18
 */
public class LinkNode implements Cloneable{
    public LinkNode next;
    public int val;

    public LinkNode(int a){
        val = a;
    }

    @Override
    public LinkNode clone(){
        LinkNode node = null;
        try{
            node = (LinkNode)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
