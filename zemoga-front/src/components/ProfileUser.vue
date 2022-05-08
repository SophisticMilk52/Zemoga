<template>
  <div class="hello">
    <div class="twitter">
      <img :src="image" />
      <div class="tweets">
        <h3>{{ names }}'s Timeline</h3>
        <ul>
          <li v-for="(tweet, index) in lista" :key="index">
            <div v-if="index < 5"><img :src="tweet.user.miniProfileImageURL"/><p>{{tweet.user.screenName}}</p><p>{{ tweet.user.description }}</p></div>
          </li>
        </ul>
      </div>
    </div>

    <div class="userInfo">
      <h1>Title: {{ tittle }}</h1>
      <h2>Name: {{ names }} {{ lastNames }}</h2>
      <h3>Email: {{ email }}</h3>
      <p>My work experience</p>
      <p>Summary: {{ summary }}</p>
      <p>description: {{ description }}</p>
      <form @submit.prevent="submit">
        <input type="text" v-model="change" placeholder="Insert Id" />
        <button type="submit">Submit ID</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ProfileUser",
  props: {
    msg: String,
  },

  data() {
    return {
      id: "2",
      lista: null,
      elmento1: null,
      elmento2: null,
      elmento3: null,
      elmento4: null,
      elmento5: null,
      user: null,
      twitterUser: "",
      names: "",
      image: "",
      summary: "",
      description: "",
      tittle: "",
      lastNames: "",
      email: "",
      change: "",
    };
  },
  mounted() {
    this.consumeUser();
  },
  methods: {
    consumeUser() {
      axios
        .get(`http://localhost:8080/getPortafolio/${this.id}`)
        .then((response) => {
          console.log(response.data);
          this.user = response.data;
          this.names = this.user.names;
          this.image = this.user.image;
          this.summary = this.user.experienceSummary;
          this.description = this.user.description;
          this.tittle = this.user.tittle;
          this.lastNames = this.user.lastNames;
          this.email = this.user.email;
          this.lista = response.data.twitterList;
          console.log(response.data.twitterList);
        });
    },
    submit() {
      this.id = this.change;
      this.consumeUser();
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
#hello {
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-between;
  background-color: grey;
  width: auto;
  height: auto;

}
#twitter {
  display: flex;
  background-color: #42b983;
    float: left
}
</style>
