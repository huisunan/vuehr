package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.EmployeetrainMapper;
import org.javaboy.vhr.model.Employeeremove;
import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonTrainService {
    @Autowired
    EmployeetrainMapper employeetrainMapper;

    public RespPageBean page(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(), pageRequest.getSize());

        List<Employeetrain> list = employeetrainMapper.selectPage(pageRequest.getKeyword());

        PageInfo<Employeetrain> of = PageInfo.of(list);

        return PageUtil.create(of);
    }

    public Integer add(Employeetrain employeetrain) {

        return  employeetrainMapper.insert(employeetrain);
    }
}
