<template>
  <el-row >
    <el-col :span="12"  :offset="6">
      <el-card>
        <div style="padding: 15px;">
          <div id="list-top">
            <span class="avatar"><img class="avatar-middle" :src="User.avatar"></span>
            <div class="user">
              <div class="username">{{item.id}}</div>
              <div class="pub-end">截至{{item.publishDate}}-{{item.endTime}}</div>
            </div>
          </div>
          <div id="list-main" class="clearfix">
            <p class="des">发的顺丰快递是甲方的历史奋斗的司法鉴定所就反对司法鉴定所发生纠纷</p>
            <div class="pic"><img class="" style="" :src="User.avatar"></div>
          </div>
          <div id="list-bottom">
            <i class="iconfont icon-xihuan"></i>
            <span class="collect-count">123</span>
            <i class="iconfont icon-iconxihuan"></i>
            <span class="pay">￥12</span>
            <el-button type="primary" size="small" class="button accept" @click="accpet(item)">接受任务</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>

</template>
<script>
  export default {
    data() {
      return {
        User: {
          avatar: "/static/co.png",
        }
      }
    },
    props:['item']
  }
</script>
<style>
  .user{
    float: left;
    margin-left: 10px;
  }
  .user .pub-end{

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

  }
  .accept{
    display: block;
    float: right;
    margin-right: 20px;
  }
</style>
