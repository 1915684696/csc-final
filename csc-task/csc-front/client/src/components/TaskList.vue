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
              <i class="iconfont icon-xihuan2" style="margin-bottom: 10px" @click="collect(item.id)"></i>
              <span>{{Task.collectTimes}}</span>
            </span>
            <i class="iconfont icon-contact contact"></i>
            <el-button type="primary" size="small" class="button accept" @click="accpet(item.id)" style="margin-top:-10px">接受任务</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import commonUtils from "../common/commonUtils"
  export default {
    data() {
      return {
        User: {
          avatar: this.item.avatars=='' ? '/static/co.png' : this.item.avatars
        },
        Task: {
          pic: this.item.pic,
          collectTimes:this.item.collectTimes
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
      }
    },
    method:{
      collect:(id)=>{
        //收藏
        //在原来基础上收藏次数加1
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
    margin-left:650px;
  }
</style>
