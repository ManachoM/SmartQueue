<template class = "background-color-page">
  <div id="search">
    <v-card>
      <v-card-title> <h1 class="display-1"> Busca tu lugar en la fila </h1> </v-card-title>
      <v-card-text>
        <v-form>
          <v-text-field label="RUT" pretend-icon = "mdi-account-circle" />
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn>Buscar mi lugar en la fila</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>


<script>

export default {
  name: "Search",
};
</script>

<style>
/*.background-color-page{
  background-color: #d9d9d9;
  height: 100%;
}*/
</style>