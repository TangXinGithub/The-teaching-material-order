// table.vue
<template>
    <div>
<!--   高亮选中行，触发函数  highlight-row @on-current-change="currentrow"-->
    <Table :columns="columns10" :data="data9" highlight-row>
        <template slot-scope="{ row }" slot="name">
            <strong>{{ row.name }}</strong>
        </template>
        <template slot-scope="{ row, index }" slot="action">
            <Button type="primary" size="small" style="margin-right: 5px" @click="pass(row,index)">通过</Button>
            <Button type="error" size="small" @click="refuse(row,index)">拒绝</Button>
        </template>
    </Table>

    </div>
</template>
<script>
    import expandrow from "./expand";

    export default {
        name: "reviewer",
        components: { expandrow },
        mounted() {
            //开始请求数据
            this.refresh;//刷新？？？ 不然会this中的data未定义

            this.$http.post('/api/audit/query/textbook').then((res)=>{
                console.log("审核人员查看订单：",res);

                //把审核状态代码换成相应的审核状态
                //switch
                        this._data.data9=res.data;//更新数据

            }).catch((err)=>{
                console.log("审核人员查看订单发生的错误：",err);
            });
        },
        data () {
            return {
                columns10: [
                    {
                        type: 'expand',
                        width: 50,
                        render: (h, params) => {
                            return h(expandrow, {
                                props: {
                                    row: params.row
                                }
                            })
                        }
                    },
                    {
                        title: '订单流水号',
                        key: 'orderNum'
                    },
                    {
                        title: '用户ID',
                        key: 'userId'
                    },
                    {
                        title: '审核状态',
                        key: 'status'
                    },
                    {
                        title: 'Action',
                        slot: 'action',
                        width: 150,
                        align: 'center'
                    }
                ],
                data9: [

                ]
            }
        },
        methods:{
            //会影响到下面的事件，所以不要了
            // currentrow:function (current,old) {
            //     //开启 highlight-row 后有效，当表格的当前行发生变化的时候会触发
            //     console.log("currentrow:",current,old)
            // },
            pass:function (row,index) {
                //通过审核
                console.log("通过审核",row,index);

                //处理一下数据
                let updateStatus={
                    "userId":parseInt(row.userId),
                    "orderNum":row.orderNum };

                console.log(updateStatus);
                //请求
                this.$http.get('/api/audit/submit/textbookstatus?userId='+row.userId+'&orderNum='+row.orderNum).then((res)=>{

                    if( res.data=="600"){

                        this.$Notice.success({
                            title: '该订单审核已通过',
                            desc: false ? '' : res.data
                        });
                        //删除当前行
                        // this.data9.splice(index, 1);

                    }
                    else {

                        this.$Notice.error({
                            title: '提交通过审核过程发生了某些错误',
                            desc: false ? '' : res.data
                        });
                    }
                }).catch((err)=> {
                    console.log(err);
                    this.$Notice.error({
                        title: '通过发生了某些错误',
                        desc: false ? '' : '发生了某些错误'
                    });
                });

            },
            refuse:function (row,index) {
                //拒绝审核
                console.log("审核拒绝",index);

                //处理一下数据

                let updateStatus={
                  "userId":row.userId,
                    "orderNum":row.orderNum
                };

                //请求
                this.$http.post('/api/audit/submit/textbookstatus',updateStatus).then((res)=>{

                   if( res.data.status=="600"){

                       this.$Notice.warning({
                           title: '该订单审核已拒绝',
                           desc: false ? '' : res.data
                       });
                       //从数组中彻底删除
                       // this.data9.splice(index, 1);
                   }
                   else {

                           this.$Notice.error({
                               title: '拒绝发生了某些错误',
                               desc: false ? '' : res.data
                           });
                   }
                }).catch((err)=> {
                    console.log(err);
                    this.$Notice.error({
                        title: '发生了某些错误',
                        desc: false ? '' : '发生了某些错误'
                    });
                });


            }
                    }

    }
</script>


<style scoped>

</style>