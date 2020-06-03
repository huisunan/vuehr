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
                <el-button type="warning" @click="$refs.dialog.visible = true">发起调动</el-button>
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
                        prop="depName"
                        label="部门名称">

                </el-table-column>
                <el-table-column
                        label="职位名称"
                        prop="jobName">

                </el-table-column>
                <el-table-column
                        label="原因"
                        prop="reason">

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
        <per-mv-dialog ref="dialog" @update="getList"/>
    </div>
</template>

<script>
    import {postRequest} from "../../utils/api";
    import PerMvDialog from "./components/PerMvDialog";

    export default {
        name: "PerMv",
        components: {PerMvDialog},
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
                postRequest('/personnel/move/list', this.search).then(res => {
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
