<template>
  <div>
    <br>
    <br>
    <br>
    <br>
    <h1 class="underline">로그인</h1>
    <br>
    <br>

    <div class="container">
      <fieldset class="text-center666">

        <div class="label-wrapper">
          <label for="id">아이디</label>
          <input type="text" id="userId" v-model="userId" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="password">비밀번호</label>
          <input type="password" id="userPwd" v-model="userPwd" class="view" />
        </div>
        <br />
        <button class="loginbtn" @click="login">로그인</button>
      </fieldset>
    </div>
  </div>
  
</template>

<script>
export default {
  name: "LoginForm",
  data() {
    return {
      userId: "",
      userPwd: "",
    };
  },
  methods: {
    login() {
      let user = {
        userId: this.userId,
        userPwd: this.userPwd,
      };

      this.$store.dispatch("setLoginUser", user);
    },
  },
};
</script>

<style>
.loginbtn {
  padding: 8px 16px;
  background-color: #00aaff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
  margin-left: 5px;

}


.label-wrapper {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
}

.label-wrapper label {
  margin-right: 8px;
}


.label-wrapper input[type="text"],
  .label-wrapper input[type="number"],
  .label-wrapper input[type="password"],
  .label-wrapper input[type="email"] {
    flex: 1; /* input 요소가 남은 공간을 모두 차지하도록 설정 */
  }


.container{
  background-color: white;
  border: 5px solid #000;

}
.underline{
  font-family: 'TTWanjudaedunsancheB';
  text-align: center;
}
@font-face {
    font-family: 'TTWanjudaedunsancheB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/TTWanjudaedunsancheB.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}
</style>