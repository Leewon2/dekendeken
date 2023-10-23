<template>
  <div class="ArticleCommentContainer">
    <br />
    <h2>댓글</h2>
    <br />
    <ul
      class="articlecommentul"
      v-for="articleComment in articlecomments"
      :key="articleComment.commentSeq"
    >
      <li>
        &nbsp;&nbsp;&nbsp;
        <br />
        {{ articleComment.commentUserId }}
        &nbsp;&nbsp;&nbsp;
        {{ formatDate(articleComment.commentJoinedAt) }}
      </li>
      <hr class="boooo" />
      &nbsp;&nbsp;&nbsp;
      {{
        articleComment.commentContent
      }}
      <li class="articlecommentupdate">
        <span v-if="articleComment.commentUserId === commentUserId">
          <ArticleCommentUpdate
            class="articlecommentup"
            :commentArticleSeq="commentArticleSeq"
            :articleComment="articleComment"
          ></ArticleCommentUpdate>
          &nbsp;&nbsp;
          <ArticleCommentDelete
            class="articlecommentdel"
            :commentArticleSeq="commentArticleSeq"
            :commentSeq="articleComment.commentSeq"
          ></ArticleCommentDelete>
          &nbsp;&nbsp;
        </span>
      </li>
      <br />
    </ul>
    <br /><br />
    <div v-if="this.commentUserId !== null">
      <input
        placeholder="댓글을 입력해 주세요"
        class="articlecommentinput"
        v-model="commentContent"
        @keyup.enter="writeArticleComment"
        type="text"
      />
      &nbsp;&nbsp;
      <button class="articlecommentbtn" @click="writeArticleComment">
        댓글 등록
      </button>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import ArticleCommentDelete from "./ArticleCommentDelete.vue";
import ArticleCommentUpdate from "./ArticleCommentUpdate.vue";
export default {
  name: "ArticleComment",

  components: {
    ArticleCommentDelete,
    ArticleCommentUpdate,
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
    commentArticleSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    // ExistLoginUser() {
    //   return this.commentUserId !== null;
    // },
    writeArticleComment() {
      // console.log(this.loginUser.userId + "현재 로그인한 유저 아이디 나오냐");
      let comment = {
        commentSeq: this.commentSeq,
        commentUserId: this.commentUserId,
        commentContent: this.commentContent,
        commentArticleSeq: this.commentArticleSeq,
        commentJoinedAt: Date(),
      };
      if (this.commentContent === null) {
        alert("댓글을 입력하세요");
      } else {
        this.$store.dispatch("writeArticleComments", comment);
        this.commentContent = "";

        this.$store.dispatch("getArticleComments", this.commentArticleSeq);
        this.$store.dispatch("getArticleComments", this.commentArticleSeq);
        this.$store.dispatch("getArticleComments", this.commentArticleSeq);
        this.$store.dispatch("getArticleComments", this.commentArticleSeq);
        this.$store.dispatch("getArticleComments", this.commentArticleSeq);
        this.$store.dispatch("getArticleComments", this.commentArticleSeq);
      }

      // this.$router.go();
    },

    getArticleComments() {
      this.$store.dispatch("getArticleComments", this.commentArticleSeq);
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
    ...mapGetters(["articlecomments"], ["article"]),
    ...mapState(["loginUser"]),
  },

  watch: {
    commentArticleSeq(newVal) {
      this.getArticleComments(newVal);
    },
  },

  mounted() {
    this.getArticleComments();

    if (this.loginUser !== null) {
      this.commentUserId = this.loginUser.userId;
    }
    console.log(this.loginUser);
  },
};
</script>

<style>
.articlecommentinput {
  border: 1px solid black;
  height: 50px;
  width: 600px;
}
.articlecommentbtn {
  border: 1px solid black;
  background-color: aquamarine;
  height: 50px;
  width: 100px;
}
.articlecommentul {
  border: 1px solid black;
  list-style: none;
  width: 900px;
  border-radius: 10px;
}

.articlecommentupdate {
  justify-content: right;
  align-items: right;
  text-align: right;
}
.articlecommentup {
  color: gold;
}

.articlecommentdel {
  color: red;
}

.boooo {
  border: none;
  height: 1px;
  background-color: black;
}
</style>
