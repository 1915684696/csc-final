
const state = {
  showLogin:true,
  isLogin: false
}

const mutations = {
  SHOW_LOGIN(state,flag) {
    state.showLogin = !!flag
  },
  IS_LOGIN(state,flag){
    state.isLogin= !!flag
  }
}



const getters = {
  showLogin(state) {
    return state.showLogin
  },
  isLogin(state) {
    return state.isLogin
  }
}

export default {
  state,
  mutations,
  getters
}
