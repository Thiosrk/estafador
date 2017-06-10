package com.module.service.Impl;

import com.module.mapper.KstockMapper;
import com.module.pojo.Kstock;
import com.module.service.KstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/6/10.
 */
@Service
public class KstockServiceImpl implements KstockService {

    @Autowired
    KstockMapper kstockMapper;

    @Override
    public int deleteByCode(String code) {
        return kstockMapper.deleteByCode(code);
    }

    @Override
    public int insert(Kstock record) {
        return kstockMapper.insert(record);
    }

    @Override
    public List<Kstock> selectByCode(String code) {
        return kstockMapper.selectByCode(code);
    }

    @Override
    public int update(Kstock record) {
        return kstockMapper.update(record);
    }
}
