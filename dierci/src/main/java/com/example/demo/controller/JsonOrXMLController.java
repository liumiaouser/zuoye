package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.bean.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JsonOrXMLController {

    @GetMapping("/getJson")
    @ResponseBody
    public Object getJson() {
        Map map = new HashMap();
        map.put("name", "a");
        return JSON.toJSON(map);
    }

    @GetMapping(value = "/getXml", produces = MediaType.APPLICATION_XML_VALUE)
    public Object getXml() {
        return new Student("zhangsan", 6);
    }
}
