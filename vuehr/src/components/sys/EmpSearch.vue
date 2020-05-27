<!--公用的用户搜索组件   -->

<template>
    <el-select
            v-model="value"
            filterable
            remote
            reserve-keyword
            placeholder="请输入员工名称或者ID"
            :remote-method="remoteMethod"
            @change="change"
            :loading="loading">
        <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            <span style="float: left; color: #8492a6; font-size: 13px">ID:{{ item.value }}</span>
            <span style="float: right">{{ item.label }}</span>
        </el-option>
    </el-select>
</template>

<script>

    export default {
        name: "EmpSearch",
        props:['value'],
        data() {
            return {
                options: [],
                loading: false
            }
        },
        created() {

        },
        methods: {
            //当输入的时候会触发回调函数
            remoteMethod(query) {  //query-->输入的内容,会根据这个内容进行模糊搜索
                this.getRequest('/employee/basic/keyword', {query}).then(res => {
                    //如果数据长度大于10 就展示前十条  不足十条就全部展示
                    let count = res.length > 10 ? 10 : res.length;
                    //展示前会将上次的搜索结果进行清空
                    this.options = []
                    for (let i = 0; i < count; i++) {
                        //构建下拉选项
                        this.options.push({
                            //value 选中后的值
                            value: res[i].id,
                            //label 展示的内容
                            label: res[i].name
                        })
                    }

                })
            },change(val){
                //给父组件发一个信号
                this.$emit('input',val)
            }
        }
    }
</script>

<style scoped>

</style>
