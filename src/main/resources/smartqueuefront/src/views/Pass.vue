<template >
  <div id="pass" class = "background-color-page">
    <v-container>


    <v-simple-table id="tablaClientes" width="500">

        <thead>
        <tr>
          <th class="text-left">Nombre</th>
          <th class="text-left">Rut</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="cliente in local.filaAsoc.listaClientes" :key="cliente._id">
          <td>{{ cliente.nombre }} {{cliente.apellido}}</td>
          <td>{{ cliente.rut }}</td>
        </tr>
        </tbody>

    </v-simple-table>
    </v-container>
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
          <v-btn class = "alinear-centro" depressed x-large color="#284b63" dark v-on:click="hacerPasar()">¡Hacer pasar cliente!</v-btn>
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
      local: {}
    }
  },
  created(){
    axios
      .get("http://localhost:8080/admin/333333-4")
      .then(result => {
          this.local = result.data;
          })
      .catch(e => {
        console.log("Error: " + e);
      });
  },methods:{
    hacerPasar (){
      axios
        .delete("http://localhost:8080/admin/333333-4")
        .then(result => {
          if(result != null){
            this.local = result.data;
          }
        })
        .catch(function (error) {
          console.log("Error: "+ error);
        });
    }
  }
};
</script>

<style>
#tablaClientes{
  justify-content: left;
  align-items: center;
  text-align: center;
}
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