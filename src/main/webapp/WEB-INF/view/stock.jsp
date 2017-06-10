<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ include file="/WEB-INF/view/common/tagPage.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Responsive Bootstrap Advance Admin Template</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="<c:url value="/css/font-awesome.css"/>" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="<c:url value="/css/basic.css"/>" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="<c:url value="/css/custom.css"/>" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- 引入 ECharts 文件 -->
    <script src="<c:url value="/js/jquery-1.10.2.js"/>"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<c:url value="/js/jquery.metisMenu.js"/>"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="<c:url value="/js/custom.js"/>"></script>

    <script  src="<c:url value="/js/echarts.min.js"/>"></script>
</head>
<body>

            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="index.html">${stock.name}</a>
                        </div>
                        <div class="header-right">
                            <a href="login.html" class="btn btn-danger" title="Logout"><i class="fa" style="width: 100px;">返回</i></a>

                        </div>
                    </nav>
                </div>
                <div class="col-md-1"></div>
                <!-- /. ROW  -->
                    <!--   Kitchen Sink -->
                    <div class="panel panel-default">
                       <div class="panel-heading" style="height:100px;">
                              <div style="height:100%;width:40%;margin-top:1.5%;float:left;">
                              <span style="font-size:36px;margin-top:30%;"><b>价格:${stock.close}</b></span>
                                  <span class="glyphicon glyphicon-arrow-up"></span>
                              </div>
                              <div style="float:left;">
                                  <table class="table table-striped table-bordered table-hover" style="border:0px;">
                                      <tbody>
                                      <tr>
                                           <th>今开:</th>
                                           <td>${stock.open}</td>
                                           <th>最高:</th>
                                           <td>${stock.high}</td>
                                           <th>最低:</th>
                                           <td>${stock.low}</td>
                                           <th>昨收:</th>
                                           <td>${stock.close}</td>
                                          <th>成交量:</th>
                                          <td>${stock.tradeVol}</td>
                                          <th>成交额:</th>
                                          <td>${stock.tradeAmount}</td>
                                      </tr>
                                      <tr>
                                          <th>总市值:</th>
                                          <td>${stock.totalValue}</td>
                                          <th>流通市值:</th>
                                          <td>${stock.freeValue}</td>
                                          <th>振幅:</th>
                                          <td>${stock.changeP}</td>
                                          <th>换手率:</th>
                                          <td>${stock.tr}</td>
                                          <th>市净率:</th>
                                          <td>${stock.pb}</td>
                                          <th>市盈率:</th>
                                          <td>${stock.pe}</td>
                                      </tr>
                                      </tbody>
                                  </table>
                              </div>
                          </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <tbody>
                                    <tr>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                    </tr>
                                    <tr>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--<div class="row" style="margin-left: 30%;margin-bottom: 5%;">-->
                                <!--<div class="col-md-12">-->
                                    <!--<ul class="nav nav-pills">-->
                                        <!--<li role="presentation" class="active"><a href="stock.html">K线图表</a></li>-->
                                        <!--<li role="presentation"><a href="stock_comment.html">论坛评论</a></li>-->
                                        <!--<li role="presentation"><a href="stock_forecast.html">预测分析</a></li>-->
                                        <!--<li role="presentation"><a href="stock_introduction.html">公司简介</a></li>-->
                                    <!--</ul>-->
                                <!--</div>-->
                                <div>

                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">K线图表</a></li>
                                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">论坛评论</a></li>
                                        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">预测分析</a></li>
                                        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">公司简介</a></li>
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="home">
                                            <!--K线图表-->
                                            <div>
                                                <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                                                <div id="main" style="margin-left:5%;width: 1200px;height:400px;"></div>
                                                <script type="text/javascript">
                                                    // 基于准备好的dom，初始化echarts实例
                                                    var myChart = echarts.init(document.getElementById('main'));

                                                    // 指定图表的配置项和数据
                                                    // 数据意义：开盘(open)，收盘(close)，最低(lowest)，最高(highest)
                                                    var data0 = splitData(${echartstock});


                                                    function splitData(rawData) {
                                                        var categoryData = [];
                                                        var values = []
                                                        for (var i = 0; i < rawData.size(); i++) {
                                                            categoryData.push(rawData.get(i).splice(0, 1)[0]);
                                                            values.push(rawData.get(i))
                                                        }
                                                        return {
                                                            categoryData: categoryData,
                                                            values: values
                                                        };
                                                    }

                                                    function calculateMA(dayCount) {
                                                        var result = [];
                                                        for (var i = 0, len = data0.values.length; i < len; i++) {
                                                            if (i < dayCount) {
                                                                result.push('-');
                                                                continue;
                                                            }
                                                            var sum = 0;
                                                            for (var j = 0; j < dayCount; j++) {
                                                                sum += data0.values[i - j][1];
                                                            }
                                                            result.push(sum / dayCount);
                                                        }
                                                        return result;
                                                    }



                                                    option = {
                                                        title: {
                                                            text: ${echartstock.get(i).getCode()},
                                                            left: 0
                                                        },
                                                        tooltip: {
                                                            trigger: 'axis',
                                                            axisPointer: {
                                                                type: 'cross'
                                                            }
                                                        },
                                                        legend: {
                                                            data: ['日K', 'MA5', 'MA10', 'MA20', 'MA30']
                                                        },
                                                        grid: {
                                                            left: '10%',
                                                            right: '10%',
                                                            bottom: '15%'
                                                        },
                                                        xAxis: {
                                                            type: 'category',
                                                            data: data0.categoryData,
                                                            scale: true,
                                                            boundaryGap : false,
                                                            axisLine: {onZero: false},
                                                            splitLine: {show: false},
                                                            splitNumber: 20,
                                                            min: 'dataMin',
                                                            max: 'dataMax'
                                                        },
                                                        yAxis: {
                                                            scale: true,
                                                            splitArea: {
                                                                show: true
                                                            }
                                                        },
                                                        dataZoom: [
                                                            {
                                                                type: 'inside',
                                                                start: 50,
                                                                end: 100
                                                            },
                                                            {
                                                                show: true,
                                                                type: 'slider',
                                                                y: '90%',
                                                                start: 50,
                                                                end: 100
                                                            }
                                                        ],
                                                        series: [
                                                            {
                                                                name: '日K',
                                                                type: 'candlestick',
                                                                data: data0.values,
                                                                markPoint: {
                                                                    label: {
                                                                        normal: {
                                                                            formatter: function (param) {
                                                                                return param != null ? Math.round(param.value) : '';
                                                                            }
                                                                        }
                                                                    },
                                                                    data: [
                                                                        {
                                                                            name: 'XX标点',
                                                                            coord: ['2013/5/31', 2300],
                                                                            value: 2300,
                                                                            itemStyle: {
                                                                                normal: {color: 'rgb(41,60,85)'}
                                                                            }
                                                                        },
                                                                        {
                                                                            name: 'highest value',
                                                                            type: 'max',
                                                                            valueDim: 'highest'
                                                                        },
                                                                        {
                                                                            name: 'lowest value',
                                                                            type: 'min',
                                                                            valueDim: 'lowest'
                                                                        },
                                                                        {
                                                                            name: 'average value on close',
                                                                            type: 'average',
                                                                            valueDim: 'close'
                                                                        }
                                                                    ],
                                                                    tooltip: {
                                                                        formatter: function (param) {
                                                                            return param.name + '<br>' + (param.data.coord || '');
                                                                        }
                                                                    }
                                                                },
                                                                markLine: {
                                                                    symbol: ['none', 'none'],
                                                                    data: [
                                                                        [
                                                                            {
                                                                                name: 'from lowest to highest',
                                                                                type: 'min',
                                                                                valueDim: 'lowest',
                                                                                symbol: 'circle',
                                                                                symbolSize: 10,
                                                                                label: {
                                                                                    normal: {show: false},
                                                                                    emphasis: {show: false}
                                                                                }
                                                                            },
                                                                            {
                                                                                type: 'max',
                                                                                valueDim: 'highest',
                                                                                symbol: 'circle',
                                                                                symbolSize: 10,
                                                                                label: {
                                                                                    normal: {show: false},
                                                                                    emphasis: {show: false}
                                                                                }
                                                                            }
                                                                        ],
                                                                        {
                                                                            name: 'min line on close',
                                                                            type: 'min',
                                                                            valueDim: 'close'
                                                                        },
                                                                        {
                                                                            name: 'max line on close',
                                                                            type: 'max',
                                                                            valueDim: 'close'
                                                                        }
                                                                    ]
                                                                }
                                                            },
                                                            {
                                                                name: 'MA5',
                                                                type: 'line',
                                                                data: calculateMA(5),
                                                                smooth: true,
                                                                lineStyle: {
                                                                    normal: {opacity: 0.5}
                                                                }
                                                            },
                                                            {
                                                                name: 'MA10',
                                                                type: 'line',
                                                                data: calculateMA(10),
                                                                smooth: true,
                                                                lineStyle: {
                                                                    normal: {opacity: 0.5}
                                                                }
                                                            },
                                                            {
                                                                name: 'MA20',
                                                                type: 'line',
                                                                data: calculateMA(20),
                                                                smooth: true,
                                                                lineStyle: {
                                                                    normal: {opacity: 0.5}
                                                                }
                                                            },
                                                            {
                                                                name: 'MA30',
                                                                type: 'line',
                                                                data: calculateMA(30),
                                                                smooth: true,
                                                                lineStyle: {
                                                                    normal: {opacity: 0.5}
                                                                }
                                                            },

                                                        ]
                                                    };
                                                    // 使用刚指定的配置项和数据显示图表。
                                                    myChart.setOption(option);
                                                </script>
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="profile">
                                            <!--论坛评论-->
                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="messages">
                                            <!--预测分析-->
                                            <div  id="forecast" style="width: 1200px;height:400px;">
                                                <script type="text/javascript">
                                                    var myChart = echarts.init(document.getElementById('forecast'));

                                                    var colors = ['#5793f3', '#d14a61', '#675bba'];


                                                    option = {
                                                        color: colors,
                                                        title: {
                                                            text: '预测分析',
                                                            left: 0
                                                        },
                                                        tooltip: {
                                                            trigger: 'none',
                                                            axisPointer: {
                                                                type: 'cross'
                                                            }
                                                        },
                                                        legend: {
                                                            data:['实际数据', '预测数据']
                                                        },
                                                        grid: {
                                                            top: 70,
                                                            bottom: 50
                                                        },
                                                        xAxis: [
                                                            {
                                                                type: 'category',
                                                                axisTick: {
                                                                    alignWithLabel: true
                                                                },
                                                                axisLine: {
                                                                    onZero: false,
                                                                    lineStyle: {
                                                                        color: colors[1]
                                                                    }
                                                                },
                                                                axisPointer: {
                                                                    label: {
                                                                        formatter: function (params) {
                                                                            return '收盘价  ' + params.value
                                                                                    + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                                                                        }
                                                                    }
                                                                },
                                                                data: ["2016-1", "2016-2", "2016-3", "2016-4", "2016-5", "2016-6", "2016-7", "2016-8", "2016-9", "2016-10", "2016-11", "2016-12"]
                                                            },
                                                            {
                                                                type: 'category',
                                                                axisTick: {
                                                                    alignWithLabel: true
                                                                },
                                                                axisLine: {
                                                                    onZero: false,
                                                                    lineStyle: {
                                                                        color: colors[0]
                                                                    }
                                                                },
                                                                axisPointer: {
                                                                    label: {
                                                                        formatter: function (params) {
                                                                            return '收盘价  ' + params.value
                                                                                    + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                                                                        }
                                                                    }
                                                                },
                                                                data: ["2015-1", "2015-2", "2015-3", "2015-4", "2015-5", "2015-6", "2015-7", "2015-8", "2015-9", "2015-10", "2015-11", "2015-12"]
                                                            }
                                                        ],
                                                        yAxis: [
                                                            {
                                                                type: 'value'
                                                            }
                                                        ],
                                                        series: [
                                                            {
                                                                name:'实际数据',
                                                                type:'line',
                                                                xAxisIndex: 1,
                                                                smooth: true,
                                                                data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                                                            },
                                                            {
                                                                name:'预测数据',
                                                                type:'line',
                                                                smooth: true,
                                                                data: [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 46.6, 55.4, 18.4, 10.3, 0.7]
                                                            }
                                                        ]
                                                    };
                                                    myChart.setOption(option);
                                                </script>
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="settings">
                                            <!--公司简介-->
                                        </div>
                                    </div>

                                </div>
                            <!--</div>-->

                        </div>
                    </div>
                    <!-- End  Kitchen Sink -->


</body>
</html>