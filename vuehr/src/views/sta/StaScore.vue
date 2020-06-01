<template>
    <div>
        <div ref="point" style="height:300px"/>
    </div>
</template>

<script>
    import {getRequest} from "../../utils/api";
    import echarts from "echarts";

    export default {
        name: "StaScore",
        mounted() {
            this.initPoint(this.$refs.point)
        }, methods: {
            initPoint(chart) {
                getRequest('/chart/base/point').then(res => {
                    const myChart = echarts.init(chart)
                    const xLabel = []
                    const data = []
                    res.forEach(i => {
                        xLabel.push(i.name)
                        data.push(i.value)
                    })
                    console.log(xLabel,data)

                    myChart.setOption({
                        series: [{
                            name: '积分情况',
                            type: 'bar',
                            radius: "50%",
                            data: data
                        }],
                        title: {
                            text: '积分情况',
                            top: 'bottom',
                            left: 'center'
                        }, xAxis: {
                            data:xLabel,
                        },yAxis:{}
                    })
                })
            }
        }
    }
</script>

<style scoped>

</style>
