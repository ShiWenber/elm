import type buinfoVue from "@/views/buinfo.vue"

export function localGet (key) {
  const value = window.localStorage.getItem(key)
  try {
    return JSON.parse(window.localStorage.getItem(key))
  } catch (error) {
    return value
  }
}

export function localSet (key, value) {
  window.localStorage.setItem(key, JSON.stringify(value))
}

export function localRemove (key) {
  window.localStorage.removeItem(key)
}

export const pathMap = {
  index: '首页',
  login: '登录',
  add: '添加',
  data: '数据',
  buinfo: '商家信息',
  conOrder: '订单',
  hisOrder: '历史订单',
  buList: '商家列表',
  custom: '用户首页',
  pay: '支付'
}
