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
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="/css/font-awesome.css>" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="/css/custom.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">

    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

    <%--<!-- JQUERY SCRIPTS -->--%>
    <%--<script src="/js/jquery-1.10.2.js"></script>--%>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="/js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="/js/custom.js"></script>


    <%--<script type="text/javascript">--%>
        <%--function load(){--%>
<%--//实现页面的跳转--%>
            <%--window.location.href='<%=basePath%>Stock/Stockspecific/'+${id};--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>


                <!-- /. ROW  -->


            <div class="row">
                <div class="col-md-6" style="margin-left: 20%">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 >
                                <span style="margin-left: 40%">银行业股票盘点</span>
                            </h1>
                        </div>
                    </div>
                     <!--    Hover Rows  -->
                    <div class="panel panel-default"   style="width: 800px;">
                        <div class="panel-heading" style="text-align: center">
                            <span  style="text-align: center">股票涨跌榜</span>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">

                                <div id="container">
                                    <!-- 定义一个表格元素 -->
                                    <table id="table_id_example" class="display" >
                                        <thead>
                                        <tr>
                                            <th>股票代码</th>
                                            <th>名称</th>
                                            <th>最新价</th>
                                            <th>涨跌额</th>
                                            <th>涨跌幅</th>
                                            <th>昨收</th>
                                            <th>今开</th>
                                            <th>最高</th>
                                            <th>最低</th>
                                            <th>成交量</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${!empty bankstocklist }">
                                            <c:forEach items="${bankstocklist}" var="stock">
                                                <tr onclick="function test() {
                                                        window.location.href='<%=basePath%>Stock/Stockspecific/'+${stock.id};
                                                        }">
                                                    <td><a href="<%=basePath%>Stock/Stockspecific/${stock.id}">${stock.id}</a></td>
                                                    <td>${stock.name}</td>
                                                    <td>${stock.price}</td>
                                                    <td>${stock.change}</td>
                                                    <td>${stock.changeP}</td>
                                                    <td>${stock.close}</td>
                                                    <td>${stock.open}</td>
                                                    <td>${stock.high}</td>
                                                    <td>${stock.low}</td>
                                                    <td>${stock.tradeVol}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End  Hover Rows  -->
                </div>

    </div>
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <script>
        $(document).ready( function () {
            $('#table_id_example').DataTable();
        } );
    </script>


</body>
</html>