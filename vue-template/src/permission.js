import router from './router'
import store from './store'
import {
  Message
} from 'element-ui'
import NProgress from 'nprogress' // 进度条
import 'nprogress/nprogress.css' // 进度条样式
import {
  getToken
} from '@/utils/auth' // 从cookie中获得token
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({
  showSpinner: false
}) // 进度条设置

const whiteList = ['/login', '/register', '/auth-redirect'] // no redirect whitelist

//路由守卫
router.beforeEach(async (to, from, next) => {
  // 进度条开始
  NProgress.start()

  // set page title
  document.title = getPageTitle(to.meta.title)

  // 获取token
  const hasToken = getToken()

  //根据token，判断是否登录
  if (hasToken) {
    if (to.path === '/login') {
      // 如果已经登录，重定向到主页
      next({
        path: '/'
      })
      NProgress.done()
    } else {
      // 确定用户是否通过getInfo获取了权限角色
      const hasRoles = store.getters.roles && store.getters.roles.length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          // get user info
          // note: roles must be a object array! such as: ['admin'] or ,['developer','editor']
          const {
            roles
          } = await store.dispatch('user/getInfo')

          // 基于角色生成可访问路由图
          const accessRoutes = await store.dispatch('permission/generateRoutes', roles)

          // 动态添加可访问路由
          router.addRoutes(accessRoutes)

          //确保addRoutes完整的hack方法
          //设置replace:true，这样导航就不会留下历史记录
          next({
            ...to,
            replace: true
          })
        } catch (error) {
          // 删除token到登录页
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    //没有token
    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // 其他没有访问权限的页面将被重定向到登录页面
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // 进度条结束
  NProgress.done()
})