<template>
    <div>
    <Table :columns="columns" :data="data">
        <template slot-scope="{ row, index }" slot="bookname">
            <Input type="text" v-model="editName" v-if="editIndex === index" />
            <span v-else>{{ row.bookname }}</span>
        </template>

        <template slot-scope="{ row, index }" slot="aISBN">
            <Input type="text" v-model="editISBN" v-if="editIndex === index" />
            <span v-else>{{ row.aISBN }}</span>
        </template>

               <template slot-scope="{ row, index }" slot="author">
            <Input type="text" v-model="editAuthor" v-if="editIndex === index" />
            <span v-else>{{ row.author }}</span>
        </template>
        <template slot-scope="{ row, index }" slot="press">
            <Input type="text" v-model="editPress" v-if="editIndex === index" />
            <span v-else>{{ row.press }}</span>
        </template>
        <template slot-scope="{ row, index }" slot="pagenum">
            <Input type="text" v-model="editPagenum" v-if="editIndex === index" />
            <span v-else>{{ row.pagenum }}</span>
        </template>
        <template slot-scope="{ row, index }" slot="sumtotal">
            <Input type="text" v-model="editSumtotal" v-if="editIndex === index" />
            <span v-else>{{ row.sumtotal }}</span>
        </template>

        <template slot-scope="{ row, index }" slot="price">
            <Input type="text" v-model="editPrice" v-if="editIndex === index" />
            <span v-else>{{ row.price }}</span>
        </template>

        <template slot-scope="{ row, index }" slot="count">
            <Input type="text" v-model="editCount" v-if="editIndex === index" />
            <span v-else>{{ row.count }}</span>
        </template>

        <template slot-scope="{ row, index }" slot="action">
            <div v-if="editIndex === index">
                <Button @click="handleSave(index)">保存</Button>
                <Button @click="editIndex = -1">取消</Button>
            </div>
            <div v-else>
                <Button @click="handleEdit(row, index)">操作</Button>
            </div>
        </template>
    </Table>
        <br>
        <Button type="info" @click="submit()"> 提交新书</Button>
    </div>
</template>
<script>
    export default {
        bookname: "newbook",

        data () {
            return {
                columns: [
                    {
                        title: '书名',
                        slot: 'bookname'
                    },
                    {
                        title: 'aISBN',
                        slot: 'aISBN'
                    }, {
                        title: '作者',
                        slot: 'author'
                    },{
                        title: '出版社',
                        slot: 'press'
                    },
                    {
                        title: '页数',
                        slot: 'pagenum',
                    },{
                        title: '总页数',
                        slot: 'sumtotal'
                    },
                    {
                        title: '单价',
                        slot: 'price'
                    },
                    {
                        title: '采购数量',
                        slot: 'count'
                    },
                    {
                        title: '操作',
                        slot: 'action'
                    }
                ],
                data: [
                    {
                        bookname: '王小明',
                        aISBN: "185875555425",
                        author: '小明月',
                        price: '55',
                        press:'清华出版',
                        pagenum:'365',
                        sumtotal:'5010',
                        count:'365',
                    },
                    {
                        bookname: '李小红',
                        aISBN: "185878585425",
                        author: '小明月',
                        price: '828',
                        press:'上海市浦东新区世纪大道',
                        pagenum:'365',
                        sumtotal:'500',
                        count:'65',
                    },
                    {
                        bookname: '周小伟',
                        aISBN: "1858777785425",
                        author: '小明月',
                        price: '88',
                        press:'深圳市南山区深南大道',
                        pagenum:'365',
                        sumtotal:'500',
                        count:'35',
                    },
                ],
                editIndex: -1,  // 当前聚焦的输入框的行数
                editName: '',  // 第一列输入框，当然聚焦的输入框的输入内容，与 data 分离避免重构的闪烁
                editISBN: '',  // 第二列输入框
                editAuthor: '',  // 第三列输入框
                editPress:'',   //四列输入框
                editPagenum:'',//第五个输入框
                editSumtotal:'',// 第六个输入框
                editPrice: '',
                editCount:'',
            }
        },
        methods: {
            handleEdit (row, index) {
                this.editName = row.bookname;
                this.editISBN = row.aISBN;
                this.editPrice = row.price;
                this.editAuthor = row.author;
                this.editPress=row.press;
                this.editPagenum=row.pagenum;
                this.editSumtotal=row.sumtotal;
                this.editCount=row.count;
                this.editIndex = index;

            },
            handleSave (index) {

                //不能为空
                if(this.editName=='' || this.editISBN=='' || this.editAuthor=='' || this.editPress==''|| this.editPagenum=='' || this.editSumtotal==''|| this.editPrice==''||this.editCount=='')
                {
                    this.$Notice.error({
                        title: '字段为空不能保存',
                        desc: false ? '' : '字段为空不能保存，请输入数据. '
                    });

                    return ; //不进行下面操作，返回
                }

                this.data[index].bookname = this.editName;
                this.data[index].aISBN = this.editISBN;
                this.data[index].author = this.editAuthor;
                this.data[index].press=this.editPress;
                this.data[index].pagenum=this.editPagenum;
                this.data[index].sumtotal=this.editSumtotal;
                this.data[index].price = this.editPrice;
                this.data[index].count=this.editCount;
                this.editIndex = -1;
            },

            submit(){

                //提交数据
console.log("提交的数据",this.data);
                    this.$http.post("/api/add/book",this.data).then((res)=>{

                        this.$Notice.success({
                            title: '添加新书成功',
                            desc: true ? '' : 'Here is 添加新书成功提交返回的消息 '
                        });

                        console.log("添加新书成功提交返回的消息",res);
                    }).catch((err)=>{
                        this.$Notice.warning({
                            title: '添加新书出现错误',
                            desc: true ? '' : 'Here is 添加新书出现错误 '
                        });
                        console.log("添加新书出现错误：",err);
                    });

                this.$Notice.info({
                    title: '成功提交',
                    duration:3,
                    desc: false ? '' : '成功提交新进书！返回 '
                  });
             }
        }
    }
</script>