<template>
  <div >
    <br>
    <br>
    <br>
    <br>
    <h2 class="underline">회원 가입</h2>
    <br>
    <br>

    <div class="container">
      <fieldset class="text-center55">
        <div class="label-wrapper55">
          <label for="userId">아이디</label>
          <input type="text" id="userId" v-model="userId" class="view" />
          <button class="btn100" @click = chekcId> 중복확인 </button>
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userPwd">비밀번호</label>
          <input type="password" id="userPwd" v-model="userPwd" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userPwdC">비밀번호 확인</label>
          <input type="password" id="userPwdC" v-model="userPwdC" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userName">이름</label>
          <input type="text" id="userName" v-model="userName" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userNickname">닉네임</label>
          <input type="text" id="userNickname" v-model="userNickname" class="view" />
          <button class="btn100" @click = chekcNickname> 중복확인 </button>
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userEmail">이메일</label>
          <input type="email" id="userEmail" v-model="userEmail" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userAdress">주소 ex 신림동..()</label>
          <input type="text" id="userAdress" v-model="userAdress" class="view" />
        </div>
        <br />
    
        <div class="label-wrapper55">
          <label for="userInterestBigSport">관심 운동</label>
          <div class="cheche55">
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="라켓운동"> 라켓운동</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="조깅/하이킹"> 조깅/하이킹</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="격투기"> 격투기</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="수중운동"> 수중운동</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="헬스/요가"> 헬스/요가</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="댄스"> 댄스</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="설상운동"> 설상운동</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="구기운동"> 구기운동</label>
            <label><input type="radio" name="userInterestBigSport" v-model="userInterestBigSport" value="없음"> 없음</label>
          </div>
        </div>
        <br />


        <div class="label-wrapper55">
          <label for="userInterestSmallSport">좋아하는 종목</label>
          <input type="text" id="userInterestSmallSport" v-model="userInterestSmallSport" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userSex">성별</label>
          <label><input type="radio" name="userSex" v-model="userSex" value=0> 남</label>
          <label><input type="radio" name="userSex" v-model="userSex" value=1> 여</label>
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userAge">나이</label>
          <input type="number" id="userAge" v-model="userAge" class="view" />
        </div>
        <br />


        <div class="label-wrapper55">
          <label for="userHeight">키</label>
          <input type="number" id="userHeight" v-model="userHeight" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userWeight">몸무게</label>
          <input type="number" id="userWeight" v-model="userWeight" class="view" />
        </div>
        <br />

        <div class="label-wrapper55">
          <label for="userExcerciseGoal">운동을 하는 목적</label>
          <input type="text" id="userExcerciseGoal" v-model="userExcerciseGoal" class="view" />
        </div>
        <br />

        <button class="btnmy" @click="regist">등록</button>
        <!--<button class="btn" @click="deleteUser">삭제</button>-->
      </fieldset>
    </div>
  </div>
</template>
<script>
export default {
  //import { ___________ } from "vuex";
  name: "RegistUser",
  data() {
    return {
      userId: "",
      userPwd: "",
      userPwdC: "",
      userName: "",
      userNickname: "",
      userEmail: "",
      userAdress: "",
      userInterestBigSport: "",
      userInterestSmallSport: "",
      userSex: -1,
      userAge: -1,
      userHeight: -1,
      userWeight: -1,
      userExcerciseGoal: ""
    };
  },
  methods: {
    chekcId() {
      //console.log(this.userId);
      this.$store.dispatch("UserCheckId",this.userId);
    },

    chekcNickname() {
      this.$store.dispatch("UserCheckNickname", this.userNickname);
    },
    regist() {
      
      if (
        
        this.userId=== "" ||
        this.userPwd=== "" ||
        this.userPwdC=== "" ||
        this.userName=== "" ||
        this.userNickname=== "" ||
        this.userEmail=== "" ||
        this.userAdress=== "" ||
        this.userInterestBigSport=== "" ||
        this.userInterestSmallSport=== "" ||
        this.userSex===-1 ||
        this.userAge===-1 ||
        this.userHeight===-1 ||
        this.userWeight===-1 ||
        this.userExcerciseGoal=== ""
      ) {
        alert("필수 내용을 입력해주세요");
        return;
      }

      if(this.userPwd != this.userPwdC){
        alert("비밀 번호가 일치하지 않습니다.");
        return;
      }
      
      this.$store.dispatch("UserCheckId",this.userId);
      this.$store.dispatch("UserCheckNickname", this.userNickname);

      let user = {
      
        userId: this.userId,
        userPwd:this.userPwd,
        userName:this.userName,
        userNickname:this.userNickname,
        userEmail:this.userEmail,
        userAdress:this.userAdress,
        userInterestBigSport:this.userInterestBigSport,
        userInterestSmallSport:this.userInterestSmallSport,
        userSex:this.userSex,
        userAge:this.userAge,
        userHeight:this.userHeight,
        userWeight:this.userWeight,
        userExcerciseGoal:this.userExcerciseGoal,
      };

       this.$store.dispatch("createUser", user);
    },
  },
  computed: {
  //...___________(["randomUser"]),
},
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

.label-wrapper55 {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
}

.label-wrapper55 label {
  margin-right: 8px;
}

/* .label-wrapper input[type="text"],
.label-wrapper input[type="number"] {
  margin-left: 8px;
} */

.label-wrapper55 input[type="text"],
  .label-wrapper55 input[type="number"],
  .label-wrapper55 input[type="password"],
  .label-wrapper55 input[type="email"] {
    flex: 1; /* input 요소가 남은 공간을 모두 차지하도록 설정 */
  }

.cheche55  {
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