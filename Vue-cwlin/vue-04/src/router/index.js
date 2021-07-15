// 导入vue
import Vue from "vue";
import Router from "vue-router";
// 导入组件
import Main from "../views/Main";
import Login from "../views/Login";
import NotFound from "../views/NotFound";
//导入子模块
import UserProfile from "../views/user/Profile";
import UserList from "../views/user/List";
//使用
Vue.use(Router);
//导出
export default new Router({
  mode: 'history',
  routes: [
    { // 首页
      path: '/main/:name',
      component: Main, // 嵌套路由
      props: true,
      // 写入子模块
      children: [
        {
          path: '/main/:name/user/profile/:id',
          name: 'UserProfile',
          component: UserProfile
        },
        {
          path: '/main/:name/user/list',
          name:'UserList',
          component: UserList,
          props: true
        }
      ]
    },
    { // 登录页
      path: '/login',
      component: Login
    },
    { // 回到首页
      path: '/goHome',
      name: 'GoHome',
      redirect: '/main/:name', // 组件重定向
      props: true //在重定向组件中，props属性可有可无
    },
    {
      path: '*',
      component: NotFound
    }
  ]
})
