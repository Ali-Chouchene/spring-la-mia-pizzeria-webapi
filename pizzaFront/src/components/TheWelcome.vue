<template>
	<h1>Pizzas:</h1>
	<router-link to="/pizzas/create">Pizza create</router-link>
	<ul>
		<PizzaComp v-for="pizza in pizzas" :pizza="pizza" />
	</ul>
</template>

<script>
import PizzaComp from './PizzaComp.vue'
import axios from 'axios';

const BASE_API_URL = "http://localhost:8080/api";

export default {
	data() {

		return {
			count: 0,
			pizzas: [],

			open_desc_id: -1
		}
	},
	components: {
		PizzaComp
	},
	methods: {

		countAct() {
			this.count++;
			console.log(this.count)
		},
		getPizzas() {

			axios.get(BASE_API_URL + "/pizzas")
				.then(res => {

					const pizzas = res.data;

					console.log(pizzas);

					this.pizzas = pizzas;
				})
				.catch(err => console.log(err));
		}
	},
	mounted() {

		this.getPizzas();
	}
}

</script>