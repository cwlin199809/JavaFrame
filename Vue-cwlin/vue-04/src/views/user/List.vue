<template>
  <!--所有的元素必须在根节点下-->
  <div>
    <h1>用户列表</h1>
    {{id}}
  </div>
</template>

<script>
export default {
  name: "UserList",
  props: ["id"]
}
</script>

<style scoped>

</style>
