<template>
  <div class="videoListPagecontainer">
    <br />
    <br />
    <br />
    <br />
    <h2 class="allVideoList">전체 영상</h2>
    <VideoSearch></VideoSearch>
    <br /><br />
    <div v-if="selectedVideo" class="playvideo2">
      <iframe
        width="80%"
        height="500"
        :src="selectedVideoUrl"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen
      ></iframe>

      <VideoComment :commentVideoSeq="videoSeq"></VideoComment>
    </div>

    <ul class="sort3">
      <li
        class="video-item2"
        v-for="(thumbnail, index) in videoURL.thumbnails"
        :key="thumbnail"
      >
        <span class="thumbnail2">
          <br />
          <img
            width="500"
            height="250"
            :src="thumbnail"
            :alt="thumbnail"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen
            @click.stop="
              // heartClick = true;
              clickVideo(videoURL.videoSeqs[index], videoURL.viewCnts[index]++)
            "
          />
          <br />
          <span
            v-if="!checkLike(videoURL.videoSeqs[index])"
            @click.stop="insertLike(videoURL.videoSeqs[index])"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="30"
              height="30"
              fill="red"
              class="bi bi-heart"
              viewBox="0 0 16 16"
            >
              <path
                d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
              />
            </svg>
          </span>

          <span
            v-else
            @click.stop="
              // heartClick = false;
              deleteLike(videoURL.videoSeqs[index])
            "
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="30"
              height="30"
              fill="red"
              class="bi bi-heart-fill"
              viewBox="0 0 16 16"
            >
              <path
                fill-rule="evenodd"
                d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"
              />
            </svg>
          </span>
          <!-- 여기에서 v-if 써서 , this.likelist에 아이디랑 seq포함되어 있는지 확인 -->
          <br />
          <span class="video-title2 fffont2">
            제목 : {{ truncateTitle(videoURL.titles[index], 30) }}
          </span>
          <br />
          <div class="ffont2">
            조회수 :
            {{ videoURL.viewCnts[index] }}
          </div>
        </span>
      </li>
    </ul>
    <br />

    <nav class="sssooorrrttt">
      <ul class="pagination">
        <li class="page-item">
          <a
            class="page-link"
            href="#"
            @click="changePage(currentPage - 1)"
            :disabled="currentPage === 1"
          >
            이전
          </a>
        </li>
        <li
          class="page-item"
          v-for="page in totalPages"
          :key="page"
          :class="{ active: page === currentPage }"
        >
          <a class="page-link" href="#" @click="changePage(page)">{{ page }}</a>
        </li>
        <li class="page-item">
          <a
            class="page-link"
            href="#"
            @click="changePage(currentPage + 1)"
            :disabled="currentPage === totalPages"
          >
            다음
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import VideoComment from "../videocomment/VideoComment.vue";
import VideoSearch from "./VideoSearch.vue";

export default {
  name: "VideoList",
  components: {
    VideoComment,
    VideoSearch,
  },

  data() {
    return {
      videoSeq: 0,
      viewCnt: 0,
      PageCnt: 9,
      currentPage: 1,
    };
  },

  methods: {
    truncateTitle(title, maxLength) {
      if (title.length > maxLength) {
        return title.substring(0, maxLength) + "...";
      }
      return title;
    },
    changePage(pageNumber) {
      this.currentPage = pageNumber;
    },
    checkLike(videoSeq) {
      // this.videoSeq = videoSeq;

      for (let i = 0; i < this.likelist.length; i++) {
        if (this.likelist[i].likeVideoSeq == videoSeq) {
          return true;
        }
      }

      return false;
    },

    insertLike(videoSeq) {
      this.videoSeq = videoSeq;

      let a = {
        videoSeq: this.videoSeq,
        loginUser: this.loginUser.userId,
      };

      this.$store.dispatch("insertLike2", a);
      this.$store.dispatch("getLikeList", this.loginUser.userId);
      this.$store.dispatch("getLikeList", this.loginUser.userId);
      this.$store.dispatch("getLikeList", this.loginUser.userId);
      // location.reload();
    },

    deleteLike(videoSeq) {
      this.videoSeq = videoSeq;

      let a = {
        videoSeq: this.videoSeq,
        loginUser: this.loginUser.userId,
      };

      this.$store.dispatch("deleteLike2", a);
      // location.reload();
      this.$store.dispatch("getLikeList", this.loginUser.userId);
      this.$store.dispatch("getLikeList", this.loginUser.userId);
      this.$store.dispatch("getLikeList", this.loginUser.userId);
    },

    clickVideo(videoSeq, viewCnt) {
      console.log(videoSeq, viewCnt);
      this.videoSeq = videoSeq;
      this.viewCnt = viewCnt;
      this.$store.dispatch("clickVideo", this.videoSeq);
      let a = {
        videoSeq: this.videoSeq,
        viewCnt: this.viewCnt,
      };
      this.$store.dispatch("increaseViewCnt", a);
    },
  },

  computed: {
    ...mapGetters(["videos", "likelist"]),
    ...mapState(["video", "loginUser"]),
    totalPages() {
      return Math.ceil(this.videos.length / this.PageCnt);
    },
    getCurrentPageVideos() {
      const startIndex = (this.currentPage - 1) * this.PageCnt;
      const endIndex = startIndex + this.PageCnt;
      return this.videos.slice(startIndex, endIndex);
    },

    videoURL() {
      const viewCnts = [];
      const thumbnails = [];
      const titles = [];
      const videoSeqs = [];
      const currentPageVideos = this.getCurrentPageVideos; // 현재 페이지에 해당하는 데이터 가져오기

      for (let i = 0; i < currentPageVideos.length; i++) {
        const video = currentPageVideos[i];
        const thumbnailId = video.videothumbnail;
        const title = video.videoTitle;
        const videoSeq = video.videoSeq;
        const viewCnt = video.viewCnt;

        const thumbnail = `https://img.youtube.com/vi/${thumbnailId}/maxresdefault.jpg`;
        videoSeqs.push(videoSeq);
        thumbnails.push(thumbnail);
        titles.push(title);
        viewCnts.push(viewCnt);
      }

      return { videoSeqs, thumbnails, titles, viewCnts };
    },
    selectedVideo() {
      console.log(this.videoSeq + "첫번째비디오번호 나와랏");
      return this.videoSeq !== 0;
    },
    // computed는 method보다 먼저 실행되므로, 첫 클릭 시 오류발생
    // 이를 해결하기 위해, video와 video.URL이 null인지 확인 후 return
    selectedVideoUrl() {
      if (this.video && this.video.videoURL) {
        return `https://www.youtube.com/embed/${this.video.videoURL}`;
      } else {
        return "";
      }
    },
  },

  created() {
    if (this.loginUser !== null) {
      this.$store.dispatch("getVideos");
      this.$store.dispatch("getLikeList", this.loginUser.userId);
    }
  },
};
</script>

<style>
.videoListPagecontainer {
  background-color: beige;
  padding-left: 10%;
  padding-right: 5%;
}

.thumbnail2 {
  flex-direction: column;
  padding-top: 5%;
}

.allVideoList {
  font-size: 50px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding-bottom: 3%;
  font-family: 'TTWanjudaedunsancheB';
}

.sort3 {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
}

.video-item2 {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: left;
  margin-right: 20px !important;
  width: 500px;
}
.video-item2 .video-title2 {
  white-space: pre-wrap;
  overflow: hidden;
  text-overflow: ellipsis;
  word-break: break-word;
  width: 100%;
}

.video-item2 img {
  border: 2px solid black;
}

.playvideo2 {
  position: relative;
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 3%;
  padding-bottom: 2%;
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 2px solid black;
  border-radius: 10px;
}

.ffont2 {
  font-size: 20px;
}

.fffont2 {
  font-size: 17px;
}

.pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.page-item {
  display: inline-block;
  margin-right: 5px;
}

.page-item a {
  display: inline-block;
  padding: 5px 10px;
  color: #333;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 3px;
  text-decoration: none;
  cursor: pointer;
}

.page-item a:hover {
  background-color: #f5f5f5;
}

.page-item.active a {
  background-color: #007bff;
  color: #fff;
}

.page-item.disabled a {
  pointer-events: none;
  color: #ccc;
}

.page-item.disabled a:hover {
  background-color: #fff;
}

.sssooorrrttt {
  text-align: center;
}
@font-face {
    font-family: 'TTWanjudaedunsancheB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/TTWanjudaedunsancheB.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}
</style>
