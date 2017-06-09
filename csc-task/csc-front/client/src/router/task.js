export default [{
  path: '/task',
  component: (resolve) => {
    require(['../view/task/Task.vue'], resolve)
  }
}]
