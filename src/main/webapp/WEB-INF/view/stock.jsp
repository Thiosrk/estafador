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
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Responsive Bootstrap Advance Admin Template</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
    <!-- FONTAWESOME STYLES-->
    <link href="<c:url value="/css/font-awesome.css"/>" rel="stylesheet"/>
    <!--CUSTOM BASIC STYLES-->
    <link href="<c:url value="/css/basic.css"/>" rel="stylesheet"/>
    <!--CUSTOM MAIN STYLES-->
    <link href="<c:url value="/css/custom.css"/>" rel="stylesheet"/>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
    <!-- 引入 ECharts 文件 -->
    <script src="<c:url value="/js/jquery-1.10.2.js"/>"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<c:url value="/js/jquery.metisMenu.js"/>"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="<c:url value="/js/custom.js"/>"></script>

    <script src="<c:url value="/js/echarts.min.js"/>"></script>
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
                <a href="login.html" class="btn btn-danger" title="Logout"><i class="fa"
                                                                              style="width: 100px;">返回</i></a>

            </div>
        </nav>

        <!-- /. ROW  -->
        <!--   Kitchen Sink -->
        <div class="panel panel-default">
            <div class="panel-heading" style="height:140px;">
                <div style="height:100%;width:40%;margin-top:1.5%;float:left;">
                    <span style="font-size:36px;margin-top:50%;margin-left: 20%;"><b>价格:${stock.close}</b></span>
                    <%--<span class="glyphicon glyphicon-arrow-up"></span>--%>
                </div>
                <div style="float:left;">
                    <table class="table table-striped table-bordered table-hover" style="border:none;"  rules=none >
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
                        </tr>
                        <tr>
                            <th>成交量:</th>
                            <td>${stock.tradeVol}</td>
                            <th>成交额:</th>
                            <td>${stock.tradeAmount}</td>
                            <th>总市值:</th>
                            <td>${stock.totalValue}</td>
                            <th>流通市值:</th>
                            <td>${stock.freeValue}</td>
                        </tr>
                        <tr>
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
                            <th></th>
                            <th>总市值</th>
                            <th>净资产</th>
                            <th>净利润</th>
                            <th>市盈率</th>
                            <th>市净率</th>
                            <th>毛利率</th>
                            <th>净利率</th>
                            <th>ROE</th>
                        </tr>
                        <tr>
                            <th>${stock.id}</th>
                            <td>${stock.totalValue}</td>
                            <td>${stock.netAsset}</td>
                            <td>${stock.netMargin}</td>
                            <td>${stock.pe}</td>
                            <td>${stock.pb}</td>
                            <td>${stock.gpr}</td>
                            <td>${stock.npr}</td>
                            <td>${stock.roe}</td>
                        </tr>
                        <tr>
                            <th>银行(行业平均)</th>
                            <td>${bank.avg_totalValue}</td>
                            <td>${bank.avg_netAsset}</td>
                            <td>${bank.avg_netMargin}</td>
                            <td>${bank.avg_pe}</td>
                            <td>${bank.avg_pb}</td>
                            <td>${bank.avg_gpr}</td>
                            <td>${bank.avg_npr}</td>
                            <td>${bank.avg_roe}</td>
                        </tr>
                        <tr>
                            <th>行业排名</th>
                            <td>${stock.rank_totalValue}</td>
                            <td>${stock.rank_netAsset}</td>
                            <td>${stock.rank_netMargin}</td>
                            <td>${stock.rank_pe}</td>
                            <td>${stock.rank_pb}</td>
                            <td>${stock.rank_gpr}</td>
                            <td>${stock.rank_npr}</td>
                            <td>${stock.rank_roe}</td>
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
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                                  data-toggle="tab">K线图表</a></li>
                        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab"
                                                   data-toggle="tab">预测分析</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">新浪研报</a>
                        </li>
                        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">腾讯研报</a>
                        </li>
                        <li role="presentation"><a href="#notices" aria-controls="notices" role="tab" data-toggle="tab">公告消息</a>
                        </li>
                        <li role="presentation"><a href="#news" aria-controls="news" role="tab" data-toggle="tab">新闻消息</a>
                        </li>
                        <li role="presentation"><a href="#discuss" aria-controls="discuss" role="tab" data-toggle="tab">论坛讨论</a>
                        </li>
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
                                    var data0 = splitData(${kstocksjson});


                                    function splitData(rawData) {
                                        var categoryData = [];
                                        var values = []
                                        for (var i = 0; i < rawData.length; i++) {
                                            categoryData.push(rawData[i].splice(0, 1)[0]);
                                            values.push(rawData[i])
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
                                            result.push((sum / dayCount).toFixed(2));
                                        }
                                        return result;
                                    }


                                    option = {
                                        <%--title: {--%>
                                            <%--text: ${echartstock.get(i).getCode()},--%>
                                            <%--left: 0--%>
                                        <%--},--%>
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
                                            boundaryGap: false,
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
                                                start: 95,
                                                end: 100
                                            },
                                            {
                                                show: true,
                                                type: 'slider',
                                                y: '90%',
                                                start: 95,
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
                        <div role="tabpanel" class="tab-pane" id="messages">
                                <!--预测分析-->
                                <div id="forecast" style="width: 1200px;height:400px;">
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
                                                data: ['实际数据', '预测数据']
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
                                                    name: '实际数据',
                                                    type: 'line',
                                                    xAxisIndex: 1,
                                                    smooth: true,
                                                    data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                                                },
                                                {
                                                    name: '预测数据',
                                                    type: 'line',
                                                    smooth: true,
                                                    data: [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 46.6, 55.4, 18.4, 10.3, 0.7]
                                                }
                                            ]
                                        };
                                        myChart.setOption(option);
                                    </script>
                                </div>
                            </div>
                        <div role="tabpanel" class="tab-pane" id="profile">
                            <div>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <tbody>
                                        <tr>
                                            <th>研报标题</th>
                                            <th>日期</th>
                                            <th>报告类型</th>
                                            <th>机构名称</th>
                                            <th>研究员</th>
                                            <th>研报正文链接</th>
                                        </tr>
                                        <c:if test="${!empty reportlist1 }">
                                            <c:forEach items="${reportlist1}" var="report1">
                                                <tr>
                                                    <td>${report1.title}</td>
                                                    <td>${report1.date}</td>
                                                    <td>${report1.type}</td>
                                                    <td>${report1.org}</td>
                                                    <td>${report1.reporter}</td>
                                                    <td><a href="${report1.reportUrl}">网页链接<a></td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="settings">
                            <div>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <tbody>
                                        <tr>
                                            <th>研报标题</th>
                                            <th>日期</th>
                                            <th>报告类型</th>
                                            <th>机构名称</th>
                                            <th>研究员</th>
                                            <th>研报正文链接</th>
                                        </tr>
                                        <c:if test="${!empty reportlist2 }">
                                            <c:forEach items="${reportlist2}" var="report2">
                                                <tr>
                                                    <td>${report2.title}</td>
                                                    <td>${report2.date}</td>
                                                    <td>${report2.type}</td>
                                                    <td>${report2.org}</td>
                                                    <td>${report2.reporter}</td>
                                                    <td><a href="${report2.reportUrl}">网页链接<a></td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="news">
                            <div>
                                <div class="table-responsive">

                                        <c:if test="${!empty newslist }">
                                            <c:forEach items="${newslist}" var="news">
                                                <div>
                                                    <h3><b>${news.title}</b></h3>
                                                    <h5>${news.datetime}</h5>
                                                    <p>${news.intro}</p>
                                                    <hr />
                                                </div>
                                            </c:forEach>
                                        </c:if>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="notices">
                            <div>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <tbody>
                                        <tr>
                                            <th>日期</th>
                                            <th>消息内容</th>
                                        </tr>
                                        <c:if test="${!empty noticelist }">
                                            <c:forEach items="${noticelist}" var="notice">
                                                <tr>
                                                    <td>${notice.datetime}</td>
                                                    <td>${notice.intro}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="discuss">
                            <div>
                                <div class="table-responsive">

                                        <c:if test="${!empty discusslist }">
                                            <c:forEach items="${discusslist}" var="discuss">
                                               <div>
                                                    <h3><b>标题:${discuss.title}</b></h3>
                                                    <h4>作者:${discuss.username}<a href="${discuss.userUrl}">主页</a></h4>
                                                    <h5>${discuss.datetime}</h5>
                                                    <p>${discuss.description}<a href="${discuss.discussUrl}">详情</a></p>
                                                     <hr />
                                               </div>
                                            </c:forEach>
                                        </c:if>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!--</div>-->

                </div>
            </div>
            <!-- End  Kitchen Sink -->
            <div class="col-md-1"></div>

        </div>
</body>
</html>