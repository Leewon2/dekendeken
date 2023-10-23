<template>
  <span>
    <button @click="deleteArticle">삭제</button>
  </span>
</template>

<script>
export default {
  name: "ArticleDelete",

  data() {
    return {};
  },

  props: {
    articleSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    deleteArticle() {
      let check = confirm("삭제하시겠습니까?");
      if (check) {
        this.$store.dispatch("articleDelete", this.articleSeq);
      }
    },
  },
};
</script>

<style></style>
