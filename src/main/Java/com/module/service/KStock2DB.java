package com.module.service;

import com.module.pojo.Kstock;

import java.util.List;

/**
 * Created by lenovo on 2017/6/10.
 */
public interface KStock2DB {
    public int load2db(List<Kstock[]> kstocks);
}
