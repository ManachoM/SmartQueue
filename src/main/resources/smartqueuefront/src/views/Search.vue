<template class = "background-color-page">
  <div id="search">
    <v-col>
    <v-container>
      <v-row>
      <v-card width="100%" class="mx-auto mt-5">
        <v-card-title class="d-flex justify-space-between" id="titleSearch">
          <h1 class="display-1 text-xs-center"> Busca tu lugar en la fila </h1>
        </v-card-title>
        <v-card-text>
          <v-form>
            <v-text-field label="RUT" prepend-icon="mdi-account-circle" id="rutInput"/>
          </v-form>
        </v-card-text>
        <v-card-actions id="actionSearch">
          <v-btn color="success" id="btnBuscar" v-on:click="lugar">Buscar mi lugar en la fila</v-btn>
        </v-card-actions>
      </v-card>
      </v-row>
    </v-container>
      <br>
      <v-row>
    <v-card id="escondibleCard" v-if="tiempo != 0">
      <v-card-text>
        <p>Tu lugar en la fila es: {{tiempo}}</p>
      </v-card-text>
    </v-card>
      </v-row>
    </v-col>
  </div>
</template>


<script>
import axios from "axios";
export default {
  name: "Search",
  data() {
    return {
      tiempo: 0
    }
  }, methods:{

     inputRut : function (event){
       if(event){return document.getElementById("rutInput");}

},
//var obj = document.getElementById("btnBuscar")
//o/bj.onclick = getLugar();
 lugar: function() {

  var rut = document.getElementById("rutInput").value;
  axios
      .get("http://localhost:8080/lugarFila/" + rut)
      .then(result => {
        alert("se entró al post");
        this.tiempo = result.data
      })
      .catch(e => {
        console.log("Error: " + e);
      });
  //document.getElementById("escondibleCard").style.visibility = "visible";
}

//document.getElementById("btnBuscar").addEventListener("click", getLugar());
}
};
</script>

<style>
#actionSearch, #titleSearch, v-container{
  align-items: center;
  justify-content: center;
}


#search{
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 10px;
}

h1, btn {
  font-family: "Roboto Light", sans-serif;
  text-align: center;
}

.container{
  width: 500px;
}

#btnBuscar {
  background-color: #42b983;
  font-family: "Roboto Light", sans-serif;
}

</style>