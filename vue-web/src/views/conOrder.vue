<template>
<!-- 同一整个web应用前端风格的模板页,包括了主页面和底部按钮带 -->

<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

  <link href="../assets/css/output.css" type="text/css" rel="stylesheet">

  <!-- 使用的特殊的css样式的位置 -->
  <link href="../assets/css/conOrderPage.css" type="text/css" rel="stylesheet" />

</head>

<body>
  <div class="mainPad">
    <div class="headPad">
      <div class="my-2 text-lg text-center">
        确认订单
      </div>
    </div>
    <div class="infoCard p-2">
      <div class="basis-3/4 text-white">
        <div class="text-sm">订单配送至</div>
        <div class="text-lg font-bold">沈阳市浑南区智慧四街1-121号</div>
        <div class="text-sm">习近平先生 136556785432</div>
      </div>
      <div class="basis-1/4 text-right self-center mr-1.5 text-right">
        <i class="fas fa-angle-right"></i>
      </div>
    </div>
    <div class="bodyPad">


      <div class="buCard py-2">
        <div> 万家饺子（软件园E18店）</div>
      </div>

      <div class="hr"></div>

      <div class="orderPad">
        <div class="orderCard">
          <div>
            <img
              src="https://ts1.cn.mm.bing.net/th?id=AMMS_83e9418c167a9f7ac34b3f14cf341672&w=612&h=405&c=7&rs=1&qlt=80&o=6&cdv=1&pid=16.1">
          </div>
          <div class="items">鲜肉（水饺）x2</div>
          <div class="price">￥15</div>
        </div>

        <div class="orderCard">
          <div>
            <img
              src="https://ts4.cn.mm.bing.net/th?id=AMMS_dee0d6e312fb0cb56748454f4f8c54eb&w=612&h=459&c=7&rs=1&qlt=80&o=6&cdv=1&pid=16.1">
          </div>
          <div class="items">玉米鲜肉（水饺）x2</div>
          <div class="price">￥16</div>
        </div>

        <div class="orderCard">
          <div class="items">
            配送费
          </div>
          <div class="w-2/6 text-right">
            ￥3
          </div>
        </div>

      </div>
    </div>

  </div>

  <div class="barPad_pay bg-black">
    <div class="w-3/4 h-full text-white text-center">
      <div class="h-1/3"></div>
      <div class="h-1/3">￥34</div>
      <div class="h-1/3"></div>
    </div>
    <div class="w-1/4 h-full text-white bg-green-500 text-center">
      <div class="h-1/3"></div>
      <div>去支付</div>
      <div class="h-1/3"></div>
    </div>
  </div>
</body>
</html>
</template>