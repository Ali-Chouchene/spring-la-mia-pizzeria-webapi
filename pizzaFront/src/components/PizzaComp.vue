<template>
  <li v-if="!deleted">
    <span @click="open = !open">
      {{ pizza.nome }} - {{ pizza.prezzo }}E -
    </span>
    <button @click="deletePizza(pizza.id)">X</button>
    <div v-if="open">
      {{ pizza.descrizione }}
    </div>
  </li>
</template>

<script>
import axios from 'axios';

const BASE_API_URL = "http://localhost:8080/api";

export default {
  data() {

    return {
      open: false,
      deleted: false
    }
  },
  methods: {

    deletePizza(id) {

      console.log("delete pizza " + id);

      axios.delete(BASE_API_URL + "/pizzas/" + id)
        .then(res => this.deleted = true)
        .catch(err => console.log(err));
    }
  },
  props: {
    pizza: {}
  }
}
</script>