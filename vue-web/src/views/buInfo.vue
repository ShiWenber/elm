<template>

<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

  <link href="../dist/output.css" type="text/css" rel="stylesheet" />
  <!-- 使用的特殊的css样式的位置 -->
  <link href="../dist/buInfoPage.css" type="text/css" rel="stylesheet" />

</head>

<body>


  <div class="mainPad">
    <div class="headPad">
      <div class="my-2 text-lg text-center">
        商家信息
      </div>
    </div>
    <div class="bodyPad">
      <div class="BusInfos">
        <div>
          <img
            src="https://ts2.cn.mm.bing.net/th?id=AMMS_0cdc87eb521894c42d262e3864976729&w=306&h=459&c=7&rs=1&qlt=80&o=6&cdv=1&pid=16.1">
        </div>
        <div class="font-bold text-lg">万家饺子（软件园E18号）</div>
        <div class="text-sm text-gray-500">
          ￥15起送|￥3配送
        </div>
        <div class="text-sm text-gray-500">各种饺子炒菜</div>
      </div>

      <div class="MealList">

        <div class="MealCard">
          <div class="MealIcon">
            <img
              src="https://ts3.cn.mm.bing.net/th?id=AMMS_6aeb63ecd3c4bb943a8f38c7a7fca7fa&w=328&h=440&c=7&rs=1&qlt=80&o=6&cdv=1&pid=16.1">
          </div>
          <div class="MealInfo">
            <div class="font-bold text-base">纯肉鲜饺（水饺）</div>
            <div class="text-sm text-gray-500">
              新鲜猪肉
            </div>
            <div class="text-sm text-gray-500">￥15</div>
          </div>
          <div class="basis-1/3 self-center text-right">
            <i class="fas fa-minus-circle text-gray-400"></i>
            2
            <i class="fas fa-plus-circle text-blue-500"></i>
          </div>
        </div>

        <div class="MealCard">
          <div class="MealIcon">
            <img
              src="https://ts4.cn.mm.bing.net/th?id=AMMS_dee0d6e312fb0cb56748454f4f8c54eb&w=612&h=459&c=7&rs=1&qlt=80&o=6&cdv=1&pid=16.1">
          </div>
          <div class="MealInfo">
            <div class="font-bold text-base">玉米鲜肉（水饺）</div>
            <div class="text-sm text-gray-500">
              玉米鲜肉
            </div>
            <div class="text-sm text-gray-500">￥16</div>
          </div>
          <div class="basis-1/3 self-center text-right">
            <i class="fas fa-minus-circle text-gray-400"></i>
            3
            <i class="fas fa-plus-circle text-blue-500"></i>
          </div>
        </div>

        <div class="MealCard">
          <div class="MealIcon">
            <img
              src="https://ts1.cn.mm.bing.net/th?id=AMMS_d1b1a966ee84dd1d5befd1706b1f378a&w=232&h=232&c=7&rs=1&qlt=80&o=6&cdv=1&pid=16.1">
          </div>
          <div class="MealInfo">
            <div class="font-bold text-base">虾仁三鲜（蒸饺）</div>
            <div class="text-sm text-gray-500">
              虾仁三鲜
            </div>
            <div class="text-sm text-gray-500">￥16</div>
          </div>
          <div class="basis-1/3 self-center text-right">

            <i class="fas fa-plus-circle text-blue-500"></i>
          </div>
        </div>

      </div>


    </div>
  </div>


  <div class="barPad_pay bg-black">
    <!-- 购物车图标 -->
    <div class="p-3">
      <i class="fas fa-shopping-cart text-blue-500 text-4xl" ></i>
    </div>
    <div class="basis-3/4 justify-center text-center content-center bg-black">
      <div class="font-bold text-lg text-white justify-center content-center">
        ￥15
      </div>

      <div class="text-sm text-gray-200 justify-center content-center">
        配送费￥3
      </div>
    </div>
    <div class="basis-1/4 h-full bg-green-500">
      <!-- 空格起到高度三平分作用 -->
      <div>&nbsp</div>
      <div class="font-bold text-white text-lg text-center">
          去结算
      </div>
      <div>&nbsp</div>
    </div>
  </div>


</body>

</html>
</template>