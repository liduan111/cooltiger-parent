package com.kyj.cooltiger.cooltigercommon.utils;

import java.util.List;

/**
 * @author liduan
 * Description: 分页工具类
 * date: 2020/7/31 14:58
 */
public class PageUtil<T> {
    private Integer pageNo=1; //当前页，默认1
    private Integer pageSize; //分页单位
    private Integer totalCount; //总行数
    private Integer totalPage; //总页数
    private List<T> lists;  //数据

    public PageUtil(Integer pageNo, Integer pageSize, Integer totalCount) {
        //当前页
        if (null == pageNo || pageNo < 0) {
            //如果传入的页码为空 或者小于0  就默认给 1
            this.pageNo = 1;
        }else if (pageNo > this.totalPage && this.totalPage> 0) {
            //如果当前页码数>总页码数就让当前页码数等于最大页码数
            this.pageNo = this.totalPage;
        } else {
            //都符合条件 就让 当前页码数 等于 传入的页码数
            this.pageNo = pageNo;
        }
        //分页单位
        this.pageSize = pageSize;
        //总条数
        this.totalCount = totalCount;
        //总页数 如果总条数为0总页数也为0
        if(totalCount==0){
            this.totalPage=0;
        }else{
            //根据总行数以及每页显示的行数求出总页数
            this.totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
        }
    }

    public PageUtil() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    //设置当前页
    public void setPageNo(Integer pageNo) {
        //如果传入的页码为空 或者小于0  就默认给 1
        if (null == pageNo || pageNo < 0) {
            this.pageNo = 1;
        }else if (pageNo > this.totalPage && this.totalPage> 0) {
            //如果当前页码数>总页码数就让当前页码数等于最大页码数
            this.pageNo = this.totalPage;
        } else {
            //都符合条件 就让 当前页码数 等于 传入的页码数
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    //设置总行数
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //设置总页数 如果总条数为0总页数也为0
        if(totalCount==0){
            this.totalPage=0;
        }else{
            //设置总页数 根据传入的总行数以及每页显示的行数求出总页数
            this.totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
        }
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
