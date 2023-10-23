<template>
  <div id="app">
    <!-- CSS only -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <link
      rel="stylesheet"
      href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
    />
    <!--link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">-->

    <header>
      <HeaderNav v-if="isIndexPage" class="black-background" />
      <HeaderNav v-else></HeaderNav>
    </header>

    <main>
      <!-- <img src = " 
      https://static.wikia.nocookie.net/pokemon/images/2/29/%EA%B0%80%EB%94%94%EC%95%88_%ED%8F%BF%EA%B6%8C_%EA%B3%B5%EC%8B%9D_%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8.png/revision/latest?cb=20170617143333&path-prefix=ko
      " width = "300" height = "300">-->
      <router-view />
      <div class="space">
        <br />
        <br />
        <br />
      </div>
    </main>

    <footer v-if="isIndexPage" class="black-background">
      <hr />
      <FooterNav />
    </footer>

    <footer v-else class="footer">
      <hr />
      <FooterNav />
    </footer>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import FooterNav from "@/components/common/FooterNav.vue";

export default {
  name: "App",
  components: {
    HeaderNav,
    FooterNav,
  },

  computed: {
    isIndexPage() {
      return this.$route.path === "/";
    },
  },
};
</script>

<style>
html,
body {
  height: 100%;
  margin: 0;
  padding: 0;
}

#app {
  min-height: 100%;
  position: relative;
  background-color: beige;
}

.main {
  padding-bottom: 60px; /* footer의 높이에 맞게 값 설정 */
}

.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 60px; /* footer의 높이 설정 */
  background-color: beige; /* footer 배경색 설정 */
}
</style>
