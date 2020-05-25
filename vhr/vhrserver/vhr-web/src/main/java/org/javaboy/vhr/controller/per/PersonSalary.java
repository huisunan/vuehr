package org.javaboy.vhr.controller.per;

import org.javaboy.vhr.model.AdjustSalary;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.service.PersonSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 调薪
 */
@RestController
@RequestMapping("/personnel/salary")
public class PersonSalary {
    @Autowired
    PersonSalaryService personSalaryService;

    @PostMapping("list")
    public RespPageBean list(@RequestBody PageRequest pageRequest){

        return personSalaryService.page(pageRequest);
    }

    @PostMapping("add")
    public Integer add(@RequestBody AdjustSalary adjustSalary){
        return personSalaryService.add(adjustSalary);
    }
}
