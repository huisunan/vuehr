package org.javaboy.vhr.controller.system;

import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/log")
public class LogController {

    @Autowired
    OpLogService opLogService;

    @PostMapping("list")
    public RespPageBean list(@RequestBody PageRequest pageRequest){

        return opLogService.page(pageRequest);
    }
}
