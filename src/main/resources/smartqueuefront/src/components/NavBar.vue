<template>

  <nav>
    <v-toolbar flat app color = "#284b63">
      <v-toolbar-title>
        <span class = "white tamaño-titulo">Smart</span>
        <span class = "white tamaño-titulo">Queue</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn to = "/" color = "#284b63">
        <span class = "white">
          Ingresar a la fila
        </span>
        <v-icon>fas fa-tachometer-alt</v-icon>
      </v-btn>
      <v-btn to = "/search" color = "#284b63">
        <span class = "white">
          Buscarme en la fila
        </span>
      </v-btn>
      <v-btn to = "/pass" color = "#284b63">
        <span v-if = "true" class = "white">
          Pasar una persona
        </span>
        <span v-else class = "white">

        </span>
      </v-btn>
      <v-btn to = "/" color = "#284b63">
        <span class = "white">
          FAQ
        </span>
      </v-btn>

    </v-toolbar>
  </nav>
</template>
<script>
export default {
  data: () => ({
    drawers: ['Default (no property)', 'Permanent', 'Temporary'],
    primaryDrawer: {
      model: null,
      type: 'default (no property)',
      clipped: false,
      floating: false,
      mini: false,
    },
    footer: {
      inset: false,
    },
  }),
}
</script>

<style>
  .white{
    color: #fff;
  }
  .tamaño-titulo{
    font-size: 200%;
  }
</style>