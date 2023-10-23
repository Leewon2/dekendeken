<template>
  <div class="ArticleListContainer">
    <br /><br /><br />
    <ArticleSearch></ArticleSearch>
    <br /><br /><br />
    <div class="MainArticleList">
      <table id="article-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 50%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일자</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(article, index) in articles" :key="index">
            <td align="center">{{ index + 1 }}</td>
            <td align="center">
              <router-link
                :to="{
                  path: '/article/articleDetail',
                  query: { articleSeq: article && article.articleSeq },
                }"
                >{{ article && article.articleTitle }}
              </router-link>
            </td>
            <!-- <td align="center">{{ article.articleContent }}</td> -->
            <td align="center">{{ article && article.articleWriter }}</td>
            <td align="center">
              {{ article && formatDate(article.articleCreatedAt) }}
            </td>
            <!-- <td align="center">{{article &&  article.articleViewCnt }}</td> -->
          </tr>
        </tbody>
      </table>
    </div>
    <br /><br />
    <div class="articleregist">
      <router-link
        class="articlelistbtnright"
        :to="{
          path: '/article/articleWrite',
          query: { articleWriter: loginUser.userId },
        }"
        >게시글 등록
        <!-- <ArticleWrite></ArticleWrite> -->
      </router-link>
    </div>
  </div>
</template>

<script>
import ArticleSearch from "./ArticleSearch.vue";
// import ArticleWrite from "./ArticleWrite.vue";
import { mapGetters, mapState } from "vuex";
export default {
  name: "ArticleList",
  data() {
    return {
      // videoSeq: 0,
    };
  },

  computed: {
    ...mapGetters(["articles"]),
    ...mapState(["loginUser"]),
  },

  components: {
    ArticleSearch,
    // ArticleWrite,
  },

  methods: {
    formatDate(timestamp) {
      const date = new Date(timestamp);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      return `${year}-${month}-${day}`;
    },
  },

  // watch:{
  //   articles() {
  //     this.$store.dispatch("getArticles");
  //   },
  // },

  created() {
    this.$store.dispatch("getArticles");
  },
};
</script>

<style>
.ArticleListContainer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#article-list {
  border-collapse: collapse;
  width: 100%;
}

#article-list thead {
  background-color: #ccc;
  font-weight: bold;
}

#article-list td,
#article-list th {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
  font-size: 20px;
}

.MainArticleList {
  padding-left: 5%;
  width: 100%;
}

.articleregist {
  font-size: 30px;
  text-align: right;
  width: 91%;
  margin-top: 20px;
}

.articlelistbtnright {
  display: block;
  width: 100%;
  text-align: right;
}
</style>
