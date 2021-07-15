import Vue from 'vue'
// 导入路由插件
import VueRouter from 'vue-router'
// 导入上面定义的组件
import Content from '../components/Content'
import Main from '../components/Main'
import Cwlin from '../components/Cwlin'

// 安装路由
Vue.use(VueRouter)

// 配置路由
export default new VueRouter({
  routes: [
    {
      // 路由路径
      path: '/Content',
      // 路由名称
      name: 'Content',
      // 跳转到组件
      component: Content
    },
    {
      // 路由路径
      path: '/Main',
      // 路由名称(可省)
      name: 'Main',
      // 跳转到组件
      component: Main
    },
    {
      // 路由路径
      path: '/Cwlin',
      // 跳转到组件
      component: Cwlin
    }
  ]
})
