<template class = "background-color-page">
  <div id="pass">
    <v-row >
      <v-col cols = "4">

      </v-col>
      <v-col cols = "4" md = "4" align-self>
        <p class = "fuente-cliente" v-for = "cliente in clientes" :key="`user-name-${cliente.id}`"> {{cliente.nombre}} {{cliente.apellido}}</p>
      </v-col>

      <v-col cols = "4">

      </v-col>
    </v-row>
    <v-spacer>
    </v-spacer>
    <v-row>
      <v-col cols = "4">

      </v-col>
      <v-col cols = "4" md = "4">
        <div >
          <v-btn class = "alinear-centro" depressed x-large color="#284b63" dark>¡Hacer pasar cliente!</v-btn>
        </div>
      </v-col>
      <v-col cols = "4">

      </v-col>
    </v-row>

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
      .get("http://localhost:8081/lugarFila/getAll")
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
.fuente-cliente{
  font-size: 150%;
  border:solid #2c3e50 ;
  text-align: center;
}

</style>