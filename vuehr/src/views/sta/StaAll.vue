<template>
    <div>
        <div ref="sex" style="height:300px"/>
        <div ref="age" style="height:300px"/>
    </div>
</template>

<script>
    import {getRequest} from "../../utils/api";
    import echarts from 'echarts'

    export default {
        name: "StaAll",
        created() {
        },mounted() {
            this.initSex(this.$refs.sex)
            this.initAge(this.$refs.age)
        }, methods: {
            initSex(chart) {
                getRequest('/chart/base/sex').then(res => {
                    const myChart = echarts.init(chart)
                    const data = res.map(i=>{
                        return {name:i.gender,value:i.sum}
                    })
                    myChart.setOption({
                        series:[{
                            name:'性别分布',
                            type: 'pie',
                            radius:"50%",
                            data:data
                        }],
                        title:{
                            text:'性别分布',
                            top: 'bottom',
                            left: 'center'
                        }
                    })
                })
            },initAge(chart){
                getRequest('/chart/base/age').then(res => {
                    const myChart = echarts.init(chart)

                    myChart.setOption({
                        series:[{
                            name:'年龄分布',
                            type: 'pie',
                            radius:"50%",
                            data:res
                        }],
                        title:{
                            text:'年龄分布',
                            top: 'bottom',
                            left: 'center'
                        }
                    })
                })
            }

        }
    }
</script>

<style scoped>

</style>
