/**
 * 二次封装 axios
 */
import axios from 'axios'
import router from '@/router/index'


// // import config from '~/config'
// const config = {
//   development: {
//     baseUrl: '/api' // 开发代理地址
//   },
//   beta: {
//     baseUrl: '//' // 测试接口域名
//   },
//   release: {
//     baseUrl: '//' // 正式接口域名
//   }
// }

import { ElMessage } from 'element-plus'
import { localGet } from './index'
import config from './config'


// 这边由于后端没有区分测试和正式，姑且都写成一个接口。
axios.defaults.baseURL = config[import.meta.env.MODE].baseUrl
// axios.defaults.baseURL = config["development"].baseUrl
// axios.defaults.baseURL = 'http://localhost:9000'
// 携带 cookie，对目前的项目没有什么作用，因为我们是 token 鉴权
axios.defaults.withCredentials = true
// 请求头，headers 信息
axios.defaults.headers['X-Requested-With'] = 'XMLHttpRequest'
axios.defaults.headers['Authorization'] = localStorage.getItem('token') || ''
// axios.defaults.headers['Access-Control-Allow-Headers'] = '*'
// axios.defaults.headers['Access-Control-Allow-Origin'] = '*'
// 默认 post 请求，使用 application/json 形式
axios.defaults.headers.post['Content-Type'] = 'application/json'

// 请求拦截器，内部根据返回值，重新组装，统一管理。
axios.interceptors.response.use(res => {
    if (typeof res.data !== 'object') {

        ElMessage.error('服务端异常！')
        alert('服务端异常！')
        return Promise.reject(res)
    }
    if (res.data.resultCode != 200) {
        if (res.data.message) alert(res.data.message)
        ElMessage.error(res.data.message)
        if (res.data.resultCode == 419) {
            router.push({ path: '/login' })
        }
        return Promise.reject(res.data)
    }

    return res.data.data
})

axios.defaults.headers['token'] = localGet('token') || ''

export default axios