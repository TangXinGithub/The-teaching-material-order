<template>
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
        <FormItem label="Name" prop="name">
            <Input v-model="formValidate.name" placeholder="Enter your name"></Input>
        </FormItem>
        <FormItem label="password" prop="password">
            <Input type="password" v-model="formValidate.passsword" placeholder="Enter your password"></Input>
        </FormItem>
        <FormItem label="Role" prop="role">
            <Select v-model="formValidate.role" placeholder="Select your city">
                <Option value="学生">学生</Option>
                <Option value="教师">教师</Option>
                <Option value="管理人员">管理人员</Option>
                <Option value="采购人员">采购人员</Option>
            </Select>
        </FormItem>

        <FormItem label="Gender" prop="gender">
            <RadioGroup v-model="formValidate.gender">
                <Radio label="male">Male</Radio>
                <Radio label="female">Female</Radio>
            </RadioGroup>
        </FormItem>


        <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
    </Form>
</template>

<script>

    import Axios from 'axios'
    export default {
        data () {
            return {
                formValidate: {
                    name: '',
                    passsword: '',
                    role: '',
                    gender: '',

                },
                ruleValidate: {
                    name: [
                        { required: true, message: 'The name cannot be empty', trigger: 'blur' }
                    ],
                    passsword: [
                        { required: true, message: 'Mailbox cannot be empty', trigger: 'blur' },
                    ],
                    role: [
                        { required: true, message: 'Please select the city', trigger: 'change' }
                    ],
                    gender: [
                        { required: true, message: 'Please select gender', trigger: 'change' }
                    ],
                }
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {

                        //  取值
                        var data={
                            "username":this.formValidate.name,
                            "password":this.formValidate.passsword,
                            "role":this.formValidate.role,
                        }

                        window.console.log(data);

                        //请求
                        Axios.post('/api/register',data).then((res) => {
                            window.console.log(res);
                           // window.alert(res);//使用window的alert才会有效
                        }).catch((err) => {

                            window.console.log(err)

                        })


                        this.$Message.success('Success!');





                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            }
        }
    }
</script>

<style scoped>
div{
    margin-left: 20%;
    margin-right: 20%;
}
</style>