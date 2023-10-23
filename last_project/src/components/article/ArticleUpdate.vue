<template>
  <div>
    <fieldset class="text-center">
      <input
        placeholder="변경할 제목을 입력 해주세요"
        class="input100"
        type="text"
        v-model="articleTitle"
      />
      <br />

      <input
        placeholder="변경할 내용을 입력 해주세요"
        class="input1000"
        type="text"
        v-model="articleContent"
        @keyup.enter="ArticleUpdate"
      />
      <br />
      <div class="articleupdatebtn">
        <button class="articleupdatebtn2" @click="ArticleUpdate">수정</button>
        &nbsp;&nbsp;
        <button class="articleupdatebtn22" @click="closeModal">취소</button>
      </div>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: "ArticleUpdate",

  data() {
    return {
      articleTitle: "",
      articleContent: "",
    };
  },
  props: {
    isModalOpen: {
      type: Boolean,
      required: true,
    },
    articleWriter: {
      type: String,
      required: true,
    },
    articleSeq: {
      type: Number,
      required: true,
    },
  },

  methods: {
    ArticleUpdate() {
      let updatearticle = {
        articleTitle: this.articleTitle,
        articleContent: this.articleContent,
        articleWriter: this.articleWriter,
        articleSeq: this.articleSeq,
      };
      let check = confirm("수정하시겠습니까?");
      if (check) {
        this.$store.dispatch("articleUpdate", updatearticle);
      }
      location.reload();
    },
    closeModal() {
      this.$emit("update:isModalOpen", false);
    },
  },
};
</script>

<style>
.input100 {
  border: 1px solid black;
  /* outline-color: black;
  caret-color: black; */
  font-size: 30px;

  /* background-color: aqua; */
  height: 50px;
  width: 1200px;
}

.input1000 {
  border: 1px solid black;
  /* outline-color: black;
  caret-color: black; */
  font-size: 30px;

  /* background-color: aqua; */
  height: 150px;
  width: 1200px;
}

.articleupdatebtn2 {
  border: 1px solid black;
  height: 50px;
  width: 100px;
  background-color: cyan;
}

.articleupdatebtn22 {
  border: 1px solid black;
  height: 50px;
  width: 100px;
  background-color: brown;
}

.articleupdatebtn {
  text-align: right;
}
</style>
