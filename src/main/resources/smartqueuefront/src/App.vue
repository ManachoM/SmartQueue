<template>
  <div id="app" >

    <NavBar/>
    <router-view/>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar";
export default {
  name: "App",
  components:{
    NavBar
  },
  data: () => ({
    //
  })
};
</script>
<style>
.background-color-page{
  background-color: #d9d9d9;
}
#app{
  height:100vh;
}
</style>