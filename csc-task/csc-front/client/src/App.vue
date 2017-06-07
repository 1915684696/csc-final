<template>
  <div id="app-main">
    <div class="app-wrapper">
      <e-header></e-header>
      <div class="app-container" :class="{active: false}">
        <router-view></router-view>
      </div>
      <e-footer></e-footer>
      <n-progress parent=".app-wrapper"></n-progress>
    </div>
    <el-dialog :close-on-click-modal="false" :show-close="false" title="提示" v-model="login" size="tiny">
      <el-form :model="form">
        <el-form-item label="用户名">
          <el-input v-model="form.userName" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="info">返回</el-button>
        <el-button @click="loginIn" type="success">登陆</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import Vue from 'vue'
import EHeader from './components/Header'
import EFooter from './components/Footer'
import ContentModule from './components/ContentModule'
import NProgress from './components/NProgress'
Vue.component('EHeader',EHeader)
Vue.component('EFooter',EFooter)
Vue.component('ContentModule', ContentModule)
import store from './store/index.js'
import ajaxUtils from './http/ajaxUtils'
import {setSessionUser} from './storage/index'
export default {
  data() {
    return {
      form: {
        userName:'',
        password:''
      }
    }
  },
  computed: {
    login: ()=> {
      return store.getters.showLogin
    }
  },
  methods:{
    loginIn() {
      let params = {name:this.form.userName,password:this.form.password}
      ajaxUtils.post("/api/login",params,(result)=>{
        if (result!=-1 && result.code==200) {
          alert("登陆成功")
          setSessionUser(result.result.user)
          store.commit("SHOW_LOGIN",false)
        } else{
          alert(result.message)
        }
      })
    }
  },
  components: {
    NProgress
  }
}
</script>
<style lang="stylus">
  @import "assets/css/variable.styl";
  @import "assets/css/animate.styl";
  @import "assets/fonts/iconfont.css";
  @import "assets/css/flex.styl";
  @import "//at.alicdn.com/t/font_dwdkgucn0qpsnhfr.css";

  ::-webkit-scrollbar
    width 4px
    height 4px
    background-color $color-gray
  ::-webkit-scrollbar-button
  ::-webkit-scrollbar-track
    display none
  ::-webkit-scrollbar-thumb
    background-color $color-silver-light
  ::-webkit-scrollbar-thumb:hover
    background-color $color-black-exact-light

  html
    font-size 16px
    font-family "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif
  body
    margin 0
    padding 0
    font-size .75rem
    background-color #f0f0f0
  /**
  *::before
  *::after
    box-sizing border-box*/
  a
    text-decoration none
  #app-main
    display flex
    width 100%
    height 100%
    .app-wrapper
      flex 1
      display flex
      flex-flow column
      overflow-x hidden
      min-width 500px;
      .app-container
        position relative
        flex 1
        min-height 500px
        display flex
        justify-content center
        margin 0
        padding 0rem
        background-color #fff
        overflow auto
        &.active
          margin 1rem

  .el-dropdown-link
    cursor pointer
</style>
