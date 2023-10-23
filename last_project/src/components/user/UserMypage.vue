<template>
  <div>
    <br>
    <br>
    <br>
    <br>
    <h1 class="underline">회원 정보</h1>
    <br>
    <br>

    <div class="container">
      <fieldset class="text-center5">

        <div class="label-wrapper">
          <label for="userId">아이디</label>
          <input readonly type="text" id="userId" v-model="loginUser.userId" class="view"/>
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userPwd">비밀번호</label>
          <input type="password" id="userPwd" v-model="loginUser.userPwd" class="view"/>
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userName">이름</label>
          <input type="text" id="userName" v-model="loginUser.userName" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userNickname">닉네임</label>
          <input type="text" id="userNickname" v-model="loginUser.userNickname" class="view" />
          <div v-show="getNickname()">
            <button class="btn100" @click = chekcNickname> 중복확인 </button>
          </div>
        </div>
        <div class="label-wrapper">
          <label for="userAdress">주소</label>
          <input type="email" id="userAdress" v-model="loginUser.userAdress" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userInterestBigSport">관심 운동</label>
          <div class="cheche">
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="라켓운동"> 라켓운동</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="조깅/하이킹"> 조깅/하이킹</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="격투기"> 격투기</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="수중운동"> 수중운동</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="헬스/요가"> 헬스/요가</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="댄스"> 댄스</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="설상운동"> 설상운동</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="구기운동"> 구기운동</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="숨쉬기운동"> 숨쉬기운동</label>
            <label><input type="radio" id="userInterestBigSport" v-model="loginUser.userInterestBigSport" value="없음"> 없음</label>
          </div>
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userInterestSmallSport">좋아하는 종목</label>
          <input type="text" id="userInterestSmallSport" v-model="loginUser.userInterestSmallSport" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userSex">성별</label>
          <label><input type="radio" id="userSex" v-model="loginUser.userSex" value=0> 남</label>
          <label><input type="radio" id="userSex" v-model="loginUser.userSex" value=1> 여</label>
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userAge">나이</label>
          <input type="number" id="userAge" v-model="loginUser.userAge" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userHeight">키</label>
          <input type="number" id="userHeight" v-model="loginUser.userHeight" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userWeight">몸무게</label>
          <input type="number" id="userWeight" v-model="loginUser.userWeight" class="view" />
        </div>
        <br />

        <div class="label-wrapper">
          <label for="userExcerciseGoal">운동을 하는 목적</label>
          <input type="text" id="userExcerciseGoal" v-model="loginUser.userExcerciseGoal" class="view" />
        </div>
        <br />

        

        <button class="btnmy" @click="updateUser">수정</button>
        <!--<button class="btn" @click="deleteUser">삭제</button>-->
      </fieldset>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "UserDetail",
  data() {
    return {
      
      tmpNickname: ""
      
    };
  },
  methods: {
    updateUser() {
      this.$store.dispatch("updateUser", this.loginUser);
    },
    chekcNickname() {
      this.$store.dispatch("UserCheckNickname", this.loginUser.userNickname);
      //console.log(this.loginUser.userNickname);
    },
    getNickname() {
      if (this.tmpNickname == this.loginUser.userNickname) {
        return false;
      } else {
        return true;
      }
    },
    
  },
  computed: {
    ...mapState(["loginUser"]),
    
  },

  mounted(){
      this.tmpNickname = this.loginUser.userNickname;
      this.$store.dispatch("updateLoginUser");
  }
  
};
</script>

<style>
.btnmy {
  padding: 8px 16px;
  background-color: #00aaff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
  margin-left: 5px;

}
.btn100 {
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

/* .label-wrapper input[type="text"],
.label-wrapper input[type="number"] {
  margin-left: 8px;
} */

.label-wrapper input[type="text"],
  .label-wrapper input[type="number"],
  .label-wrapper input[type="password"],
  .label-wrapper input[type="email"] {
    flex: 1; /* input 요소가 남은 공간을 모두 차지하도록 설정 */
  }

.cheche  {
  margin-left: 65px;
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