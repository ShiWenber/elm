import { createRouter, createWebHistory } from 'vue-router'
import Index from '@/views/home.vue'
import AddRecord from '@/views/AddRecordView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue')
    },
    {
      path: '/add',
      name: 'add',
      component: AddRecord
    },
    {
      path: '/data',
      name: 'data',
      component: () => import('../views/DataView.vue')
    },
    {
      path: '/custom',
      name: 'custom',
      component: () => import('../views/home.vue')
    },
    {
      path: '/buinfo',
      name: 'buinfo',
      component: () => import('../views/buinfo.vue')
    },
    {
      path: '/conOrder',
      name: 'conOrder',
      component: () => import('../views/conOrder.vue')
    },
    {
      path: '/index',
      name: 'home',
      component: () => import('../views/home.vue')
    },
    {
      path: '/pay',
      name: 'pay',
      component: () => import('../views/pay.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/register.vue')
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('../views/home.vue')
    },
    {
      path: '/order',
      name: 'order',
      component: () => import('../views/order.vue')
    },
    {
      path: "/addUserAddress",
      name: "addUserAddress",
      component: () => import('../views/addUserAddress.vue')
    },
    {
      path: "/userAddress",
      name: "userAddress",
      component: () => import('../views/userAddress.vue')
    },
    {
      path: "/buInfo",
      name: "buInfo",
      component: () => import('../views/buInfo.vue')
    }

  ]
})

export default router
