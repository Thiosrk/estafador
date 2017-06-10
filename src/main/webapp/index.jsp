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
    <title>Online-Stock Analysis</title>

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

    <!-- JQUERY SCRIPTS -->
    <script src="<c:url value="/js/jquery-1.10.2.js"/>"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<c:url value="/js/jquery.metisMenu.js"/>"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="<c:url value="/js/custom.js"/>"></script>


    <script type="text/javascript">
        function load(){
//实现页面的跳转
            window.location.href='<%=basePath%>Stock/Stockspecific/sh600000';
        }
    </script>
</head>
<body>

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-head-line" >
                            <span style="margin-left: 35%">银行业股票盘点</span>
                        </h1>
                        <h1 class="page-subhead-line">每日更新 </h1>

                    </div>
                </div>
                <!-- /. ROW  -->


            <div class="row">
                <div class="col-md-6" style="margin-left: 20%">
                     <!--    Hover Rows  -->
                    <div class="panel panel-default" >
                        <div class="panel-heading">
                            <span  style="margin-left: 40%">股票涨跌榜</span>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>股票代码</th>
                                            <th>名称</th>
                                            <th>最新价</th>
                                            <th>涨跌额</th>
                                            <th>涨跌幅</th>
                                            <th>买入</th>
                                            <th>卖出</th>
                                            <th>昨收</th>
                                            <th>今开</th>
                                            <th>最高</th>
                                            <th>最低</th>
                                            <th>成交量</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr onclick="load()">
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr onclick="load()">
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr onclick="load()">
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr onclick="load()">
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                            <td>sh60000</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- End  Hover Rows  -->
                </div>

    </div>
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->



</body>
</html>