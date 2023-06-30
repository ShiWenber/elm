<script setup lang="ts">
import Head from "../components/Head.vue";
import BarPad from "../components/BarPad.vue";
import "../assets/css/orderPage.css";
import "../assets/css/output.css"
import { ref } from "vue";
</script>

<template>
    <!-- 同一整个web应用前端风格的模板页,包括了主页面和底部按钮带 -->

    <Head></Head>
    <div>


        <div class="mainPad">
            <div class="headPad">
                <div class="my-2 text-lg text-center">
                    我的订单
                </div>
            </div>
            <div class="bodyPad">
                <div class="py-3 text-gray-400">
                    未支付订单信息
                </div>
                <div class="buCard">
                    <div class="buInfo">
                        <div>万家饺子（软件园E18店）</div>
                        <div>
                            <i class="fas fa-caret-down"></i>
                        </div>
                        <div>￥49</div>
                        <div class="rounded-sm bg-orange-500 text-white">
                            <RouterLink to="/pay">
                                去支付
                            </RouterLink>
                        </div>
                    </div>
                    <div class="line">
                        <div class="items">
                            纯肉鲜肉（水饺）x2
                        </div>
                        <div class="price">
                            ￥15
                        </div>
                    </div>
                    <div class="line">
                        <div class="items">
                            玉米鲜肉（水饺）x1
                        </div>
                        <div class="price">
                            ￥16
                        </div>
                    </div>
                    <div class="line">
                        <div class="items">
                            配送费
                        </div>
                        <div class="price">
                            ￥3
                        </div>
                    </div>
                </div>
                <div class="buCard">
                    <div class="buInfo">
                        <div>小锅饭豆腐馆（全运店）</div>
                        <div>
                            <i class="fas fa-caret-down"></i>
                        </div>
                        <div>￥55</div>
                        <div class="rounded-sm bg-orange-500 text-white">去支付</div>
                    </div>
                    <div class="line">
                        <div class="items">
                            纯肉鲜肉（水饺）x2
                        </div>
                        <div class="price">
                            ￥15
                        </div>
                    </div>
                    <div class="line">
                        <div class="items">
                            玉米鲜肉（水饺）x1
                        </div>
                        <div class="price">
                            ￥16
                        </div>
                    </div>
                    <div class="line">
                        <div class="items">
                            配送费
                        </div>
                        <div class="price">
                            ￥3
                        </div>
                    </div>
                </div>
                <div class="py-5 text-gray-400">
                    已支付订单信息
                </div>
                <div class="buCard">
                    <div class="buInfo">
                        <div>万家饺子（软件园E18店）</div>
                        <div>
                            <i class="fas fa-caret-down"></i>
                        </div>
                        <div>
                            ￥49
                        </div>
                    </div>
                    <div class="buInfo">
                        <div>小锅饭豆腐馆（全运店）</div>
                        <div>
                            <i class="fas fa-caret-down"></i>
                        </div>
                        <div>
                            ￥55
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <BarPad></BarPad>


    </div>
</template>