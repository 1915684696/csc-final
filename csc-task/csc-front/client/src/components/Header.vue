<template lang="html">
    <div class="e-header">
        <el-row style="background-color: #2c333d;" :gutter="20">
             <el-col :offset="3" :span="6">
                <div class="header-con">
                    <i class="el-icon-message"></i>&nbsp;&nbsp;Email : 2514362803@qq.com
                </div>
             </el-col>
             <el-col :span="6">
                 <div class="header-con">
                     <h1 class="p-title">
                         <a href="/">ETASK</a>
                     </h1>
                 </div>
             </el-col>
             <el-col :span="6">
                 <div class="header-con">
                       <i class="iconfont icon-QQ1"></i>&nbsp;&nbsp;&nbsp;&nbsp;
                       <i class="iconfont icon-weixin"></i>
                       <span style="margin-left: 10px" v-if="flag">欢迎您{{name}}</span>
                       <span class="login" style="margin-left: 10px" @click="trigger" v-else>登陆</span>
                 </div>
             </el-col>
        </el-row>

    </div>

</template>

<script>
import Vue from 'vue'
import store from '../store/index.js'
import {getSessionUser} from '../storage/index'
export default {
  data(){
    return{

    }
  },
  methods:{
    trigger(){
      store.commit("SHOW_LOGIN",true)
    }
  },
  computed:{
    flag:()=>{
      if (store.getters.isLogin){
        return true
      }else {
        return false
      }
    },
    name(){
      return getSessionUser().name
    }
  }
}
</script>

<style lang="css">
    .e-header{
        width: 100%;
    }
    .p-title a{
        text-align: center;
        text-decoration: none;
        color: #bfe7cd;
        font-size: 1.4em;
    }
    .header-con {
      padding-left: 30px;
      padding-right: 30px;
      line-height: 100px;
      text-align: center;
    }
    .header-con {
        color: #fff;
        font-size: 1em;
        margin-top: 1.1em;
        text-align: center;
    }
  .login:hover{
    cursor:pointer;
  }
</style>
