<template>
  <div class="hello">
    <div class="twitter">
      <img :src="image" />
      <div class="tweets">
        <ul>
          <li v-for="(tweet, index) in lista" :key="index"  ><div v-if="index < 5">{{ tweet.user.screen_name}}</div></li>
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
      lista: [],
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
    this.consumeTwitter();
  },
  methods: {
    consumeUser() {
      axios
        .get(`http://localhost:8080/getPortafolio/${this.id}`)
        .then(response => {
          console.log(response);
          this.user = response.data;
          this.names = this.user.names;
          this.image = this.user.image;
          this.summary = this.user.experienceSummary;
          this.description = this.user.description;
          this.tittle = this.user.tittle;
          this.lastNames = this.user.lastNames;
          this.email = this.user.email;
          this.lista=this.user.status;
        });
    },
    submit() {
      this.id = this.change;
      this.consumeUser();
    },
    consumeTwitter() {
      // var params = {
      //   algorithm: "HMAC-SHA1",
      //   key: "KRy7l0v8wex3w8Sy5zThai3Ea",
      //   secret: "X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu",
      //   token: "1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja",
      //   tokenSecret: "tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj",
      //   screen_name: this.names,
      // };
      // addOAuthInterceptor(axios.create(), params);
      var config = {
        method: "get",
        url: `https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=jesus&oauth_consumer_key=KRy7l0v8wex3w8Sy5zThai3Ea&oauth_token=1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja&oauth_signature_method=HMAC-SHA256&oauth_timestamp=1651889436&oauth_nonce=fecUzOg2LWM&oauth_version=1.0&oauth_signature=zlpjJpmeSAaQl8N0o9tJtDw2DwDOBSOvkF%2BhX12uxkE%3D`,
        headers: {
          Cookie:
            'guest_id=v1%3A165185501896789976; guest_id_ads=v1%3A165185501896789976; guest_id_marketing=v1%3A165185501896789976; personalization_id="v1_yffO4IdDVAyjwn52SoxIDQ=="; lang=en',
        },
      };

      axios(config)
        .then(response =>{
          console.log(this.lista);
          console.log(response.data);
          console.log(response.data[0]);
          console.log(typeof response.data[0]);
          this.lista = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
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
}
#twitter {
  display: flex;
}
</style>
