<template>
  <content-module name="dashboard">
    <el-row style="margin-top: 30px">
      <el-col :span="12" :offset="6">
        <div class="grid-content bg-purple-dark">
          <el-row v-for="item in taskList">
            <el-col>
              <el-card :body-style="{ padding: '0px' }">
                <div style="padding: 14px;">
                  <span>{{item.id}}</span>
                  <div class="bottom clearfix">
                    <time class="time">{{ item.publishDate }}</time>
                    <el-button type="info" size="small" class="button">查看详细</el-button>
                    <el-button type="danger" size="small" class="button" @click="deleteHonor(item)">删除</el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </content-module>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
    data() {
      return {
        taskList:[]
      }
    },
    methods: {
      initData() {
        let url="api/task/all"
        ajaxUtils.send(url,null,result=> {
          if (result.code==200) {
            this.taskList = result.result
          } else if (result.code == 414) {
            return
          }
        })
      }
    },
    mounted() {
      this.initData()
    }
  }

</script>
<style>

</style>
