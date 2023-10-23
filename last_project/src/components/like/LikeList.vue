<template>
  <div class="LikeListPagecontainer">
    <br />
    <h2 class="LikeVideoList">내가 좋아요한 동영상</h2>
    <VideoSearch></VideoSearch>
    <br />
    <br />
    <div v-if="selectedVideo && heartClick" class="playvideo001">
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

    <div v-if="likelist == ''" class="nolikevideo">
      좋아요한 동영상이 없습니다. <br /><br /><br /><br /><br />
    </div>
    <div v-else>
      <div v-for="(thumbnail, index) in videoURL.thumbnails" :key="thumbnail">
        <div v-if="checkLike(videoURL.videoSeqs[index])">
          <div class="video-item001">
            <div class="sort00001">
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
                  heartClick = true;
                  clickVideo(
                    videoURL.videoSeqs[index],
                    videoURL.viewCnts[index]++
                  );
                "
              />
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <span
                @click.stop="
                  heartClick = false;
                  deleteLike(videoURL.videoSeqs[index]);
                "
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="50"
                  height="50"
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
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <span class="fffont001">
                제목 : {{ truncateTitle(videoURL.titles[index], 30) }}

                <div class="ffont001">
                  조회수 :
                  {{ videoURL.viewCnts[index] }}
                </div>
              </span>
            </div>
          </div>

          <!-- 여기에서 v-if 써서 , this.likelist에 아이디랑 seq포함되어 있는지 확인 -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import VideoComment from "../videocomment/VideoComment.vue";
import VideoSearch from "@/components/video/VideoSearch.vue";

export default {
  name: "LikeList",
  components: {
    VideoComment,
    VideoSearch,
  },

  data() {
    return {
      videoSeq: 0,
      viewCnt: 0,
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
      //   location.reload();
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
    videoURL() {
      const viewCnts = [];
      const thumbnails = [];
      const titles = [];
      const videoSeqs = [];
      for (let i = 0; i < this.videos.length; i++) {
        const thumbnailId = this.videos[i].videothumbnail;
        const title = this.videos[i].videoTitle;
        const videoSeq = this.videos[i].videoSeq;
        const viewCnt = this.videos[i].viewCnt;

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
  },
};
</script>

<style>
.sort00001 {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.LikeListPagecontainer {
  background-color: beige;
  padding-left: 10%;
  padding-right: 5%;
}

.LikeVideoList {
  font-size: 50px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  padding-bottom: 3%;
  font-family: 'TTWanjudaedunsancheB';
}

.playvideo001 {
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

.video-item001 {
  display: flex;
  flex-direction: row;
  align-items: left;
  text-align: left;
  margin-right: 20px !important;
  padding-top: 1%;
  padding-left: -5%;
  width: 500px;
}

.video-item001 img {
  border: 2px solid black;
}

.ffont001 {
  width: 300px;
  font-size: 17px;
  display: flex;
  flex-direction: column;
  align-items: left;
  text-align: left;
  white-space: normal;
  overflow: hidden;
  text-overflow: ellipsis;
  max-width: 250px;
}

.fffont001 {
  text-align: left;
  font-size: 20px;
}

.nolikevideo {
  font-size: 30px;
  align-items: center;
  text-align: center;
}
@font-face {
    font-family: 'TTWanjudaedunsancheB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-2@1.0/TTWanjudaedunsancheB.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}
</style>
