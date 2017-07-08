package com.module.service.Impl;

import com.module.mapper.KstockMapper;
import com.module.pojo.Kstock;
import com.module.service.calculateservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 69401 on 2017/7/8.
 */
@Service
public class calculateimpl implements calculateservice {


    String[] codelist = {"000001", "002142", "002807", "002839", "600000"
            , "600015", "600016", "600036", "600908", "600919", "600926", "601009", "601128",
            "601166", "601169", "601229", "601288", "601328", "601398", "601818", "601939",
            "601988", "601997", "601998", "603323"};

    @Autowired
    KstockMapper kstockMapper;


//    for (int i=0;i<list.length;++i){
//        if (i<daycount){
//            continue;
//        }
//        double sum = 0;
//        for (int j=0;j<daycount;++j){
//            sum +=Double.parseDouble(list[i-j].getClose());
//        }
//        ma[i] = sum/daycount;
//    }

    @Override
    public void calculateMA(int daycount) {
//        for (int i=0;i<codelist.length;++i){
            List<Kstock> kstocks = kstockMapper.selectByCode("sh600000");
            for (int j=0;j<kstocks.size();++j){
                if (j<daycount){
                    kstocks.get(j).setMA5(0);
                    continue;
                }
                double sum = 0;
                for (int t=0;t<daycount;++t){
                    sum +=Double.parseDouble(kstocks.get(j-t).getClose());
                }
                kstocks.get(j).setMA5(sum/daycount);
                kstockMapper.updateByPrimaryKey(kstocks.get(j));
            }

//        }

    }

    @Override
    public void calculateBias() {

    }

    @Override
    public void calculateWR() {

    }

    @Override
    public void calculateKDJ() {

    }
}
