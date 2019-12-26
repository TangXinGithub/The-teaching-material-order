<template>
  <div id="app">
<!--   导航条-->
<navigation></navigation>



    <router-view></router-view> <!--有这个才能显示-->
  </div>
</template>

<script>


import Navigation from "@/components/navigation";

export default {
  name: 'app',
  components: {
    Navigation,


  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
