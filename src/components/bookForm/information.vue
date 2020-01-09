<template>
    <div >
    <Carousel
            v-model="value3"
            :autoplay="setting.autoplay"
            :autoplay-speed="setting.autoplaySpeed"
            :dots="setting.dots"
            :radius-dot="setting.radiusDot"
            :trigger="setting.trigger"
            :arrow="setting.arrow">
        <CarouselItem>
            <img src="../../assets/1.jpg"  width="70%">
            <div class="demo-carousel">1</div>
        </CarouselItem>
        <CarouselItem>
            <img src="../../assets/2.jpg"  width="70%">
            <div class="demo-carousel">2</div>
        </CarouselItem>
        <CarouselItem>
            <img src="../../assets/3.jpg"  width="70%">
            <div class="demo-carousel">3</div>
        </CarouselItem>
        <CarouselItem>
            <img src="../../assets/4.jpg"  width="70%">
            <div class="demo-carousel">4</div>
        </CarouselItem>
    </Carousel>
        <br>
        <Button  icon="ios-download-outline" type="primary"  @click="invoices()">发票</Button>
    </div>
</template>
<script>
    import invoice from "../service/invoice";//弹出层要用
    export default {
        name: "information",
        data () {
            return {
                value3: 0,
                setting: {
                    autoplay: true,
                    autoplaySpeed: 2000,
                    dots: 'inside',
                    radiusDot: false,
                    trigger: 'click',
                    arrow: 'hover'
                }
            }
        },
        methods:{
            async funA(){
                // 同步机制
             let res= await this.$http.post('/api/query/textbook/invoice');//这里的res就是你axios请求回来的结果了
                window.console.log("funA",res);
                    //弹出层
                this.$layer.iframe({
                    content: {
                        content: invoice, //传递的组件对象
                        parent: this,//当前的vue对象
                        data:{info:res.data}//props
                    },
                    area:['800px','600px'],
                    title: '你的发票',
                    cancel:()=>{//关闭事件
                        // alert('关闭iframe');
                        this.$Notice.info({
                            title: 'Notification title',
                            desc: '已关闭 '
                        });

                    }
                });


            },
            invoices:function () {
                //调用同步函数
               this.funA();

            }
        }
    }
</script>

<style scoped>

</style>
