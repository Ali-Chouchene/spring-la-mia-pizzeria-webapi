<template>
  <div>
    <h1>Crea Pizza</h1>
    <form @submit.prevent="createPizza">
      <label for="nome">Nome</label><br>
      <input type="text" name="nome" v-model="pizza.nome">
      <br>
      <label for="descrizione">Descrizione</label><br>
      <input type="text" name="descrizione" v-model="pizza.descrizione">
      <br>
      <label for="foto">Foto</label><br>
      <input type="text" name="foto" v-model="pizza.foto">
      <br>
      <label for="prezzo">Prezzo</label><br>
      <input type="number" name="prezzo" v-model="pizza.prezzo">
      <br>
      <input type="submit" value="Crea">
    </form>
  </div>
</template>

<script>
import axios from 'axios';

const BASE_API_URL = "http://localhost:8080/api";

export default {
  data() {

    return {

      pizza: {
        nome: "",
        descrizione: "",
        foto: "",
        prezzo: ""
      }
    };
  },
  methods: {

    createPizza() {

      console.log("pre create", JSON.stringify(this.pizza));

      axios.post(BASE_API_URL + "/pizzas", this.pizza)
        .then(res => {

          this.$router.push('/');
        })
        .catch(err => console.log(err));
    }
  },
  mounted() {

    console.log("pizza create mounted");
  }
}
</script>