<template>
<div  >
    <Row>
        <Col span="24">
<!--        <img src="../assets/logo.png">-->
            <div class="container">
                <div class="title">桂工教材订购系统<span style="padding-left:16px;">H</span>
                </div>
                <div class="subtitle">think creative.</div>
            </div>

        </Col>
    </Row>2
    <br>
    <br><br>
    <Row class="c">
        <Col span="14">
            <div>  <router-link id="wq1" to="/login"> <Button type="primary" ghost>登录</Button></router-link></div>
        </Col>
        <Col span="6">
            <div><router-link id="wq2" to="/register"> <Button type="primary" ghost>注册</Button></router-link></div>
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
    width: 400px;
    height:400px;
   margin:auto;
   position: relative;
    top:300px;

    }
@import url(http://fonts.googleapis.com/css?family=Raleway:400,,800,900);
html {
    width: 100%;
    height: 100%;
}
body {
    background: -webkit-linear-gradient(#ebece7, white);
    background: linear-gradient(#ebece7, white);
    margin: 0;
    width: 100%;
    height: 100%;
    font-family: 'Raleway', sans-serif;
}
.container {
    position: absolute;
    -webkit-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    left: 50%;
    top:100px;
}
.title {
    color: #333;
    letter-spacing: -0.1px;
    margin-left: -1px;
    font-weight: 800;
    color: transparent;
    font-size: 50px;
    background: url("https://images.blogthings.com/thecolorfulpatterntest/pattern-2.png") repeat;
    background-position: 10% 30%;
    -webkit-background-clip: text;
    position: relative;
    text-align: center;
    line-height: 200px;
    width: 660px;
}
.subtitle {
    display: block;
    text-align: center;
    text-transform: uppercase;
    padding-top: 10px;
}

</style>
