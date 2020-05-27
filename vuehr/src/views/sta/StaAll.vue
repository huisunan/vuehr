<template>
    <div>
        综合信息统计
    </div>
</template>

<script>
    import {getRequest} from "../../utils/api";

    export default {
        name: "StaAll",
        created() {
            this.getSex()
        }, methods: {
            getSex() {
                getRequest('/chart/base/sex').then(res => {

                })
            }
        }
    }
</script>

<style scoped>

</style>
