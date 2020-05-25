package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.OpLogMapper;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.OpLog;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.requeset.PageRequest;
import org.javaboy.vhr.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpLogService {
    @Autowired
    OpLogMapper opLogMapper;

    public void add(OpLog log) {
        opLogMapper.insert(log);
    }

    public RespPageBean page(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(), pageRequest.getSize());

        List<OpLog> list = opLogMapper.selectPage(pageRequest.getKeyword());

        PageInfo<OpLog> of = PageInfo.of(list);

        return PageUtil.create(of);
    }
}
