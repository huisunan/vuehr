<template>
    <el-dialog
            :visible.sync="visible"
            title="员工调薪"
            @open="destroy = true"
            @closed="destroy = false">
        <el-form
                :model="formData"
                label-width="120px">
            <el-form-item
                    label="员工ID">
                <emp-search v-model:number="formData.eid"></emp-search>
            </el-form-item>
            <el-form-item
                    label="调薪日期">
                <el-date-picker
                        v-model="formData.asdate"
                        type="date"
                        placeholder="选择日期">
                </el-date-picker>
            </el-form-item>

            <el-form-item
                    label="调后薪资">
                <el-input v-model:number="formData.aftersalary"></el-input>
            </el-form-item>
            <el-form-item
                    label="原因">
                <el-input type="textarea"
                          :rows="2"
                          placeholder="请输入内容"
                          clearable v-model="formData.reason"></el-input>
            </el-form-item>
            <el-form-item
                    label="备注">
                <el-input type="textarea"
                          :rows="2"
                          placeholder="请输入内容"
                          clearable v-model="formData.remark"></el-input>
            </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
            <el-button @click="visible = false">取 消</el-button>
            <el-button type="primary" @click="add">确 定</el-button>
        </span>
    </el-dialog>
</template>

<script>
    import EmpSearch from "../../../components/sys/EmpSearch";
    import {postRequest} from "../../../utils/api";

    export default {
        name: "PerSalaryDialog",
        components: {EmpSearch},
        data() {
            return {
                visible: false,
                formData: {
                    eid: null,
                    asdate: null,
                    aftersalary: null,
                    reason:null,
                    remark:null,
                },
                destroy: true,
                allDeps: [],
                positions: [],
                defaultProps: {
                    children: 'children',
                    label: 'name'
                },
                popVisible: false,
                inputDepName: null,
            }
        }, mounted() {
            this.initPositions();
            this.initDeps()
        },
        methods: {
            add() {
                postRequest('/personnel/salary/add', this.formData).then(res => {
                    this.$emit('update')
                    this.visible = false
                })
            }
        }
    }
</script>

<style scoped>

</style>
