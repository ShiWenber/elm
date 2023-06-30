<script setup lang="ts">
import { ref, onMounted, reactive } from 'vue';
import BarPad from '@/components/BarPad.vue';
import Head from '@/components/Head.vue';
import "../assets/css/output.css";
import { ElTable, ElTableColumn, ElButton } from 'element-plus';
import axios from 'axios';
import router from '@/router';
import { localGet } from '@/utils';


const isLoaded = ref(false);
let deliveryAddresses_rec = reactive([]);


onMounted(() => {
	// 如果这个变量改变，需要重新渲染页面
	let config_rec = {
		method: 'get',
		maxBodyLength: Infinity,
		url: 'http://localhost:9000/user/addressList?id=' + localGet('userInfo').id,
		headers: {
			'Accept': '*/*',
			'Authorization': 'Bearer ' + localGet('token'),
		}
	};

	axios.request(config_rec)
		.then((response) => {
			deliveryAddresses_rec = response.data;
			isLoaded.value = true;
			console.log(JSON.stringify(deliveryAddresses_rec));
		})
		.catch((error) => {
			console.log(error);
		});
});


const setDeliveryAddress = (deliveryAddress: any) => {
	console.log("tst")
	console.log(deliveryAddress);
	// 存储默认地址
	localStorage.setItem("defaultDeliveryAddress", JSON.stringify(deliveryAddress));
	// router.push({ path: '/orders', query: { businessId } });
};

const toAddUserAddress = () => {
	window.location.href = '/addUserAddress'
};

const editUserAddress = (daId: any) => {
	window.location.href = '/addUserAddress'
};

const removeUserAddress = (daId: any) => {
	window.location.href = '/addUserAddress'
};

const sexFilter = (value: number) => {
	return value == 1 ? '先生' : '女士';
};

</script>

<template>
	<Head />
	<div class="homePage">
		<div class="mainPad" v-if="isLoaded">
			<!-- 地址列表部分 -->
			<el-table :data="deliveryAddresses_rec" style="width: 100%">
				<el-table-column fixed prop="contactName" label="contactName" />
				<el-table-column prop="contactSex" label="contactSex" :formatter="sexFilter" />
				<el-table-column prop="contactTel" label="contactTel" />
				<el-table-column fixed="right" label="Operations" width="120">
					<template #default>
						<el-button link type="primary" size="small" @click="removeUserAddress">Remove</el-button>
						<el-button link type="primary" size="small" @click="editUserAddress">Edit</el-button>
					</template>
				</el-table-column>
			</el-table>

			<el-button class="addbtn" icon="el-icon-plus" @click="toAddUserAddress">
				新增收货地址
			</el-button>
		</div>

		<BarPad />
	</div>
</template>
