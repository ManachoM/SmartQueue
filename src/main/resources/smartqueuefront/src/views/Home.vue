<template>

  <div id="home" class = "background-color-page">
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
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
                v-model="phoneNumber"
                :rules="phoneRules"
                label="Número de teléfono"
                required
            ></v-text-field>
          </v-col>
          <v-col cols = "12" md = "4">
            <v-text-field
                v-model="age"
                :rules="ageRules"
                label="Edad"

                required
            ></v-text-field>
          </v-col>
          <v-col>
            <v-select
                v-model="select"
                :items="items"
                taggable
                multiple
                label="Local"
                required
            >
            </v-select>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols = "12" md = "4">
            <v-checkbox
                v-model="checkbox"
                label="Me encuentro en alguna situación de discapacidad."

            ></v-checkbox>
            <v-col cols = "12" md = "4">
              <v-btn
                  dark
                  color="#284b63"
                  class="mr-4"
                  @click="validate"

              >
                Ingresar a la fila
              </v-btn>
            </v-col>
          </v-col>
        </v-row>
      </v-container>
    </v-form>


  </div>
</template>


<script>

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
  },
};
</script>

<style>
  .background-color-page{
    background-color: #d9d9d9;
    height: 100%;
  }
</style>