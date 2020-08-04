import Vue from 'vue'
import Cookies from 'js-cookie'
import 'normalize.css/normalize.css' // 一个可以定制的CSS文件，它让不同的浏览器在渲染网页元素的时候形式更统一
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './styles/element-variables.scss'
import '@/styles/index.scss' // 全局css
import App from './App'
import store from './store'
import router from './router'
import './icons' // 图标
import './permission' // 权限控制
import * as filters from './filters' // 全局过滤器

Vue.use(ElementUI, {
  size: Cookies.get('size') || 'default' // 设置element-ui大小
})

// 注册全局过滤器
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})