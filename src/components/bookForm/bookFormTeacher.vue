<template>
  <div>
    <Table border ref="selection" :columns="columns4" :data="data1" ></Table>
    <br>
    <Button @click="submitOder()">提交订单</Button>
  </div>
</template>

<script>
//保存已选择的数据
var th=this;//mounted中会给值的，这个this不等于mounted的this，因为，export 成了另一对象
var nu;//保存临时订单数量
    export default {
        name: "bookFormTeacher",
      mounted() {

let there=this;
th=this;
        //请求数据
        this.$http.post('/api/buy/textbook',"data").then(function(res){
          window.console.log("这是bookFormTeacher请求中的：",res);
          // 压数据
          let i;
          for (i=0;i<res.data.length;i++) {
//增加要购买书的数量的列
            res.data[i].orderNumber=0;
            there._data.data1.push(res.data[i]);
          }
          var v=new Array(res.data.length);
          v.forEach((i,ix)=>{
            v[ix]=0;//初始化
          });
          nu=v;

        }).catch(function (err) {
              window.console.log("err",err);
        })

          window.console.log("完成加载");


      },
      data () {

        return {
          columns4: [
            // {
            //   type: 'selection',
            //   width: 60,
            //   align: 'center'
            // },
            {
              title: '书名',
              key: 'bookname'
            },
            {
              title: 'ISBN',
              key: 'isbn'
            },
            {
              title:'出版社',
              key:'press'
            },{
              title:'作者',
              key:'author'
            },{
              title:'页数',
              key:'pagenum'
            },{
            title:'畅销指数',
              key:'sumtotal'
            },
            {
              title: 'id',
              key: 'id'
            },
            {
              title: '单价',
              key: 'price'
            },
            {
              title: '剩余数量',
              key: 'count'
            },
            {
              title: 'Action',
              key: 'action',
              width: 150,
              align: 'center',
              render: (h, params) => {
                return h('div', [
                  h('InputNumber', {
                    props: {
                      min: 0,
                      max:params.row.count,
                      value: params.row.orderNumber
                    },
                    on: {
                      // 编辑数量的时候,触发的事件,这里的e是输入框的数字，params也是当前行？
                      'on-change': e => {
                        th.upd(params.index,e);


                      }
                    },

                  })
                ])
              }
            }
          ],
          data1: [

          ]
        }
      },
      methods: {

          upd:function(index,e){
           // 保存数据
          nu[index]=e;//保存增加的数量

        },
        submitOder:function () {
         // 提交书单

          let up=new Array();
          let now=false;

          nu.forEach((s,m)=>{
            if(s!=0){

              let gh=Object.assign({},th.data1[m]);//深浅拷贝
             gh.orderNumber=s;//订购数量
              up.push(gh);//// 深浅拷贝

              now=true;
            }

          });

          // /如果没有选择则不提交
          if(now==false){

              this.$Modal.info({
              title: 'User Info',
              content: "没有选择任何书"
            });return;}




            //处理一下数据
            for(let j=0;j<up.length;j++){
              delete up[j].id; //删除id
              let aisbn=up[j].isbn;
              delete up[j].isbn;//删除原来的
              up[j].aISBN=aisbn;

              //交换orderNumber
              up[j].count=up[j].orderNumber;
           delete   up[j].orderNumber;//删除这个
              up[j].orderNum=(new Date()).valueOf()+j;//居然相等，我日要微秒才行

              up[j].prebuyingId="5";
              up[j].userId="1";
              up[j].status="500"
            }
  console.log("bookformteacher提交的数据", up);


            //提交
            this.$http.post('/api/buy/submit/textbook',up).then((res)=>{
              window.console.log("提交成功：",res);
            //因为引用的关系，必须刷新路由，否则up 改了数据会导致 一些量undefined ,
            //前面已经深拷贝了，但剩余数量得刷新，路由不能刷新
            this.$router.push({path:'/student'});//刷新路由
            // this.$router.push({path:'/student/book'});//刷新路由 不能转回来，相同的就直接不跳？？？


              this.$Notice.success({
                title: '提交成功!!',
                desc: true ? '' : 'Here is the notification description. Here is the notification description. '
              });

          }).catch((err)=>{

            window.console.log("提交失败",err);
            this.$Notice.error({
              title: '提交失败!!',
              desc: false ? '' : '本页面准备刷新，请重新浏览下单 '
            });

          });

        }
      }

    }
</script>

<style scoped>

</style>
