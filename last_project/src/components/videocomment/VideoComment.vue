<template>
  <div class="videoCommentContainer">
    <br />
    <h2>댓글</h2>
    <br />

    <ul
      class="videocommentul"
      v-for="videoComment in videocomments"
      :key="videoComment.commentSeq"
    >
      <li>
        <br />
        &nbsp;&nbsp;&nbsp;{{ videoComment.commentUserId }}

        &nbsp;&nbsp;&nbsp;
        {{ formatDate(videoComment.commentJoinedAt) }}
      </li>
      <hr class="booo" />
      &nbsp;&nbsp;
      {{
        videoComment.commentContent
      }}
      <li class="videoCommentupdate">
        <span v-if="videoComment.commentUserId === commentUserId">
          <VideoCommentUpdate
            class="videocommentup"
            :commentVideoSeq="commentVideoSeq"
            :videoComment="videoComment"
          ></VideoCommentUpdate>
          &nbsp;&nbsp;
          <VideoCommentDelete
            class="videocommentdel"
            :commentVideoSeq="commentVideoSeq"
            :commentSeq="videoComment.commentSeq"
          ></VideoCommentDelete>
          &nbsp;&nbsp;
        </span>
      </li>
      <br />
    </ul>
    <br /><br />
    <div v-if="this.commentUserId !== null">
      <input
        placeholder="댓글을 입력해 주세요"
        class="videocommentinput"
        type="text"
        v-model="commentContent"
        @keyup.enter="writeComment"
      />
      &nbsp;&nbsp;
      <button class="videocommentbtn" @click="writeComment">댓글 등록</button>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import VideoCommentDelete from "./VideoCommentDelete.vue";
import VideoCommentUpdate from "./VideoCommentUpdate.vue";
export default {
  name: "VideoComment",

  components: {
    VideoCommentDelete,
    VideoCommentUpdate,
  },

  data() {
    return {
      commentSeq: 0,
      commentContent: null,
      // commentVideoSeq:this.video.videoSeq,
      commentUserId: null,
      commentJoinedAt: null,
    };
  },

  props: {
    commentVideoSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    // ExistLoginUser() {
    //   return this.commentUserId !== null;
    // },
    writeComment() {
      // console.log(this.loginUser.userId + "현재 로그인한 유저 아이디 나오냐");
      let comment = {
        commentSeq: this.commentSeq,
        commentUserId: this.commentUserId,
        commentContent: this.commentContent,
        commentVideoSeq: this.commentVideoSeq,
        commentJoinedAt: Date(),
      };
      if (this.commentContent === null) {
        alert("댓글을 입력하세요");
      } else {
        this.$store.dispatch("writeVideoComments", comment);
        this.commentContent = "";

        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
        this.$store.dispatch("getVideoComments", this.commentVideoSeq);
      }

      // this.$router.go();
    },

    getVideoComments() {
      this.$store.dispatch("getVideoComments", this.commentVideoSeq);
    },
    //   clickVideo(videoSeq) {
    //     this.videoSeq = videoSeq;
    //     this.$store.dispatch("clickVideo", this.videoSeq);
    //   },

    formatDate(timestamp) {
      const date = new Date(timestamp);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      return `${year}-${month}-${day}`;
    },
  },

  computed: {
    ...mapGetters(["videocomments"], ["video"]),
    ...mapState(["loginUser"]),

    // // const videoSeq = this.video.videoSeq;
    // // this.commentVideoSeq = videoSeq;
    // this.$store.dispatch("getVideoComments", this.commentVideoSeq);
  },

  watch: {
    commentVideoSeq(newVal) {
      this.getVideoComments(newVal);
    },
  },

  mounted() {
    this.getVideoComments();
    // console.log(JSON.stringify(this.video) + " video콘솔");
    // if (this.video && this.video.videoSeq) {
    //   this.$store.dispatch("getVideoComments", this.video.videoSeq);
    //   console.log("성공");
    // }
    if (this.loginUser !== null) {
      this.commentUserId = this.loginUser.userId;
    }
    console.log(this.loginUser);
  },
};
</script>

<style>
.videocommentinput {
  border: 1px solid black;
  /* outline-color: black;
  caret-color: black; */

  /* background-color: aqua; */
  height: 50px;
  width: 600px;
}
.videocommentbtn {
  border: 1px solid black;
  background-color: aquamarine;
  height: 50px;
  width: 100px;
}
.videocommentul {
  border: 1px solid black;
  list-style: none;
}

.videoCommentupdate {
  justify-content: right;
  align-items: right;
  text-align: right;
}

.videocommentup {
  color: blue;
}

.videocommentdel {
  color: red;
}

.booo {
  border: none;
  height: 1px;
  background-color: black;
}
</style>
