<template>
  <span>
    <button @click="deleteVideoComment">삭제</button>
  </span>
</template>

<script>
export default {
  name: "VideoCommentDelete",

  data() {
    return {};
  },

  props: {
    commentSeq: {
      type: Number,
      required: true,
    },
    commentVideoSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    deleteVideoComment() {
      this.$store.dispatch("deleteVideoComment", this.commentSeq);
      this.$store.dispatch("getVideoComments", this.commentVideoSeq);
      this.$store.dispatch("getVideoComments", this.commentVideoSeq);
      this.$store.dispatch("getVideoComments", this.commentVideoSeq);
    },
  },
};
</script>

<style></style>
