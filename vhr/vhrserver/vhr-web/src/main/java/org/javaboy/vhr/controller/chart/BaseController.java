package org.javaboy.vhr.controller.chart;

import org.javaboy.vhr.mapper.ChartMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chart/base")
public class BaseController {
    @Autowired
    ChartMapper chartMapper;
    @GetMapping("sex")
    public Object sex(){
        List<Map<String,Object>>  res =chartMapper.sex();
        return res;
    }
}
