<template>
  <div id="app">
    <router-link to="/main">main</router-link> <!--提供一个入口-->
    <router-link to="/login">login</router-link>
    <router-view></router-view>
  </div>
</template>

<script>


export default {
  name: 'App',

}
</script>

<style>

</style>
