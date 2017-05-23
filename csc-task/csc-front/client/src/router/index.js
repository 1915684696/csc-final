import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

//路由对象数组
const routes = [{
  path: '/',
  component: (resolve) => {
    require(['../view/index.vue'], resolve)
  },
  meta: {
    skipAuth: true
  }
}]

const router=new Router({
  routes
})

export default router
