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

        <div style="display: flex;justify-content: flex-end">
            <el-pagination
                    background
                    @current-change="currentChange"
                    @size-change="sizeChange"
                    layout="sizes, prev, pager, next, jumper, ->, total, slot"
                    :total="total">
            </el-pagination>
        </div>

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
                    keyword: null
                },
                tableData: [],
                total: null,
            }
        }, created() {
            this.getList()
        },
        methods: {
            getList() {
                postRequest('/system/log/list', this.search).then(res => {
                    this.tableData = res.data
                    this.total = res.total
                })
            },
            sizeChange(currentSize) {
                this.search.size = currentSize;
                this.getList();
            },
            currentChange(currentPage) {
                this.search.page = currentPage;
                this.getList();
            }
        }
    }
</script>

<style scoped>

</style>
