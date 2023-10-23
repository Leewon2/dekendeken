<template>
  <div class="ArticleDetailContainer">
    <br /><br /><br /><br />
    <div class="ArticleName">게시판</div>
    <br /><br />
    <div v-if="article">
      <div class="articledetail">
        <br />

        <div class="titlecontent">{{ article.articleTitle }}</div>
        <hr class="boo" />

        <div class="titlecontent">{{ article.articleWriter }}</div>

        <hr class="boo" />

        <div class="titlecontent">
          <strong>작성일 : </strong>
          {{ formatDate(article.articleCreatedAt) }}
        </div>
        <hr class="boo" />

        <div class="titlecontent">{{ article.articleContent }}</div>
        <br />
      </div>

      <div class="btnright">
        <button
          class="articledetailbtn"
          v-if="loginUser.userId === article.articleWriter"
          @click="openModal()"
        >
          수정
        </button>
      </div>

      <!-- <ArticleDelete :articleSeq="article.articleSeq"></ArticleDelete> -->
      <br /><br />
      <div v-if="isModalOpen">
        <ArticleUpdate
          :articleSeq="article.articleSeq"
          :articleWriter="article.articleWriter"
          :isModalOpen.sync="isModalOpen"
        ></ArticleUpdate>
      </div>
    </div>
    <br /><br /><br />
    <ArticleComment :commentArticleSeq="article.articleSeq"></ArticleComment>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import ArticleComment from "@/components/articlecomment/ArticleComment.vue";
import ArticleUpdate from "./ArticleUpdate.vue";
// import ArticleDelete from "./ArticleDelete.vue";
export default {
  name: "ArticleList",
  data() {
    return {
      isModalOpen: false,
      //  articles:[],
    };
  },

  methods: {
    openModal() {
      this.isModalOpen = true;
    },
    formatDate(timestamp) {
      const date = new Date(timestamp);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      return `${year}-${month}-${day}`;
    },
  },

  computed: {
    ...mapState(["loginUser"]),
    ...mapGetters(["article"], ["articles"]),
  },

  components: {
    ArticleComment,
    ArticleUpdate,
    // ArticleDelete,
  },

  watch: {
    articles() {
      this.$store.dispatch("getArticles");
    },
  },

  created() {
    console.log(this.$route.query.articleSeq);
    this.$store.dispatch("getArticle", this.$route.query.articleSeq);
  },
};
</script>

<style>
.ArticleDetailContainer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.articledetail {
  border: 1px solid black;
  border-radius: 10px;
  font-size: 25px;
  width: 1200px;
  /* 원하는 최대 너비 설정 */
  height: auto;
}

.titlecontent {
  padding-left: 2%;
}

.boo {
  border: none;
  height: 1px;
  background-color: black;
}

.ArticleName {
  font-size: 50px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding-bottom: 3%;
  font-family: "TTWanjudaedunsancheB";
}

@font-face {
  font-family: "TTWanjudaedunsancheB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/TTWanjudaedunsancheB.woff2")
    format("woff2");
  font-weight: 700;
  font-style: normal;
}

.articledetailbtn {
  border: 1px solid black;
  height: 50px;
  width: 100px;
  background-color: aqua;
}

.btnright {
  text-align: right;
}
</style>
