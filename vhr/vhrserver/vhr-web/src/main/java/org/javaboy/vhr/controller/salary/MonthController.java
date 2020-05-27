package org.javaboy.vhr.controller.salary;

import org.javaboy.vhr.model.Appraise;
import org.javaboy.vhr.model.Employeeremove;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/salary/month")
public class MonthController {

    @Autowired
    AppraiseService appraiseService;

    @PostMapping("add")
    public Integer add(@RequestBody Appraise appraise){
        Integer a = appraiseService.add(appraise);
        return a;
    }


    @PostMapping("list")
    public RespPageBean getList(@RequestBody PageRequest pageRequest){
        return appraiseService.page(pageRequest);
    }

}
