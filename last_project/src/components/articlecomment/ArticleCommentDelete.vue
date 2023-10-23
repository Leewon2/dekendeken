<template>
  <span>
    <button @click="deleteArticleComment">삭제</button>
  </span>
</template>

<script>
export default {
  name: "ArticleCommentDelete",

  data() {
    return {};
  },

  props: {
    commentSeq: {
      type: Number,
      required: true,
    },
    commentArticleSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    deleteArticleComment() {
      let check = confirm("삭제하시겠습니까?");
      if (check) {
        this.$store.dispatch("deleteArticleComment", this.commentSeq);
      }
      location.reload();
    },
  },
};
</script>

<style></style>
