<template>
  <!-- <div class="black-background">
    <h1 class="white-text align-top">
      나를 죽이지 못하는 고통은 나를 더 강하게 만든다.
    </h1>
    <br /><br /><br /><br /><br />
    <h1 class="align-bottom">
      <router-link to="/home">웹 페이지 접속하기</router-link>
    </h1>
    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
    <h2 class="white-text align-bottom2">MADE BY 이원희 박대균</h2>
  </div> -->
  <div class="black-background">
    <br />
    <br />
    <br /><br /><br /><br />
    <span class="white-text align-top"> "나를 죽이지 못하는 고통은 </span>
    <div>
      <br />
      <br />
      <br />
    </div>
    <span class="white-text align-top"> 나를 더 강하게 만든다" </span>
    <br />
    <br />
    <br />
    <div class="align-bottom">
      <br /><br /><br />
      <router-link to="/home">웹 페이지 접속하기</router-link>
    </div>
    <br /><br /><br /><br /><br /><br /><br /><br />
    <div class="white-text2 align-bottom">MADE BY 이원희 박대균</div>
  </div>
</template>

<style>
/* 흰색 글씨와 검은색 배경 적용 */
.white-text2 {
  color: white;
  font-size: 1.5em;
}

.white-text {
  color: white;
  font-family: "Dovemayo_wild";
  font-size: 7em;
}

.black-background {
  background-color: black;
  height: 100vh;
  /* display: list-item; */
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.align-top {
  align-items: start;
}

.align-bottom {
  align-self: center;
  font-size: 1.5em;
}
@font-face {
  font-family: "Dovemayo_wild";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/Dovemayo_wild.woff2")
    format("woff2");
  font-weight: normal;
  font-style: normal;
}
</style>
