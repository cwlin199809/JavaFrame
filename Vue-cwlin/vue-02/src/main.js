/* eslint-disable */
import Vue from 'vue'
import App from './App'
//导入上面创建的路由配置目录
import router from './router' // 自动扫描里面的路由配置

//关闭生产模式下给出的提示
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  // 配置路由
  router,
  components: { App },
  template: '<App/>'
})
