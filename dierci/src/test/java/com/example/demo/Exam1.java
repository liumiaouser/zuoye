package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam1 {
    public static void main(String[] args) {
        String json = "[{\"a\":1,\"b\":\"一级 1\",\"c\":0}, {\"a\":2,\"b\":\"一级 2\",\"c\":0}, {\"a\":3,\"b\":\"一级 3\",\"c\":0}, {\"a\":4,\"b\":\"二级 1-1\",\"c\":1}, {\"a\":5,\"b\":\"二级 2-1\",\"c\":2}, {\"a\":6,\"b\":\"二级 2-2\",\"c\":2}, {\"a\":7,\"b\":\"二级 3-1\",\"c\":3}, {\"a\":8,\"b\":\"二级 3-2\",\"c\":3}, {\"a\":9,\"b\":\"三级 1-1-1\",\"c\":4}, {\"a\":10,\"b\":\"三级 2-1-1\",\"c\":5}, {\"a\":11,\"b\":\"三级 2-2-1\",\"c\":6}, {\"a\":12,\"b\":\"三级 3-1-1\",\"c\":7}, {\"a\":13,\"b\":\"三级 3-2-1\",\"c\":8} ]";
        List<Map<String, Object>> list = JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {
        });
        List<Map<String, Object>> result = noRecursion(list, "a", "c", 0, "children");
        System.out.println(JSON.toJSON(result));
    }
    public static List<Map<String, Object>> noRecursion(List<Map<String, Object>> list, String id, String pid, Object pidValue, String children) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> result = new ArrayList<>();
        list.forEach(bean -> {
            map.put(String.valueOf(bean.get(id)), bean);
        });
        list.forEach(bean -> {
            if (bean.get(pid).equals(pidValue)) {
                Object o = map.get(String.valueOf(bean.get(id)));
                result.add((Map<String, Object>) map.get(String.valueOf(bean.get(id))));
            } else {
                Object o = map.get(String.valueOf(bean.get(pid)));

                Map<String, Object> p = (Map<String, Object>) map.get(String.valueOf(bean.get(pid)));
                
                if (!p.containsKey(children)) {
                    p.put(children, new ArrayList<>());
                }
                ((List<Map<String, Object>>) (p.get(children))).add((Map<String, Object>) map.get(String.valueOf(bean.get(id))));
            }
        });
        return result;
    }
}
