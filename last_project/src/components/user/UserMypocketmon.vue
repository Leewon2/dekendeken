<template>
  <div >
    <br>
    <br>
    <br>
    <br>
    <h1 class="underline">내 포켓몬</h1>
    <br>
    <br>

    <div class="container">
      <fieldset class="text-center2">     
        <div v-if = "loginUser.userTotalCalorie < 500" style="float:left;">
            <img src = " https://post-phinf.pstatic.net/MjAxOTA4MThfMTE0/MDAxNTY2MTI2MzYyMDAy.6PygmolE5XxIaKdttCHDUiQ9AoZ2Nm5I7H5CV9vBQmUg.PQ3kL8sRX5S1YOdziAQVq0juVupvTXlP2zS1qjUEcu8g.GIF/%EC%95%8C.gif" width = "300" height = "300"> 
            <br>
            <br>
            
        </div>

        <div v-else style="float:left;" align="center">
            <div> <br> </div>
            <div style="color: #black; font-weight: bold; font-size: 30px"> 
            {{ loginUser.userPokectmonName }}
            </div> 
            <img :src = "loginUser.userPokectmonUrl" width = "300" height = "300"> 
        </div>
        <br>
        <br>
        <br>
        <div class = "todotext" style="float:left;">
            <span class = "todos">
            오늘의 할일
            </span>
            <button class="todobtn" @click="plus"> 추가 </button>
            <div v-for="todo in todolist" :key="todo.todolistSeq" class="todo-item">
              <span v-if="todo.todolistGoalCheck" class="completed">
                <del>{{ todo.todolistGoal }}</del>
              </span>
              <span v-else class="not-completed">
                <span>{{ todo.todolistGoal }}</span>
              </span>
              
              <button class="maketodo complete-btn" @click="updateTodo(todo)">완료</button> 
              <button class="maketodo delete-btn" @click="deleteTodo(todo.todolistSeq)">삭제</button> 
            </div>
            <br>
            <br>
            <br>
            <br>
            <div>
                당신의 운동량은 총 {{ loginUser.userTotalCalorie }} 칼로리 입니다!
            </div>

            <div class="experience-bar">
              <div class="experience-bar-fill" :style="fillWidth"></div>
              <div class="experience-bar-info">
              <span>{{ loginUser.userTotalCalorie }} / {{ maxExperience }}</span>
              </div>
            </div>

            <button @click="updatecal">칼로리 입력하기</button> 
          </div>
          <br>
          <br>

      </fieldset>
    </div>
  </div>
</template>
<script>
//import { mapState } from "vuex";
import { mapGetters } from "vuex";

export default {
  name: "UserPoketmon",
  data() {
    return {
      
      todoSeq : 0,
      tmptodo:[],
      tmpcal: 0,
      beforecal: 0,
      todo: {},
      maxExperience:500,
    };
  },
  methods: {
    updatecal() {
    //console.log(this.userId);
    var a = Number(prompt("오늘의 운동량을 입력해 주세요", ""));
    if(a===""){
          alert("1글자 이상 입력해주세요");          
      }

    if(a){
    
    this.beforecal=this.loginUser.userTotalCalorie ;
    this.$store.dispatch("UpdateCal",a);

    
    if(this.beforecal<500 && this.beforecal+a>=500){
      //console.log(this.beforecal);
      //console.log(this.beforecal+a);
      if(confirm("어랏?! 알이 이상하다")==true){
        this.$router.go();
      }else{
        this.$router.go();
      }
    }else if(this.beforecal<10000 && this.beforecal+a>=10000){
      if(confirm("어랏?! 포켓몬이 이상하다")==true){
        this.$router.go();
      }else{
        this.$router.go();
      }
    }else{
      this.$router.go();
    }
    
    
    }

    },
  plus() {
      //console.log(this.userId);
      var a = prompt("매일의 목표를 입력해주세요", "");
      if(a===""){
          alert("1글자 이상 입력해주세요");          
      }

      if(a){
      this.$store.dispatch("AddTodoList",a);
      this.$store.dispatch("getTodolist");
      this.$router.go();
      }

    },
  
    deleteTodo(todoSeq) {
      this.$store.dispatch("DeleteTodo",todoSeq);
      this.$store.dispatch("getTodolist");
      this.$router.go();
  
    },

    updateTodo(todo) {
      //console.log(todo);
      this.$store.dispatch("UpdateTodo",todo);
      this.$store.dispatch("getTodolist");
      this.$router.go();

    },
  },
  computed: {
    ...mapGetters(["loginUser"]),
    ...mapGetters(["todolist"]),
    fillWidth() {
      return {
        width: `${(this.loginUser.userTotalCalorie/ this.maxExperience) * 100}%`,
      };
    },
    
    
  },


  mounted(){
      this.tmpcal = this.loginUser.userTotalCalorie;
      this.$store.dispatch("updateLoginUser");
     

  },
  created() {
  this.$store.dispatch("getTodolist");
},

watch: {
    loginUser() {
      if (this.loginUser.userTotalCalorie <500) {
        this.maxExperience = 500;
      }else if(this.loginUser.userTotalCalorie >=500 && this.loginUser.userTotalCalorie <10000){
        this.maxExperience = 10000;
      }else{
        this.maxExperience = 100000000;
      }
      //console.log(newMsg);
    },
  },
  
};
</script>
<style>
.experience-bar {
  width: 200px;
  height: 20px;
  background-color: #ccc;
}

.experience-bar-fill {
  height: 100%;
  background-color: #00aaff;
}

.experience-bar-info {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  color: #fff;
  font-weight: bold;
}

.todotext {
  margin: auto;
}
.todos {
  font-size: 32px;
  font-weight: bold;
  color: #333;
  margin-right: 8px;
}

.todobtn {
  padding: 8px 16px;
  background-color: #00aaff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
}

.todobtn:hover {
  background-color: #0099dd;
}
.todo-item {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
}

.completed {
  text-decoration: line-through;
  color: #888;
}

.not-completed {
  color: #333;
}

.maketodo {
  padding: 4px 8px;
  background-color: #00aaff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 8px;
}

.complete-btn {
  background-color: #00cc00;
}

.delete-btn {
  background-color: #ff0000;
}

.maketodo:hover {
  background-color: #0099dd;
}

.text-center2 {
  
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
}
.container{
  background-color: white;
  border: 5px solid #000;
  border-radius: 10px;

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

