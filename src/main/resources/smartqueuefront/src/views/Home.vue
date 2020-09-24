<template>

  <div id="home" class = "background-color-page">
   <v-container>
    <v-card id="homeCard" width="100%" class="mx-auto mt-5">
      <v-card-title>
        <h1 class="Display-1">
          ¡Ingresa a la fila!
        </h1>
      </v-card-title>
    <v-card-text>
    <v-form v-model="valid">
      <v-container>

        <v-row>
          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                id="nombre"
                v-model="firstname"
                :rules="nameRules"
                :counter="50"
                label="Nombres"
                required
            ></v-text-field>
          </v-col>

          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                id="apellido"
                v-model="lastname"
                :rules="lastRules"
                :counter="50"
                label="Apellidos"
                required
            ></v-text-field>
          </v-col>

          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                id="rut"
                v-model="RUT"
                label="RUT"
                :rules = "rutRules"
                required
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols = "12" md = "4">
            <v-text-field
                id="telefono"
                v-model="phoneNumber"
                :rules="phoneRules"
                label="Número de teléfono"
                required
            ></v-text-field>
          </v-col>
          <v-col cols = "12" md = "4">
            <v-text-field
                id="edad"
                v-model="age"
                :rules="ageRules"
                label="Edad"

                required
            ></v-text-field>
          </v-col>



          <v-col cols = "12" md = "4">
            <v-checkbox
                id="discapacidad"
                v-model="checkbox"
                label="Me encuentro en alguna situación de discapacidad."

            ></v-checkbox>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
    </v-card-text>
        <v-card-actions id="homeActions">
            <v-col cols = "12" md = "4">
              <v-btn
                  dark
                  color="#284b63"
                  class="mr-4"
                  @click="validate"
                  v-on:click="ingresarFila()"


              >
                Ingresar a la fila
              </v-btn>
            </v-col>
        </v-card-actions>

    </v-card>
   </v-container>
  </div>
</template>


<script>
import axios from "axios";
export default {
  name: "Home",
  data: () => ({
    items: [
      'ola','qtalllllll'
    ],
    valid: true,
    firstname: '',
    nameRules: [
      v => !!v || 'Llena el campo nombre.',
      v => (v && v.length <= 50) || 'El nombre debe ser de menos de 50 carácteres.',
    ],
    lastname: '',
    lastRules: [
      v => !!v || 'Llena el campo nombre.',
      v => (v && v.length <= 50) || 'El nombre debe ser de menos de 50 carácteres.',
    ],
    phoneNumber: '',
    phoneRules: [
      v => !!v || 'Llena el campo número de teléfono.',
      v => /^\+?([0-9]{3})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/.test(v) || 'Ingresa un número de teléfono válido (ej: +111 1111 1111)'
    ],
    RUT: '',
    rutRules: [
      v => !!v || 'Llena el campo de RUT',
      v => /^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test(v) || 'Este RUT no es válido (ej: 12345578-9)',

    ],
    age: '',
    ageRules: [
      v => !!v || 'Llena el campo edad',
      v => /^[0-9]$/.test(v) || 'La edad debe ser un número',
    ],

    checkbox: false,
  }),
  methods: {
    validate () {
      this.$refs.form.validate()
    },
    reset () {
      this.$refs.form.reset()
    },
    ingresarFila () {
      var nombre = document.getElementById("nombre").value;
      var apellido = document.getElementById("apellido").value;
      var rut = document.getElementById("rut").value;
      var telefono = document.getElementById("telefono").value;
      var edad = document.getElementById("edad").value;
      var discapacidad = document.getElementById("discapacidad").value;
      axios
          .post("http://localhost:8080/home/almacen", {
            nombre: nombre,
            apellido: apellido,
            rut: rut,
            telefono: telefono,
            edad: edad,
            discapacidad: discapacidad
          })
          .then(function () {
            console.log("Se ingresó correctamente");
          })
          .catch(function (error) {
            console.log(error);
          });
      document.getElementById("nombre").value = "";
      document.getElementById("apellido").value = "";
      document.getElementById("rut").value = "";
      document.getElementById("telefono").value = "";
      document.getElementById("edad").value = "";
      document.getElementById("discapacidad").value = 0;
    }
  },
};
</script>

<style>
  .background-color-page{
    background-color: #d9d9d9;
    height: 100%;
    padding: 5px;
  }
  #homeActions{
    align-items: center;
    justify-content: center;
  }
  #homeCard{
    margin-top: 10px;

  }
</style>