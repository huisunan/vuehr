package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.EmployeeecMapper;
import org.javaboy.vhr.model.AdjustSalary;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonPrizeService {
    @Autowired
    EmployeeecMapper employeeecMapper;

    public RespPageBean page(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(), pageRequest.getSize());

        List<Employeeec> list = employeeecMapper.selectPage(pageRequest.getKeyword());

        PageInfo<Employeeec> of = PageInfo.of(list);

        return PageUtil.create(of);
    }

    public Integer add(Employeeec employeeec) {
        return employeeecMapper.insert(employeeec);
    }
}
