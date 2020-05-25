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
            remoteMethod(query) {
                this.getRequest('/employee/basic/keyword', {query}).then(res => {
                    let count = res.length > 10 ? 10 : res.length;
                    this.options = []
                    for (let i = 0; i < count; i++) {
                        this.options.push({
                            value: res[i].id,
                            label: res[i].name
                        })
                    }

                })
            },change(val){
                this.$emit('input',val)
            }
        }
    }
</script>

<style scoped>

</style>
