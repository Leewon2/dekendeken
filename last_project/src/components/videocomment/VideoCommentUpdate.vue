<template>
  <span>
    <button @click="updateVideoComment">수정</button>
  </span>
</template>

<script>
export default {
  name: "VideoCommentUpdate",

  data() {
    return {
      commentContent: "",
    };
  },

  props: {
    videoComment: {
      type: Object,
      required: true,
    },
    commentVideoSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    updateVideoComment() {
      var a = prompt("수정할 메세지를 입력해주세요", "");
      let comment = {
        commentSeq: this.videoComment.commentSeq,
        commentContent: a,
        commentUserId: this.videoComment.commentUserId,
        commentJoinedAt: this.videoComment.commentJoinedAt,
      };
      if (a === "") {
        alert("1글자 이상 입력해주세요");
      }

      if (a) {
        let check = confirm("수정하시겠습니까?");

        if (check) {
          console.log(this.videoComment);
          this.$store.dispatch("updateVideoComment", comment);
          this.$store.dispatch("getVideoComments", this.commentVideoSeq);
          this.$store.dispatch("getVideoComments", this.commentVideoSeq);
          this.$store.dispatch("getVideoComments", this.commentVideoSeq);
          this.$store.dispatch("getVideoComments", this.commentVideoSeq);
          this.$store.dispatch("getVideoComments", this.commentVideoSeq);
          this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        }
      }
    },
  },
};
</script>

<style></style>
