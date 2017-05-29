<template>
  <div id="app">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="form.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="loginIn">登陆</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import ajaxUtils from './http/ajaxUtils'
export default {
  name: 'app',
  data() {
    return {
      form: {
        userName: '',
        password: ''
      }
    }
  },
  methods: {
    loginIn() {
      let params={userName:this.form.userName,password:this.form.password}
      ajaxUtils.post("/api/login",params,(result)=>{
          if (result!=-1 && result.code==200){
              console.log(result)

          }else{
              console.log("身份认证失败")
          }
      })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
