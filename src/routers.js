import Home from './components/home.vue'
import register from "@/components/register";
import login from "@/components/login";
const routers = [
    {
        path: '/home',
        name: 'home',
        component: Home
    },
  {
      path: '/',
          component: login
  },
    {
        path: '/register',
        component: register
    },
]
export default routers