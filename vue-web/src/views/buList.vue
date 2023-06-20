<!-- 
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="/dist/output.css" rel="stylesheet">
</head>
<body>
  <h1 class="text-3xl font-bold underline">
    Hello world!
  </h1>
</body>
</html> -->

<!-- tailwind 中的 w-60 表示 width: 15rem; /* 240px */  -->
<!-- 使用 cdn 方式应用 tailwindcss -->
<template>

<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

  <link href="../dist/output.css" type="text/css" rel="stylesheet">
  <link href="../dist/buListPage.css" type="text/css" rel="stylesheet" />

</head>

<body>


  <div class="mainPad">
    <div class="headPad">
      <div class="my-2 text-lg text-center">
        商家列表
      </div>
    </div>
    <div class="bodyPad">
      <!-- 商家列表 -->
      <div class="businessList">
        <div class="businessCard">
          <div class="businessIcon">
            <img src="../../images/-12f424b44c0cdcb.jpg" title="菜">
          </div>
          <div class="businessInfo">
            <div>包菜狗肉</div>
            <div>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              4.9月销售996
            </div>
            <div>￥15起</div>
          </div>
        </div>

        <div class="businessCard">
          <div class="businessIcon">
            <img src="../../images/-12f424b44c0cdcb.jpg" title="菜">
          </div>
          <div class="businessInfo">
            <div>包菜狗肉</div>
            <div>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              4.9月销售996
            </div>
            <div>￥15起</div>
          </div>
        </div>

        <div class="businessCard">
          <div class="businessIcon">
            <img src="../../images/-12f424b44c0cdcb.jpg" title="菜">
          </div>
          <div class="businessInfo">
            <div>包菜狗肉</div>
            <div>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              4.9月销售996
            </div>
            <div>￥15起</div>
          </div>
        </div>
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