const state = {
  collectTimes:'0'
}
const mutations = {
  COLLECT_TIMES(state,count) {
    state.collectTimes = count
  }
}

const getters = {
  collectTimes(state) {
    return state.collectTimes
  }
}

export default {
  state,
  mutations,
  getters
}
