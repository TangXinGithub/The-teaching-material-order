<template>
  <div class="qui-nav nav-type-1" >
    <!--关键代码 v-for  -->{{msg}}
    <Collapse v-model="value2" accordion value @on-change="currentRow"  >
      <Panel   :name="(index+1).toString()"  v-for="(mssg, index) in son" :key="index"  >
<!--这个name要不要也没着关系 orderDate 是声明子组件接收items用的-->
       订单ID：<Button type="info" ghost>{{mssg.date}}</Button>  状态：<Button type="primary" ghost>{{mssg.status}}</Button>
        <p slot="content" >
           <historyorder :zi="items"></historyorder>
        </p>
      </Panel>

    </Collapse>
  </div>
</template>

<script>

  // return 所以这里用function来每次返回一个对象实例；,减少引用
  // ，属性的接口暴露只需要写在prosp里面就可以：把属性写在props里面，就可以暴露给其他页面调用了；
  import historyorder from "./historyorder";

  export default {
name:"order",
    // data () {
    // 东西放哪我真不知道，这个props本在data的return ，现在在，props，学会看错误
    // }
      components:{
          historyorder,
      },
    props:{
      msg: {
        default:'历史订单'
      },
      son:Array,//声明是接收父组件的数组，或者用''也行，即为空
      // value2:1, 放这里会警告说 子组件修改 props 中的值，props 只能由父组件改？？


    },
    data(){
      return {
        value2:"1",
          msgg:'',
        items:[{"dsaf":"hewlll"}],
      }
    },
    methods:{

    currentRow:function (arr) {

this.items=this.son[parseInt(arr[0])-1].bookItem;//传给子组件的props
        window.console.log(arr);


    }

}
  }
</script>
