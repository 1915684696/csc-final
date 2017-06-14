import Vue from 'vue'
import Vuex from 'vuex'
import routeLoading from './modules/route'
import config from './modules/global-config'
import user from './modules/user'
import task from './modules/task'
Vue.use(Vuex)

const store = new Vuex.Store({
  //strict: process.env.NODE_ENV !== 'production',
  state: {
    name:'zhou'
  },
  modules: {
    user,
    task,
    config,
    routeLoading
  }
})

export default store
