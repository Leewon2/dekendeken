import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "../router";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    users: [],
    // user: {},
    loginUser: null,
    //randomUser: null,
    videos: [],

    video: null,

    videocomments: [],

    articlecomments: [],

    todolist: [],

    likelist: [],

    neighborlist: [],

    msglist: [],

    articles: [],

    article: null,

    blacklist: [],
  },
  getters: {
    articlecomments(state) {
      return state.articlecomments;
    },

    articles(state) {
      return state.articles;
    },

    article(state) {
      return state.article;
    },

    loginUser(state) {
      return state.loginUser;
    },

    videos(state) {
      return state.videos;
    },

    video(state) {
      return state.video;
    },

    videocomments(state) {
      return state.videocomments;
    },
    todolist(state) {
      return state.todolist;
    },

    likelist(state) {
      return state.likelist;
    },
    neighborlist(state) {
      return state.neighborlist;
    },
    msglist(state) {
      return state.msglist;
    },

    blacklist(state) {
      return state.blacklist;
    },

    // userCnt: function (state) {
    //   return state.users.length;
    // },
    // searchUserCnt: function (state) {
    //   return state.searchUsers.length > 0 ? state.searchUsers.length : null;
    // },
  },
  mutations: {
    CREATE_USER: function (state, user) {
      state.users.push(user);
    },
    // SET_USERS: function (state, users) {
    //   state.users = users;
    // },
    // SET_USER: function (state, user) {
    //   state.user = user;
    // },
    // SEARCH_NAME: function (state, users) {
    //   state.searchUsers = users;
    // },
    SET_LOGIN_USER: function (state, user) {
      state.loginUser = user;
      console.log(state.loginUser);
    },
    User_Logout: function (state) {
      state.loginUser = null;
    },
    // SET_RANDOM_USER: function (state, user) {
    //   state.randomUser = user;
    // },
    VIDEO_LIST: function (state, payload) {
      state.videos = payload;
    },
    VIDEO_SEARCH_LIST: function (state, payload) {
      state.videos = payload;
    },

    VIDEO_CLICK: function (state, payload) {
      state.video = payload;
    },

    VIDEO_COMMENT_LIST: function (state, payload) {
      state.videocomments = payload;
    },

    VIDEO_COMMENT_WRITE: function (state, payload) {
      state.videocomments.push(payload);
    },

    VIDEO_COMMENT_DELETE: function (state) {
      state.videocomments.pop();
    },

    get_Todolist: function (state, payload) {
      state.todolist = payload;
    },

    VIDEO_VIEWCNT_UPDATE: function (state, payload) {
      if (!state.videocomments.payload) {
        state.videocomments.payload = []; // 배열 초기화
      }
      state.videocomments.payload.push(payload.viewCnt);
    },

    VIDEO_COMMENT_UPDATE: function (state, payload) {
      const targetIndex = state.videocomments.findIndex(
        (item) => item.commentSeq === payload.commentSeq
      );
      if (targetIndex !== -1) {
        state.videocomments.splice(targetIndex, 1, payload);
      }
    },

    LIKE_INSERT: function (state, payload) {
      state.likelist.push(payload);
    },

    LIKE_DELETE: function (state) {
      state.likelist.pop();
    },

    LIKE_LIST: function (state, payload) {
      state.likelist = payload;
    },

    get_Neighborlist: function (state, payload) {
      state.neighborlist = payload;
    },

    get_Msglist: function (state, payload) {
      state.msglist = payload;
    },

    ARTICLE_SEARCH_LIST: function (state, payload) {
      state.articles = payload;
    },

    ARTICLE_LIST: function (state, payload) {
      state.articles = payload;
    },

    ARTICLE_GET: function (state, payload) {
      state.article = payload;
    },

    ARTICLE_COMMENT_LIST: function (state, payload) {
      state.articlecomments = payload;
    },

    ARTICLE_COMMENT_WRITE: function (state, payload) {
      state.articlecomments.push(payload);
    },

    ARTICLE_COMMENT_DELETE: function (state) {
      state.articlecomments.pop();
    },

    ARTICLE_COMMENT_UPDATE: function (state, payload) {
      const { commentSeq, commentContent } = payload;

      const index = state.articlecomments.findIndex(
        (comment) => comment.commentSeq === commentSeq
      );
      if (index !== -1) {
        state.articlecomments.splice(index, 1, commentContent);
      }
    },

    ARTICLE_UPDATE: function (state, payload) {
      state.article = payload;
    },

    ARTICLE_DELETE: function (state) {
      delete state.article;
    },

    Black_Msg: function (state, payload) {
      state.blacklist = payload;
    },

    ARTICLE_WRITE: function (state, payload) {
      state.articles.push(payload);
    },
  },

  actions: {
    ArticleRegist: function ({ commit }, comment) {
      console.log(comment);
      const API_URL = `http://localhost:9999/article/write`;
      const frm = new FormData();
      frm.append("articleWriter", comment.articleWriter);
      frm.append("articleContent", comment.articleContent);
      frm.append("articleTitle", comment.articleTitle);

      axios
        .post(API_URL, frm)
        .then((res) => {
          console.log(res.data);
          commit("ARTICLE_WRITE", res.data);
          alert("게시글이 등록 되었습니다.");
          router.push("./articleList");
        })
        .catch((err) => {
          console.log(frm);
          console.log(err);
        });
    },

    articleDelete: function ({ commit }, articleSeq) {
      console.log(articleSeq);
      const API_URL = `http://localhost:9999/article/delete/${articleSeq}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          commit("ARTICLE_DELETE");
          // commit();
          router.push("/article/articleList");
        })
        .catch((err) => {
          console.log(err);
          alert("에러발생!");
        });
    },

    articleUpdate: function ({ commit }, updatearticle) {
      console.log(updatearticle);
      const API_URL = `http://localhost:9999/article/update`;
      const frm = new FormData();
      frm.append("articleTitle", updatearticle.articleTitle);
      frm.append("articleContent", updatearticle.articleContent);
      frm.append("articleWriter", updatearticle.articleWriter);
      frm.append("articleSeq", updatearticle.articleSeq);

      axios
        .put(API_URL, frm)
        .then(() => {
          console.log(frm);
          commit("ARTICLE_UPDATE", updatearticle);
          alert("수정 완료!");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateArticleComment: function ({ commit }, comment) {
      const API_URL = `http://localhost:9999/CommentArticle/update`;
      const frm = new FormData();
      frm.append("commentSeq", comment.commentSeq);
      frm.append("commentContent", comment.commentContent);
      frm.append("commentUserId", comment.commentUserId);

      axios
        .put(API_URL, frm)
        .then(() => {
          console.log(frm);
          commit("ARTICLE_COMMENT_UPDATE", comment);
          alert("수정 완료!");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    deleteArticleComment: function ({ commit }, commentSeq) {
      const API_URL = `http://localhost:9999/CommentArticle/delete/${commentSeq}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          console.log(commentSeq);
          commit("ARTICLE_COMMENT_DELETE");
        })
        .catch((err) => {
          console.log(commentSeq);

          console.log(err);
          alert("에러발생!");
        });
    },

    writeArticleComments: function ({ commit }, comment) {
      console.log(comment);
      const API_URL = `http://localhost:9999/CommentArticle/write`;
      const frm = new FormData();
      frm.append("commentSeq", comment.commentSeq);
      frm.append("commentArticleSeq", comment.commentArticleSeq);
      frm.append("commentContent", comment.commentContent);
      frm.append("commentUserId", comment.commentUserId);
      frm.append("commentJoinedAt", comment.commentJoinedAt);

      axios
        .post(API_URL, frm)
        .then((res) => {
          console.log(res.data);
          commit("ARTICLE_COMMENT_WRITE", res.data);
          alert("등록되었습니다.");
        })
        .catch((err) => {
          console.log(comment);
          console.log(err);
        });
    },

    getArticleComments: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/CommentArticle/list/${payload}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data + " 비디오 번호에 맞는 댓글 리스트");
          commit("ARTICLE_COMMENT_LIST", res.data);
        })
        .catch((err) => {
          console.log(err);
          alert("에러발생!");
        });
    },

    getArticle: function ({ commit }, articleSeq) {
      const API_URL = `http://localhost:9999/article/select/${articleSeq}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          commit("ARTICLE_GET", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    getArticles: function ({ commit }) {
      const API_URL = `http://localhost:9999/article/list`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          commit("ARTICLE_LIST", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    searchArticle: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/article/search/${payload}`;

      axios({
        url: API_URL,
        method: "GET",
        params: { word: payload },
      })
        .then((res) => {
          console.log(res);

          commit("ARTICLE_SEARCH_LIST", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    getLikeList: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/like/LikeUserList/${payload}`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          likeUserId: payload,
        },
      })
        .then((res) => {
          console.log(res.data);
          commit("LIKE_LIST", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    insertLike2: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/like/insert`;
      axios({
        url: API_URL,
        method: "POST",
        params: {
          likeUserId: payload.loginUser,
          likeVideoSeq: payload.videoSeq,
        },
      })
        .then(() => {
          commit("LIKE_INSERT", payload);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    deleteLike2: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/like/delete`;
      axios({
        url: API_URL,
        method: "DELETE",
        params: {
          likeUserId: payload.loginUser,
          likeVideoSeq: payload.videoSeq,
        },
      })
        .then(() => {
          commit("LIKE_DELETE");
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    increaseViewCnt({ commit }, payload) {
      const API_URL = `http://localhost:9999/video/update`;
      const frm = new FormData();

      console.log(payload);
      frm.append("videoSeq", payload.videoSeq);
      frm.append("viewCnt", (payload.viewCnt += 1));

      axios
        .put(API_URL, frm)
        .then(() => {
          console.log(frm);
          commit("VIDEO_VIEWCNT_UPDATE", frm);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateVideoComment: function ({ commit }, comment) {
      const API_URL = `http://localhost:9999/CommentVideo/update`;
      const frm = new FormData();
      frm.append("commentSeq", comment.commentSeq);
      frm.append("commentContent", comment.commentContent);
      frm.append("commentUserId", comment.commentUserId);

      axios
        .put(API_URL, frm)
        .then(() => {
          console.log(frm);
          commit("VIDEO_COMMENT_UPDATE", comment);
          alert("수정 완료!");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    deleteVideoComment: function ({ commit }, commentSeq) {
      const API_URL = `http://localhost:9999/CommentVideo/delete/${commentSeq}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          console.log(commentSeq);
          commit("VIDEO_COMMENT_DELETE");
        })
        .catch((err) => {
          console.log(commentSeq);

          console.log(err);
          alert("에러발생!");
        });
    },

    writeVideoComments: function ({ commit }, comment) {
      console.log(comment);
      const API_URL = `http://localhost:9999/CommentVideo/write`;
      const frm = new FormData();
      frm.append("commentSeq", comment.commentSeq);
      frm.append("commentVideoSeq", comment.commentVideoSeq);
      frm.append("commentContent", comment.commentContent);
      frm.append("commentUserId", comment.commentUserId);
      frm.append("commentJoinedAt", comment.commentJoinedAt);

      axios
        .post(API_URL, frm)
        .then((res) => {
          console.log(res.data);
          commit("VIDEO_COMMENT_WRITE", res.data);
          alert("등록되었습니다.");
        })
        .catch((err) => {
          console.log(comment);
          console.log(err);
        });
    },

    getVideoComments: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/CommentVideo/list/${payload}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data + " 비디오 번호에 맞는 댓글 리스트");
          commit("VIDEO_COMMENT_LIST", res.data);
        })
        .catch((err) => {
          console.log(err);
          alert("에러발생!");
        });
    },

    clickVideo: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/video/detail/${payload}`;
      axios({
        url: API_URL,
        method: "GET",
        // params: payload,
      })
        .then((res) => {
          console.log(res.data);
          commit("VIDEO_CLICK", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    getVideos: function ({ commit }) {
      const API_URL = `http://localhost:9999/video/list`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("VIDEO_LIST", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    searchVideo: function ({ commit }, payload) {
      const API_URL = `http://localhost:9999/video/search`;

      axios({
        url: API_URL,
        method: "GET",
        params: { word: payload },
      })
        .then((res) => {
          console.log(res);

          commit("VIDEO_SEARCH_LIST", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    createUser: function ({ commit }, user) {
      //console.log(user)
      const API_URL = `http://localhost:9999/user/register`;
      const frm = new FormData();
      frm.append("userId", user.userId);
      frm.append("userPwd", user.userPwd);
      frm.append("userName", user.userName);
      frm.append("userNickname", user.userNickname);
      frm.append("userEmail", user.userEmail);
      frm.append("userAdress", user.userAdress);
      frm.append("userInterestBigSport", user.userInterestBigSport);
      frm.append("userInterestSmallSport", user.userInterestSmallSport);
      frm.append("userSex", Number(user.userSex));
      frm.append("userHeight", Number(user.userHeight));
      frm.append("userWeight", Number(user.userWeight));
      frm.append("userExcerciseGoal", user.userExcerciseGoal);
      frm.append("userAge", Number(user.userAge));
      axios
        .post(API_URL, frm)
        .then((res) => {
          console.log(res);
          commit("CREATE_USER", user);
          alert("등록되었습니다.");
          router.push("/home");
        })
        .catch((err) => {
          console.log(user);
          console.log(err);
        });
    },

    updateUser: function ({ commit }, user) {
      console.log(commit);
      const API_URL = `http://localhost:9999/user/userUdate`;

      const frm = new FormData();
      frm.append("userSeq", user.userSeq);
      frm.append("userId", user.userId);
      frm.append("userPwd", user.userPwd);
      frm.append("userName", user.userName);
      frm.append("userNickname", user.userNickname);
      frm.append("userEmail", user.userEmail);
      frm.append("userAdress", user.userAdress);
      frm.append("userInterestBigSport", user.userInterestBigSport);
      frm.append("userInterestSmallSport", user.userInterestSmallSport);
      frm.append("userSex", Number(user.userSex));
      frm.append("userHeight", Number(user.userHeight));
      frm.append("userWeight", Number(user.userWeight));
      frm.append("userExcerciseGoal", user.userExcerciseGoal);
      frm.append("userAge", Number(user.userAge));
      axios
        .put(API_URL, frm)

        .then(() => {
          alert("수정 완료!");
          commit("SET_LOGIN_USER", user);
          router.push("/home");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    setLoginUser: function ({ commit }, user) {
      const API_URL = `http://localhost:9999/user/rogin`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          userId: user.userId,
          userPwd: user.userPwd,
        },
      })
        .then((res) => {
          let resUser = res.data;
          if (resUser.userId == null) {
            alert("로그인 실패");
          } else {
            alert("로그인 성공!");
            //console.log(res.data);
            commit("SET_LOGIN_USER", res.data);
            router.push("/home");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    UserLogout: function ({ commit }) {
      const API_URL = `http://localhost:9999/user/out`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then(() => {
          alert("로그아웃합니다.");
          commit("User_Logout");
          //router.go();
        })
        .catch((err) => {
          console.log(err);
        });
    },

    UserCheckId: function ({ commit }, userId) {
      const API_URL = `http://localhost:9999/user/userCheckId`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          userId: userId,
        },
      })
        .then((res) => {
          //console.log(res);
          //console.log(res.data);
          if (res.data == 0) {
            alert("아이디 체크 완료");
            commit;
          } else {
            alert("겹치는 아이디가 존재합니다");
            commit;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    UserCheckNickname: function ({ commit }, userNickname) {
      const API_URL = `http://localhost:9999/user/userCheckNickname`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          userCheckNickname: userNickname,
        },
      })
        .then((res) => {
          //console.log(res);
          //console.log(userNickname);
          //console.log(res.data);
          if (res.data == 0) {
            alert("닉네임 체크 완료");
            commit;
          } else {
            alert("겹치는 닉네임이 존재합니다");
            commit;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    AddTodoList: function ({ commit }, a) {
      //console.log(user)
      const API_URL = `http://localhost:9999/todolist/write`;
      const frm = new FormData();
      frm.append("todolistGoal", a);
      frm.append("todolistUserId", this.state.loginUser.userId);

      axios
        .post(API_URL, frm)
        .then(() => {
          //console.log(res.data);
          commit;
          alert("등록되었습니다.");
          //router.push("/");
        })
        .catch((err) => {
          //console.log(user);
          console.log(err);
        });
    },

    getTodolist: function ({ commit }) {
      const API_URL = `http://localhost:9999/todolist/list`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          todolistUserId: this.state.loginUser.userId,
        },
      })
        .then((res) => {
          commit("get_Todolist", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    DeleteTodo: function ({ commit }, todoSeq) {
      const API_URL = `http://localhost:9999/todolist/delete/${todoSeq}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          //console.log(commentSeq);
          commit;
        })
        .catch((err) => {
          //console.log(commentSeq);

          console.log(err);
          alert("에러발생!");
        });
    },
    UpdateTodo: function ({ commit }, todo) {
      console.log(commit);
      const API_URL = `http://localhost:9999/todolist/update`;

      const frm = new FormData();
      frm.append("todolistSeq", todo.todolistSeq);
      frm.append("todolistGoalCheck", !todo.todolistGoalCheck);
      axios
        .put(API_URL, frm)
        .then(() => {
          //alert("수정 완료!");
          commit;
          //router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    UpdateCal: function ({ commit }, cal) {
      console.log(commit);
      const API_URL = `http://localhost:9999/user/userCal`;

      const frm = new FormData();
      frm.append("userSeq", this.state.loginUser.userSeq);
      frm.append("userTotalCalorie", cal);
      axios
        .put(API_URL, frm)
        .then(() => {
          //alert("수정 완료!");
          //console.log(res);
          //console.log(res.data);
          commit;
          //router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateLoginUser: function ({ commit }) {
      const API_URL = `http://localhost:9999/user/rogin`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          userId: this.state.loginUser.userId,
          userPwd: this.state.loginUser.userPwd,
        },
      })
        .then((res) => {
          //console.log(res.data);
          commit("SET_LOGIN_USER", res.data);
          //router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getNeighbor: function ({ commit }) {
      const a = this.state.loginUser.userAdress;
      const API_URL = `http://localhost:9999/user/list/${a}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("get_Neighborlist", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },
    SendMsg: function ({ commit }, msg) {
      //console.log(user)
      const API_URL = `http://localhost:9999/message/reply`;
      const frm = new FormData();
      frm.append("msgToId", msg.msgToId);
      frm.append("msgFromId", msg.msgFromId);
      frm.append("msgContent", msg.msgContent);

      axios
        .post(API_URL, frm)
        .then(() => {
          //console.log(res);
          commit;
          alert("전송완료!");
          //router.push("/");
        })
        .catch((err) => {
          //console.log(user);
          console.log(err);
        });
    },
    getMsg: function ({ commit }) {
      const a = this.state.loginUser.userId;
      const API_URL = `http://localhost:9999/message/list/`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          msgToId: a,
        },
      })
        .then((res) => {
          commit("get_Msglist", res.data);
          //router.push("/");
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    PoliceMsg: function ({ commit }, msg) {
      console.log(commit);
      const API_URL = `http://localhost:9999/message/report`;

      const frm = new FormData();
      frm.append("messageReportState", !msg.messageReportState);
      frm.append("msgSeq", msg.msgSeq);
      axios
        .put(API_URL, frm)
        .then(() => {
          alert("신고 완료!");
          commit;
          //this.$router.go();
          //router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getBlackMsg: function ({ commit }) {
      const API_URL = `http://localhost:9999/message/black`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          //console.log(res.data);
          commit("Black_Msg", res.data);
        })
        .catch(() => {
          alert("에러발생!");
        });
    },

    badPoint: function ({ commit }, msg) {
      //console.log(user)
      const API_URL = `http://localhost:9999/user/badScoreUpdate`;
      const frm = new FormData();
      frm.append("userId", msg.msgFromId);

      axios
        .put(API_URL, frm)
        .then(() => {
          //console.log(res);
          commit;
          //alert("전송완료!");
          //router.push("/");
        })
        .catch((err) => {
          //console.log(user);
          console.log(err);
        });
    },

    ReadMsg: function ({ commit }, msg) {
      console.log(commit);
      const API_URL = `http://localhost:9999/message/read`;

      const frm = new FormData();

      frm.append("msgSeq", msg.msgSeq);
      axios
        .put(API_URL, frm)
        .then(() => {
          //alert("신고 완료!");
          commit;
          //this.$router.go();
          //router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
  plugins: [createPersistedState()],
});
