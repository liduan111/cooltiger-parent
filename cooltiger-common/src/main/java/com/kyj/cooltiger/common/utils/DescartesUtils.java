package com.kyj.cooltiger.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liduan
 * Description: 笛卡尔积工具类
 * date: 2020/10/12 14:52
 */
public class DescartesUtils {

    /**
     * 字符串集合笛卡尔积算法
     *
     * @param dimvalue 初始对象
     * @param result   结果对象
     * @param layer    初始下标
     * @param curList  临时对象
     */
    public static void descartes(List<List<String>> dimvalue, List<List<String>> result, int layer, List<String> curList) {
        if (layer < dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                descartes(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descartes(dimvalue, result, layer + 1, list);
                }
            }
        } else if (layer == dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
    }
}
