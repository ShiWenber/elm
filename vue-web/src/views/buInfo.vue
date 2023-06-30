<script setup lang="ts">
import '../assets/css/output.css';
import '../assets/css/buInfoPage.css'
import Head from '@/components/Head.vue';
import { useRoute } from 'vue-router';
import { onMounted, ref } from 'vue';
import axios from 'axios';
import { localGet } from '@/utils';

// 取得从上一个页面传来的参数
const route = useRoute();
const businessId = route.query.businessId;

let foods_rec = ref({});
let isLoaded = ref(false);


// 获取商家信息
onMounted(() => {
  console.log(businessId);

  let config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: 'http://localhost:9000/shop/getItemList/' + businessId,
    headers: {
      'Authorization': 'Bearer ' + localGet('token'),
    }
  };

  axios.request(config)
    .then((response) => {
      foods_rec = response.data;
      isLoaded.value = true;
      console.log(JSON.stringify(response.data));
    })
    .catch((error) => {
      console.log(error);
    });

});


let business_rec = ref({});
let isLoaded2 = ref(false);

onMounted(() => {
  console.log(businessId);

  let config = {
    method: 'get',
    maxBodyLength: Infinity,
    url: 'http://localhost:9000/shop/' + businessId,
    headers: {
      'Accept': '*/*',
      'Authorization': 'Bearer ' + localGet('token'),
    }
  };

  axios.request(config)
    .then((response) => {
      business_rec = response.data;
      isLoaded2.value = true;
      console.log(JSON.stringify(response.data));
    })
    .catch((error) => {
      console.log(error);
    });

});

</script>

<template>
  <Head></Head>

  <div class="buInfoPage">
    <div class="bodyPad">
      <div class="mainPad">
        <div class="headPad">
          <div class="my-2 text-lg text-center">
            商家信息
          </div>
        </div>
        <div class="BusInfos" v-if="isLoaded2">
          <div>
            <img :src="business_rec.image" style="display: block;">
          </div>
          <div class="font-bold text-lg">{{ business_rec.name }}</div>
          <div class="text-sm text-gray-500">
            ￥{{ business_rec.startPrice }}起送|￥{{ business_rec.deliveryPrice }}配送
          </div>
          <div class="text-sm text-gray-500">{{ business_rec.description }}</div>
        </div>

        <div class="MealList">
          <li v-for="food in foods_rec">
            <div class="MealCard">
              <div class="MealIcon">
                <img :src="food.image">
              </div>
              <div class="MealInfo">
                <div class="font-bold text-base">{{ food.name }}</div>
                <div class="text-sm text-gray-500">
                  {{ food.description }}
                </div>
                <div class="text-sm text-gray-500">￥{{ food.price }}</div>
              </div>
              <div class="basis-1/3 self-center text-right">
                <i class="fas fa-minus-circle text-gray-400"></i>
                2
                <i class="fas fa-plus-circle text-blue-500"></i>
              </div>
            </div>
          </li>

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

        <div class="barPad_pay bg-black">
          <!-- 购物车图标 -->
          <div class="p-3">
            <i class="fas fa-shopping-cart text-blue-500 text-4xl"></i>
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

      </div>

    </div>
  </div>
</template>