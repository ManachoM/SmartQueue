<template class = "background-color-page">
  <div id="pass">

    <p>hola soy pass</p>
    <p v-for = "cliente in clientes" :key="`user-name-${cliente.id}`"> {{cliente.nombre}} {{cliente.apellido}}</p>
  </div>
</template>


<script>
import axios from "axios";
export default {
  name: "Pass",
  data() {
    return {
      clientes: []
    }
  },
  created(){
    axios
      .get("http://localhost:8080/lugarFila/getAll")
      .then(result => {
          this.clientes = result.data;
          })
      .catch(e => {
        console.log("Error: " + e);
      });
  }
};
</script>

<style>
.background-color-page{
  background-color: #d9d9d9;
  height: 100%;
}
</style>