// table-expand.vue
<template>
    <Table border :columns="columns1" :data="data10"></Table>
</template>
<script>
    export default {
        name: "expandrow",
        props: {
            row: Object
        },
        mounted() {
          this.refresh;
          this._data.data10.push(this.row);
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
                    },{
                        title:'作者',
                        key:'author'
                    },{
                        title:'出版社',
                        key:'press'
                    },
                    {
                        title: 'ID',
                        key: 'id'
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
                data10: [

                ],
            }
        }
    }
</script>


<style scoped>
    .expand-row{
        margin-bottom: 16px;
    }
</style>