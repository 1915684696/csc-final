<template>
  <content-module name="dashboard">
    <header-nav></header-nav>
    <task></task>
  </content-module>
</template>
<script>
  import HeaderNav from '../components/Header.nav.vue'
  import Task from './task/Task'
  export default {
    components: {
      HeaderNav,
      Task
    }
  }
</script>
