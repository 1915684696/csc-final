<template>
  <content-module name="dashboard">
    <header-nav></header-nav>
    <task-list></task-list>
  </content-module>
</template>
<script>
  import HeaderNav from '../components/Header.nav.vue'
  import TaskList from './task/TaskList'
  export default {
    components: {
      HeaderNav,
      TaskList
    }
  }
</script>
