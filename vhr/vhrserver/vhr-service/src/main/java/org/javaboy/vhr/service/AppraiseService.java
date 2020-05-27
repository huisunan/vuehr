package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.AppraiseMapper;
import org.javaboy.vhr.model.Appraise;
import org.javaboy.vhr.model.Employeeremove;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppraiseService {
    @Autowired
    AppraiseMapper appraiseMapper;

    public Integer add(Appraise appraise) {

        return appraiseMapper.insert(appraise);
    }

    public RespPageBean page(PageRequest pageRequest) {

        PageHelper.startPage(pageRequest.getPage(), pageRequest.getSize());

        List<Employeeremove> list = appraiseMapper.selectPage(pageRequest.getKeyword());

        PageInfo<Employeeremove> of = PageInfo.of(list);

        return PageUtil.create(of);
    }
}
