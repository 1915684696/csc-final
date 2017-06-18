export default [{
  path: '/user/situation',
  component: (resolve) => {
    require(['../view/user/task.situation.vue'], resolve)
  }
}]
