// 导入vue
import Vue from "vue";
import Router from "vue-router";
// 导入组件
import Main from "../views/Main";
import Login from "../views/Login";
//导入子模块
import UserProfile from "../views/user/Profile";
import UserList from "../views/user/List";
//使用
Vue.use(Router);
//导出
export default new Router({
  routes: [
    { // 首页
      path: '/main',
      component: Main, // 嵌套路由
      // 写入子模块
      children: [
        {
          path: '/user/profile',
          component: UserProfile
        },
        {
          path: '/user/list',
          component: UserList
        }
      ]
    },
    { // 登录页
      path: '/login',
      component: Login
    },
  ]
})
