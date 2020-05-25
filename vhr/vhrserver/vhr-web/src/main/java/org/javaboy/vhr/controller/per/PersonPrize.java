package org.javaboy.vhr.controller.per;

import org.javaboy.vhr.model.AdjustSalary;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.service.PersonPrizeService;
import org.javaboy.vhr.service.PersonSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personnel/prize")
public class PersonPrize {
    @Autowired
    PersonPrizeService personPrizeService;

    @PostMapping("list")
    public RespPageBean list(@RequestBody PageRequest pageRequest){

        return personPrizeService.page(pageRequest);
    }

    @PostMapping("add")
    public Integer add(@RequestBody Employeeec employeeec){
        return personPrizeService.add(employeeec);
    }
}
