<template>
  <div>
    <user-gram :userId="User.id"></user-gram>
  </div>
</template>

<script>
  import UserGram from '../../components/charts/TaskSituationGram.vue'
  import {getSessionUser} from '../../storage/index'
  import store from '../../store/index'
  export default {
    data(){
      return{
        User:{
        }
      }
    },
    components:{
      UserGram
    },
    methods:{
      initUserPage() {
        if (getSessionUser()== null){
          store.commit("SHOW_LOGIN",true)
        }else {
          this.User=getSessionUser()
        }
      }
    },
    mounted(){
      this.initUserPage()
    }
  }
</script>
