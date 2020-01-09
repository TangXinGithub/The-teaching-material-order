import navigation from "./components/navigation";
import register from "@/components/register";
import login from "@/components/login";
import teacher from "./components/bookList/teacher";
import student from "./components/bookList/student";
import bookFormTeacher from "./components/bookForm/bookFormTeacher";
import order from "./components/bookForm/order";
import information from "./components/bookForm/information";
import reviewerlayout from "./components/review/reviewerlayout";
import procurementlayout from "./components/PurchasingSstaff/procurementlayout";
import procurement from "./components/PurchasingSstaff/procurement";
import newbook from "./components/PurchasingSstaff/newbook";
import Login from "./components/Home/Login";
import Register from "./components/Home/Register";
import chart from "./components/charts/chart";
import barchart from "./components/charts/barchart";
import piechart from "./components/charts/piechart";
import funeel from "./components/charts/funeel";
import ring from "./components/charts/ring";
const routers = [
    {
        path: '/',
        name: 'home',
        component: navigation
    },

  {
      path: '/login',
          component: Login
  },
    {
        path: '/register',
        component: Register
    },
  {
    path: '/teacher',
    component: teacher
  },
  {
    path: '/student',
    component: student,
    children:[{
      path:'book',
      component:bookFormTeacher
    },{
      path: 'status',
      component: order
    },{
      path:'information',
      component:information
    },{
        path:'chart',
        component:piechart
    },{
        path:'chart1',
        component:funeel
    },{
        path:'chart2',
        component:ring
    }]
  },
    {
        path:'/reviewer',
        component:reviewerlayout,
        children:[{
            path:'chart',
            component:barchart
        }]
    },
    {
        path:'/procurement',
        component:procurementlayout,
        children:[{
            path: '/',
            component: procurement

        },
            {
            path: 'purchasebook',
            component: procurement
        },
            {
                path: 'newbook',
                component: newbook
            },
            {
                path: 'chart',
                component: chart
            }
        ]
    }
];
export default routers
