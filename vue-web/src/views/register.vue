<script setup lang="ts">
import Head from "../components/Head.vue";
import BarPad from "../components/BarPad.vue";
import "../assets/css/registerPage.css";
import { reactive, ref } from "vue";
import { ElForm, ElFormItem, ElInput, ElButton, ElRadioGroup, ElRadio } from "element-plus";
import { ElMessage, ElMessageBox } from "element-plus";
import axios from "axios";
import { generateId } from "element-plus/es/utils";

const formRef = ref(null)

const form = ref({
    tel: "",
    password: "",
    password2: "",
    name: "",
    gender: "男",
    username: ""
})
const rules = reactive({
    tel: [
        { required: true, message: '请输入手机号码', trigger: 'blur' },
        { pattern: /^1[3-9]\d{9}$/, message: '手机号码格式不正确', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
        { min: 6, max: 20, message: '密码长度为6-20个字符', trigger: 'blur' }
    ],
    password2: [
        { required: true, message: '请再次输入密码', trigger: 'blur' },
        { validator: validatePassword2, trigger: 'blur' }
    ],
    name: [
        { required: true, message: '请输入用户姓名', trigger: 'blur' },
        { max: 20, message: '用户姓名不能超过20个字符', trigger: 'blur' }
    ],
    gender: [
        { required: true, message: '请选择用户性别', trigger: 'change' }
    ]
})

function validatePassword2(rule, value, callback) {
    if (value !== form.value.password) {
        callback(new Error('两次输入的密码不一致'))
    } else {
        callback()
    }
}

function register() {
    formRef.value.validate(valid => {
        if (valid) {
            const gender = form.value.gender === '男' ? 1 : 0;
            let data = JSON.stringify({
                "password": '{noop}' + form.value.password,
                "username": form.value.tel,
                "type": 1,
                "sex": gender,
                "email": "string",
                "tel": form.value.tel,
            });

            let config = {
                method: 'post',
                maxBodyLength: Infinity,
                url: 'http://localhost:9000/pub/auth/registerCustomer',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };

            axios.request(config)
                .then((response) => {
                    console.log(JSON.stringify(response.data));
                    ElMessage.success(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    ElMessage.error("userphone already exists");
                });
            window.location.href = "/login";

            // TODO: 提交注册数据
        }
    })
}

</script>
<!-- 同一整个web应用前端风格的模板页,包括了主页面和底部按钮带 -->
<template>
    <Head></Head>

    <div>


        <div class="mainPad">
            <div class="headPad">
                <div class="my-2 text-lg text-center">
                    用户注册
                </div>
            </div>
            <div class="bodyPad">
                <el-form :model="form" :rules="rules" ref="formRef" label-width="20%">
                    <el-form-item label="手机号码" prop="tel">
                        <el-input type="text" v-model.trim="form.tel" placeholder="请输入手机号码" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model.trim="form.password" placeholder="请输入密码"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="password2">
                        <el-input type="password" v-model.trim="form.password2" placeholder="请再次输入密码"></el-input>
                    </el-form-item>
                    <el-form-item label="用户姓名" prop="name">
                        <el-input v-model.trim="form.name" placeholder="请输入用户姓名"></el-input>
                    </el-form-item>
                    <el-form-item label="用户性别" prop="gender">
                        <el-radio-group v-model="form.gender">
                            <el-radio label="男">男</el-radio>
                            <el-radio label="女">女</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="register" style="color: black;">注册</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>

        <BarPad></BarPad>

    </div>
</template>
