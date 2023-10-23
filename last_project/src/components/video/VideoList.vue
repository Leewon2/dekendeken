<template>
  <div class="videoListcontainer">
    <br />
    <br />
    <br />
    <br />
    <h2 class="popularvideo">금주의 인기영상</h2>
    <br />
    <br />
    <div v-if="selectedVideo" class="playvideo">
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

    <ul class="sort2">
      <li
        class="video-item"
        v-for="(thumbnail, index) in videoURL.thumbnails"
        :key="thumbnail"
      >
        <span class="thumbnail1">
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
          <span v-if="loginUser">
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
          </span>

          <!-- 여기에서 v-if 써서 , this.likelist에 아이디랑 seq포함되어 있는지 확인 -->

          <br />
          <span class="video-title fffont" :title="videoURL.titles[index]">
            <!-- {{ videoURL.titles[index] }} -->
            {{ truncateTitle(videoURL.titles[index], 30) }}
          </span>
          <br />
          <div class="ffont">
            조회수 :
            {{ videoURL.viewCnts[index] }}
          </div>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import VideoComment from "../videocomment/VideoComment.vue";

export default {
  name: "VideoList",
  components: {
    VideoComment,
  },

  data() {
    return {
      videoSeq: 0,
      viewCnt: 0,
      tenVideos: [],
    };
  },

  methods: {
    truncateTitle(title, maxLength) {
      if (title.length > maxLength) {
        return title.substring(0, maxLength) + "...";
      }
      return title;
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

      this.$store.dispatch("getVideos");
      this.$store.dispatch("getVideos");
      this.$store.dispatch("getVideos");
      this.$store.dispatch("getVideos");

      this.$store.dispatch("getLikeList", this.loginUser.userId);
    },
  },

  computed: {
    ...mapGetters(["videos", "likelist"]),
    ...mapState(["video", "loginUser"]),
    videoURL() {
      const viewCnts = [];
      const thumbnails = [];
      const titles = [];
      const videoSeqs = [];
      for (let i = 0; i < this.tenVideos.length; i++) {
        const thumbnailId = this.tenVideos[i].videothumbnail;
        const title = this.tenVideos[i].videoTitle;
        const videoSeq = this.tenVideos[i].videoSeq;
        const viewCnt = this.tenVideos[i].viewCnt;

        const thumbnail = `https://img.youtube.com/vi/${thumbnailId}/maxresdefault.jpg`;
        videoSeqs.push(videoSeq);
        thumbnails.push(thumbnail);
        titles.push(title);
        viewCnts.push(viewCnt);
        // console.log(videoSeqs);
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
    this.tenVideos = this.videos.slice(0, 10);
  },
};
</script>

<style>
.videoListcontainer {
  background-color: beige;
  padding-left: 10%;
  padding-right: 5%;
}

.thumbnail1 {
  flex-direction: column;
}

.popularvideo {
  font-size: 50px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding-bottom: 3%;
  font-family: "TTWanjudaedunsancheB";
}

.sort2 {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
}

.video-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: left;
  margin-right: 20px !important;
  width: 500px;
}
.video-item .video-title {
  white-space: pre-wrap;
  overflow: hidden;
  text-overflow: ellipsis;
  word-break: break-word;
  width: 100%;
}

.video-item img {
  border: 2px solid black;
}

.playvideo {
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

.ffont {
  font-size: 20px;
}

.fffont {
  font-size: 17px;
}
@font-face {
  font-family: "TTWanjudaedunsancheB";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/TTWanjudaedunsancheB.woff2")
    format("woff2");
  font-weight: 700;
  font-style: normal;
}
</style>
