<!-- 同一整个web应用前端风格的模板页,包括了主页面和底部按钮带 -->
<template>

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

    <link href="../dist/output.css" type="text/css" rel="stylesheet">

    <!-- 使用的特殊的css样式的位置 -->
    <link href="../dist/payPage.css" type="text/css" rel="stylesheet" />

</head>

<body>


    <div class="mainPad">
        <div class="headPad">
            <div class="my-2 text-lg text-center">
                在线支付
            </div>
        </div>

        <div class="bodyPad">
            <div class="my-3 text-gray-400">订单信息：</div>

            <div class="orderPad">
                <div class="orderCard">
                    <div class="items text-base mb-3">万家饺子（软件园E18店）
                        <i class="fas fa-caret-down"></i>
                    </div>

                    <div class="price text-red-500 text-lg mb-3">￥34</div>
                </div>
                <div class="orderCard">
                    <div class="items">纯肉鲜肉（水饺）x2</div>
                    <div class="price">￥15</div>
                </div>
                <div class="orderCard">
                    <div class="items">玉米鲜肉（水饺）x2</div>
                    <div class="price">￥16</div>
                </div>
                <div class="orderCard">
                    <div class="items">配送费</div>
                    <div class="price">￥3</div>
                </div>
                <div class="h-20">
                </div>
                <!-- 蓝色大号支付宝图标 -->
                <div class="orderCard">
                    <div class="items flex flex-row">
                        <i class="fab fa-alipay" style="font-size:48px ; color:blue;"></i>
                        <div class="self-center basis-1/2 pl-3">支付宝</div>
                    </div>
                    <div class="price self-center">
                        <i class="fas fa-check-circle"></i>
                    </div>
                </div>
                <div class="orderCard">
                    <div class="items flex flex-row">
                        <!-- 绿色微信支付图标 -->
                        <i class="fab fa-weixin" style="font-size:48px ; color:green;"></i>
                        <div class="self-center basis-1/2 pl-3">微信支付</div>
                    </div>
                    <div class="price self-center">
                        <i class="fas fa-check-circle"></i>
                    </div>
                </div>


            </div>
            <!-- 确认支付按钮 -->
            <div class="flex flex-row">
                <div class="w-1/3">&nbsp</div>
                <div class="payBtn">
                    <div>确认支付</div>
                </div>
                <div class="w-1/3">&nbsp</div>
            </div>
        </div>
    </div>


    <div class="barPad">
        <div>
            <i class="fas fa-home"></i>
            <br />首页
        </div>
        <div>
            <i class="fas fa-search"></i>
            <br />发现
        </div>
        <div>
            <i class="fas fa-shopping-cart"></i>
            <br />订单
        </div>
        <div>
            <i class="fas fa-user"></i>
            <br />我的
        </div>
    </div>


</body>

</html>
</template>