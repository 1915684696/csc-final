<template>
  <div>
    <el-button @click="send">测试发送消息</el-button>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        socket:null
      }
    },
    methods: {
      send() {
        let data={};
        data["type"]=1
        data["fromUserId"]="1"
        data["toUserId"]="2"
        data["msg"]="haiweb"
        this.socket.send(JSON.stringify(data))
      }
    },
    mounted() {
      if ('WebSocket' in window) {
        this.socket = new WebSocket("ws://localhost:8081/api/ws")
      } else if ('MozWebSocket' in window) {
        this.socket = new MozWebSocket("ws://localhost:8081/api/ws")
      } else {
        //this.socket = new SockJS("http://" + path + "/ws/sockjs"+uid);
      }
      this.socket.onopen = function (event) {
        alert("连接打开")
        if(window.console){ console.log(event)}
      }
      this.socket.onerror = function(event) {
        alert("WebSocket:发生错误 ");
        if(window.console){ console.log(event)}
      };
      this.socket.onclose = function(event) {
        alert("WebSocket:已关闭");
        if(window.console){ console.log(event)}
      }
      this.socket.onmessage = function(event) {
        let data = JSON.parse(event.data)
        alert(data.msg)
      };
      if(window.console){ console.log(this.socket)}
    }
  }
</script>
