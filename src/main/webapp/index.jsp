<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" />
    <style>
        .jumbotron{
            background:url(WEB-INF/view/statics/img/jumu.jpeg);
            width: auto;
            height: auto;
        }
    </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="jumbotron" style="margin: 1.5%;padding: 6%">
    <h1>Welcome to estafador</h1>
    <br />
    <p>股票交易平台</p>
    <br />
    <br />
    <br />
    <br />
    <p><a class="btn btn-primary btn-lg" href="/BankStock" role="button">Learn more</a></p>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
</div>
    <!-- 引入 ECharts 文件 -->
    <script src="<c:url value="/js/jquery-1.10.2.js"/>"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
</body>
</html>