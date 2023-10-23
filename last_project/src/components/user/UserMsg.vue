<template>
    <div>
      <br>
      <br>
      <br>
      <br>
      <div class="modal2" v-if="isModalOpen">
        <h1 class="underline">쪽지함</h1>
        <br>
        <br>

      </div>
      <div v-if="!isModalOpen">
        <h1 class="underline">쪽지함</h1>
        <br>
        <br>

      </div>
      <div class="modal2" v-show="isModalOpen">
        <div class="text-center" >
          <h2 align="center">{{tmpmsg.msgFromId  }}님이 보낸 쪽지</h2>
          <br>
          <br>
          <div align="center">
            <label for="fromUser">보낸 사람</label>
            <input readonly type="text" id="fromUserId" v-model="this.tmpmsg.msgFromId" class="view"/>
            <br />

            <label for="content">내용</label>
            <input readonly type="text" id="content" v-model="this.tmpmsg.msgContent" class="view"/>
            <br />

            <label for="content">답장</label>
            <input type="text" id="content" v-model="contents" class="view"/>
          </div>
          <br>
          <br>
          <br>
          <div class="modal-buttons-container">
            <span>
            <button class="btnre1" @click="sendMsg">답장하기</button>
            </span>

            <span style="margin: 0 10px;"></span>
            
            <span>
            <button class="btnre1" @click="closeModal">취소</button>
            </span>
            <span class="modal-buttons-spacer"></span>
          </div>
        </div>
      </div>
     
      <div v-if="msglist.length" class="container ">
        <table id="car-list">
          <colgroup>
            <col style="width: 10%" />
            <col style="width: 20%" />
            <col style="width: 60%" />
            <col style="width: 10%" />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
                <th>보낸 사람</th>
                <th>내용</th>
                <th>신고하기</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(msg, index) in msglist" :key="index" :tmpmsg="msg">
              <td @click="openModal(msg)">{{`${index + 1}`}}</td>
              <td @click="openModal(msg)">{{ msg.msgFromId }}</td>
              <td @click="openModal(msg)">{{ msg.msgContent }}</td>
              <td >
              <button class="police" @click="policeMsg(msg)"> 신고하기 </button>
              
              </td>
            </tr>
          </tbody>
        </table>
        <br>
        <br>
        <br>
        <br>
      </div>
    </div>
  </template>
  
  <script>
  import { mapGetters } from "vuex";

  
  export default {
    name: "neighborLists",
    data() {
      return {

        tmpmsg:{},
        isModalOpen: false,
        contents: ''
      };
    },
    components: {

    },
    computed:{
      ...mapGetters(["msglist"]),
      ...mapGetters(["loginUser"])
    },
    created() {
      this.$store.dispatch("getMsg");
      this.$store.dispatch("updateLoginUser");
    },
    methods: {
    openModal(tmpmsg) {
      this.isModalOpen = true;
      this.tmpmsg = tmpmsg;
      this.$store.dispatch("ReadMsg",tmpmsg);
      //this.$store.dispatch("getMsg");
    },
    closeModal() {
      this.isModalOpen = false;
    },

    sendMsg() {
      let msg = {
        msgToId:this.tmpmsg.msgFromId,
        msgFromId: this.loginUser.userId,
        msgContent:this.contents,
      }
      this.contents ='';
      this.isModalOpen = false;
      if(this.loginUser.userBooleanMsg == false && this.loginUser.userWarning<3){
        this.$store.dispatch("SendMsg",msg);
      }else{
        alert("선생님은 경고 누적으로 더이상 해당 기능을 사용할 수 없어여");
      }
      
    },
    policeMsg(tmpmsg) {

      this.tmpmsg = tmpmsg;

      this.$store.dispatch("PoliceMsg",tmpmsg);
      //this.$router.go();
      
    },
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

  .underline{
  font-family: 'TTWanjudaedunsancheB';
  text-align: center;
}
  .modal2 {
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

  .police {
  padding: 8px 16px;
  background-color: red;
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
@font-face {
    font-family: 'TTWanjudaedunsancheB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/TTWanjudaedunsancheB.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}
  </style>