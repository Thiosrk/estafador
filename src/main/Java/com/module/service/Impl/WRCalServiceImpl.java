package com.module.service.Impl;

import com.module.pojo.Kstock;
import com.module.service.KstockService;
import com.module.service.WRCalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/6/11.
 */
@Service
public class WRCalServiceImpl implements WRCalService {
    @Autowired
    KstockService kstockService;
    private static double CON_WR = 100;
    private List<Kstock> kstockList;
    private double WR1;
    private double WR2;

    @Override
    public double GetWR1(String code) {
//        kstockList=kstockService.selectByCode(code);
//
//        if (high - low == 0)
//            return 0;
//        WR1 = CON_WR * (high - close) / (high - low);
        return WR1;
    }

    @Override
    public double GetWR2(String code) {
        kstockList=kstockService.selectByCode(code);
        double[] lows={Double.parseDouble(kstockList.get(0).getLow()),Double.parseDouble(kstockList.get(1).getLow()),
                Double.parseDouble(kstockList.get(2).getLow()),Double.parseDouble(kstockList.get(3).getLow()),
                Double.parseDouble(kstockList.get(4).getLow()),Double.parseDouble(kstockList.get(5).getLow())};
        double[] highs={Double.parseDouble(kstockList.get(0).getHigh()),Double.parseDouble(kstockList.get(1).getHigh()),
                Double.parseDouble(kstockList.get(2).getHigh()),Double.parseDouble(kstockList.get(3).getHigh()),
                Double.parseDouble(kstockList.get(4).getHigh()),Double.parseDouble(kstockList.get(5).getHigh())};
        double close=Double.parseDouble(kstockList.get(0).getClose());
        double high=findmax(highs);
        double low=findmin(lows);
        if (high - low == 0)
            return 0;
        WR2 = CON_WR * (high - close) / (high - low);
        WR2 = (int)(WR2*100)/100.0;
        return WR2;
    }

    public double findmax(double[] a) {
        // TODO Auto-generated method stub
        double max = a[0];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] >= max)
                max = a[i];
        }
        return max;
    }

    public double findmin(double[] a) {
        // TODO Auto-generated method stub

        double min = a[0];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] <= min)
                min = a[i];
        }
        return min;
    }


}
