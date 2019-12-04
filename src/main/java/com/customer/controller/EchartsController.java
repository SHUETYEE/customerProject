package com.customer.controller;

import com.customer.entity.Echarts;
import com.customer.service.EchartsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Echarts)表控制层
 *
 * @author makejava
 * @since 2019-12-03 10:21:30
 */
@RestController
@RequestMapping("echarts")
@CrossOrigin
public class EchartsController {
    /**
     * 服务对象
     */
    @Resource
    private EchartsService echartsService;

    private Map<String, Object> map = new HashMap<>();

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Echarts selectOne(Integer id) {
        return this.echartsService.queryById(id);
    }

    @GetMapping("findAll")
    public List<Echarts> findAll() {
        return this.echartsService.findAll();
    }

    @GetMapping("bar")
    public Map<String, Object> bar() {
        map.clear();
        List<Echarts> list = this.echartsService.bar();
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Echarts echarts : list) {
            list1.add(echarts.getName());
            list2.add(echarts.getValue());
        }
        map.put("name",list1);
        map.put("value",list2);
        return map;
    }

    @RequestMapping("/line")
    public List<Integer> line(){
        List<Integer> list=echartsService.line();
        return list;
    }

    @RequestMapping("/lineStack")
    public Map<String,Object> lineStack(){
        map.clear();
        List<Echarts> echarts =echartsService.lineStack();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for (Echarts echart : echarts) {
            list1.add(echart.getPrice());
            list2.add(echart.getValue());
        }
        map.put("list1",list1);
        map.put("list2",list2);
        return map;
    }

}