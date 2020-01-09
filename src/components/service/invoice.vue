<template>
    <div class="drag_main">
        <div class="img_large">
            <div class="only">
                <!-- 发票 -->
                <div class="invoice_box">
                    <div class="invoice_top">
                        <div class="top_left">机器编号：<span class="machine_num" style="color:#2e2e2e"> {{datainvoice.machinenum}}</span></div>
                        <div  class="top_middle">
                            <h1 class="i_title">桂工材库增值税电子普通发票</h1>
                            <div>
                                <p class="un_line"></p>
                                <p style="opacity: 0;">——————————————————————</p>
                            </div>
                        </div>
                        <div  class="top_right">
                            <p>发票代码：<span class="i_code" style="color:#2e2e2e">{{datainvoice.icode}} </span></p>
                            <p>发票号码：<span class="i_num" style="color:#2e2e2e">{{datainvoice.inum}} </span></p>
                            <p>开票日期：<span class="i_year"> {{datainvoice.iyear}}</span>&nbsp;年&nbsp;<span class="imonth">{{datainvoice.imonth}} </span>&nbsp;月&nbsp;<span  class="i_date">{{datainvoice.idate}} </span>&nbsp;日</p>
                            <p>校&nbsp;验 &nbsp;码：<span class="i_checkout" style="color:#2e2e2e">{{datainvoice.icheckout}} </span></p>
                        </div>
                    </div>
                    <div class="invoice_center" >
                        <table class="itable" cellspacing="0" cellpadding="0" width="787px" style="table-layout:fixed;">
                            <tr>
                                <td width="25px" style="padding-left:3px">购买方</td>
                                <td>
                                    <p> &nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<span class="i_buy_name">{{datainvoice.ibuyname}}</span></p>
                                    <p> &nbsp;纳税人识别号：<span class="i_buy_distinguish" style="font-size:13px;letter-spacing:2px;"> {{datainvoice.ibuydistinguish}}</span></p>
                                    <p> &nbsp;地&nbsp;址&nbsp;、电&nbsp;话：<span class="i_buy_contact"> {{datainvoice.ibuycontact}}</span></p>
                                    <p> &nbsp;开户行及账号：<span class="i_buy_bank">{{datainvoice.ibuybank}} </span></p>
                                </td>
                            </tr>
                        </table>
                        <table class="itable itable_one" cellspacing="0" cellpadding="0" width="787px" height="157px" style="table-layout:fixed;">
                            <tr style="height:10px;" valign="top" align="center">
                                <td width="181px" height="10px">货物或应税劳务、服务名称</td>
                                <td width="60px" >规格型号</td>
                                <td width="50px" >单位</td>
                                <td width="80px" >数量</td>
                                <td width="90px" >单价</td>
                                <td width="90px" >金额</td>
                                <td width="40px" >税率</td>
                                <td width="80px" >税额</td>
                            </tr>
                        </table>
                        <table  class="ii_table" cellspacing="0" cellpadding="0" width="787px" style="table-layout:fixed;">
                            <tr align="center">
                                <td width="181px">合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计</td>
                                <td width="60px"></td>
                                <td width="50px"></td>
                                <td width="80px"></td>
                                <td width="90px"></td>
                                <td width="90px" align="right"><span>￥</span><span class="i_mongey"> {{datainvoice.imongey}}</span></td>
                                <td width="40px"></td>
                                <td width="80px" align="right"><span>￥</span><span class="i_paid">{{datainvoice.ipaid}} </span></td>
                            </tr>
                        </table>
                        <table class="itable" cellspacing="0" cellpadding="0" width="787px" style="table-layout:fixed;">
                            <tr>
                                <td width="211px">&nbsp;价税合计（大写）</td>
                                <td width="363px" style="border-right:none; padding-left:3px;"><span class="i_big_num"> {{datainvoice.ibignum}}</span></td>
                                <td style="border-left:none;">（小写）<span>￥</span> <span class="i_small_num"> {{datainvoice.ismallnum}}</span></td>
                            </tr>
                        </table>
                        <table class="itable" cellspacing="0" cellpadding="0" width="787px" style="table-layout:fixed; border-bottom:2px solid #b88787;">
                            <tr>
                                <td width="25px" style="padding-left:3px">销售方</td>
                                <td width="450px">
                                    <p>&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<span class="i_sell_name"> {{datainvoice.isellname}}</span></p>
                                    <p>&nbsp;纳税人识别号：<span class="i_sell_distinguish" style="font-size:13px; letter-spacing:2px;">{{datainvoice.iselldistinguish}} </span></p>
                                    <p>&nbsp;地&nbsp;址&nbsp;、电&nbsp;话：<span class="i_sell_contact">{{datainvoice.isellcontact}} </span></p>
                                    <p>&nbsp;开户行及账号：<span class="i_sell_bank"> {{datainvoice.isellbank}}</span></p>
                                </td>
                                <td width="20px" style="padding:0 3px">
                                    备注
                                </td>
                                <td valign="top" style="padding-left:3px">
                                    <span class="i_remarks" style="width:285px;word-break: break-all;">{{datainvoice.iremarks}} </span>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="invoice_bottom">
                        <p>收款人：<span>{{datainvoice.ipayee}}</span></p>
                        <p>复核：<span>{{datainvoice.ireviewer}}</span></p>
                        <p>开票人：<span>{{datainvoice.iissuer}}</span></p>
                        <p>销售方：(章)<span>{{datainvoice.iseller}}</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    export default {
        name: "invoice",
        props: {
            info: {
                type: Object,
                default: () => {
                    return {};
                    }
                 },
            layerid: {
                type: String,
                default: ""
            },
            lydata: {
                type: Object,
                default: () => {
                    return {};
                }
            }
            },
        mounted() {
            this.datainvoice = this.info;
        },
        data(){
              return {
                  datainvoice:
                      {
                          machinenum:"6229421614419351xxxx",
                          ititle:"40159xxx",
                          icode:"9xxxxxxxxxxxxxxxxQ",
                          inum:"66161995xxxx",
                          iyear:"2019",
                          imonth:'12',
                          idate:'12',
                          icheckout:'',
                          ibuyname:'',
                          ibuydistinguish:'',
                          ibuycontact:'',
                          ibuybank:'',
                          imongey:'',
                          ipaid:'',
                          ibignum:'',
                          ismallnum:'',
                          isellname:'',
                          iselldistinguish:'',
                          isellcontact:'',
                          isellbank:'',
                          iremarks:'',
                          ipayee:'',
                          ireviewer:'',
                          iissuer:'',
                          iseller:'',


                      }
              }
        }

    }


</script>

<style scoped>
    .drag_main{ position: absolute;width: 870px; height: 580px; background-color: #f5f5f5; opacity:1; left:50%; margin-left:-435px; top:50%; margin-top:-290px;  z-index: 1000; box-shadow: darkgrey 1px 1px 10px 1px; }
    /* 已查验 */
    .already_big{ position: absolute; background-image: url(../../assets/logo.png);background-repeat: no-repeat; width: 249px;height: 270px; top:50%; margin-top: -135px; left: 50%; margin-left: -124.5px;}
    .success_tip{ position: absolute; top:0px; color:#2883ff; font-size: 18px; width:135px; height:36px; background: #e9f2ff; text-align: center; line-height: 36px; left:50%; margin-left:-67.5px;}
    .error_tip{ position: absolute; top:-50px; color:#ff2a2a; font-size: 26px;}

    /* 发票填充 */
    .invoice_box{ padding:35px 44px 20px 44px; color:#964300; line-height: 20px; font-weight: bold; background-color:#ffffff; font-size: 6px;}
    .invoice_box span{ color:#808080; font-size: 8px; }
    .drag_box td{ word-wrap:break-word; }
    .un_line{ width:100%; height:5px; border-top:2px solid #964300; border-bottom:1px solid #b88787;}
    .invoice_box div{ display: inline-block;}
    .top_left{ width:28%;}
    .top_middle{ width:40%; text-align: center; line-height: 30px; font-size: 12px;}
    .top_right{ width:30%; }

    .invoice_top{ width:100%;}
    .invoice_center{ width:100%;}
    .invoice_bottom{ width:100%;}
    .itable{ border-left:2px solid #b88787; border-top:2px solid #b88787;}
    .itable td,.ii_table td{ border-right:2px solid #b88787; }
    .ii_table{ border-left:2px solid #b88787; }
    .invoice_bottom p{ display:inline-block; width:168px; padding-left:14px;}

</style>