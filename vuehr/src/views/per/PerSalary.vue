<template>
    <div>
        <div style="display: flex;justify-content: space-between">
            <div>
                <el-input placeholder="请输入员工名进行搜索，可以直接回车搜索..." prefix-icon="el-icon-search"
                          clearable
                          style="width: 350px;margin-right: 10px" v-model="search.keyword"></el-input>
                <el-button icon="el-icon-search" type="warning">
                    搜索
                </el-button>
            </div>
            <div>
                <el-button type="warning" @click="$refs.dialog.visible = true">添加员工调薪</el-button>
            </div>
        </div>
        <div>
            <el-table
                    :data="tableData">
                <el-table-column
                        label="姓名"
                        prop="name">

                </el-table-column>
                <el-table-column
                        prop="asdate"
                        label="调薪日期">

                </el-table-column>
                <el-table-column
                        label="调前薪资"
                        prop="beforesalary">

                </el-table-column>
                <el-table-column
                        label="调后薪资"
                        prop="aftersalary">

                </el-table-column>
                <el-table-column
                        label="调薪原因"
                        prop="reason">

                </el-table-column>
                <el-table-column
                        label="备注"
                        prop="remark">

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
        <per-salary-dialog ref="dialog" @update="getList"/>
    </div>
</template>

<script>
    import {postRequest} from "../../utils/api";
    import PerSalaryDialog from "./components/PerSalaryDialog";

    export default {
        name: "PerSalary",
        components: {PerSalaryDialog},
        data() {
            return {
                id: null,
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
                postRequest('/personnel/salary/list', this.search).then(res => {
                    this.tableData = res.data
                    this.total = res.total
                })
            }, sizeChange(currentSize) {
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
