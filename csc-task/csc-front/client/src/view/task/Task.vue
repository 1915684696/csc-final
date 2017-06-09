<template>
  <div style="margin-top: 30px;margin-bottom: 30px">
    <task-list v-for="item in taskList" v-bind:item="item"></task-list>
  </div>
</template>

<script>
  import ajaxUtils from '../../http/ajaxUtils'
  import TaskList from '../../components/TaskList'
  export default {
    data() {
      return {
        taskList: []
      }
    },
    methods: {
      initData() {
        let url = "api/task/all"
        ajaxUtils.send(url, null, result => {
          if (result.code == 200) {
            this.taskList = result.result
          } else if (result.code == 414) {
            return
          }
        })
      }
    },
    mounted() {
      this.initData()
    },
    components:{
      TaskList
    }
  }
</script>
