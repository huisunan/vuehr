<template>
    <div>
        <el-form
                :model="formData"
                label-width="120px">
            <el-form-item
                label="昵称">
                <el-input v-model="formData.name" style="width: 150px">

                </el-input>
            </el-form-item>
            <el-form-item
                label="登录名">
                <el-input v-model="formData.username" style="width: 150px"></el-input>
            </el-form-item><el-form-item
                label="手机">
            <el-input v-model="formData.phone" style="width: 150px"></el-input>
        </el-form-item>
            <el-form-item
                label="座机"
                >
                <el-input v-model="formData.telephone" style="width: 150px"></el-input>
            </el-form-item>
            <el-form-item
                label="地址">
                <el-input v-model="formData.address" style="width: 150px"></el-input>
            </el-form-item>
            <el-form-item
                    label="启用">
                <el-switch
                        v-model="formData.enabled"
                        active-color="#13ce66"
                        inactive-color="#ff4949"
                        :active-value="1"
                        :inactive-value="0">
                </el-switch>
            </el-form-item>
            <el-form-item
                label="密码">
                <el-input type="password" v-model="formData.password" style="width: 150px"></el-input>
            </el-form-item>
            <el-form-item
                label="备注">
                <el-input v-model="formData.remark" style="width: 150px"></el-input>
            </el-form-item>
            <el-form-item
                    label="头像路径">
                <el-input v-model="formData.userface" style="width: 150px"></el-input>
            </el-form-item>
        </el-form>
        <el-button type="primary" @click="add">添加</el-button>
    </div>
</template>

<script>
    import {postRequest} from "../../utils/api";

    export default {
        name: "SysCfg",
        data(){
            return{
                formData:{
                    name:null,
                    phone:null,
                    telephone:null,
                    address:null,
                    enabled:1,
                    username:null,
                    password:null,
                    userface:null,
                    remark:null,
                }
            }
        },methods:{
            add(){
                postRequest('/system/hr/add',this.formData).then(res=>{
                    console.log(res);
                })
            }
        }
    }
</script>

<style scoped>

</style>
