<template>
  <div >
    <br>
    <br>
    <br>
    <br>
    <div class="newP" v-if="isModalOpen1">
      <h1 class="underline">동네친구들</h1>
      <br>
      <br>

    </div>
    <div v-if="!isModalOpen1">
      <h1 class="underline">동네친구들</h1>
      <br>
      <br>

    </div>
    <div class="newP" v-show="isModalOpen1">
      <div class="text-center" >
          <h2 align="center">{{tmpuser.userId}}님에게 쪽지 보내기</h2> 
        <br>
        <br>
        <div align="center">
          <label for="toUser">받는 사람</label>
          <input readonly type="text" id="toUserId" v-model="this.tmpuser.userId" class="view"/>
          <br />

          <label for="fromUser">보내는 사람</label>
          <input readonly type="text" id="fromUserId" v-model="loginUser.userId" class="view"/>
          <br />

          <label for="content">내용</label>
          <input type="text" id="content" v-model="contents" class="view"/>
          <br />
        </div>
        <br>
        <br>
        <br>
        <div class="modal-buttons-container">
          <span>
          <button class="btnre1" @click="sendMsg">보내기</button>
          </span>

          <span style="margin: 0 10px;"></span>
            
          <span>
          <button class="btnre1" @click="closeModal">취소</button>
          </span>
          <span class="modal-buttons-spacer"></span>
        </div>
      </div>
    </div>

    <div v-if="neighborlist.length" class="container ">
      <table id="car-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 15%" />
          <col style="width: 15%" />
          <col style="width: 15%" />
          <col style="width: 15%" />
          <col style="width: 15%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>아이디</th>
            <th>닉네임</th>
            <th>포켓몬</th>
            <th>좋아하는 스포츠</th>
            <th>관심 종목</th>
            <th>주소</th>
            <th>쪽지보내기</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(user, index) in neighborlist" :key="index" :tmpuser="user">
            <td>{{`${index + 1}`}}</td>
            <td>{{ user.userId }}</td>
            <td>{{ user.userNickname }}</td>
            <td>{{ user.userPokectmonName }}</td>
            <td>{{ user.userInterestBigSport }}</td>
            <td>{{ user.userInterestSmallSport }}</td>
            <td>{{ user.userAdress }}</td>
            <td v-if="user.userId !==loginUser.userId">
              <button class="send" @click="openModal(user)">
              쪽지보내기
              </button>
            </td>
            <td v-else>
              본인
            </td>

          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
  
  <script>
  import { mapGetters } from "vuex";

  
  export default {
    name: "neighborLists",
    data() {
      return {
        //userId: '',
        //toUserId: '',
        tmpuser:{},
        isModalOpen1: false,
        contents: ''
      };
    },
    components: {

    },
    computed:{
      ...mapGetters(["neighborlist"]),
      ...mapGetters(["loginUser"])
    },
    created() {
      this.$store.dispatch("getNeighbor");
      this.$store.dispatch("updateLoginUser");
    },
    methods: {
    openModal(tmpuser) {
      this.isModalOpen1 = true;
      this.tmpuser = tmpuser;
    },
    closeModal() {
      this.isModalOpen1 = false;
    },

    sendMsg() {
      let msg = {
        msgToId:this.tmpuser.userId,
        msgFromId: this.loginUser.userId,
        msgContent:this.contents,
      }
      //console.log(msg.msgToId);
     // console.log(msg.msgFromId);
      this.contents ='';
      //console.log(msg.msgContent);
      //console.log(this.contents);
      this.isModalOpen1 = false;
      if(this.loginUser.userBooleanMsg == false && this.loginUser.userWarning<3){
        this.$store.dispatch("SendMsg",msg);
      }else{
        alert("선생님은 경고 누적으로 더이상 해당 기능을 사용할 수 없어여");
      }
      
    }
    }
  };
  </script>
  
  <style scoped>
  #car-list {
    border-collapse: collapse;
    width: 100%;
  }
  
  #car-list thead {
    background-color: #ccc;
    font-weight: bold;
  }
  
  #car-list td,
  #car-list th {
    text-align: center;
    border-bottom: 1px solid #ddd;
    height: 50px;
  }
  
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  .newP {
    width:100%;
    height:100%;
    background: rgba(0,0,0,0.6);
    position: fixed;
    border: 10px solid black;
  }
  .text-center{
    width:90%;
    margin:80px auto;
    background: white;
    border-radius: 5px;
    padding: 20px 0;
  }
  .modal-buttons-container {
    display: flex;
    justify-content: flex-end;
  }

  .btnre1 {
  padding: 8px 16px;
  background-color: #00aaff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
  margin-left: 5px;

}

.modal-buttons-spacer {
    margin-right: 15px;
  }

  .send {
  padding: 8px 16px;
  background-color: rgba(121, 228, 94, 0.699);
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
  margin-left: 5px;

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
  