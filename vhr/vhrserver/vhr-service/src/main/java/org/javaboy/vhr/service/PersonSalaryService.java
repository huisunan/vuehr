package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.AdjustSalaryMapper;
import org.javaboy.vhr.mapper.SalaryMapper;
import org.javaboy.vhr.model.AdjustSalary;
import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.Salary;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonSalaryService {

    @Autowired
    AdjustSalaryMapper adjustSalaryMapper;

    @Autowired
    SalaryMapper salaryMapper;

    public RespPageBean page(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(), pageRequest.getSize());

        List<AdjustSalary> list = adjustSalaryMapper.selectPage(pageRequest.getKeyword());

        PageInfo<AdjustSalary> of = PageInfo.of(list);

        return PageUtil.create(of);
    }

    public Integer add(AdjustSalary adjustSalary) {
        Salary salary = salaryMapper.selectByEid(adjustSalary.getEid());
        if (salary != null){
            adjustSalary.setBeforesalary(salary.getBasicSalary());
        }
        return adjustSalaryMapper.insert(adjustSalary);
    }
}
