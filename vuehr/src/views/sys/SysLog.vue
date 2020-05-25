<template>
    <div>
        <div>
            <el-table
                    :data="tableData">

                <el-table-column
                    label="ID"
                    prop="id">

                </el-table-column>
                <el-table-column
                        label="操作时间"
                        prop="adddate">

                </el-table-column>
                <el-table-column
                        prop="operate"
                    label="操作内容">
                </el-table-column>
                <el-table-column
                    label="操作人ID"
                    prop="hrid">

                </el-table-column>
            </el-table>
        </div>

<!--        分页查询-->
        <div style="display: flex;justify-content: flex-end">
            <el-pagination
                    background
                    @current-change="currentChange"
                    @size-change="sizeChange"
                    layout="sizes, prev, pager, next, jumper, ->, total, slot"
                    :total="total">
            </el-pagination>
        </div>
        <!--        分页查询-->
    </div>
</template>

<script>
    import {postRequest} from "../../utils/api";

    export default {
        name: "SysLog",
        data() {
            return {
                search: {
                    size: 10,
                    page: 1,
                    //关键字
                    keyword: null
                },
                tableData: [],
                total: null,
            }
        },
        //vue的钩子函数,当组件创建的时候会执行created()里的方法
        created() {
            this.getList()
        },
        methods: {

            getList() {
                postRequest('/system/log/list', this.search).then(res => {
                    this.tableData = res.data
                    this.total = res.total
                })
            },
            //当分页大小变化时触发的回调函数
            sizeChange(currentSize) { //currentSize 改变的值 （页面大小的值  每页有10，20)
                //将页面的大小变更为当前值
                this.search.size = currentSize;
                //用当前的数据进行查询
                this.getList();
            },
            //当页码发生变化时触发的回调函数
            currentChange(currentPage) { //currentPage 改变的值  (页码的值  第1，2页）
                //将页码变更为当前值
                this.search.page = currentPage;
                //用当前的数据进行查询
                this.getList();
            }
        }
    }
</script>

<style scoped>

</style>
