<template>
  <div><Table border :columns="columns1" :data="data1"></Table>
  </div>
</template>
<script>
    export default {
        name:"historyorder",
    props:{
            zi:Array,
    },
      watch:{
        zi:function () {
this.dataupdata();//监听数据变化。
        }
      },
        data () {
            return {
                columns1: [
                  {
                    title: '书名',
                    key: 'bookname'
                  },
                  {
                    title: 'ISBN',
                    key: 'aISBN'
                  },
                  {
                    title: '作者',
                    key: 'author'
                  },{
                      title:'出版社',
                    key:'press'
                  },{
                        title:'用户ID',
                    key:'userId'
                  },{
                      title:'prebuyingId',
                    key:'prebuyingId'
                  },
                  {
                    title: '单价',
                    key: 'price'
                  },
                  {
                    title: '购买数量',
                    key: 'count'
                  },
                ],
                data1: [ ]
            }
        },
        methods:{
            dataupdata:function () {

              this._data.data1=this._props.zi;
              console.log("zi数据更新中");
            }
        }
    }
</script>



<style scoped>

</style>