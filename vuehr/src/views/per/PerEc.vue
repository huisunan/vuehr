<template>
    <div>
        <div style="display: flex;justify-content: space-between">
            <div>
                <el-input placeholder="请输入员工名进行搜索，可以直接回车搜索..." prefix-icon="el-icon-search"
                          clearable
                          style="width: 350px;margin-right: 10px" v-model="search.keyword"></el-input>
                <el-button icon="el-icon-search" type="primary">
                    搜索
                </el-button>
            </div>
            <div>
                <el-button type="primary" @click="$refs.dialog.visible = true">添加奖惩</el-button>
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
                        prop="ecdate"
                        label="奖罚日期">

                </el-table-column>
                <el-table-column
                        label="奖罚原因"
                        prop="ecreason">

                </el-table-column>
                <el-table-column
                        label="奖罚分"
                        prop="ecpoint">

                </el-table-column>
                <el-table-column
                        label="类型">
                    <template slot-scope="{row}">
                        <el-tag>
                            {{row.ectype === 1 ?'奖':'罚'}}
                        </el-tag>
                    </template>
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
        <per-ec-dialog ref="dialog" @update="getList"/>
    </div>
</template>

<script>
    import PerEcDialog from "./components/PerEcDialog";
    import {postRequest} from "../../utils/api";
    export default {
        name: "PerEc",
        components: {PerEcDialog},
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
                postRequest('/personnel/prize/list', this.search).then(res => {
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
