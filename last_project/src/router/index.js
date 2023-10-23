import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import VideoView from "../views/VideoView.vue";
import UserLogin from "@/components/user/UserLogin.vue";
import UserSignup from "@/components/user/UserSignup.vue";
import UserMypage from "@/components/user/UserMypage.vue";
import UserMypocketmon from "@/components/user/UserMypocketmon.vue";
import VideoListPage from "@/components/video/VideoListPage";
import UserNeighbor from "@/components/user/UserNeighbor.vue";
import UserMsg from "@/components/user/UserMsg.vue";
import ArticleView from "../views/ArticleView.vue";
import ArticleList from "@/components/article/ArticleList.vue";
import articleDetail from "@/components/article/articleDetail.vue";
import IndexView from "../views/IndexView.vue";
import MessageControll from "@/components/user/MessageControll.vue";
import ArticleWrite from "@/components/article/ArticleWrite.vue";
import LikeList from "@/components/like/LikeList.vue";

Vue.use(VueRouter);

const routes = [
  { path: "/", component: IndexView },
  {
    path: "/home",
    name: "home",
    component: HomeView,
  },
  {
    path: "/likelist",
    name: "likelist",
    component: LikeList,
  },

  {
    path: "/article",
    name: "article",
    component: ArticleView,
    children: [
      {
        path: "articleList",
        name: "ArticleList",
        component: ArticleList,
      },
      {
        path: "articleDetail",
        name: "articleDetail",
        component: articleDetail,
      },
      {
        path: "articleWrite",
        name: "articleWrite",
        component: ArticleWrite,
      },
    ],
  },
  {
    path: "/video",

    component: VideoView,
    children: [
      {
        path: "videoListPage",
        name: "videoListPage",
        component: VideoListPage,
      },
    ],
  },
  // {
  //   path: '/article',
  //   name: 'article',
  //   children:[

  //   ]
  // },
  // {
  //   path: '/comment',
  //   name: 'comment',
  //   children:[
  //     {

  //     }
  //   ]
  // },
  {
    path: "/user",
    component: UserView,
    children: [
      {
        path: "mypage",
        name: "UserMypage",
        component: UserMypage,
      },
      {
        path: "login",
        name: "UserLogin",
        component: UserLogin,
      },
      {
        path: "signup",
        name: "UserSignup",
        component: UserSignup,
      },
      {
        path: "mypocketmon",
        name: "UserMypocketmon",
        component: UserMypocketmon,
      },
      {
        path: "neighbor",
        name: "UserNeighbor",
        component: UserNeighbor,
      },
      {
        path: "msg",
        name: "UserMsg",
        component: UserMsg,
      },
      {
        path: "black",
        name: "MessageControll",
        component: MessageControll,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
