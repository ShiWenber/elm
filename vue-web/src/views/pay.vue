<!-- 同一整个web应用前端风格的模板页,包括了主页面和底部按钮带 -->
<script setup lang="ts">
import Head from "../components/Head.vue";
import BarPad from "../components/BarPad.vue";
import "../assets/css/orderPage.css";
import "../assets/css/payPage.css"
import "../assets/css/output.css"
import { ref } from "vue";
</script>
<template>
    <Head> </Head>

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


        <BarPad></BarPad>


    </body>
</template>