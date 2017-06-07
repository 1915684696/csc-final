<template>
  <div class="login-wrapper">
    <div class="bg"></div>
    <h1>CSC</h1>
    <el-form ref="form" :model="form" :rules="rules">
      <el-form-item prop="username">
        <el-input v-model="form.name" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="form.password" type="password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button class="login-button" type="success" @click="loginIn">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import ajaxUtils from '../../http/ajaxUtils'
import {setSessionUser} from '../../storage/index'
export default {
  data () {
    return {
      form: {
        name: '',
        password: ''
      },
      rules: {
        userName: [{
          required: true, message: '请输入用户名', trigger: 'blur'
        }],
        password: [{
          required: true, message: '请输入密码', trigger: 'blur'
        }]
      }
    }
  },
  methods: {
    loginIn(){
      let params = {name:this.form.name,password:this.form.password}
      ajaxUtils.post("/api/login",params,(result)=>{
        if (result!=-1 && result.code==200) {
          alert("登陆成功")
          this.$router.push("/dashboard")
          setSessionUser(result.result.user)
        } else{
          alert(result.message);
        }
      })
    }
  }
}
</script>
<style lang="stylus">
@import "../../assets/css/variable"
$input-width = 15rem
.login-wrapper
  align-self center
  .bg
    position absolute
    left 0
    right 0
    top 0
    bottom 0
    width 100%
    height 100%
    background-size cover
    background-position 100%
    background-image url('../../assets/images/login-bg.jpg')
  > h1
    position relative
    margin 0 0 1rem
    text-align center
    z-index 1
  > form
    width $input-width
    margin 0 auto
    .el-input__inner
      color $color-black-exact-light
      border-color $color-silver-light
      background-color transparent
      &:focus
        color $color-black
        border-color $color-black
  .login-button
    width 100%
    &.error
      animation shake .5s
</style>
