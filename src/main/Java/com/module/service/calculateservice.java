package com.module.service;

import com.module.pojo.Kstock;

import java.util.List;

/**
 * Created by 69401 on 2017/7/8.
 */
public interface calculateservice {

    void calculateMA(int daycount);

    void calculateBias();

    void calculateWR();

    void calculateKDJ();

}
