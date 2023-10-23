<template>
    <div>
      <br>
        <br>
        <br>
        <br>
        <h1 class="underline">신고 메시지 목록</h1>

        <br>
        <br>

       
        <div class="container" v-if="blacklist.length">
            <table id="car-list">
                <colgroup>
                    <col style="width: 5%" />
                    <col style="width: 20%" />
                    <col style="width: 20%" />
                    <col style="width: 20%" />
                    <col style="width: 20%" />
                    <col style="width: 15%" />
                </colgroup>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>보낸사람</th>
                        <th>받는사람</th>
                        <th>내용</th>
                        <th>승인</th>
                        <th>기각</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(msg, index) in blacklist" :key="index" :tmpmsg="msg">
                
                    <td>{{`${index + 1}`}}</td>
                    <td>{{ msg.msgFromId }}</td>
                    <td>{{ msg.msgToId }}</td>
                    <td>{{ msg.msgContent }}</td>

                    <td >
                    <button class="redbtn" @click="badMsg(msg)">
                       승인
                    </button>
                    </td>

                    <td >
                    <button class="greenbtn" @click="Nop(msg)">
                       기각
                    </button>
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
    name: "BlackLists",
    data() {
      return {

        tmpmsg:{},
        //contents: ''
      };
    },
    components: {

    },
    computed:{
      ...mapGetters(["blacklist"]),
      ...mapGetters(["loginUser"])
    },
    mounted(){
    
      //this.$store.dispatch("getBlackMsg");
     

  },
    created() {
      this.$store.dispatch("getBlackMsg");
      this.$store.dispatch("updateLoginUser");
    },
    methods: {
        
    badMsg(tmpmsg) {
        this.tmpmsg  = tmpmsg;
        this.$store.dispatch("badPoint",tmpmsg);
        this.$store.dispatch("PoliceMsg",tmpmsg);
        this.tmpmsg  ={};
        this.$router.go();
    },

    Nop(tmpmsg) {
        this.tmpmsg  = tmpmsg;
        this.$store.dispatch("PoliceMsg",tmpmsg);
        this.tmpmsg  ={};
        this.$router.go();
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

  .greenbtn {
  padding: 4px 8px;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
  background-color: #00cc00;
}

.redbtn {
  padding: 4px 8px;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
  background-color: #ff0000;
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