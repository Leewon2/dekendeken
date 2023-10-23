<template>
  <div class="ArticleSearchSort">
    <input
      placeholder="검색어를 입력해 주세요"
      class="input3"
      type="text"
      v-model="keyword"
      @keyup.enter="articlesearch"
    />
    &nbsp;&nbsp;
    <button class="ArticleSearchBtn1" @click="articlesearch">검색</button>
  </div>
</template>

<script>
export default {
  name: "ArticleSearch",
  data() {
    return {
      keyword: "",
    };
  },
  methods: {
    articlesearch() {
      if (this.keyword === "") {
        alert("검색어를 입력해주세요");
      } else {
        this.$store.dispatch("searchArticle", this.keyword);
      }
    },
  },
};
</script>

<style>
.ArticleSearchSort {
  display: flex;
  justify-content: center;
  align-items: center;
}

.input3 {
  border: 1px solid black;
  /* outline-color: black;
  caret-color: black; */
  font-size: 30px;

  /* background-color: aqua; */
  height: 50px;
  width: 600px;
}

.ArticleSearchBtn1 {
  border: 1px solid black;
  height: 50px;
  width: 100px;
}
</style>
