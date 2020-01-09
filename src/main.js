import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import routers from './routers'

Vue.use(VueRouter);
const router = new VueRouter({
  // mode: 'history',//在创建的 router 对象中，如果不配置 mode，就会使用默认的 hash 模式，该模式下会将路径格式化为 #! 开头。
  routes: routers
});

// ivew
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';
Vue.use(ViewUI);

// // element
// import ElementUI from 'element-ui';
// import 'element-ui/lib/theme-chalk/index.css';
// Vue.use(ElementUI);


// //vue-resource还要导入才行
// import VueResource from 'vue-resource'
// Vue.use(VueResource);

//axios
import Axios from 'axios'
// Vue.use (Axios);//这是错误的，不是插件不能use
Vue.prototype.$http = Axios;

  import Qs from 'qs';//引入qs;
// Vue.use(Qs);

//vue-layer 弹出层框架
import layer from 'vue-layer'
import 'vue-layer/lib/vue-layer.css';
Vue.prototype.$layer = layer(Vue);


//图表 框架
import VCharts from 'v-charts'
Vue.use(VCharts);

Vue.config.productionTip = false;

//mock
// import Mock  from  '@/mock'
//
// Vue.use(Mock);





new Vue({
  render: h => h(App),
  router,
}).$mount('#app')

