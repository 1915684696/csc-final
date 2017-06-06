<template>
  <div class="login-wrapper">
    <div class="bg"></div>
    <h1>CSC</h1>
    <el-form ref="form" :model="form" :rules="rules"
      @submit.native.prevent="onSubmit">
      <el-form-item prop="username">
        <el-input v-model="form.name" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="form.password" type="password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button class="login-button" :class="{error: loginError}" type="success"
           :loading="loading" @click="loginIn">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
import ajaxUtils from '../../http/ajaxUtils'
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
      },
      loading: false,
      valid: false,
      loginError: false
    }
  },
  computed: {
    ...mapGetters(['loggedIn'])
  },
  methods: {
    loginIn(){
      let params = {name:this.form.name,password:this.form.password}
      ajaxUtils.post("/api/login",params,(result)=>{
        if (result!=-1 && result.code==200) {
          alert("登陆成功")
          this.$router.push("/")
        } else{
          alert("身份认证失败")
        }

      })
    },
    ...mapActions(['login']),
    onSubmit () {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.loading = true
          this.login({
            username: this.form.username,
            password: this.form.password
          }).then((data) => {
            this.loading = false
            this.$router.push(this.$route.query.redirect || '/')
          }).catch((err) => {
            this.$notify({
              title: 'undefined',
              message: err.message || 'undefined',
              type: 'error',
              duration: 1500
            })
            this.loading = false
            this.loginError = true
            setTimeout(() => {
              this.loginError = false
            }, 500)
          })
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
