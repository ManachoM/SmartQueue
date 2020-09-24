<template class = "background-color-page">
  <div id="search">
    <v-card width="50vh" class="mx-auto mt-5">
      <v-card-title> <h1 class="display-3"> Busca tu lugar en la fila </h1> </v-card-title>
      <v-card-text>
        <v-form>
          <v-text-field label="RUT" prepend-icon="mdi-account-circle" />
        </v-form>
      </v-card-text>
      <v-card-actions>
        <v-btn color="info">Buscar mi lugar en la fila</v-btn>
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

h1, btn {
  font-family: roboto;
}

</style>