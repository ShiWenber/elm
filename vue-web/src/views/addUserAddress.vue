<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue';
import Head from '../components/Head.vue';
import axios from 'axios';
import { localGet } from '@/utils';
import { ElMessage, ElForm, ElFormItem, ElInput, ElButton, ElRadioGroup, ElRadio } from 'element-plus';
import { timePanelSharedProps } from 'element-plus/es/components/time-picker/src/props/shared';
import '../assets/css/output.css'

// ref(null) 是常用的初始化方式，表示定义一个初始化值为 null 的响应式变量
const deliveryAddressRef = ref(null)
const deliveryAddress = ref({
	contactName: '',
	contactSex: 1,
	contactTel: '',
	address: ''
});

// 做一个 reactive 的响应式变量，用于判断输入值是否合法
const rules = reactive({
	contactName: [
		{ required: true, message: '请输入联系人姓名', trigger: 'blur' },
		{ min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' }
	],
	contactTel: [
		{ required: true, message: '请输入联系人电话', trigger: 'blur' },
		{ pattern: /^1[3-9]\d{9}$/, message: '手机号码格式不正确', trigger: 'blur' }
	],
	address: [
		{ required: true, message: '请输入收货地址', trigger: 'blur' },
		{ min: 2, max: 100, message: '长度在 2 到 100 个字符', trigger: 'blur' }
	]
});


const state = reactive({
	addresses_rec: [],
});

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
			state.addresses_rec = response.data;
			console.log(JSON.stringify(response.data));
		})
		.catch((error) => {
			console.log(error);
		});
});



// 保存用户地址
const addUserAddress = () => {
	const data_local = {
		contactName: deliveryAddress.value.contactName,
		contactSex: deliveryAddress.value.contactSex,
		contactTel: deliveryAddress.value.contactTel,
		address: deliveryAddress.value.address
	};
	console.log(data_local);
	// 调取接口
	// ---
	let data = JSON.stringify({
		"contactName": deliveryAddress.value.contactName,
		"contactSex": deliveryAddress.value.contactSex,
		"contactTel": deliveryAddress.value.contactTel,
		"address": deliveryAddress.value.address
	});

	let config = {
		method: 'post',
		maxBodyLength: Infinity,
		url: 'http://localhost:9000/user/addAddress/' + localGet('userInfo').id,
		headers: {
			'Content-Type': 'application/json',
			'Accept': '*/*',
			'Authorization': 'Bearer ' + localGet('token'),
		},
		data: data
	};

	axios.request(config)
		.then((response) => {
			console.log(JSON.stringify(response.data));
			ElMessage.success('添加成功');
			window.location.reload();
		})
		.catch((error) => {
			console.log(error);
			ElMessage.error('添加失败');
		});





};





</script>

<template>
	<Head></Head>
	<div class="homePage">
		<div class="mainPad">
			<div class="headPad">
				<!-- pl-4左侧内边距 -->
				<div class="pl-4">
					添加送货地址
				</div>
			</div>
			<div class="mainPad" style="padding:20px">
				<!-- 表单部分 -->
				<el-form :model="deliveryAddress" :rules="rules" ref="deliveryAddresRef" label-width="80px"
					style="margin-top: 20px;">
					<el-form-item label="联系人：" prop="contactName">
						<el-input v-model.trim="deliveryAddress.contactName" placeholder="联系人姓名"></el-input>
					</el-form-item>
					<el-form-item label="性别：" prop="contactSex">
						<el-radio-group v-model.trim="deliveryAddress.contactSex">
							<el-radio :label="1">男</el-radio>
							<el-radio :label="0">女</el-radio>
						</el-radio-group>
					</el-form-item>
					<el-form-item label="电话：">
						<el-input v-model.trim="deliveryAddress.contactTel" placeholder="电话"></el-input>
					</el-form-item>
					<el-form-item label="地址：">
						<el-input v-model.trim="deliveryAddress.address" placeholder="收货地址"></el-input>
					</el-form-item>
				</el-form>

				<!-- 查看地址 -->
				<div class="contact-list">
					<el-table :data="state.addresses_rec" style="width: 100%">
						<el-table-column prop="contactName" label="姓名"></el-table-column>
						<el-table-column prop="contactSex" label="性别">
							<template #default="{ row }">
								{{ row.contactSex === 1 ? '男' : '女' }}
							</template>
						</el-table-column>
						<el-table-column prop="contactTel" label="电话"></el-table-column>
						<el-table-column prop="address" label="地址"></el-table-column>
					</el-table>
				</div>



				<!-- 底部菜单部分 -->
				<!-- <Footer></Footer> -->
			</div>

		</div>
		<div class="barPad">
			<div class="button-add">
				<el-button type="primary" @click="addUserAddress">保存</el-button>
			</div>
		</div>
	</div>
</template>


