<template>
  <div class="sort1">
    <input
      placeholder="검색어를 입력해 주세요"
      class="input1"
      type="text"
      v-model="keyword"
      @keyup.enter="search"
    />
    &nbsp;&nbsp;
    <button class="btn1" @click="search">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="20"
        height="20"
        fill="green"
        class="bi bi-search"
        viewBox="0 0 16 16"
      >
        <path
          d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"
        />
      </svg>
    </button>
  </div>
</template>

<script>
// import { mapGetters } from "vuex";
export default {
  name: "VideoSearch",
  data() {
    return {
      keyword: "",
    };
  },
  methods: {
    search() {
      this.$store.dispatch("searchVideo", this.keyword);
    },
  },
};
</script>

<style>
.input1 {
  border: 1px solid black;
  /* outline-color: black;
  caret-color: black; */
  font-size: 30px;

  /* background-color: aqua; */
  height: 50px;
  width: 600px;
}

.btn1 {
  border: 1px solid black;
  height: 50px;
  width: 100px;
}

.sort1 {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
