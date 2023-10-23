<template>
  <span>
    <button @click="updateArticleComment">수정</button>
  </span>
</template>

<script>
export default {
  name: "ArticleCommentUpdate",

  data() {
    return {
      commentContent: "",
    };
  },

  props: {
    articleComment: {
      type: Object,
      required: true,
    },
    commentArticleSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    updateArticleComment() {
      var a = prompt("수정할 메세지를 입력해주세요", "");
      let comment = {
        commentSeq: this.articleComment.commentSeq,
        commentContent: a,
        commentUserId: this.articleComment.commentUserId,
        commentJoinedAt: this.articleComment.commentJoinedAt,
      };
      if (a === "") {
        alert("1글자 이상 입력해주세요");
      }

      if (a) {
        let check = confirm("수정하시겠습니까?");

        if (check) {
          console.log(this.articleComment);
          this.$store.dispatch("updateArticleComment", comment);
          location.reload();
        }
      }
    },
  },
};
</script>

<style></style>
