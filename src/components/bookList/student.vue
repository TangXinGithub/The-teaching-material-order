<template>
  <div class="layout">
    <Layout>
      <Header>
        <Menu mode="horizontal" theme="dark" active-name="1">
          <div class="layout-logo"></div>
          <div class="layout-nav">
            <MenuItem name="1">
              <Icon type="ios-navigate"></Icon>
              书单
            </MenuItem>
            <div >
            <MenuItem name="2">

              <img  src="../../assets/user.png" class="user-img-c">

            </MenuItem>
            </div>

            <MenuItem name="3">
              <Icon type="ios-analytics"></Icon>
             小明
            </MenuItem>
            <MenuItem name="4">
              <Icon type="ios-paper"></Icon>
              登出
            </MenuItem>
          </div>
        </Menu>
      </Header>
      <Layout>
        <Sider hide-trigger :style="{background: '#fff'}">
          <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
            <Submenu name="1">
              <template slot="title">
                <Icon type="ios-navigate"></Icon>
                教材管理
              </template>
              <MenuItem name="1-1"><router-link to="/student/book">选购书</router-link></MenuItem>
              <MenuItem name="1-2" @click.native="clickOrderUpdateMsg()"><router-link to="/student/status" >已订书单</router-link></MenuItem>
              <MenuItem name="1-3"><router-link to="/student/information">发票</router-link></MenuItem>
            </Submenu>
            <Submenu name="2">
              <template slot="title">
                <Icon type="ios-keypad"></Icon>

              敬请期待
              </template>
            <router-link to="/student/chart2">  <MenuItem name="2-1">暂无</MenuItem> </router-link>
              <MenuItem name="2-2">Option 2</MenuItem>
            </Submenu>
            <Submenu name="3">
              <template slot="title">
                <Icon type="ios-analytics"></Icon>
                敬请期待
              </template>
            <router-link to="/student/chart"> <MenuItem name="3-1">暂无</MenuItem>  </router-link>
              <router-link to="/student/chart1">  <MenuItem name="3-2">暂无</MenuItem> </router-link>
            </Submenu>
          </Menu>
        </Sider>
        <Layout :style="{padding: '0 24px 24px'}">
          <Breadcrumb :style="{margin: '24px 0'}">
            <BreadcrumbItem>Home</BreadcrumbItem>
            <BreadcrumbItem>Components</BreadcrumbItem>
            <BreadcrumbItem>Layout</BreadcrumbItem>
          </Breadcrumb>
          <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
            Content
<!--父组件定义的msg 要在节点声明才能传得过去 ,声明子组件的son 接收这里的msg,子组件有props中声明才行，子组件的标签也得有msg-->
            <router-view  :son="msg" :i="ii"></router-view>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  </div>
</template>
<script>


    export default {
        name: "student",
      data(){
          return {
            msg:[],
            ii:''//先留着
          }
      },
      methods:{
          clickOrderUpdateMsg:function () {
//点击已购定单，更新 子组件的order 的列表数组，
//             要在路由之前吗
//             Content-Type:
//             application/x-www-form-urlencoded
//             multipart/form-data
//             application/json
//             text/xml
// 请求书单
// 为什么没有执行，用=>其它就不要写function 了，,this 得用=>，好像也不行
  // 因为有错误，所以代码没有执行，也不是错误只是回调的时候对应，你写错了，所以不执行，
//  官网的肯定没错
//             https://blog.csdn.net/m0_37885651/article/details/81558623
            //获得当前路由
            // console.log("当前路由：",this.$route.path);
            // if(this.$route.path=="/student/status"){
            //   this.$router.push("/student");
            // }else{

            //从sessionStorge找一下用户名一下。
            if(sessionStorage.getItem("username")==''||sessionStorage.getItem("username")==null||sessionStorage.getItem("username")==undefined)
            {    console.log("username为空，undefined，不进行操作");        return ;}//返回，不操作
         let   user= sessionStorage.getItem("username");

            let us={
              "username":user
            };
                    let is=this;
                    this.$http.get('/api/query/textbook?username='+user).then((res)=>{
                   window.console.log("queryorder:",res);
                    //设置数据
                     if( res.data!=null){
                             let i=0;
                              let arrnew=new Array();//要声明是个数组
                            for (i=0;i<res.data.length;i++){
                              //判断状态
                              let st="未知";
                              switch (parseInt(res.data[i].status)) {
                                case 500: {st="审核通过";break;}
                                case 501: {st="未审核";break;}
                                case 502: {st="未通过审核";break;}
                                case 503: {st="未知错误";break;}
                                default:{st="默认错误"}
                              }

                              let item={"date":res.data[i].orderNum,"status":st,"bookItem":res.data};
                         arrnew.push(item);
                             // is.ii=(i+1).toString(); 暂时不用传唯一id
                            }
                            is.msg=arrnew;//防止订单重复
                     }
                    }).catch((err)=>{
                      window.console.log(err);
                    });

                   console.log("clickorderupdatemsg");
                }
      }
        // }

    }
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
background-image: url("../../assets/logo1.png");
    top: 15px;
    left: 20px;
  }
  .layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
  }

  .user-img-c {
    width: 34px;
    height: 34px;
    background: #ddd;
    border-radius: 50%;
margin-top: 40%;
    overflow: hidden;

  }
</style>
