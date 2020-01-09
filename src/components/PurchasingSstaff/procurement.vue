<template>
    <div><Table border ref="selection"   :columns="columns7" :data="data15"  @on-selection-change="currentselected"></Table>
        <br>
    <Button type="primary" @click="submit()">更新书的数量</Button>
        <br>
        <Modal
                :width="800"
                v-model="modal1"
                title="确认提交更新"
                @on-ok="ok"
                @on-cancel="cancel">
            <Table border :columns="columns8"  :data="data16" >   </Table>
        </Modal>
    </div>
</template>
<script>
    //js 实现HashMap函数
    function HashMap() {
        this.map = {};
    }
    HashMap.prototype = {
        put: function (key, value) {// 向Map中增加元素（key, value)
            this.map[key] = value;
        },
        get: function (key) { //获取指定Key的元素值Value，失败返回Null
            if (this.map.hasOwnProperty(key)) {
                return this.map[key];
            }
            return null;
        },
        remove: function (key) { // 删除指定Key的元素，成功返回True，失败返回False
            if (this.map.hasOwnProperty(key)) {
                return delete this.map[key];
            }
            return false;
        },
        removeAll: function () {  //清空HashMap所有元素
            this.map = {};
        },
        keySet: function () { //获取Map中所有KEY的数组（Array）
            var _keys = [];
            for (var i in this.map) {
                _keys.push(i);
            }
            return _keys;
        }
    };
    HashMap.prototype.constructor = HashMap;

let purchaseNumber=new HashMap();//保存选购的数量数组
    // let purchaseNumber=new Array();
    let selectItem=new Array();//保存当前选择项
    export default {
        name: "procurement",
        mounted() {
          this.refresh;//刷新

            this.$http.post('/api/purchase/textbook',{username:"purchaseStaff"}).then((res)=>{
                console.log("查询缺书单返回的数据",res);
                //更新数据
                for(let i=0;i<res.data.length;i++){
                    res.data[i]["SerialNumber"]=i+1;
                    //purchaseQuantity默认为1，最少一本，防止没有触发输入框，影响hashmap值而为空
                    res.data[i]["purchaseQuantity"]=1;//放多个采购数量用来给 提交的时候 selectItem 变量 赋值保存
                }
                this._data.data15=res.data;

            }).catch((err)=>{
                console.log("请求缺书单发生了错误：",err);
            })

        },

        data () {
            return {
                modal1: false,
                columns8:[
                    {
                        title: '书名',
                        key: 'bookname'
                    },
                    {
                        title: 'ISBN',
                        key: 'isbn'
                    },
                    {
                        title: 'ID',
                        key: 'id'
                    },
                    {
                        title:'作者',
                        key:'author'
                    },{
                        title:'出版社',
                        key:'press'
                    },
                    {
                        title: '单价',
                        key: 'price'
                    },
                    {
                        title: '采购数量',
                        key: 'purchaseQuantity'
                    },],
                data16:[],
                columns7: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                      title:'序号',
                        width:70,
                      key:'SerialNumber',
                    },
                    {
                        title: 'Name',
                        key: 'bookname',
                        render: (h, params) => {
                            return h('div', [
                                h('Icon', {
                                    props: {
                                        type: 'person'
                                    }
                                }),
                                h('strong', params.row.bookname)
                            ]);
                        }
                    },
                    {
                        title: 'ISBN',
                        key: 'isbn'
                    },
                    {
                        title: 'ID',
                        key: 'id'
                    },{
                        title:'作者',
                        key:'author'
                    },{
                        title:'出版社',
                        key:'press'
                    },{
                        title:'总页数',
                        key:'sumtotal'
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
                        title: '需要采购的数量',
                        key: 'action',
                        width: 250,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('InputNumber',{
                                   props:{
                                       max:10,
                                       min:1,
                                   },
                                    style:{
                                    marginRight:'5px'
                                    },
                                    ref:"inputnumber",
                                    on:{
                                        'on-change': e => {
                                           console.log("当前inputnumber的行号是：",params.index,"typeof",typeof(params.index));
                                            // 保存选购的数据
                                            purchaseNumber.put(params.index+1,e);//与序列号对应
                                        }
                                    }
                                }),
                            ]);
                        }
                    }
                ],
                data15: [ ]
            }
        },
        methods: {
            submit(){
                if(selectItem.length==0){
                    this.$Notice.error({
                        title: '没有选择任何采购的书本',
                        desc: true ? '' : 'Here is the notification description. 没有选择任何采购的书本 '
                    });
                    return;}//没有选任何项

                //循环赋值
              selectItem.forEach((val,index)=>{
                 if(purchaseNumber.get(val.SerialNumber)!=null){
                     selectItem[index].purchaseQuantity=purchaseNumber.get(val.SerialNumber);//赋值 保存订购的数量
                 }else console.log("hashmap error hashmap index for value is null");/*当前数量给*/
              });

              //提交
                console.log("提交的数量，看下采购数量purchaseQuantity的值",selectItem);

                //显示确认对话框
                this.data16=selectItem;//显示要用
                this.modal1=true;

            },
            currentselected:function(selection){
                console.log("当前选择项",selection);
                selectItem=selection;//保存当前已选项
            },
            ok(){

                console.log("提交的是selectItem:",selectItem);
                    this.$http.post('/api/purchase/updata/book',selectItem).then((res)=>{
                        //返回码
                        if(res.data.code==700){
                            this.$Notice.success({
                                title: '提交成功',
                                desc: true ? '' : 'Here is the notification description. 提交成功 '
                            });
                        }else{
                            if(res.data.code==701){
                                this.$Notice.warning({
                                    title: '没有提交成功，稍后再试',
                                    desc: false ? '' : '可能数据库繁忙，或者数据有错误，稍后再试 '
                                });
                            }else{
                                    this.$Notice.warning({
                                        title: '未知错误',
                                        desc: true ? '' : '返回了未知错误 '
                                    });
                            }
                        }
                    }).catch((err)=>{
                        //something wrong
                        this.$Message.error('This is something wrong in submit process');
                    });
            },
            cancel(){
                //nothing to doing
                this.$Notice.info({
                    title: '你取消了本次提交',
                    desc: true ? '' : 'Here is the notification description. 你取消了本次提交 '
                });
            }

        }
    }
</script>
<style scoped>

</style>