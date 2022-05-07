<template>
  <div class="hello">
    <div>
      <img
        src="https://pbs.twimg.com/profile_images/1386711841410359298/Dqme1G0m_400x400.jpg"
      />
      <div>
        <ul>
          <li>sssss</li>
        </ul>
      </div>
    </div>
    <div></div>
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
      twitter: null,
      user: null
    };
  },
  mounted() {
    this.consumeTwitter();
  },
  methods: {
    consumeTwitter() {
     var config = {
  method: 'get',
  url: 'https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=jesus&oauth_consumer_key=KRy7l0v8wex3w8Sy5zThai3Ea&oauth_token=1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja&oauth_signature_method=HMAC-SHA256&oauth_timestamp=1651889436&oauth_nonce=fecUzOg2LWM&oauth_version=1.0&oauth_signature=zlpjJpmeSAaQl8N0o9tJtDw2DwDOBSOvkF%2BhX12uxkE%3D',
  headers: { 
    'Cookie': 'guest_id=v1%3A165185501896789976; guest_id_ads=v1%3A165185501896789976; guest_id_marketing=v1%3A165185501896789976; personalization_id="v1_yffO4IdDVAyjwn52SoxIDQ=="; lang=en'
  }
};

axios(config)
.then(function (response) {
  console.log(response.data);
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
</style>
