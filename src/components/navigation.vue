<template>
<div class="c">
    <Row >
        <Col span="2">
            <div>  <router-link id="wq1" to="/">登录</router-link></div>
        </Col>
        <Col span="6">
            <div><router-link id="wq2" to="/register">加入我们</router-link></div>
        </Col>
    </Row>
    <br>

</div>

</template>

<script>

    export default {
        name: "navigation",

    }
</script>

<style scoped>
.c{
    /*background-color: #2d8cf0;*/
    margin-left: 40%;
    margin-right: 12%;
    }

</style>