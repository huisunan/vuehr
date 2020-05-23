package org.javaboy.vhr.controller.per;

import org.javaboy.vhr.model.Employeeremove;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.service.PersonMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 发起调动
 */
@RestController
@RequestMapping("/personnel/move")
public class PersonMove {

    @Autowired
    PersonMoveService personMoveService;


    @PostMapping("list")
    public RespPageBean getList(@RequestBody PageRequest pageRequest){
        return personMoveService.page(pageRequest);
    }

    @PostMapping("add")
    public Integer add(@RequestBody Employeeremove employeeremove){
        employeeremove.setRemovedate(new Date());
        return personMoveService.add(employeeremove);
    }
}
