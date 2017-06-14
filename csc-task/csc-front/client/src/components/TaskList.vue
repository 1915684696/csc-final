<template>
  <el-row >
    <el-col :span="12"  :offset="6">
      <el-card>
        <div style="padding: 15px;">
          <div id="list-top">
            <span class="avatar">
              <img class="avatar-middle"  :src='User.avatar'>
            </span>
            <div class="user">
              <div class="username">{{item.name}}</div>
              <div class="pub-end">截至{{publishDate}}-<span>{{endTime}}</span></div>
            </div>
            <div class="taskType">{{item.taskType}}</div>
          </div>
          <div id="list-main" class="clearfix">
            <p class="des">{{item.description}}</p>
            <div class="pic"><img class="" style="" :src='Task.pic'></div>
          </div>
          <div id="list-bottom">
            <span class="pay">￥{{item.pay}}</span>
            <span class="collect-count">
                <el-button size="small"  @click="collectTask"><i class="iconfont icon-xihuan2" style="margin-bottom: 10px"></i></el-button>
                <span>{{Task.collectTimes}}</span>
            </span>
            <i class="iconfont icon-contact contact"></i>
            <el-button type="primary" size="small" class="button accept">接受任务</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import commonUtils from "../common/commonUtils"
  import ajaxUtils from '../http/ajaxUtils'
  import store from '../store/index'
  import router from '../router/index'
  export default {
    data() {
      return {
        User: {
          avatar: this.item.avatars=='' ? '/static/co.png' : this.item.avatars
        },
        Task: {
          pic: this.item.pic,
          collectTimes:'0'
        }
      }
    },
    props: ['item'],
    computed: {
      publishDate: function () {
        return commonUtils.formatDate(this.item.publishDate, "hh:mm")
      },
      endTime: function () {
        return commonUtils.formatDate(this.item.endTime, "hh:mm")
      }/*,
      collectTimes:  function () {return store.getters.collectTimes}*/
    },
    methods:{
      collectTask(){
        let params = {taskId:this.item.id}
        ajaxUtils.post("/api/task/collect",params,result=>{
          if (result.code == 200) {
            this.Task.collectTimes=result.result.collectTimes
            /*store.commit("COLLECT_TIMES",result.result.collectTimes)*/
            this.$message.success(result.message)
          }else {
            this.$message.success(result.message)
            store.commit("SHOW_LOGIN",true)
          }
        })

      }
    }
  }
</script>

<style>
  @import "../assets/fonts/iconfont.css";
  @import "//at.alicdn.com/t/font_v29d7q2dnnlv7vi.css";
  .user{
    float: left;
    margin-left: 10px;
  }
  .avatar{
    display: block;
    float: left;
  }
  .avatar-middle {
    width:30px;
    height:30px;
    border-radius: 15px;
  }
  .clearfix :before,
  .clearfix :after {
    display: table;
    content: "";
    clear: both;

  }
  .collect-count{
    margin-left: 50px;
  }
  .accept{
    display: block;
    float: right;
  }
  .taskType{
    float: right;
  }
  .contact{
    margin-left:600px;
  }
</style>
