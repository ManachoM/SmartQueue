<template class = "background-color-page">
  <div id="home" class = "background-color-page">
    <NavBar/>
    <p>holi</p>

  </div>
</template>


<script>
import NavBar from "@/components/NavBar";
export default {
  name: "Home",
  components: {NavBar}
};
</script>

<style>
  .background-color-page{
    background-color: #d9d9d9;
  }
</style>