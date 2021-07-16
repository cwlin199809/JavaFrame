<template>
  <!--所有的元素必须在根节点下-->
  <div>
    <h1>个人信息</h1>
    <!--{{$route.params.id}}-->
    <div id="userInfo" v-cloak>
      <div>Name: {{info.name}}</div>
      <div>Address: {{info.address.street}}, {{info.address.city}}, {{info.address.country}}</div>
      <div>URL: <a v-bind:href="info.url" target="_blank" rel="noopener noreferrer">{{info.url}}</a> </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserProfile",
  data(){ //data方法，区别于data属性
    return{
      //请求的返回参数格式，必须和json字符串一样
      info: {
        name: null,
        url: null,
        address: {
          street: null,
          city: null,
          country: null
        }
      }
    }
  },
  // 钩子函数：过滤器
  beforeRouteEnter: (to, from, next) => {
    console.log("准备进入个人信息页"); // 控制台显示
    // alert("准备进入个人信息页"); // 弹窗显示
    next(vm => {
      vm.info = vm.getData(); // 进入路由之前，执行getData方法来加载数据
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
      var _this = this;
      this.axios({
        method: 'get',
        url: 'http://localhost:8080/static/mock/data.json'
      }).then(function (response) {
        console.log(response); // 控制台显示
        _this.info = response.data;
      })
      return _this.info;
    }
  }
}
</script>

<style scoped>
  #userInfo, a:link, a:visited{ /* 未访问和已访问的链接 */
    color: #333;
    font-size: 16px;
  }
  a:hover{
    color: blue;
  }
  a:active{
    color: red;
  }
  /*不存在闪烁问题，以下代码可以省略*/
  [v-cloak]{
    /*v-cloak 解决闪烁问题*/
    display: none;
  }
</style>
