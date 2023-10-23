<template>
  <header>
    <nav class="header-nav">
      <div class="d-flex justify-content-between">
        <router-link to="/home" class="logo">
          <span class="word"> 득근득근 </span>
        </router-link>
      </div>
      <div v-if="getUser">
        <span class="bar1">
          <span>
            <router-link :to="`/likelist`">LIKES</router-link>
          </span>
          &nbsp;
          <span class="t1">|</span>
          &nbsp;
          <span>
            <router-link :to="`/video/videoListPage`">VIDEO</router-link>
          </span>
          &nbsp;
          <span class="t1">|</span>
          <span>
            &nbsp;
            <router-link :to="`/article/articleList`">BOARD</router-link>
          </span>
          &nbsp;
          <span class="t1">|</span>
          &nbsp;
          <span>
            <router-link :to="`/user/neighbor`">NEIGHBOR</router-link>
          </span>
          &nbsp;
          <span class="t1">|</span>
          <span>
            &nbsp;
            <router-link :to="`/user/mypocketmon?userSeq=${loginUser.userSeq}`"
              >MY POCKETMON</router-link
            >
          </span>
        </span>
      </div>

      <div v-if="getUser">
        <span class="bar2">
          <span v-if="checkingMsg">
            <router-link :to="`/user/msg`"
              ><i class="bi bi-envelope-open"></i
            ></router-link>
          </span>

          <span v-if="!checkingMsg">
            <router-link :to="`/user/msg`"
              ><i class="bi bi-envelope-plus"></i
            ></router-link>
          </span>

          <span>
            <router-link to="/home" @click.native="logout">
              <i class="bi bi-box-arrow-right"></i
            ></router-link>
          </span>

          <span>
            <router-link :to="`/user/mypage?userSeq=${loginUser.userSeq}`"
              ><i class="bi bi-person-fill-gear"></i
            ></router-link>
          </span>

          <span v-if="loginUser.userManager == 2">
            <router-link :to="`/user/black`"
              ><i class="bi bi-exclamation-triangle-fill"></i
            ></router-link>
          </span>
        </span>
      </div>

      <div v-else>
        <span>
          <router-link to="/user/login">로그인</router-link>
        </span>

        <span>
          <router-link to="/user/signup">회원가입</router-link>
        </span>
      </div>
    </nav>
    <br />
    <br />
    <br />
    <br />
    <br />
  </header>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "HeaderNav",

  data() {
    return {
      tmploginuser: {},
    };
  },

  methods: {
    logout() {
      //console.log("들어오나?");
      //this.$emit("logout");
      //     console.log("fhrmdkdntgkqslek");
      this.$store.dispatch("UserLogout");
    },
  },
  computed: {
    ...mapGetters(["loginUser"]),
    ...mapGetters(["msglist"]),

    getUser() {
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },

    checkingMsg() {
      var a = true;
      for (var i = 0; i < this.msglist.length; i++) {
        if (!this.msglist[i].msgReadCheck) {
          a = false;
          break;
        }
      }
      return a;
    },
  },

  created() {
    if (this.loginUser !== null) {
      this.$store.dispatch("getMsg");
      this.$store.dispatch("updateLoginUser");
    }
  },

  watch: {
    loginUser() {
      if (this.loginUser !== null) {
        this.$store.dispatch("getMsg");
      }
      //console.log(newMsg);
    },
  },

  // mounted (){
  //   ...mapState(['loginUser']),
  // }
};
</script>

<style>
.bar2 {
  font-size: 39px;
}

header {
  height: 70px;
  background-color: beige;

  line-height: 70px;
  padding: 0px 0px;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: black;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: black;
  margin: 10;
}
.word {
  font-size: 39px;
  font-weight: bold;
  color: black;
  position: relative;
  top: -10px;
  left: 0px;
  font-family: "DOSPilgiMedium";
}

.bar1 {
  font-size: 2.5rem;
  font-weight: bold;
  font-style: oblique;
}
.navbar-right {
  margin-left: auto;
}

.t1 {
  font-size: 2.5rem;
  font-weight: lighter;
  color: rgb(191, 189, 189);
}
@font-face {
  font-family: "DOSPilgiMedium";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/DOSPilgiMedium.woff2")
    format("woff2");
  font-weight: normal;
  font-style: normal;
}
</style>
