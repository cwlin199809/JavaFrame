<template>
  <!--所有的元素必须在根节点下-->
  <div>
    <h1>个人信息</h1>
    <!--{{$route.params.id}}-->
    <!--<div id="app" v-cloak>-->
    <!--  <div>name: {{info.name}}</div>-->
    <!--  <div>address: {{info.address.street}}, {{info.address.city}}, {{info.address.country}}</div>-->
    <!--  <div>url: <a v-bind:href="info.url" target="_blank" rel="noopener noreferrer">{{info.url}}</a> </div>-->
    <!--</div>-->
  </div>
</template>

<script>
export default {
  name: "UserProfile",
  // 钩子函数：过滤器
  beforeRouteEnter: (to, from, next) => {
    console.log("准备进入个人信息页"); // 控制台显示
    // alert("准备进入个人信息页"); // 弹窗显示
    next(vm => {
      vm.getData(); // 进入路由之前，执行getData方法来加载数据
    });
  },
  beforeRouteLeave: (to, from, next) => {
    console.log("准备离开个人信息页"); // 控制台显示
    // alert("准备离开个人信息页"); // 弹窗显示
    next();
  },
  // axios：异步请求
  methods: {
    getData: function () {
      this.axios({
        method: 'get',
        url: 'http://localhost:8080/static/mock/data.json'
      }).then(function (response) {
        console.log(response); // 控制台显示
      })
    }
  }
}
</script>

<style scoped>
  /*[v-cloak]{*/
  /*  !*v-cloak 解决闪烁问题*!*/
  /*  display: none;*/
  /*}*/
</style>
