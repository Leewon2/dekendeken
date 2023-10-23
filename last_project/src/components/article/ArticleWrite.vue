<template>
  <div class="ArticleWriterContainer">
    <br /><br /><br /><br /><br /><br />
    <fieldset>
      <div>
        <label class="fontsizetitle">제목</label>
        <input type="text" v-model="articleTitle" class="ArticleWriteTitle" />
      </div>
      <br />
      <br />
      <div>
        <label class="fontsizecontent">내용</label>
        <input
          type="textarea"
          v-model="articleContent"
          class="ArticleWriteContent"
        />
      </div>
      <br />
      <div class="articleWriteregist">
        <button class="ArticleWriteBTN" @click="ArticleRegist">
          게시글 등록
        </button>
      </div>
    </fieldset>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ArticleWrite",

  components: {},

  data() {
    return {
      articleContent: null,
      articleTitle: null,
    };
  },

  methods: {
    ArticleRegist() {
      // console.log(this.loginUser.userId + "현재 로그인한 유저 아이디 나오냐");
      let comment = {
        articleWriter: this.loginUser.userId,
        articleTitle: this.articleTitle,
        articleContent: this.articleContent,
      };

      this.$store.dispatch("ArticleRegist", comment);

      this.$store.dispatch("getArticles");
    },
  },

  computed: {
    ...mapState(["loginUser"]),
  },
};
</script>

<style>
.ArticleWriteTitle {
  font-size: 35px;
  width: 50%;
  height: 100%;
  border: 1px solid black;
}

.ArticleWriteContent {
  font-size: 35px;
  width: 50%;
  height: 600px;
  border: 1px solid black;
}

.ArticleWriterContainer {
  display: flex;
  flex-direction: column;
  justify-content: left;
  align-items: left;
  padding-left: 15%;
}

.fontsizetitle {
  font-size: 35px;
}

.fontsizecontent {
  font-size: 35px;
}

.ArticleWriteBTN {
  border: 1px solid black;
  height: 50px;
  width: 150px;
  background-color: aqua;
}

.articleWriteregist {
  font-size: 20px;
  text-align: right;
  width: 57%;
  margin-top: 20px;
}
</style>
