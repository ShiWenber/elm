<script setup lang="ts">
import Head from "../components/Head.vue";
import BarPad from "@/components/BarPad.vue";
import "../assets/css/homePage.css";
import "../assets/css/output.css";
import { RouterLink } from 'vue-router'
import { localGet, localRemove } from "@/utils";
import UserAddress from "./userAddress.vue";
import axios from "axios";
import { ref, reactive, onMounted } from "vue";
import router from "@/router";
function logout() {
  localRemove("token");
  localRemove("id");
  window.location.reload();
}

function toBuInfo(businessId: any) {
  // window.location.href = "/businessInfo?businessId=" + businessId;
  router.push({ path: '/buInfo', query: { businessId } });
}


let isLoaded = ref(false);
let businesses_rec = reactive([]);

onMounted(() => {
  // 如果这个变量改变，需要重新渲染页面
  let config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: 'http://localhost:9000/shop/all',
    headers: {
      'Accept': '*/*',
      'Authorization': 'Bearer ' + localGet('token'),
    }
  };

  axios.request(config)
    .then((response) => {
      businesses_rec = response.data;
      isLoaded.value = true;
    })
    .catch((error) => {
      console.log(error);
    });
});


</script>
<template>
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

  <Head></Head>

  <div class="homePage">
    <div class="bodyPad">

      <div class="mainPad">
        <!-- 设置导航栏 -->
        <div class="headPad">
          <!-- pl-4左侧内边距 -->
          <div class="pl-4">
            <i class="fas fa-map-marker-alt"></i>
            云南大学呈贡校区
          </div>
          <div class="m-4">
            <input type="text" placeholder="搜索">
          </div>

        </div>

        <!-- 商品分类 -->
        <div class="cataMenu">
          <div class="grid grid-cols-5 gap-3" v-if="isLoaded">
            <li v-for="item in businesses_rec" @click="toBuInfo(item.id)">
              <div>
                <img :src="item.image" style="display: block;">
                {{ item.name }}
              </div>
            </li>
          </div>

        </div>
        <div class="buttonPad">
          <a class="btn btn-full btn-green grow" v-if="!localGet('token')">
            <RouterLink to="/login">
              <i class="fas fa-sign-in-alt"></i>
              登录
            </RouterLink>
          </a>
          <a class="btn btn-full btn-blue grow" v-if="localGet('token')" @click="logout">
            <i class="fas fa-sign-out-alt"></i>
            退出
          </a>
          <a class="btn btn-full btn-blue grow" v-if="localGet('token')">
            <RouterLink to="/userAddress">
              <i class="fas fa-address-card"></i>
              地址
            </RouterLink>
          </a>
        </div>
        <div class="adPad">
          <a href="#">
            <img
              src="https://tse1-mm.cn.bing.net/th/id/R-C.e788419a7b58c22ddaf2f43903c6e739?rik=yr43i9GI1DDcHg&riu=http%3a%2f%2fepaper.file.routeryun.com%2flsrb%2f2020-04-03%2f5e86361508699.jpg&ehk=naYuJ611UhG0rT6pXbj%2bTTqt%2bZeawR%2fhrb46lyDlRvE%3d&risl=&pid=ImgRaw&r=0"
              title="广告" />
          </a>
        </div>

        <div class="businessPad">
          <div class="titlePad">
            <span></span> 商家列表<span></span>
          </div>
          <div class="searchBar mx-4">
            <button>综合排序</button>
            <button>距离最近</button>
            <button>销量最高</button>
            <button>筛选</button>
          </div>
        </div>



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
    <BarPad></BarPad>

  </div>
</template>