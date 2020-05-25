package org.javaboy.vhr.controller.per;

import org.javaboy.vhr.model.Employeeremove;
import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.service.PersonTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/personnel/train")
public class PersonTrain {

    @Autowired
    PersonTrainService personTrainService;


    @PostMapping("list")
    public RespPageBean getList(@RequestBody PageRequest pageRequest){

        return personTrainService.page(pageRequest);
    }

    @PostMapping("add")
    public Integer add(@RequestBody Employeetrain employeetrain){
        return personTrainService.add(employeetrain);
    }
}
